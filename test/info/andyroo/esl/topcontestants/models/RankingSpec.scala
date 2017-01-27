package info.andyroo.esl.topcontestants.models

import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.json.Json

@RunWith(classOf[JUnitRunner])
class RankingSpec extends Specification {

  val validRankingJson =
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

  val valid2RankingJson = """{
                            |  "type": "team",
                            |  "pager": {
                            |    "total": 186,
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
                            |        "id": "9763781",
                            |        "name": "Team Top Adin!",
                            |        "suffix": "",
                            |        "prefix": "T1",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9763000\/9763781_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 8
                            |      }
                            |    },
                            |    {
                            |      "position": 2,
                            |      "label": "2.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 14,
                            |      "seed": 14,
                            |      "team": {
                            |        "id": "9961250",
                            |        "name": "Silent Assassins",
                            |        "suffix": "SNS",
                            |        "prefix": "SNS",
                            |        "region": "EU",
                            |        "area": "Europe",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9961000\/9961250_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 3,
                            |      "label": "3.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 2,
                            |      "seed": 2,
                            |      "team": {
                            |        "id": "9250927",
                            |        "name": "Infinite eSports.WoT",
                            |        "suffix": "Go4WoT",
                            |        "prefix": "iE.WoT",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "http:\/\/infiniteesports.wixsite.com\/gaming",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9250000\/9250927_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 9
                            |      }
                            |    },
                            |    {
                            |      "position": 4,
                            |      "label": "4.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 52,
                            |      "seed": 52,
                            |      "team": {
                            |        "id": "10595715",
                            |        "name": "ASUS Repair Kit",
                            |        "suffix": "GO4WOT",
                            |        "prefix": "ASUS",
                            |        "region": "EU",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10595000\/10595715_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 14
                            |      }
                            |    },
                            |    {
                            |      "position": 5,
                            |      "label": "5-8.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 37,
                            |      "seed": 37,
                            |      "team": {
                            |        "id": "10385034",
                            |        "name": "NightNine",
                            |        "suffix": "",
                            |        "prefix": "NN",
                            |        "region": "DE",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10385000\/10385034_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 20
                            |      }
                            |    },
                            |    {
                            |      "position": 6,
                            |      "label": "5-8.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 11,
                            |      "seed": 11,
                            |      "team": {
                            |        "id": "9718064",
                            |        "name": "Delicious Vicious",
                            |        "suffix": "De\\'Vi",
                            |        "prefix": "De\\'Vi",
                            |        "region": "EU",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9718000\/9718064_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 9
                            |      }
                            |    },
                            |    {
                            |      "position": 7,
                            |      "label": "5-8.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 183,
                            |      "seed": 183,
                            |      "team": {
                            |        "id": "10772558",
                            |        "name": "Bad Image",
                            |        "suffix": "",
                            |        "prefix": "BAD",
                            |        "region": "EU",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10772000\/10772558_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 11
                            |      }
                            |    },
                            |    {
                            |      "position": 8,
                            |      "label": "5-8.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 8,
                            |      "seed": 8,
                            |      "team": {
                            |        "id": "10540960",
                            |        "name": "Bonfire of Faith.WGL",
                            |        "suffix": "",
                            |        "prefix": "LTU",
                            |        "region": "LT",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10540000\/10540960_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 8
                            |      }
                            |    },
                            |    {
                            |      "position": 9,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 152,
                            |      "seed": 152,
                            |      "team": {
                            |        "id": "10846014",
                            |        "name": "BeAsT Team",
                            |        "suffix": null,
                            |        "prefix": "",
                            |        "region": "DE",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10846000\/10846014_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 9
                            |      }
                            |    },
                            |    {
                            |      "position": 10,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 7,
                            |      "seed": 7,
                            |      "team": {
                            |        "id": "8828856",
                            |        "name": "Rag Nar\u00f6k",
                            |        "suffix": "",
                            |        "prefix": "RGN",
                            |        "region": "CZ",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/8828000\/8828856_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 11
                            |      }
                            |    },
                            |    {
                            |      "position": 11,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 38,
                            |      "seed": 38,
                            |      "team": {
                            |        "id": "10612539",
                            |        "name": "Dimenty",
                            |        "suffix": "",
                            |        "prefix": "",
                            |        "region": "EU",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10612000\/10612539_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 12,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 12,
                            |      "seed": 12,
                            |      "team": {
                            |        "id": "9525456",
                            |        "name": "midAREA eSport",
                            |        "suffix": "World of Tanks",
                            |        "prefix": "mAREA",
                            |        "region": "DE",
                            |        "area": "",
                            |        "homepage": "www.midarea.de",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9525000\/9525456_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 12
                            |      }
                            |    },
                            |    {
                            |      "position": 13,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 4,
                            |      "seed": 4,
                            |      "team": {
                            |        "id": "7681199",
                            |        "name": "TWB-Gaming",
                            |        "suffix": "TWB",
                            |        "prefix": "TWB",
                            |        "region": "RS",
                            |        "area": "",
                            |        "homepage": "http:\/\/www.TWB-Gaming.com",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/7681000\/7681199_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 10
                            |      }
                            |    },
                            |    {
                            |      "position": 14,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 3,
                            |      "seed": 3,
                            |      "team": {
                            |        "id": "9215879",
                            |        "name": "No Hard Feelings",
                            |        "suffix": "NHF",
                            |        "prefix": "NHF",
                            |        "region": "MG",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9215000\/9215879_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 11
                            |      }
                            |    },
                            |    {
                            |      "position": 15,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 15,
                            |      "seed": 15,
                            |      "team": {
                            |        "id": "8658584",
                            |        "name": "EasyPeasy. ",
                            |        "suffix": "EzPz",
                            |        "prefix": "EzPz",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "http:\/\/www.facebook.com\/EasyPeasyEzPz",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/8658000\/8658584_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 22
                            |      }
                            |    },
                            |    {
                            |      "position": 16,
                            |      "label": "9-16.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 17,
                            |      "seed": 17,
                            |      "team": {
                            |        "id": "10344905",
                            |        "name": "SUICIDE SQUAD WGL",
                            |        "suffix": "",
                            |        "prefix": "SQ",
                            |        "region": "DE",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10344000\/10344905_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 17,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 177,
                            |      "seed": 177,
                            |      "team": {
                            |        "id": "10803422",
                            |        "name": "ChickenPower",
                            |        "suffix": null,
                            |        "prefix": "",
                            |        "region": "DE",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10803000\/10803422_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 8
                            |      }
                            |    },
                            |    {
                            |      "position": 18,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 18,
                            |      "seed": 18,
                            |      "team": {
                            |        "id": "7474173",
                            |        "name": "Xpain",
                            |        "suffix": "",
                            |        "prefix": "Xp",
                            |        "region": "ES",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/7474000\/7474173_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 14
                            |      }
                            |    },
                            |    {
                            |      "position": 19,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 174,
                            |      "seed": 174,
                            |      "team": {
                            |        "id": "9907342",
                            |        "name": "... Not Even Close, Baby !",
                            |        "suffix": "",
                            |        "prefix": "",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/9907000\/9907342_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 11
                            |      }
                            |    },
                            |    {
                            |      "position": 20,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 20,
                            |      "seed": 20,
                            |      "team": {
                            |        "id": "10494613",
                            |        "name": "Team Paria",
                            |        "suffix": "Go4WoT",
                            |        "prefix": "Paria.Go4",
                            |        "region": "NL",
                            |        "area": "",
                            |        "homepage": "http:\/\/www.teamparia.com",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10494000\/10494613_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 21,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 21,
                            |      "seed": 21,
                            |      "team": {
                            |        "id": "10018232",
                            |        "name": "CYE.Go4WoT",
                            |        "suffix": "",
                            |        "prefix": "CYE",
                            |        "region": "RO",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10018000\/10018232_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": true,
                            |        "memberCount": 21
                            |      }
                            |    },
                            |    {
                            |      "position": 22,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 171,
                            |      "seed": 171,
                            |      "team": {
                            |        "id": "10817111",
                            |        "name": "Paraolimpiada_Gaming",
                            |        "suffix": "",
                            |        "prefix": "",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10817000\/10817111_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 23,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 23,
                            |      "seed": 23,
                            |      "team": {
                            |        "id": "8845177",
                            |        "name": "Power of Conception",
                            |        "suffix": "",
                            |        "prefix": "POC",
                            |        "region": "HU",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/8845000\/8845177_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 16
                            |      }
                            |    },
                            |    {
                            |      "position": 24,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 9,
                            |      "seed": 9,
                            |      "team": {
                            |        "id": "8557962",
                            |        "name": "ABSURD Team",
                            |        "suffix": "",
                            |        "prefix": "ABSRD",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "http:\/\/absurdteam.eu",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/8557000\/8557962_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 13
                            |      }
                            |    },
                            |    {
                            |      "position": 25,
                            |      "label": "17-32.",
                            |      "activity": 0,
                            |      "credibility": 0,
                            |      "numOpenMatches": 0,
                            |      "startSeeding": 153,
                            |      "seed": 153,
                            |      "team": {
                            |        "id": "10758110",
                            |        "name": "Madafaka TIM",
                            |        "suffix": "",
                            |        "prefix": "MTIM",
                            |        "region": "PL",
                            |        "area": "",
                            |        "homepage": "",
                            |        "logo": "https:\/\/eslgfx.net\/logos\/teams\/10758000\/10758110_medium.jpg",
                            |        "penaltyPoints": 0,
                            |        "isBarred": false,
                            |        "isPublic": false,
                            |        "memberCount": 9
                            |      }
                            |    }
                            |  ]
                            |}""".stripMargin

