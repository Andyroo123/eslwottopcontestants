package info.andyroo.esl.topcontestants.controllers

import info.andyroo.esl.topcontestants.models._
import info.andyroo.esl.topcontestants.services.EslService
import org.junit.runner._
import org.specs2.mock.Mockito
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.json.Json
import play.api.mvc.Results
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification with Mockito with Results {

  "Application" should {

    val mockEslService = mock[EslService]
    val applicationController = new Application(mockEslService)

    "return json on top contestant call" in new WithApplication{
      val topContestants = route(FakeRequest(GET, "/contestants/top/1")).get

      status(topContestants) must equalTo(OK)
      contentType(topContestants) must beSome.which(_ == "application/json")
      contentAsString(topContestants) must contain ("{")
    }

    "return contestant summaries for a single league with a 2 teams" in new WithApplication{
      val team1 = Contestant("team1")
      val team2 = Contestant("team2")
      mockEslService.listLeagues() returns Future(Map("1" -> League(1, 2)))
      mockEslService.getRankings(1) returns Future(Ranking(Some(
        List(
          Position(1, team = Some(team1)),
          Position(2, team = Some(team2))
        ))))

      val team1Summary = ContestantSummary(1, 1, 1)
      val team2Summary = ContestantSummary(1, 2, 2)

      import info.andyroo.esl.topcontestants.models.JsonFormats.teamSummaryFormat
      val expectedResponse = Json.toJson(Map("team1" -> team1Summary, "team2" -> team2Summary)).toString


      val result = applicationController.getTopContestants(2).apply(FakeRequest())

      status(result) must equalTo(OK)
      contentType(result) must beSome.which(_ == "application/json")
      contentAsString(result) must equalTo(expectedResponse)

    }

    "return contestant summaries for a multiple leagues with a varying amounts of users and ignore team league" in new WithApplication{
      val user1 = Contestant("user1")
      val user2 = Contestant("user2")
      val user3 = Contestant("user3")
      val user4 = Contestant("user4")
      val user5 = Contestant("user5")
      mockEslService.listLeagues() returns Future(Map("1" -> League(1, 1), "2" -> League(2, 1), "3" -> League(3, 1), "4" -> League(4, 1), "5" -> League(5, 2)))
      mockEslService.getRankings(1) returns Future(Ranking(Some(
        List(
          Position(1, user = Some(user1)),
          Position(2, user = Some(user3)),
          Position(3, user = Some(user5)),
          Position(4, user = Some(user4))
        ))))
      mockEslService.getRankings(2) returns Future(Ranking(Some(
        List(
          Position(1, user = Some(user5)),
          Position(2, user = Some(user2))
        ))))
      mockEslService.getRankings(3) returns Future(Ranking(Some(
        List(
          Position(1, user = Some(user1)),
          Position(2, user = Some(user4)),
          Position(3, user = Some(user5)),
          Position(4, user = Some(user3))
        ))))
      mockEslService.getRankings(4) returns Future(Ranking(Some(
        List(
          Position(1, user = Some(user5)),
          Position(2, user = Some(user3)),
          Position(3, user = Some(user2))
        ))))


      val user1Summary = ContestantSummary(cupsPlayed = 2, bestPosition = 1, worstPosition = 1)
      val user2Summary = ContestantSummary(cupsPlayed = 2, bestPosition = 2, worstPosition = 3)
      val user3Summary = ContestantSummary(cupsPlayed = 3, bestPosition = 2, worstPosition = 4)
      val user4Summary = ContestantSummary(cupsPlayed = 2, bestPosition = 2, worstPosition = 4)
      val user5Summary = ContestantSummary(cupsPlayed = 4, bestPosition = 1, worstPosition = 3)

      import info.andyroo.esl.topcontestants.models.JsonFormats.teamSummaryFormat
      val expectedResponse = Json.toJson(Map(
        "user1" -> user1Summary,
        "user2" -> user2Summary,
        "user3" -> user3Summary,
        "user4" -> user4Summary,
        "user5" -> user5Summary)).toString


      val result = applicationController.getTopContestants(1).apply(FakeRequest())

      status(result) must equalTo(OK)
      contentType(result) must beSome.which(_ == "application/json")
      contentAsString(result) must equalTo(expectedResponse)

    }
  }
}
