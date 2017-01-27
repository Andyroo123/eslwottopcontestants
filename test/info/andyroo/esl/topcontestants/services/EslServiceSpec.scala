package info.andyroo.esl.topcontestants.services

import info.andyroo.esl.topcontestants.models.{League, Ranking}
import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import play.api.libs.json.Json
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.test.WithApplication

import scala.concurrent.{Await, Promise}
import scala.concurrent.duration.FiniteDuration

@RunWith(classOf[JUnitRunner])
class EslServiceSpec extends Specification with Mockito {

  val duration = FiniteDuration(5, "seconds")

  val leaguesJson =
    """
      |{
      |"142948": {
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
      |  },
      |  "142950": {
      |    "id": 142950,
      |    "type": "cup",
      |    "name": {
      |      "full": "WoT 7on7 Leclerc Cup Saison 3 Cup #10 Western Europe",
      |      "normal": "WoT 7on7 Leclerc Cup Saison 3 Cup #10 Western Europe",
      |      "short": "WoT 7on7 Leclerc Cup Saison 3 Cup #10 Western Europe"
      |    },
      |    "uri": "\/play\/worldoftanks\/europe\/wot\/open\/7on7-leclerc-cup-w-eu\/saison-3-cup-10\/",
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
      |        "begin": "2016-08-22T19:11:13+00:00",
      |        "end": "2016-11-11T19:30:00+00:00"
      |      },
      |      "inProgress": {
      |        "begin": "2016-11-11T20:00:00+00:00",
      |        "end": "2016-11-16T13:45:00+00:00"
      |      },
      |      "finished": {
      |        "begin": "2016-11-16T13:45:00+00:00"
      |      },
      |      "checkIn": {
      |        "begin": "2016-11-11T19:30:00+00:00",
      |        "end": "2016-11-11T19:50:00+00:00"
      |      },
      |      "lateSignUp": {
      |        "begin": "2016-11-11T19:50:00+00:00",
      |        "end": "2016-11-11T20:00:00+00:00"
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

  val rankingJson =
    """
      |{
      |  "type": "team",
      |  "pager": {
      |    "total": 2,
      |    "limit": 25,
      |    "offset": 0
      |  },
      |  "ranking": [
      |    {
      |      "position": 1,
      |      "label": "1.",
      |      "activity": 0,
      |      "credibility": 0,
      |      "numOpenMatches": 0,
      |      "startSeeding": 1,
      |      "seed": 1,
      |      "team": {
      |        "id": "9254386",
      |        "name": "Bapi test",
      |        "suffix": "",
      |        "prefix": "BT",
      |        "region": "RO",
      |        "area": "",
      |        "homepage": "",
      |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9254000\/9254386_medium.jpg",
      |        "penaltyPoints": 0,
      |        "isBarred": false,
      |        "isPublic": false,
      |        "memberCount": 4
      |      }
      |    },
      |    {
      |      "position": 2,
      |      "label": "2.",
      |      "activity": 0,
      |      "credibility": 0,
      |      "numOpenMatches": 0,
      |      "startSeeding": 2,
      |      "seed": 2,
      |      "team": {
      |        "id": "10045453",
      |        "name": "TnB",
      |        "suffix": "npa",
      |        "prefix": "npa",
      |        "region": "RO",
      |        "area": "",
      |        "homepage": "",
      |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10045000\/10045453_medium.jpg",
      |        "penaltyPoints": 0,
      |        "isBarred": false,
      |        "isPublic": true,
      |        "memberCount": 3
      |      }
      |    }
      |  ]
      |}
    """.stripMargin

  trait initialisation extends Scope {
    val mockWSRequest = mock[WSRequest]
    val mockWSClient = mock[WSClient]
    val mockWSResponse = mock[WSResponse]
  }


  "EslService#listLeagues" should {
    "return a map of leagueId to league model on 200" in new WithApplication with initialisation {

      val eslService = new EslService(mockWSClient)

      mockWSResponse.json returns Json.parse(leaguesJson)
      mockWSResponse.status returns 200

      val promise: Promise[WSResponse] = Promise()
      val futureWSResponse = promise.future

      val mockRequest = mockWSClient.url(anyString) returns mockWSRequest
      mockWSRequest.get() returns futureWSResponse

      val result = eslService.listLeagues()

      there was one(mockWSRequest).get()

      promise.success(mockWSResponse)

      val leagues = Await.result(result, duration)

      leagues should beAnInstanceOf[Map[String, League]]
      leagues.head._2.id shouldEqual 142948
    }

    "handle a 500" in  new WithApplication with initialisation {
      val eslService = new EslService(mockWSClient)

      mockWSResponse.json returns Json.parse("{}")
      mockWSResponse.status returns 500

      val promise: Promise[WSResponse] = Promise()
      val futureWSResponse = promise.future

      mockWSClient.url(anyString) returns mockWSRequest
      mockWSRequest.get() returns futureWSResponse

      val result = eslService.listLeagues()

      there was one(mockWSRequest).get()

      promise.success(mockWSResponse)

      val leagues = Await.result(result, duration)

      leagues should beAnInstanceOf[Map[String, League]]
      leagues.size shouldEqual 0
    }
  }

  "EslService#getRankings" should {
    "return a ranking model on 200" in  new WithApplication with initialisation {
      val eslService = new EslService(mockWSClient)

      mockWSResponse.json returns Json.parse(rankingJson)
      mockWSResponse.status returns 200

      val promise: Promise[WSResponse] = Promise()
      val futureWSResponse = promise.future

      mockWSClient.url(anyString) returns mockWSRequest
      mockWSRequest.get() returns futureWSResponse

      val result = eslService.getRankings(1)

      there was one(mockWSRequest).get()

      promise.success(mockWSResponse)

      val rankings = Await.result(result, duration)

      rankings should beAnInstanceOf[Ranking]

      rankings.ranking.head.head.position shouldEqual 1
      rankings.ranking.head.head.contestant.id shouldEqual "9254386"
    }

    "handle a 500" in  new WithApplication with initialisation {
      val eslService = new EslService(mockWSClient)

      mockWSResponse.json returns Json.parse("{}")
      mockWSResponse.status returns 500

      val promise: Promise[WSResponse] = Promise()
      val futureWSResponse = promise.future

      mockWSClient.url(anyString) returns mockWSRequest
      mockWSRequest.get() returns futureWSResponse

      val result = eslService.getRankings(1)

      there was one(mockWSRequest).get()

      promise.success(mockWSResponse)

      val rankings = Await.result(result, duration)

      rankings should beAnInstanceOf[Ranking]

      rankings.ranking should beNone
    }
  }

}
