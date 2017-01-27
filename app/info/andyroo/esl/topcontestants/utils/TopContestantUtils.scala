package info.andyroo.esl.topcontestants.utils

import info.andyroo.esl.topcontestants.models._

object TopContestantUtils {

  def getOrderedPositions(contestant: Contestant)(implicit rankings: List[Ranking]): List[Int] = {
    rankings.map{
      case ranking if doesContestantExist(contestant, ranking) =>
        Some(getPosition(contestant, ranking))
      case _ => None

    }.filter(_.isDefined).map(_.get).sorted
  }

  def getPosition(contestant: Contestant, ranking: Ranking): Int = {
    ranking.ranking.head.dropWhile(_.contestant != contestant).head.position
  }

  def doesContestantExist(contestant: Contestant, ranking: Ranking): Boolean = {
    val positions: Option[List[Position]] = ranking.ranking
    positions match {
      case Some(position) =>
        position.exists{ rank =>
          rank.contestant.equals(contestant)
        }
      case _ =>
        false
    }
  }

  def uniqueContestantsFromRankings()(implicit rankings: List[Ranking]): Seq[Contestant] = {
    rankings.flatMap{ ranking =>
      ranking.ranking match {
        case Some(x) =>
          x.map(_.contestant)
      }
    }.distinct
  }

  def getTeamSummaries(contestants: Seq[Contestant])(implicit rankings: List[Ranking]): Map[String, ContestantSummary] = {
    contestants.map{ team =>
      val positions = TopContestantUtils.getOrderedPositions(team)
      val cupsPlayed = positions.size
      val bestPosition = positions.head
      val worstPosition = positions.reverse.head
      team.id -> ContestantSummary(cupsPlayed, bestPosition, worstPosition)
    }.toMap
  }

}