  val userRankingJson = """{
                          |  "type": "user",
                          |  "pager": {
                          |    "total": 240,
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
                          |      "startSeeding": 100,
                          |      "seed": 100,
                          |      "user": {
                          |        "id": "8671324",
                          |        "alias": "8671324",
                          |        "nickname": "Buffonator",
                          |        "region": "CH",
                          |        "homepage": "https:\/\/www.youtube.com\/channel\/UCEAKwwQ8BiOyAZdJPIwRUZA",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220614\/logos\/playerphotos\/8671000\/8671324_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 24,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 86
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 2,
                          |      "label": "2.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 87,
                          |      "seed": 87,
                          |      "user": {
                          |        "id": "8583241",
                          |        "alias": "8583241",
                          |        "nickname": "WarfighterTank98",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/\/logos\/playerphotos\/default_medium.gif",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 18,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 17
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 3,
                          |      "label": "3.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 126,
                          |      "seed": 126,
                          |      "user": {
                          |        "id": "8153025",
                          |        "alias": "8153025",
                          |        "nickname": "Sanya77",
                          |        "region": "HU",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220635\/logos\/playerphotos\/8153000\/8153025_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 21,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 4,
                          |      "label": "4.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 136,
                          |      "seed": 136,
                          |      "user": {
                          |        "id": "10656936",
                          |        "alias": "10656936",
                          |        "nickname": "PokerProsvk",
                          |        "region": "SK",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/\/logos\/playerphotos\/default_medium.gif",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 18,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 8
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 5,
                          |      "label": "5-8.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 28,
                          |      "seed": 28,
                          |      "user": {
                          |        "id": "10137955",
                          |        "alias": "10137955",
                          |        "nickname": "TheKawa_TS",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/\/logos\/playerphotos\/default_medium.gif",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 21,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 16
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 6,
                          |      "label": "5-8.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 6,
                          |      "seed": 6,
                          |      "user": {
                          |        "id": "10321430",
                          |        "alias": "10321430",
                          |        "nickname": "liefka",
                          |        "region": "LT",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220612\/logos\/playerphotos\/10321000\/10321430_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 24,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 39
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 7,
                          |      "label": "5-8.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 194,
                          |      "seed": 194,
                          |      "user": {
                          |        "id": "8674668",
                          |        "alias": "8674668",
                          |        "nickname": "WardaQs",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220700\/logos\/playerphotos\/8674000\/8674668_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 46,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 24
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 8,
                          |      "label": "5-8.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 240,
                          |      "seed": 240,
                          |      "user": {
                          |        "id": "9475871",
                          |        "alias": "9475871",
                          |        "nickname": "marek0lawa",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/9475000\/9475871_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 13,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 9,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 184,
                          |      "seed": 184,
                          |      "user": {
                          |        "id": "10135315",
                          |        "alias": "10135315",
                          |        "nickname": "jaeckefa",
                          |        "region": "DE",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/\/logos\/playerphotos\/default_medium.gif",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 23,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 10,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 26,
                          |      "seed": 26,
                          |      "user": {
                          |        "id": "10384377",
                          |        "alias": "10384377",
                          |        "nickname": "DeeJuu_Kat",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220802\/logos\/playerphotos\/10384000\/10384377_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 11,
                          |        "awards": 1,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 11,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 150,
                          |      "seed": 150,
                          |      "user": {
                          |        "id": "9156679",
                          |        "alias": "9156679",
                          |        "nickname": "Kabzelo",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220612\/logos\/playerphotos\/9156000\/9156679_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 13,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 39
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 12,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 181,
                          |      "seed": 181,
                          |      "user": {
                          |        "id": "9632153",
                          |        "alias": "9632153",
                          |        "nickname": "blazej49",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220451\/logos\/playerphotos\/9632000\/9632153_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 19,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 25
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 13,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 84,
                          |      "seed": 84,
                          |      "user": {
                          |        "id": "8734477",
                          |        "alias": "8734477",
                          |        "nickname": "ericos77",
                          |        "region": "FR",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220635\/logos\/playerphotos\/8734000\/8734477_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 30,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 13
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 14,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 174,
                          |      "seed": 174,
                          |      "user": {
                          |        "id": "8841942",
                          |        "alias": "8841942",
                          |        "nickname": "camper1j",
                          |        "region": "RO",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/8841000\/8841942_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 22,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 6
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 15,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 18,
                          |      "seed": 18,
                          |      "user": {
                          |        "id": "6294907",
                          |        "alias": "6294907",
                          |        "nickname": "wood4yankee",
                          |        "region": "AT",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20120117232544\/logos\/playerphotos\/6294000\/6294907_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 1,
                          |        "level": 82,
                          |        "awards": 7,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 138
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 16,
                          |      "label": "9-16.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 1,
                          |      "seed": 1,
                          |      "user": {
                          |        "id": "9278958",
                          |        "alias": "9278958",
                          |        "nickname": "abrams456",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220631\/logos\/playerphotos\/9278000\/9278958_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 13,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 18
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 17,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 144,
                          |      "seed": 144,
                          |      "user": {
                          |        "id": "10544222",
                          |        "alias": "10544222",
                          |        "nickname": "rezako78",
                          |        "region": "FR",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/10544000\/10544222_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 13,
                          |        "awards": 1,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 18,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 178,
                          |      "seed": 178,
                          |      "user": {
                          |        "id": "8425817",
                          |        "alias": "8425817",
                          |        "nickname": "Johahn",
                          |        "region": "DE",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220635\/logos\/playerphotos\/8425000\/8425817_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 22,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 18
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 19,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 14,
                          |      "seed": 14,
                          |      "user": {
                          |        "id": "8209682",
                          |        "alias": "8209682",
                          |        "nickname": "Piotr Lichograj",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/8209000\/8209682_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 17,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 8
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 20,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 180,
                          |      "seed": 180,
                          |      "user": {
                          |        "id": "8158444",
                          |        "alias": "8158444",
                          |        "nickname": "Figure9",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220802\/logos\/playerphotos\/8158000\/8158444_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 7,
                          |        "awards": 1,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 21,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 213,
                          |      "seed": 213,
                          |      "user": {
                          |        "id": "6557644",
                          |        "alias": "6557644",
                          |        "nickname": "RM7",
                          |        "region": "PL",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220802\/logos\/playerphotos\/6557000\/6557644_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 15,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 22,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 139,
                          |      "seed": 139,
                          |      "user": {
                          |        "id": "8952919",
                          |        "alias": "8952919",
                          |        "nickname": "Marino1983",
                          |        "region": "HR",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/8952000\/8952919_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 38,
                          |        "awards": 3,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 6
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 23,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 202,
                          |      "seed": 202,
                          |      "user": {
                          |        "id": "10520145",
                          |        "alias": "10520145",
                          |        "nickname": "MISTICNI",
                          |        "region": "RS",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220627\/logos\/playerphotos\/10520000\/10520145_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 13,
                          |        "awards": 1,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 24,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 169,
                          |      "seed": 169,
                          |      "user": {
                          |        "id": "10546161",
                          |        "alias": "10546161",
                          |        "nickname": "Lintero",
                          |        "region": "CZ",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/20170125220614\/logos\/playerphotos\/10546000\/10546161_medium.jpg",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 17,
                          |        "awards": 2,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 86
                          |          }
                          |        }
                          |      }
                          |    },
                          |    {
                          |      "position": 25,
                          |      "label": "17-32.",
                          |      "activity": 0,
                          |      "credibility": 0,
                          |      "numOpenMatches": 0,
                          |      "startSeeding": 168,
                          |      "seed": 168,
                          |      "user": {
                          |        "id": "10068980",
                          |        "alias": "10068980",
                          |        "nickname": "sdvhksjd",
                          |        "region": "BE",
                          |        "homepage": "",
                          |        "penaltyPoints": 0,
                          |        "photo": "https:\/\/eslgfx.net\/\/logos\/playerphotos\/default_medium.gif",
                          |        "premium": false,
                          |        "trustLevel": 0,
                          |        "level": 8,
                          |        "awards": 1,
                          |        "isBarred": false,
                          |        "stats": {
                          |          "leagues": {
                          |            "wins": 36
                          |          }
                          |        }
                          |      }
                          |    }
                          |  ]
                          |}""".stripMargin

  val nullRanking = """{"type":"team","pager":{"total":0,"limit":25,"offset":0},"ranking":null}"""

  "Ranking model" should {
    "parse useful json" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val rankings = Json.parse(validRankingJson).as[Ranking]

      rankings.ranking.head.head.contestant.id shouldEqual "9254386"
    }

    "parse large useful json" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val rankings = Json.parse(valid2RankingJson).as[Ranking]

      rankings.ranking.head.head.contestant.id shouldEqual "9763781"
    }

    "parse large user contestant json" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val rankings = Json.parse(userRankingJson).as[Ranking]

      rankings.ranking.head.head.contestant.id shouldEqual "8671324"
    }

    "handle a null ranking" in {
      import info.andyroo.esl.topcontestants.models.JsonFormats._

      val rankings = Json.parse(nullRanking).as[Ranking]

      rankings.ranking should beNone
    }
  }

}