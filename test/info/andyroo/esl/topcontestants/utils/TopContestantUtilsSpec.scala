package info.andyroo.esl.topcontestants.utils

import info.andyroo.esl.topcontestants.models.{League, Position, Ranking, Contestant}
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TopContestantUtilsSpec extends Specification {
  val contestant1: Contestant = Contestant("1")
  val contestant2: Contestant = Contestant("2")
  val contestant3: Contestant = Contestant("3")
  val contestant4: Contestant = Contestant("4")
  val contestant5: Contestant = Contestant("5")
  val contestant6: Contestant = Contestant("6")


  val league1Ranking: Ranking = Ranking(Some(List(
    Position(1, team = Some(contestant1))
  )))
  val league2Ranking: Ranking = Ranking(Some(List(
    Position(1, team = Some(contestant2))
  )))
  val league3Ranking: Ranking = Ranking(Some(List(
    Position(1, team = Some(contestant1)),
    Position(2, team = Some(contestant2))
  )))
  val league4Ranking: Ranking = Ranking(Some(List(
    Position(1, team = Some(contestant2)),
    Position(2, team = Some(contestant1))
  )))
  val league5Ranking: Ranking = Ranking(Some(List(
    Position(1, user = Some(contestant2)),
    Position(2, user = Some(contestant1)),
    Position(3, user = Some(contestant5)),
    Position(4, user = Some(contestant3)),
    Position(5, user = Some(contestant4))
  )))

  val league6Ranking: Ranking = Ranking(Some(List(
    Position(1, user = Some(contestant2)),
    Position(2, user = Some(contestant1)),
    Position(3, user = Some(contestant5)),
    Position(4, user = Some(contestant4)),
    Position(5, user = Some(contestant6))
  )))


  "TopCotestantUtils#getPosition" should {
    "Return the correct position in a 1 team league" in {
      TopContestantUtils.getPosition(contestant1, league1Ranking) shouldEqual 1
    }

    "Return the correct position in a 2 team league" in {
      TopContestantUtils.getPosition(contestant1, league3Ranking) shouldEqual 1
    }

    "Return an alternate position in a 2 team league" in {
      TopContestantUtils.getPosition(contestant2, league3Ranking) shouldEqual 2
    }

    "Return all positions of a 4 contestant league" in {
      TopContestantUtils.getPosition(contestant1, league6Ranking) shouldEqual 2
      TopContestantUtils.getPosition(contestant2, league6Ranking) shouldEqual 1
      TopContestantUtils.getPosition(contestant4, league6Ranking) shouldEqual 4
      TopContestantUtils.getPosition(contestant5, league6Ranking) shouldEqual 3
    }
  }

  "TopCotestantUtils#doesContestantExist" should {
    "Return true if contestant exists" in {
      TopContestantUtils.doesContestantExist(contestant1, league1Ranking) should beTrue
      TopContestantUtils.doesContestantExist(contestant2, league1Ranking) should beFalse
    }

    "Return true if contestant exists with multiple" in {
      TopContestantUtils.doesContestantExist(contestant1, league3Ranking) should beTrue
      TopContestantUtils.doesContestantExist(contestant2, league3Ranking) should beTrue
    }
  }

  "TopCotestantUtils#uniqueTeamsFromRankings" should {
    "Return single contestant for a single ranking" in {
      implicit val rankings: List[Ranking] = List(league1Ranking)

      val result = TopContestantUtils.uniqueContestantsFromRankings

      result.size shouldEqual 1
      result should contain(contestant1)
    }

    "Return a two teams when two rankings different contestants" in {
      implicit val rankings: List[Ranking] = List(league1Ranking, league2Ranking)

      val result = TopContestantUtils.uniqueContestantsFromRankings

      result.size shouldEqual 2
      result should contain(contestant1, contestant2)
    }

    "Return multiple contestants for a multiple rankings" in {
      implicit val rankings: List[Ranking] = List(league3Ranking, league4Ranking)

      val result = TopContestantUtils.uniqueContestantsFromRankings

      result.size shouldEqual 2
      result should contain(contestant1, contestant2)
    }

    "Return multiple contestants for a lots of rankings" in {
      implicit val rankings: List[Ranking] = List(league1Ranking, league2Ranking, league3Ranking, league4Ranking, league5Ranking, league6Ranking)

      val result = TopContestantUtils.uniqueContestantsFromRankings

      result.size shouldEqual 6
      result should contain(contestant1, contestant2, contestant3, contestant4, contestant5, contestant6)
    }
  }


}
