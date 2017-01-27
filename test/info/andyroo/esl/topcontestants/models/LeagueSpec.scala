package info.andyroo.esl.topcontestants.models

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.libs.json.Json

@RunWith(classOf[JUnitRunner])
class LeagueSpec extends Specification {

  val validLeagueJson =
    """
 |{
 |  "135167": {
 |    "id": 135167,
 |    "type": "cup",
 |    "name": {
 |      "full": "WoT Team Easy BAPI Test",
 |      "normal": "WoT Team Easy BAPI Test",
 |      "short": "WoT Team Easy BAPI Test"
 |    },
 |    "uri": "\/play\/worldoftanks\/europe\/wot\/open\/7on7-easy-challenge-romania\/cup-37\/",
 |    "mode": "7on7",
 |    "resultType": "oneround_noshift",
 |    "teamSize": 7,
 |    "skillLevel": "open",
 |    "series": "7on7_easy_challenge_romania",
 |    "prizePool": null,
 |    "gameAccountType": "wot_eu",
 |    "gameIntegration": "wotapi",
 |    "matchSetupAllowed": false,
 |    "matchMediaAllowed": false,
 |    "mapvoteEnabled": false,
 |    "anticheatEnabled": true,
 |    "gameId": 6081,
 |    "restrictions": [
 |      {
 |        "type": "gameaccount",
 |        "params": {
 |          "type": "wot_eu",
 |          "minmembers": 7
 |        }
 |      },
 |      {
 |        "type": "ga_team_positions",
 |        "params": {
 |          "team_positions": [
 |            "orga",
 |            "player",
 |            "team_captain",
 |            "team_manager",
 |            "team_owner",
 |            "trial"
 |          ]
 |        }
 |      }
 |    ],
 |    "contestants": {
 |      "signedUp": 2,
 |      "checkedIn": 2,
 |      "max": 2
 |    },
 |    "timeline": {
 |      "signUp": {
 |        "begin": "2016-02-20T23:21:01+00:00",
 |        "end": "2016-03-12T14:30:00+00:00"
 |      },
 |      "inProgress": {
 |        "begin": "2016-03-12T15:00:00+00:00",
 |        "end": "2016-12-30T11:57:00+00:00"
 |      },
 |      "finished": {
 |        "begin": "2016-12-30T11:57:00+00:00"
 |      },
 |      "checkIn": {
 |        "begin": "2016-03-12T14:30:00+00:00",
 |        "end": "2016-03-12T14:40:00+00:00"
 |      },
 |      "lateSignUp": {
 |        "begin": "2016-03-12T14:40:00+00:00",
 |        "end": "2016-03-12T15:00:00+00:00"
 |      }
 |    },
 |    "signUp": {
 |      "enabled": true,
 |      "verificationRequired": true,
 |      "premiumRequired": false,
 |      "teamRequirements": {
 |        "minMembers": 7,
 |        "maxMembers": 0
 |      }
 |    },
 |    "state": "finished"
 |  }
 |}
    """.stripMargin

