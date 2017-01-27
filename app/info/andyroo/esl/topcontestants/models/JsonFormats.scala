package info.andyroo.esl.topcontestants.models

import play.api.libs.json.Json

object JsonFormats {

  implicit val leagueFormat = Json.format[League]
  implicit val teamFormat = Json.format[Contestant]
  implicit val teamSummaryFormat = Json.format[ContestantSummary]
  implicit val positionFormat = Json.format[Position]
  implicit val rankingFormat = Json.format[Ranking]

}
