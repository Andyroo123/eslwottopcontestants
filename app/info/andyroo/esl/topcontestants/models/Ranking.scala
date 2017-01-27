package info.andyroo.esl.topcontestants.models

import play.api.Logger

case class Position(position: Int, team: Option[Contestant] = None, user: Option[Contestant] = None) {
  private[this] val log: Logger = Logger(this.getClass)

  val contestant: Contestant = (team, user) match {
    case (Some(x), None) => x
    case (None, Some(x)) => x
    case _ =>
      log.error("Unknown type of contestant")
      throw new IllegalStateException()
  }
}

case class Ranking(ranking: Option[List[Position]])