  val validMultipleLeagueJson =
    """
 |{
      "141411": {
 |    "id": 141411,
 |    "type": "cup",
 |    "name": {
 |      "full": "WoT 3on3 Ace Season 8 Final Europe",
 |      "normal": "WoT 3on3 Ace Season 8 Final Europe",
 |      "short": "WoT 3on3 Ace Season 8 Final Europe"
 |    },
 |    "uri": "\/play\/worldoftanks\/europe\/wot\/open\/3on3-ace-europe\/season-8-final\/",
 |    "mode": "3on3 Encounter",
 |    "resultType": "oneround_noshift",
 |    "teamSize": 3,
 |    "skillLevel": "open",
 |    "series": "3on3_ace_cup",
 |    "prizePool": "64.050 gold",
 |    "gameAccountType": "wot_eu",
 |    "gameIntegration": "wotapi",
 |    "matchSetupAllowed": false,
 |    "matchMediaAllowed": false,
 |    "mapvoteEnabled": false,
 |    "anticheatEnabled": true,
 |    "gameId": 6081,
 |    "restrictions": [
 |      {
 |        "type": "gameaccount",
 |        "params": {
 |          "type": "wot_eu",
 |          "minmembers": 3
 |        }
 |      },
 |      {
 |        "type": "logo",
 |        "params": null
 |      },
 |      {
 |        "type": "ga_team_positions",
 |        "params": {
 |          "team_positions": [
 |            "orga",
 |            "player",
 |            "team_captain",
 |            "team_manager",
 |            "team_owner",
 |            "trial"
 |          ]
 |        }
 |      }
 |    ],
 |    "contestants": {
 |      "signedUp": 12,
 |      "checkedIn": 12,
 |      "max": 16
 |    },
 |    "timeline": {
 |      "signUp": {
 |        "end": "2016-11-17T18:00:00+00:00"
 |      },
 |      "inProgress": {
 |        "begin": "2016-11-17T18:00:00+00:00",
 |        "end": "2016-11-17T20:29:00+00:00"
 |      },
 |      "finished": {
 |        "begin": "2016-11-17T20:29:00+00:00"
 |      }
 |    },
 |    "signUp": {
 |      "enabled": false,
 |      "verificationRequired": false,
 |      "premiumRequired": false,
 |      "teamRequirements": {
 |        "minMembers": 3,
 |        "maxMembers": 0
 |      }
 |    },
 |    "state": "finished"
 |  },
 |  "142948": {
 |    "id": 142948,
 |    "type": "cup",
 |    "name": {
 |      "full": "WoT 7on7 Leclerc Cup Saison 3 Cup #09 Western Europe",
 |      "normal": "WoT 7on7 Leclerc Cup Saison 3 Cup #09 Western Europe",
 |      "short": "WoT 7on7 Leclerc Cup Saison 3 Cup #09 Western Europe"
 |    },
 |    "uri": "\/play\/worldoftanks\/europe\/wot\/open\/7on7-leclerc-cup-w-eu\/saison-3-cup-09\/",
 |    "mode": "7on7",
 |    "resultType": "oneround_noshift",
 |    "teamSize": 7,
 |    "skillLevel": "open",
 |    "series": "7on7-leclerc-cup-western-europe",
 |    "prizePool": null,
 |    "gameAccountType": "wot_eu",
 |    "gameIntegration": "wotapi",
 |    "matchSetupAllowed": false,
 |    "matchMediaAllowed": false,
 |    "mapvoteEnabled": false,
 |    "anticheatEnabled": true,
 |    "gameId": 6081,
 |    "restrictions": [
 |      {
 |        "type": "inCountryList",
 |        "params": {
 |          "countries": [
 |            "be",
 |            "ch",
 |            "fr",
 |            "lu"
 |          ],
 |          "minmembers": 7
 |        }
 |      },
 |      {
 |        "type": "ga_team_positions",
 |        "params": {
 |          "team_positions": [
 |            "orga",
 |            "player",
 |            "team_captain",
 |            "team_manager",
 |            "team_owner",
 |            "trial"
 |          ]
 |        }
 |      },
 |      {
 |        "type": "gameaccount",
 |        "params": {
 |          "type": "wot_eu",
 |          "minmembers": 7
 |        }
 |      }
 |    ],
 |    "contestants": {
 |      "signedUp": 0,
 |      "checkedIn": 0,
 |      "max": null
 |    },
 |    "timeline": {
 |      "signUp": {
 |        "begin": "2016-08-22T18:14:44+00:00",
 |        "end": "2016-11-04T19:30:00+00:00"
 |      },
 |      "inProgress": {
 |        "begin": "2016-11-04T20:00:00+00:00",
 |        "end": "2016-11-16T13:45:00+00:00"
 |      },
 |      "finished": {
 |        "begin": "2016-11-16T13:45:00+00:00"
 |      },
 |      "checkIn": {
 |        "begin": "2016-11-04T19:30:00+00:00",
 |        "end": "2016-11-04T19:50:00+00:00"
 |      },
 |      "lateSignUp": {
 |        "begin": "2016-11-04T19:50:00+00:00",
 |        "end": "2016-11-04T20:00:00+00:00"
 |      }
 |    },
 |    "signUp": {
 |      "enabled": true,
 |      "verificationRequired": true,
 |      "premiumRequired": false,
 |      "teamRequirements": {
 |        "minMembers": 7,
 |        "maxMembers": 0
 |      }
 |    },
 |    "state": "finished"
 |  }
 |  }""".stripMargin

  "League model" should {
    "parse useful json" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val leagues = Json.parse(validLeagueJson).as[Map[String, League]]

      leagues.size shouldEqual 1

      leagues.head._2.id shouldEqual 135167
      leagues.head._2.teamSize shouldEqual 7
    }

    "parse multiple leagues json" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val leagues = Json.parse(validMultipleLeagueJson).as[Map[String, League]]

      leagues.size shouldEqual 2

      leagues("141411").id shouldEqual 141411
      leagues("141411").teamSize shouldEqual 3

      leagues("142948").id shouldEqual 142948
      leagues("142948").teamSize shouldEqual 7
    }

  }

}