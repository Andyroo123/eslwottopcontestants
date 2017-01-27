package info.andyroo.esl.topcontestants.services

import javax.inject.Inject

import info.andyroo.esl.topcontestants.models.JsonFormats._
import info.andyroo.esl.topcontestants.models.{League, Ranking}
import play.api.libs.ws._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

import play.api.Logger

class EslService @Inject() (ws: WSClient) {

  private[this] val log: Logger = Logger(this.getClass)

  def listLeagues(): Future[Map[String, League]] = {
    log.debug("Listing leagues")

    val url = "https://play.eslgaming.com/api/leagues?types=cup&states=finished&limit.total=100&path=%2Fplay%2Fworldoftanks%2Feurope%2F"

    val promise = Promise[Map[String, League]]
    val request = ws.url(url)

    val response = request.get()

    response.onComplete {
      case Success(wsResponse) =>
        promise.success(wsResponse.json.as[Map[String, League]])
      case Failure(ex) =>
        promise.failure(ex)
    }

    promise.future
  }

  def getRankings(leagueId: Int): Future[Ranking] = {
    log.debug(s"Getting ranks for league [$leagueId]")

    val url = s"https://play.eslgaming.com/api/leagues/$leagueId/ranking?limit=25&offset=0"

    val promise = Promise[Ranking]
    val request = ws.url(url)

    val response = request.get()

    response.onComplete {
      case Success(wsResponse) =>
        promise.success(wsResponse.json.as[Ranking])
      case Failure(ex) =>
        promise.failure(ex)
    }

    promise.future
  }

}
