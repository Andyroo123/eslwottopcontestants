package info.andyroo.esl.topcontestants.controllers

import javax.inject.Inject

import info.andyroo.esl.topcontestants.models.JsonFormats._
import info.andyroo.esl.topcontestants.models._
import info.andyroo.esl.topcontestants.services.EslService
import info.andyroo.esl.topcontestants.utils.TopContestantUtils
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Application @Inject()(eslService: EslService) extends Controller {

  private[this] val log: Logger = Logger(this.getClass)

  def getTopContestants(teamSize: Int)  = Action.async {
    log.debug(s"Getting top contestants for team size of $teamSize")
    val futureLeagues = eslService.listLeagues()

    def getAllRankings(leagues: Map[String, League]): Future[List[Ranking]] = {

      val filteredLeagues = leagues.filter{_._2.teamSize == teamSize}

      val rankings: List[Future[Ranking]] = filteredLeagues.toList.map{
        case (_, league) =>
          eslService.getRankings(league.id)
      }

      Future.sequence(rankings)
    }

    (for {
      leagues <- futureLeagues
      allRankings <- getAllRankings(leagues)
    } yield {
      val filteredRankings = allRankings.filter(_.ranking.isDefined)
      implicit val rankings: List[Ranking] = filteredRankings

      val contestants: Seq[Contestant] = TopContestantUtils.uniqueContestantsFromRankings
      val teamSummaries = TopContestantUtils.getTeamSummaries(contestants)

      log.debug("Successfully got all team summaries, returning")
      Ok(Json.toJson(teamSummaries))
    }).recover {
      case e: Exception =>
        log.error(s"An exception was throw: ${e.getMessage}", e)
        InternalServerError(e.getMessage)
    }


  }


}
