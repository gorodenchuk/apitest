package testconfig.asserts;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List <String> organizationUris = new ArrayList<>();
        organizationUris.add("http://feed.thomsonreuters.com/1-4295903076");
        organizationUris.add("http://feed.thomsonreuters.com/1-4295904307");
        ScoringResultsAsserts scoringResultsAsserts = new ScoringResultsAsserts();
        scoringResultsAsserts.assertOrgUriInResponse(200, jsonDataSourceString, organizationUris);
    }

    static String jsonDataSourceString = "{\n" +
            "    \"pageContent\": [\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/85f90ba1a7f7aff9cc00e59ff80f7730\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295889840\",\n" +
            "                \"name\": \"Hexagon AB\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/29/2017 01:51:45 PM\",\n" +
            "            \"lastUpdatedDate\": \"11/29/2017 01:51:45 PM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295904307\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.6,\n" +
            "            \"title\": \"UPDATE 1-Prosecutor asks for 18-month prison term for Hexagon CEO Rollen<HEXAb.ST><NEXT.OL>\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/df0720e0182d1c12afb1d48aaa6d358e\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295861552\",\n" +
            "                \"name\": \"Tecsys Inc\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/30/2017 10:05:01 PM\",\n" +
            "            \"lastUpdatedDate\": \"11/30/2017 10:10:07 PM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295904307\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.51,\n" +
            "            \"title\": \"BRIEF-Tecsys Reports Q2 Earnings Per Share C$0.10<TCS.TO>\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/d8eaa5fafa3cfd1d47a1347021dd247f\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295886383\",\n" +
            "                \"name\": \"Emperia Holding SA\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/24/2017 09:34:45 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/24/2017 09:47:22 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295904307\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.56,\n" +
            "            \"title\": \"BRIEF-Proposed purchase price in tender offer reflects fair value of Emperia Holding - management<EMP.WA>\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/e4f4193b25021a71c96eb81a1ba8d54d\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-5034757565\",\n" +
            "                \"name\": \"Ophir Energy PLC\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/24/2017 07:44:00 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/24/2017 07:44:00 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295904307\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.3,\n" +
            "            \"title\": \"UPDATE 1-UK Stocks-Factors to watch on Nov 24\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/e986da054220a67027c3b05f3b4ab713\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295890591\",\n" +
            "                \"name\": \"Sika AG\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/28/2017 06:14:23 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/28/2017 06:14:23 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.26,\n" +
            "            \"title\": \"Swiss stocks - Factors to watch on Nov 28\",\n" +
            "            \"relationType\": \"SupplierOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/bb035c71c8d998640cfa4c576cb3eb7a\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295912046\",\n" +
            "                \"name\": \"CNX Resources Corp\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/27/2017 07:44:39 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/27/2017 07:55:04 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.55,\n" +
            "            \"title\": \"BRIEF-Export Development Bank of Egypt Q1 Consol Profit Rises<EXPA.CA>\",\n" +
            "            \"relationType\": \"SupplierOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/bf991dc265c735734ec8a99d4a1fadef\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295875738\",\n" +
            "                \"name\": \"Salini Impregilo SpA\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/30/2017 04:10:32 PM\",\n" +
            "            \"lastUpdatedDate\": \"11/30/2017 04:45:00 PM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.58,\n" +
            "            \"title\": \"BRIEF-Salini Impregilo Wins EUR 186 Mln Contract As Part Of Consortium<SALI.MI>\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/d1928a70e32d6e27005afdc22e170fbe\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295897722\",\n" +
            "                \"name\": \"PayPoint plc\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/30/2017 07:00:58 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/30/2017 07:45:48 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295904307\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.55,\n" +
            "            \"title\": \"BRIEF-Paypoint posts HY earnings per share of ?29.1? pence<PAYP.L>\",\n" +
            "            \"relationType\": \"SupplierOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/c260f3ba796a0216557d4bcf1da791f0\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4295885704\",\n" +
            "                \"name\": \"BW Offshore Ltd\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/24/2017 06:30:57 AM\",\n" +
            "            \"lastUpdatedDate\": \"11/24/2017 06:45:54 AM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"Boeing Co\",\n" +
            "                    \"industry\": \"Commercial Aircraft Manufacturing\",\n" +
            "                    \"uri\": \"http://feed.thomsonreuters.com/1-4295903076\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.6,\n" +
            "            \"title\": \"BRIEF-Bw Offshore q3 EBITDA above forecast <BWO.OL>\",\n" +
            "            \"relationType\": \"SupplierOf\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": \"http://rdf.entagen.com/ns/document/9af279864aa2b437df5d09af2b20136e\",\n" +
            "            \"company\": {\n" +
            "                \"uri\": \"http://feed.thomsonreuters.com/1-4296390032\",\n" +
            "                \"name\": \"Symbility Solutions Inc\"\n" +
            "            },\n" +
            "            \"createdDate\": \"11/29/2017 10:00:04 PM\",\n" +
            "            \"lastUpdatedDate\": \"11/29/2017 10:03:11 PM\",\n" +
            "            \"source\": \"RTRS\",\n" +
            "            \"organizations\": [\n" +
            "                {\n" +
            "                    \"name\": \"International Business Machines Corp\",\n" +
            "                    \"industry\": \"Other IT Services & Consulting\",\n" +
            "                    \"uri\": \"321\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"relevanceScore\": 0.56,\n" +
            "            \"title\": \"BRIEF-Symbility Solutions Reports Qtrly Revenue $11.3 Million <SY.V>\",\n" +
            "            \"relationType\": \"IsCompetitorOf\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"pageNumber\": 1,\n" +
            "    \"totalElements\": 641,\n" +
            "    \"totalPages\": 65\n" +
            "}";
}