CREATE TABLE GAIANDB.CISPACES_INFOPROV
(
    WBOXID varchar(255) PRIMARY KEY NOT NULL,
    PROVST CLOB,
    PLOCK smallint,
    CHAINING varchar(72)
);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Milesinfobox', '{ }', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('New_Chat_Room', '{ 
  "http://www.itacispaces.org/JoinChatb5f0665d-4a2f-4248-8581-108076fb953a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysis5efb799f-2424-4bab-923e-5e9c015fef12" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "5efb799f-2424-4bab-923e-5e9c015fef12" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:1386cbe71827c35e72df609b589bc8fc"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat5efb799f-2424-4bab-923e-5e9c015fef12"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of New_Chat_Room" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysisb5f0665d-4a2f-4248-8581-108076fb953a"
    }
     ]
  }
   ,
  "_:2067504bf68052c798bb76d375979e26" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-06-22T01:35:15Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChatb5f0665d-4a2f-4248-8581-108076fb953a"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat9e432bad-3093-421d-ab3a-dc61a5a188a6" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis5efb799f-2424-4bab-923e-5e9c015fef12"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "f88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fed7ea05f802286443335f364359edef"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of New_Chat_Room" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat5efb799f-2424-4bab-923e-5e9c015fef12" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysisb5f0665d-4a2f-4248-8581-108076fb953a"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:1386cbe71827c35e72df609b589bc8fc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-04T11:10:24Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat5efb799f-2424-4bab-923e-5e9c015fef12"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysisb5f0665d-4a2f-4248-8581-108076fb953a" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2067504bf68052c798bb76d375979e26"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "b5f0665d-4a2f-4248-8581-108076fb953a" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChatb5f0665d-4a2f-4248-8581-108076fb953a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of New_Chat_Room" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f"
    }
     ]
  }
   ,
  "_:-7196fb32:15d98cfed09:-7fe7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:31:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat9e432bad-3093-421d-ab3a-dc61a5a188a6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Miles" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/UK"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "_:fed7ea05f802286443335f364359edef" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-06-22T01:34:56Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisf88d7d64-fb5e-4b6e-8e7b-0214e3ff0a1f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysis9e432bad-3093-421d-ab3a-dc61a5a188a6" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "9e432bad-3093-421d-ab3a-dc61a5a188a6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:-7196fb32:15d98cfed09:-7fe7"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat9e432bad-3093-421d-ab3a-dc61a5a188a6"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of New_Chat_Room" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis5efb799f-2424-4bab-923e-5e9c015fef12"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Miles', '{ 
  "_:9a473ea766b28c2456299eabb520ced2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis77564701-b70f-431d-8c83-382ea6962fbc" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "77564701-b70f-431d-8c83-382ea6962fbc" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:8fa132c9afb4b90b7a84ecd43307ddb5"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat77564701-b70f-431d-8c83-382ea6962fbc"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_Cap16_Joe_uncertainty15b82e7b-4492-4e2b-a651-1b9247cee45c"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode607cd71c-63ad-4493-b705-320c10abf68c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:09f1d18acc51175bfb8736bddcdc1da7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:30b3aed8d8bcea8e6d68e5a456669f03" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:f5eee51c3ba5d6a71ca261ed6c6b065c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Biol_Analysis" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Field_Tests"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Bio_Consultant"
    }
     ]
  }
   ,
  "_:f5e7c8f652ddfd856cefac6c8fde3f08" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:506755fb191ad9be7b5be9643fcdb7ea" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:1f08ea395f1d2549ecd8d68b390d19a6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGOReportformat" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "_:a59d0c312375a15151e7ccd90a7bc132" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Field_Tests" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:8af7f0a4067088f4360df87e4248833f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:ac63d7b3dc22aad1aff06e29d9e29007" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:7c1d41a75cf090c5f68be00eef648d19" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:c83a9bc6734e52b33f979a14e9caaad0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode9c308cba-6f53-4ede-9444-fe3b95a03426" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:0e1e97166d4f6120fc462dd6be44fd9d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:92889a0cbca374e2558dc335fb7eccf2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:633d600841712b1ab3842f37a66bcc3b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:61ff32fb9efd8587e9fd736f8e983984" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:4b3af337cc573f217e3d192bd8f47ede" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:ad3b6e317bdf84c88de021ce2e30955f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e1c394d29e6c8683e579c1ca08d4644e"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "139a6d45-9576-4066-9907-134f2c429f0b" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode607cd71c-63ad-4493-b705-320c10abf68c"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There are bacteria in the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:de9c1b694adabb3788d045644821f7ed" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:47:15Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed"
    }
     ]
  }
   ,
  "_:713478c049776fc3c3861d1365f73a6d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:47:17Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess71633bcb-a03e-45b6-a526-d71ae31e2de5"
    }
     ]
  }
   ,
  "_:a7d425a265ca078cd8ba9ff85a6b3452" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:01d2a5fc268407aa8fef281ca2929ebf" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:a74cf6379bf318a211bccb77f136b412" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat2ac94e87-357e-43bf-bc42-1239d1936301" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis77564701-b70f-431d-8c83-382ea6962fbc"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:13b2528c:15dc6a280a2:-7f7f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-09T11:08:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat6ff0aed3-07c4-4823-a3e1-b9f1bb5f742b"
    }
     ]
  }
   ,
  "_:09cba603483eb549323cba9886c5cc73" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:49bc9eef9573d1c28acd04875d05210c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:ba5a1614b7d828292ea81cd4cea09fd1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:6f5fca54afb510b9067d2e0ae699eddd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeed55d309-2f63-4cb3-a420-ee8f0ed06617" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:29e6c5bef94a8bb0bb985ef82851726b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7b017a32a656169847731bdc5b75ebcc"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c1b39578e6beddb0b8112abc53b4a930"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:df912d1cec198d6a1c1d7d84d9c45224"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:29bca63695bcfab2c32002f13723112b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:2e04284637ea93561afed4d41f5399dd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:45fd0f448b632e1422826fdec5ec3d23"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:92d9e88226fdafef4ba850cea681d0eb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f2446d864bd36765f9fd73f9926f8289"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:529ac56efb5abcc1a57e4e04ba1c4307"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ac63d7b3dc22aad1aff06e29d9e29007"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:20bcaabde5a463533ae150532064b7fb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:33dba1fdabd62b0c6be0e5a3ec3c9066"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:61a1af849f94a8ef5399a849dd929f9a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:82e9b2a8b50b7f29ca3fea210fd888b5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:66aea5579dc7f62f9801e0bb62fe822a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:01d2a5fc268407aa8fef281ca2929ebf"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c969d5d62dffd412cbf0ff4e59b795fe"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:aa80d27686d88c3aa332e2ba9fc6a884"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3d9bbcfc184493385265ba74b7fe5b0f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1e988c14d65db9e8c1808a0a288d205a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9b23f494bd3dbe8673b2353f553ef257"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:812f851f9057e83fa7e738d9faf79327"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b0ec51dda0d3ee41f1234c59ed3afba5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3907960e6eedcf345a99ff7f9bb4750f"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "ed55d309-2f63-4cb3-a420-ee8f0ed06617" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Illness among young and elderly people in Kishshire caused by bacteria" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Medical_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LivestockDeathPictures" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:18014c9d41de5eb0de912c7230a338b9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGOChemicalLab" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:6fd76f85352757b12cf62681da80e6f8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:1e1e700ceade962a7661ee79fb6ee3ce" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:b53de502f21a64246a982db54bd06b67" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:65cc3eb0684bbbcd7f965709447c89f7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:a6f43349fd65efb8d9bb62aaf4e6ad38" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:c3050a629e297ac2ff78c7feeab46c80" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:75350a4628734de5e8262f8b4b453685" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec503be16-2320-4ce7-9b57-d4646e6dfba2" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:48a2a1143241656dead24f6f23cafc6f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:e32511c532dda2372a7280098d1de8af"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4cf8caa3a4c8d84fb55684165be4dc91"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:24b9d02e4b54ecf31b2f44d551914d6a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ae18786cfa2e721e07198653a2c89419"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:754c7480cdbf55e8c1c0c22b45c12dd8"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c503be16-2320-4ce7-9b57-d4646e6dfba2" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Unidentified illness affects the local livestock in Kishshire" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US_Patrol_report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/5casesOnSouthAreaRep" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:d1b4c2b6840eee682e8a0ddaec2c3218" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:568a55e21ffe7a98bc84b09a367d60a7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CurrentAnalysis67ab7c18-d3ca-4bc9-9486-ef413345da1d" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:43ff66dd842ace039338a1ee6b6616c6"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "67ab7c18-d3ca-4bc9-9486-ef413345da1d" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Inspect67ab7c18-d3ca-4bc9-9486-ef413345da1d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed"
    }
     ]
  }
   ,
  "_:67762541622293179372f36d13fcdd92" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:47ef110fef8715594083891d8948d2b0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:241df858c984f624a9288c8e2638458c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US_Patrol_report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:ea164e29a92df6673f23ee7f27b9aea7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b7f5e8a4fe13891b122585bfc6ede659"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d26e7a4c6bd928436101dd2070f2bfe5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:24aea55c86af2414a91fcaf1f3fe8bf1"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b98074d0cfec53fd035c18ea4d30888d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:39275cee7241e5ad225e0e0c5dbbe426"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:25dd08d71ee8da73ef676e200d8fb096"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1c451e5bd86d67dc7577f6f8ebcbd2ad"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8892e82b2403a1d3e61d4ada6cdc4abd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:82dcc1e45a4a076d732f5c754ebd3cdf"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:73202a5ac2b2d38b99daac164735ffcf"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8a10d29452632645090dba97449c8b34"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3d948de40683ddd1ca8520fdfa040d90"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/FarmDailyReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Type" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US_Patrol_report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/USTeamPatrol"
    }
     ]
  }
   ,
  "_:46e51f27dc21524ac5d95e2274e843e7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:3b9dea68ee33b2fe590917adcf57779b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-11T03:08:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat13ce6836-f659-4e44-9e61-c6d9a98dbc36"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Bio_Consultant" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:de1996bc961c87ec3eaf6a748bc42aff" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aerial_Bacteria_Investigation" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aerial_Bact_Study"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Biologist_Group"
    }
     ]
  }
   ,
  "_:fa716cc5dc434b983306753f0f20ae0c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:b424d3a10e38ca0a17a19a27d8220f4d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:8892e82b2403a1d3e61d4ada6cdc4abd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:83b8516d8b0ff0abae5a0961cf783d34" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-11T03:08:31Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat22021509-6b32-45b1-b02e-278d1cd1c659"
    }
     ]
  }
   ,
  "_:a4d26a6496a5313655dfe86b1cf9ab86" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:24f542a99b1402f9c13c6bf37dcee7f7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:8f640c55e624f36aa3c3f64c14791388" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:eaf2cda5a30fdd71ccca9a89f8cccc10" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGOMedicalTeam" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:e32511c532dda2372a7280098d1de8af" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:39ed62aeaffa2e8342dd0bdb2725642d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:ba774e4a694f260548754559d601ee51"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "94fb8d47-7068-4a1e-bd8f-73c5548aff92" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccessd0247891-d5c1-4bc8-84ee-a1944dd8806e"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Illness among young and elderly people in Kishshire caused by bacteria" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeed55d309-2f63-4cb3-a420-ee8f0ed06617"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:de9c1b694adabb3788d045644821f7ed"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "8196e62d-f562-475f-9b45-fe9f55bba1ed" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox ofJoe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
   ,
  "_:705fc1d6175e19bfe084809fe525006b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:b98074d0cfec53fd035c18ea4d30888d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:87d492055dc5f8a42139610a97303fd2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:8d6261f4cffb50929eaa4d38f4bcf141" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:96f35e15ff2fb6fcc4e98cd0587eb994" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:aa80d27686d88c3aa332e2ba9fc6a884" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:2caa5631ba9c7f1d6be7b3c98c56e9dd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T09:03:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save65b95d4b-5eb1-4ae6-a115-025a6eecfd8a"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Biologist_Group" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:80989601a0587ee93ee3633102241eef" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:e1c394d29e6c8683e579c1ca08d4644e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T07:56:37Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode607cd71c-63ad-4493-b705-320c10abf68c"
    }
     ]
  }
   ,
  "_:3d948de40683ddd1ca8520fdfa040d90" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:a5f09e193d05fc7c9b10e88eeb144b72" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:302a519329564f4add13d554fad3fe0d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:bc6f226e8b980879ba643278605534cb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:d3a0c75b1a701546abda8acead76105e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/2casesOnNorthAreaRep" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:79c5938bc8dccb4a2060a4f102f9a1c3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:5bde32d1d9299af4ca99038e5cce0ceb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:5c1884ff06e7f4982f5c21a62f92b6cd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:7e3a7572d918d78f60167450918f70d9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:c398b4f87bc509d9094259132c0996a6"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "df4b8d22-5940-4f72-a5e6-66584d6e2239" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess92be1bf4-1157-459f-8e8b-e46bff0f5bc9"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Unidentified illness affects the local livestock in Kishshire" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec503be16-2320-4ce7-9b57-d4646e6dfba2"
    }
     ]
  }
   ,
  "_:eba641082b6dd6a6b2edd344bb0deb17" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:20bcaabde5a463533ae150532064b7fb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:fd048bd872d8405a90510d60f97324dd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T07:56:44Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded8228cc0-8520-4ce7-82dd-586c579a81d7"
    }
     ]
  }
   ,
  "_:e698190ff22db90357f2a997efca88f7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:704008c2f998c58c11ba85c00ec441bb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:f13fae0103766f4e358ec3843d6a6095" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:8b84f407021ebda14c207682a434b0ac" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:c1a910e34583568e2bcecd5b336822f8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/KishFarmer" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LabWaterTesting" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasInformedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/WaterSampleData"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MonitorWaterRequirements"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGOLabAssistant"
    }
     ]
  }
   ,
  "_:e49ba154b93792b1d041f1129b0a3014" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Save65b95d4b-5eb1-4ae6-a115-025a6eecfd8a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CurrentAnalysis67ab7c18-d3ca-4bc9-9486-ef413345da1d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:0a09baf957f3e27db3e3408f33aa5bce" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:a57650a5c6d150f77f532aea56599198" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:b850992ada026c8a41343dcac0fe80d5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/WaterSensor" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:c398b4f87bc509d9094259132c0996a6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:39Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess92be1bf4-1157-459f-8e8b-e46bff0f5bc9"
    }
     ]
  }
   ,
  "_:61d3b1cb52ddd70131e4bbf9487b60e3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:3406421ef6bcce06c0e152e4078c3fde" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-11T03:08:17Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat2ac94e87-357e-43bf-bc42-1239d1936301"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysis22021509-6b32-45b1-b02e-278d1cd1c659" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:83b8516d8b0ff0abae5a0961cf783d34"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "22021509-6b32-45b1-b02e-278d1cd1c659" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat22021509-6b32-45b1-b02e-278d1cd1c659"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis13ce6836-f659-4e44-9e61-c6d9a98dbc36"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat77564701-b70f-431d-8c83-382ea6962fbc" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_Cap16_Joe_uncertainty15b82e7b-4492-4e2b-a651-1b9247cee45c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:8a6683d3b1056f69acb4f0321b0e2629" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:94ca27c06cb81154e1cf2f2dea8581ea" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:4595214ad17f7cf35ab180b6ecf3f1f4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGOLabAssistant" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:29b62879ade62979a6fa9dccf11a8cd7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:21d41fbb199f000b0f82962ef08826e4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis6ff0aed3-07c4-4823-a3e1-b9f1bb5f742b" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "6ff0aed3-07c4-4823-a3e1-b9f1bb5f742b" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:13b2528c:15dc6a280a2:-7f7f"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat6ff0aed3-07c4-4823-a3e1-b9f1bb5f742b"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis22021509-6b32-45b1-b02e-278d1cd1c659"
    }
     ]
  }
   ,
  "_:fd54d6a72496b3c4de66f652fc0dd8ec" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:3750da361622a921c3c9b66fb15ca048" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:2ade2cd370260f6205a1fa6422abf8dd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:44b7d3fbf9e4755a8b1321c92b32d298" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/WaterSampleData" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:1d1e6f18b10933c2c6ef97105e5b3014"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:231e462699bedf04344cb5e34a7280e1"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d1b4c2b6840eee682e8a0ddaec2c3218"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:30b3aed8d8bcea8e6d68e5a456669f03"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fb1c607927b333e7879840c906a9ee08"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f5e7c8f652ddfd856cefac6c8fde3f08"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:241df858c984f624a9288c8e2638458c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d1bbb953666cd8d93b310ff3cee6df3c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:506755fb191ad9be7b5be9643fcdb7ea"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7e3a7572d918d78f60167450918f70d9"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:78e9d030958e9c9da070108ee7e285ea"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1e7c2b5a07445ab6c9f5b04b185c7afb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:2fae9090974f7412fcc6fd2a0e6969fe"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c83a9bc6734e52b33f979a14e9caaad0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:e698190ff22db90357f2a997efca88f7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b424d3a10e38ca0a17a19a27d8220f4d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d155e2fdf76fa88737e806b7af575470"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fda8368a7a4cd6049ae88970ac7e6b63"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a4d26a6496a5313655dfe86b1cf9ab86"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4fe2844c398ce674aafdcdbaf31eef1a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c414fc17305f21760c3a34ec3381b1e0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6d8d4e32a51e088a2c24e56d6846b7a9"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:2333fcffa8cc68958d5f061fb6d3fab8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8f640c55e624f36aa3c3f64c14791388"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:141dbb9f5c7e586542696c999b4eb741"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3195b59fed12dfa0f184e2a9955fb0b6"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:71f4db0db5a03ef09c2468b5c67607f4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:00ac526e9bcf0b331b42c390a3274a5f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9dbcda080dcd2459f9d9fc8f0757d0ad"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ae72727da722d24b3bb14ebc72f152ab"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:27d0849cdb085ff4f35f997749051822"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d10dea788b73f3b1aa72f5169595d227"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:379c7015c4261ae69f5cd2158c4d7bdc"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:80989601a0587ee93ee3633102241eef"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:73ebaefc001da1c53fac1f03fcf93b0c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:82e3e52351d3808a626483da2c88ba51"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fd54d6a72496b3c4de66f652fc0dd8ec"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:07020f1e4f4da21c3b65b3b468837e8a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:c1b39578e6beddb0b8112abc53b4a930" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:2c61f7caee394b4b32e9bc80609f1bd0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:3b269e330718345ff0fec8343a3c07c8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:7abcb2d7f19981f2926b91072e09f759" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:7f60370b788a44864e23df73a121b9bd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:39275cee7241e5ad225e0e0c5dbbe426" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:736239ec5bc42d76c7b59374b1963990"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "1fdf3463-55fa-452b-ba95-4dcc63fa182f" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Water_Bacteria_Investigation"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Waterborne bacteria have formed by a sewage leakage in the water supply pipes" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:824570a92ce75afbbc5d947f91c096c7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:47:19Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess62fd6a48-5891-4e9f-b672-a226d8d02d05"
    }
     ]
  }
   ,
  "_:107e1d89eda0282c9e8a3764f1c22ae7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:1c0486142854e28ff24f39fb1dbbf2ab" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:824570a92ce75afbbc5d947f91c096c7"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "ffebea19-e42a-41a1-a215-bb8acd1aebd2" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess62fd6a48-5891-4e9f-b672-a226d8d02d05"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Toxic Bacteria contaminated the local water system in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node62f032fa-7deb-48a2-9e17-aeb08b2b5c31"
    }
     ]
  }
   ,
  "_:9ee7e2fb08e18c003eb2471654c922fe" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpAccess71633bcb-a03e-45b6-a526-d71ae31e2de5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodef7666697-1b88-412d-a62d-9e90e5187b97"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:76b392fe324484faeb5f51d6e4d579bd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:5a2425c54a36011ada3152deeecfd184" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpAccessd0247891-d5c1-4bc8-84ee-a1944dd8806e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeed55d309-2f63-4cb3-a420-ee8f0ed06617"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/GenerateReq" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MonitoringWaterSupply"
    }
     ]
  }
   ,
  "_:fda8368a7a4cd6049ae88970ac7e6b63" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:61a1af849f94a8ef5399a849dd929f9a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:7a9da2a37e596560445b2a74c8ad7d72" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:c414fc17305f21760c3a34ec3381b1e0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:c5e3d349ccf9d9e472db069fff2d629c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:be8e584b901c572152640476aa861869" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:2333fcffa8cc68958d5f061fb6d3fab8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:fae006ab975b34bde234e241aa8ca595" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:199c2d5ff99b0f571e33daadd095d027" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-31T04:17:03Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save15b82e7b-4492-4e2b-a651-1b9247cee45c"
    }
     ]
  }
   ,
  "_:f7e4e1ee2210dec4ac7d67ecc9b130e8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:141dbb9f5c7e586542696c999b4eb741" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:66aea5579dc7f62f9801e0bb62fe822a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis13ce6836-f659-4e44-9e61-c6d9a98dbc36" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "13ce6836-f659-4e44-9e61-c6d9a98dbc36" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3b9dea68ee33b2fe590917adcf57779b"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat13ce6836-f659-4e44-9e61-c6d9a98dbc36"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis2ac94e87-357e-43bf-bc42-1239d1936301"
    }
     ]
  }
   ,
  "_:87c13cff3ecbadb8d36a6ac79bf15421" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:ae18786cfa2e721e07198653a2c89419" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:7f2c3d5dfeb4da5da07d52eacff49caa" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Save15236c11-3c2a-4e5e-a398-084026b654e4" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_AFM_phase165b95d4b-5eb1-4ae6-a115-025a6eecfd8a"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/FarmDailyReport" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:a6f43349fd65efb8d9bb62aaf4e6ad38"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d45830b666f752ded5e1124cbcdf585f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fd6bf8e4c42719d6c24ebe75317a98f5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4b8d9fc11df94ab49781f23f09f46ca4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5bde32d1d9299af4ca99038e5cce0ceb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:2c61f7caee394b4b32e9bc80609f1bd0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:066319ccc57ad9fe46889bcdb6d8609c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:276d6709bc12468a9de799e0afd3b467"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ccfaab69c450984cf303e819cdfdd7c6"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:0e1e97166d4f6120fc462dd6be44fd9d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4b822d759d83fa0afa1b3550552f965d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6d2c7758de244a2c3dffe7f567d15b82"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a5f09e193d05fc7c9b10e88eeb144b72"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ]
  }
   ,
  "_:ccfaab69c450984cf303e819cdfdd7c6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:1e988c14d65db9e8c1808a0a288d205a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:daa41200bf41a564d086426deb490d19" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat22021509-6b32-45b1-b02e-278d1cd1c659" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis13ce6836-f659-4e44-9e61-c6d9a98dbc36"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Miles" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/UK"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "_:79d080ba3c9e2a32196c8dabb0f60d84" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:f3ebccfba6c6606a0dc39efb83ab1ad4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:d30951833e4706343ed85e57375f435c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Save15b82e7b-4492-4e2b-a651-1b9247cee45c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_AFM_phase1half15236c11-3c2a-4e5e-a398-084026b654e4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:f04da659ead32cebdd5e39126efffac5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Deliver" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Medical_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGOMessenger"
    }
     ]
  }
   ,
  "_:dd4ead6f988908a48b1afee1c06bac05" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:3c0f48497ad4c7e793d4d969d0aa3629" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:29e6c5bef94a8bb0bb985ef82851726b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:ea63cec40f16dee27539a66f2d5f86d1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:231e462699bedf04344cb5e34a7280e1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:7b017a32a656169847731bdc5b75ebcc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:fd6bf8e4c42719d6c24ebe75317a98f5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:fefe49ec3f4900075efbffe1b7dcdeb4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:df912d1cec198d6a1c1d7d84d9c45224" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:d1bbb953666cd8d93b310ff3cee6df3c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:0df695275a6404feab20602ec60286ff" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:92d9e88226fdafef4ba850cea681d0eb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:f5377fe463452f3b4e7203dbcfaea8fc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:f9322001e6896e1280007e0c090bb50a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:529ac56efb5abcc1a57e4e04ba1c4307" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:e6b103b71f48a815f8889803468d97e2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:44:49Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save15236c11-3c2a-4e5e-a398-084026b654e4"
    }
     ]
  }
   ,
  "_:1c451e5bd86d67dc7577f6f8ebcbd2ad" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:1e7c2b5a07445ab6c9f5b04b185c7afb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:05d9343c1e1f367236b73499d5cc075b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:decbddbc329cbf1a21d33449baafdf07" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:ba774e4a694f260548754559d601ee51" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:47:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccessd0247891-d5c1-4bc8-84ee-a1944dd8806e"
    }
     ]
  }
   ,
  "_:ba5411e5c90dd507a0be95a6bc4d6e5c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/USTeamPatrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGOMessenger" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/SAVED_AFM_phase165b95d4b-5eb1-4ae6-a115-025a6eecfd8a" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2caa5631ba9c7f1d6be7b3c98c56e9dd"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "65b95d4b-5eb1-4ae6-a115-025a6eecfd8a" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save65b95d4b-5eb1-4ae6-a115-025a6eecfd8a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CurrentAnalysis67ab7c18-d3ca-4bc9-9486-ef413345da1d"
    }
     ]
  }
   ,
  "_:794cfb94db348dd95e746732260ac16c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T07:56:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aerial_Bacteria_Investigation"
    }
     ]
  }
   ,
  "_:667aca47f510700704325d596cd9588b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:4fe2844c398ce674aafdcdbaf31eef1a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:21bcbb7e7341a350a021e1831754398c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:701a944f2129e921bbf95d43516d62c2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:8a10d29452632645090dba97449c8b34" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:fb9864dc90f0f5734167f87dbda21aff" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:713478c049776fc3c3861d1365f73a6d"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "d855f306-be9a-40f7-a0d5-6d71b1a2b5ba" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccess71633bcb-a03e-45b6-a526-d71ae31e2de5"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "NGO Lab reports examined the contamination" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodef7666697-1b88-412d-a62d-9e90e5187b97"
    }
     ]
  }
   ,
  "_:7259c050f90dadf2c637eb8fa08c556d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:9457ea20807eed2c21c2f71bd1de2787" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T07:56:53Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9c308cba-6f53-4ede-9444-fe3b95a03426"
    }
     ]
  }
   ,
  "_:f68c26ffb4730acb6ac5ea2274660790" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:3dcefaff0b8e5be0830032f5885e129f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodef7666697-1b88-412d-a62d-9e90e5187b97" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2ade2cd370260f6205a1fa6422abf8dd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fefe49ec3f4900075efbffe1b7dcdeb4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:67762541622293179372f36d13fcdd92"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5c1884ff06e7f4982f5c21a62f92b6cd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7abcb2d7f19981f2926b91072e09f759"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f9322001e6896e1280007e0c090bb50a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1c0486142854e28ff24f39fb1dbbf2ab"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:eba641082b6dd6a6b2edd344bb0deb17"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:311e9f2e3b213570291c40c5bc51e080"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7c1d41a75cf090c5f68be00eef648d19"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5a2425c54a36011ada3152deeecfd184"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:cbf0271b3eebb7fd3e8852ae26d045f4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:667aca47f510700704325d596cd9588b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:eaf2cda5a30fdd71ccca9a89f8cccc10"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c93b6e3698444c4da471f3a4031e0667"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4b3af337cc573f217e3d192bd8f47ede"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4103f925cdbfeb994c2b1238634019b9"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ad3b6e317bdf84c88de021ce2e30955f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:0a09baf957f3e27db3e3408f33aa5bce"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a74cf6379bf318a211bccb77f136b412"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:87c13cff3ecbadb8d36a6ac79bf15421"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9703abbab5f129b3b2a8ff392a702bcb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:49bc9eef9573d1c28acd04875d05210c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:0f6bf7b50eb43f13c2c455c10d751be7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:65cc3eb0684bbbcd7f965709447c89f7"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "f7666697-1b88-412d-a62d-9e90e5187b97" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "NGO Lab reports examined the contamination" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Water_Cont_Report"
    }
     ]
  }
   ,
  "_:3552f93dacdb3af82a27e3aaee4a5c3c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:71f4db0db5a03ef09c2468b5c67607f4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/GenerateNGOReport" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Water_Cont_Report"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGOReportformat"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGOChemicalLab"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/AnnotateDailyTreatments" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/5casesOnSouthAreaRep"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/2casesOnNorthAreaRep"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGOMedicalTeam"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fd048bd872d8405a90510d60f97324dd"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "4e83ad0f-3533-42ac-94d3-ad4d7bab015c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded8228cc0-8520-4ce7-82dd-586c579a81d7"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Waterborne bacteria contaminate the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:9703abbab5f129b3b2a8ff392a702bcb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:463aafd2b4c9c3dbb5247eb9bed0f788" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:27d0849cdb085ff4f35f997749051822" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:ad7adb93ed8ee77e06b9cf96779aa6e7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/http://www.itacispaces.org/SAVED_Cap16_Joe_uncertainty15b82e7b-4492-4e2b-a651-1b9247cee45c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MonitorWaterRequirements" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:d3a0c75b1a701546abda8acead76105e"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:025cf3c6b73fb4c1abe11e6cd6d2b0c0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:deaeec1e6b25883e280f74b6e0b72603"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:47ef110fef8715594083891d8948d2b0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fcef872c93a43024b0e04fbb7db8fea2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3b269e330718345ff0fec8343a3c07c8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:0df695275a6404feab20602ec60286ff"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3bd210a02f75dfc1b46d854c1a8504fb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1a7391afc74de9024a8a006e69b79e00"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fa716cc5dc434b983306753f0f20ae0c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6b9abc7c53c6d54b0fcbde585be2d73d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5ec62af5bce4bb602b13101e474cc89b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c589588a7598961f0e12d6080568fbca"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ff3ff0591999eb45da603648ad7b2b6a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c1a910e34583568e2bcecd5b336822f8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:17b351f32dd7df4efbc4f49607de1d85"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:92889a0cbca374e2558dc335fb7eccf2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7259c050f90dadf2c637eb8fa08c556d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f68c26ffb4730acb6ac5ea2274660790"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7c8fd7e6b4e11f3f9f248c79fe90882b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ecc40a9b9d817f6db18552b0312cba1e"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f2d78f195f07c8f8b80fe18ebb809123"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a7d425a265ca078cd8ba9ff85a6b3452"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b1d056af989aac5a5a0bc25819904f79"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b850992ada026c8a41343dcac0fe80d5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a57650a5c6d150f77f532aea56599198"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:88c1acd8bf7316252365e47c9412433b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:75c9947a0e0196cb5d8e12e09c5a4a89"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7f2c3d5dfeb4da5da07d52eacff49caa"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a624277cd4ed8c72cd688248f9d68504"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6f5fca54afb510b9067d2e0ae699eddd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:94ca27c06cb81154e1cf2f2dea8581ea"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:482dfe1308963f5e9461707da2d1c123"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:dcb39007c3f78825556a9d43e9b41794"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:29b62879ade62979a6fa9dccf11a8cd7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:21d41fbb199f000b0f82962ef08826e4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d30951833e4706343ed85e57375f435c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fbb4092644679177207c421ad1fe36c4"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:bd9c8a3f71d5423fe12d54342dc60ff6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:379c7015c4261ae69f5cd2158c4d7bdc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:f6f973e3de7be4f6534a0a8d5cad4e92" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:0f6bf7b50eb43f13c2c455c10d751be7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:754c7480cdbf55e8c1c0c22b45c12dd8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:07020f1e4f4da21c3b65b3b468837e8a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:1a8ee59d0b0b8f4e17116c6f4f336b84" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:2eac9ea1f931b5219662606906e9959e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:ced047666e6812625e506d0eadd120b4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:29bca63695bcfab2c32002f13723112b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:45fd0f448b632e1422826fdec5ec3d23" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:250b4b3bf0be9e62e4e01def9d5625bf" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:78e9d030958e9c9da070108ee7e285ea" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b6ba048ddb1e696f20c5caa0d8133fc4"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "fcab8cb9-5b31-4ebf-a202-80d9821746b3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Biol_Analysis"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Non-waterborne bacteria were engineered and released in the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Field_Tests"
    }
     ]
  }
   ,
  "_:2fae9090974f7412fcc6fd2a0e6969fe" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:33dba1fdabd62b0c6be0e5a3ec3c9066" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:d155e2fdf76fa88737e806b7af575470" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:6c4a1226319ee11bc0f709bb712651e8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:24b9d02e4b54ecf31b2f44d551914d6a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:97c6895a42c77dc1bb4f6d77dec5b5aa" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:5ec62af5bce4bb602b13101e474cc89b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:82e9b2a8b50b7f29ca3fea210fd888b5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:57690870e5569fe14f31334329a23281" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:6d8d4e32a51e088a2c24e56d6846b7a9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:17b351f32dd7df4efbc4f49607de1d85" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:4103f925cdbfeb994c2b1238634019b9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:96c4d1298a66a2b821149ac21ce35021" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:3195b59fed12dfa0f184e2a9955fb0b6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:066319ccc57ad9fe46889bcdb6d8609c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:324097ff970661893052ecc581927a69" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:75c9947a0e0196cb5d8e12e09c5a4a89" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/SAVED_AFM_phase1half15236c11-3c2a-4e5e-a398-084026b654e4" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e6b103b71f48a815f8889803468d97e2"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "15236c11-3c2a-4e5e-a398-084026b654e4" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save15236c11-3c2a-4e5e-a398-084026b654e4"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_AFM_phase165b95d4b-5eb1-4ae6-a115-025a6eecfd8a"
    }
     ]
  }
   ,
  "_:812f851f9057e83fa7e738d9faf79327" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:b0d893779cab7c02b62e89cb0c1a39f7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:5bdc8b0fede8728792585efba4cd2342" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:13e35ac2d2c106548fbf79c17334f393" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:8fa132c9afb4b90b7a84ecd43307ddb5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-11T03:08:00Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat77564701-b70f-431d-8c83-382ea6962fbc"
    }
     ]
  }
   ,
  "_:fbb4092644679177207c421ad1fe36c4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:82e3e52351d3808a626483da2c88ba51" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:025cf3c6b73fb4c1abe11e6cd6d2b0c0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpAccess62fd6a48-5891-4e9f-b672-a226d8d02d05" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node62f032fa-7deb-48a2-9e17-aeb08b2b5c31"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:722fc9e6d00c070a5a9c850aec274c5c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Inspect67ab7c18-d3ca-4bc9-9486-ef413345da1d" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysis8196e62d-f562-475f-9b45-fe9f55bba1ed"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:deaeec1e6b25883e280f74b6e0b72603" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:43ff66dd842ace039338a1ee6b6616c6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:47:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Inspect67ab7c18-d3ca-4bc9-9486-ef413345da1d"
    }
     ]
  }
   ,
  "_:fcef872c93a43024b0e04fbb7db8fea2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:3bd210a02f75dfc1b46d854c1a8504fb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:f2446d864bd36765f9fd73f9926f8289" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:25dd08d71ee8da73ef676e200d8fb096" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:8b7efd11a07ab1766202c1d0db607dc4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:6b9abc7c53c6d54b0fcbde585be2d73d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aerial_Bact_Study" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Goal"
    }
     ]
  }
   ,
  "_:82dcc1e45a4a076d732f5c754ebd3cdf" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGO_Medical_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:5e8fc23289904109f300fc47a60f0322"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:75350a4628734de5e8262f8b4b453685"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:bc6f226e8b980879ba643278605534cb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c3050a629e297ac2ff78c7feeab46c80"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ea63cec40f16dee27539a66f2d5f86d1"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1a8ee59d0b0b8f4e17116c6f4f336b84"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:79c5938bc8dccb4a2060a4f102f9a1c3"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:568a55e21ffe7a98bc84b09a367d60a7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:2eac9ea1f931b5219662606906e9959e"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:250b4b3bf0be9e62e4e01def9d5625bf"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:72998df5205a4e235572e0cb8745bd66"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8b7efd11a07ab1766202c1d0db607dc4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a59d0c312375a15151e7ccd90a7bc132"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:704008c2f998c58c11ba85c00ec441bb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:de1996bc961c87ec3eaf6a748bc42aff"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f13fae0103766f4e358ec3843d6a6095"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:21bcbb7e7341a350a021e1831754398c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:225796f8768331deaf07c1fdaed76c37"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:701a944f2129e921bbf95d43516d62c2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7a9da2a37e596560445b2a74c8ad7d72"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:97c6895a42c77dc1bb4f6d77dec5b5aa"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fb9864dc90f0f5734167f87dbda21aff"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5d44ca5ef31d1a78018ded7319bf83ac"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:fae006ab975b34bde234e241aa8ca595"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:61ff32fb9efd8587e9fd736f8e983984"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:96c4d1298a66a2b821149ac21ce35021"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:705fc1d6175e19bfe084809fe525006b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:09cba603483eb549323cba9886c5cc73"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:463aafd2b4c9c3dbb5247eb9bed0f788"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:87d492055dc5f8a42139610a97303fd2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8e8d69a39607494a942423aa148b17bf"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:bd9c8a3f71d5423fe12d54342dc60ff6"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b0d893779cab7c02b62e89cb0c1a39f7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5bdc8b0fede8728792585efba4cd2342"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f6f973e3de7be4f6534a0a8d5cad4e92"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6fd76f85352757b12cf62681da80e6f8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1e1e700ceade962a7661ee79fb6ee3ce"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:302a519329564f4add13d554fad3fe0d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/5casesOnSouthAreaRep"
    }
     ]
  }
   ,
  "_:ff3ff0591999eb45da603648ad7b2b6a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:5d44ca5ef31d1a78018ded7319bf83ac" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:d45830b666f752ded5e1124cbcdf585f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T08:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:4cf8caa3a4c8d84fb55684165be4dc91" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:c93b6e3698444c4da471f3a4031e0667" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:7c8fd7e6b4e11f3f9f248c79fe90882b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat13ce6836-f659-4e44-9e61-c6d9a98dbc36" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf4b8d22-5940-4f72-a5e6-66584d6e2239"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis2ac94e87-357e-43bf-bc42-1239d1936301"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:ecc40a9b9d817f6db18552b0312cba1e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:b1d056af989aac5a5a0bc25819904f79" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:8e8d69a39607494a942423aa148b17bf" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:9457ea20807eed2c21c2f71bd1de2787"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "417097cc-b0d0-43d5-9c10-cc2e04ca9bcd" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9c308cba-6f53-4ede-9444-fe3b95a03426"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "NON-waterborne bacteria contaminate the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:3d9bbcfc184493385265ba74b7fe5b0f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:9b23f494bd3dbe8673b2353f553ef257" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:482dfe1308963f5e9461707da2d1c123" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:d23caa88c61a20cd544ca795510b4ee4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:c4c0a8ec38516952edd86d29d9df87f0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNoded8228cc0-8520-4ce7-82dd-586c579a81d7" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:b0ec51dda0d3ee41f1234c59ed3afba5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:3907960e6eedcf345a99ff7f9bb4750f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:6d2c7758de244a2c3dffe7f567d15b82" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:5e8fc23289904109f300fc47a60f0322" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CollectWaterData" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/WaterSensor"
    }
     ]
  }
   ,
  "_:1d1e6f18b10933c2c6ef97105e5b3014" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Annotate" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LivestockDeathPictures"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/KishFarmer"
    }
     ]
  }
   ,
  "_:c2f23568238448a6fe9dee59bd76abe0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Bacteria_Data_Request" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:794cfb94db348dd95e746732260ac16c"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aerial_Bacteria_Investigation"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "_:4b8d9fc11df94ab49781f23f09f46ca4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Prepare" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/FarmDailyReport"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/USTeamPatrol"
    }
     ]
  }
   ,
  "_:11ed1f4995fcc66e3e6cdceaf8b8b72a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:b7f5e8a4fe13891b122585bfc6ede659" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:fb1c607927b333e7879840c906a9ee08" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:2e04284637ea93561afed4d41f5399dd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:d26e7a4c6bd928436101dd2070f2bfe5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:24aea55c86af2414a91fcaf1f3fe8bf1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpAccess92be1bf4-1157-459f-8e8b-e46bff0f5bc9" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec503be16-2320-4ce7-9b57-d4646e6dfba2"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Water_Bacteria_Investigation" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasInformedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aerial_Bacteria_Investigation"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Bacteria_Data_Request"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Biologist_Group"
    }
     ]
  }
   ,
  "_:9836c25d32f08bbda329036af957ac06" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:37db7149045ce5c1f861e3dd9561de67" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:72998df5205a4e235572e0cb8745bd66" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:1a7391afc74de9024a8a006e69b79e00" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:311e9f2e3b213570291c40c5bc51e080" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:842db1a0822ad7e02ec5e165642f4206" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:3cd655af8aa702b1cabe56d8b6baa6cb" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "_:cbf0271b3eebb7fd3e8852ae26d045f4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:065870a68dfa4cacd402dab84e6ca5a9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:225796f8768331deaf07c1fdaed76c37" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/AnnotateDailyTreatments"
    }
     ]
  }
   ,
  "_:c589588a7598961f0e12d6080568fbca" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-22T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysis2ac94e87-357e-43bf-bc42-1239d1936301" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3406421ef6bcce06c0e152e4078c3fde"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "2ac94e87-357e-43bf-bc42-1239d1936301" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat2ac94e87-357e-43bf-bc42-1239d1936301"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis77564701-b70f-431d-8c83-382ea6962fbc"
    }
     ]
  }
   ,
  "_:73202a5ac2b2d38b99daac164735ffcf" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:5761f0c4d6e7363fa1bbb9943df16e3a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:3e53ba58d52f9ede13ebb292c5c90373" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:ea164e29a92df6673f23ee7f27b9aea7" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prepare"
    }
     ]
  }
   ,
  "_:48a2a1143241656dead24f6f23cafc6f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-30T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Type"
    }
     ]
  }
   ,
  "_:b4d03b11a5d1385d003c35b31d4f00cd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-08T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/SAVED_Cap16_Joe_uncertainty15b82e7b-4492-4e2b-a651-1b9247cee45c" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "15b82e7b-4492-4e2b-a651-1b9247cee45c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:199c2d5ff99b0f571e33daadd095d027"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Save15b82e7b-4492-4e2b-a651-1b9247cee45c"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
    , { 
      "type" : "literal" ,
      "value" : "Workbox of Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/SAVED_AFM_phase1half15236c11-3c2a-4e5e-a398-084026b654e4"
    }
     ]
  }
   ,
  "_:e64704a3d6684337ef608907a344a19a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ]
  }
   ,
  "_:f2d78f195f07c8f8b80fe18ebb809123" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:37db3bb289fbfba2a633a8c11b964c7f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:88c1acd8bf7316252365e47c9412433b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-30T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:a624277cd4ed8c72cd688248f9d68504" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:00ac526e9bcf0b331b42c390a3274a5f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:9dbcda080dcd2459f9d9fc8f0757d0ad" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node62f032fa-7deb-48a2-9e17-aeb08b2b5c31" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3c0f48497ad4c7e793d4d969d0aa3629"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9a473ea766b28c2456299eabb520ced2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c2f23568238448a6fe9dee59bd76abe0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f5eee51c3ba5d6a71ca261ed6c6b065c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:7f60370b788a44864e23df73a121b9bd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f5377fe463452f3b4e7203dbcfaea8fc"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8af7f0a4067088f4360df87e4248833f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9ee7e2fb08e18c003eb2471654c922fe"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:76b392fe324484faeb5f51d6e4d579bd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:24f542a99b1402f9c13c6bf37dcee7f7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c5e3d349ccf9d9e472db069fff2d629c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:be8e584b901c572152640476aa861869"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5761f0c4d6e7363fa1bbb9943df16e3a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3e53ba58d52f9ede13ebb292c5c90373"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:39ed62aeaffa2e8342dd0bdb2725642d"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f7e4e1ee2210dec4ac7d67ecc9b130e8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3dcefaff0b8e5be0830032f5885e129f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:e64704a3d6684337ef608907a344a19a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8a6683d3b1056f69acb4f0321b0e2629"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:daa41200bf41a564d086426deb490d19"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:d23caa88c61a20cd544ca795510b4ee4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:18014c9d41de5eb0de912c7230a338b9"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c4c0a8ec38516952edd86d29d9df87f0"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f04da659ead32cebdd5e39126efffac5"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:13e35ac2d2c106548fbf79c17334f393"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateNGOReport"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "62f032fa-7deb-48a2-9e17-aeb08b2b5c31" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Toxic Bacteria contaminated the local water system in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Water_Cont_Report"
    }
     ]
  }
   ,
  "_:ae72727da722d24b3bb14ebc72f152ab" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "_:c969d5d62dffd412cbf0ff4e59b795fe" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Deliver"
    }
     ]
  }
   ,
  "_:276d6709bc12468a9de799e0afd3b467" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MonitoringWaterSupply" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Goal"
    }
     ]
  }
   ,
  "_:dcb39007c3f78825556a9d43e9b41794" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-01T23:30:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/GenerateReq"
    }
     ]
  }
   ,
  "_:078bcf5962d83f3ee262f007a84446fa" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-06T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:d10dea788b73f3b1aa72f5169595d227" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-27T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/NGO_Water_Cont_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:dd4ead6f988908a48b1afee1c06bac05"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:44b7d3fbf9e4755a8b1321c92b32d298"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:722fc9e6d00c070a5a9c850aec274c5c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:09f1d18acc51175bfb8736bddcdc1da7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ced047666e6812625e506d0eadd120b4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:11ed1f4995fcc66e3e6cdceaf8b8b72a"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1f08ea395f1d2549ecd8d68b390d19a6"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:9836c25d32f08bbda329036af957ac06"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:46e51f27dc21524ac5d95e2274e843e7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:37db7149045ce5c1f861e3dd9561de67"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:107e1d89eda0282c9e8a3764f1c22ae7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:05d9343c1e1f367236b73499d5cc075b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:decbddbc329cbf1a21d33449baafdf07"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ba5411e5c90dd507a0be95a6bc4d6e5c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:842db1a0822ad7e02ec5e165642f4206"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3cd655af8aa702b1cabe56d8b6baa6cb"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:6c4a1226319ee11bc0f709bb712651e8"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:065870a68dfa4cacd402dab84e6ca5a9"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8b84f407021ebda14c207682a434b0ac"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:57690870e5569fe14f31334329a23281"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:e49ba154b93792b1d041f1129b0a3014"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:633d600841712b1ab3842f37a66bcc3b"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b4d03b11a5d1385d003c35b31d4f00cd"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3552f93dacdb3af82a27e3aaee4a5c3c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:324097ff970661893052ecc581927a69"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:37db3bb289fbfba2a633a8c11b964c7f"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:8d6261f4cffb50929eaa4d38f4bcf141"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:96f35e15ff2fb6fcc4e98cd0587eb994"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:61d3b1cb52ddd70131e4bbf9487b60e3"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ad7adb93ed8ee77e06b9cf96779aa6e7"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:ba5a1614b7d828292ea81cd4cea09fd1"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4595214ad17f7cf35ab180b6ecf3f1f4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:078bcf5962d83f3ee262f007a84446fa"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:79d080ba3c9e2a32196c8dabb0f60d84"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:f3ebccfba6c6606a0dc39efb83ab1ad4"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:4b5f6aea510e8492107dc9e4ead7a2b6"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b53de502f21a64246a982db54bd06b67"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3750da361622a921c3c9b66fb15ca048"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:4b5f6aea510e8492107dc9e4ead7a2b6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-29T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LabWaterTesting"
    }
     ]
  }
   ,
  "_:4b822d759d83fa0afa1b3550552f965d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-01-28T07:39:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Annotate"
    }
     ]
  }
   ,
  "_:73ebaefc001da1c53fac1f03fcf93b0c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-04T08:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CollectWaterData"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat6ff0aed3-07c4-4823-a3e1-b9f1bb5f742b" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis22021509-6b32-45b1-b02e-278d1cd1c659"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Joeinfobox', '{ 
  "http://www.itacispaces.org/MOIRA" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpAccessd482ee66-a037-490e-90cd-114b52155132" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "_:372b060dab53b8074e2f3eb85211c0af" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodefe904bd2-7b01-4407-86ef-d3319dddce3e" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:37f0e3efe8b98f2cd6375ddda004851b"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "fe904bd2-7b01-4407-86ef-d3319dddce3e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccessd482ee66-a037-490e-90cd-114b52155132"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "some info 1" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedf222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:372b060dab53b8074e2f3eb85211c0af"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:b4cd88f97921d8fe40d3079d2dd2ea1f"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiring21c72efe-3345-4fc3-8105-00886f1eedc4" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "_:37f0e3efe8b98f2cd6375ddda004851b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T10:57:39Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccessd482ee66-a037-490e-90cd-114b52155132"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:b4cd88f97921d8fe40d3079d2dd2ea1f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodedf222a6d-ec6c-4f0c-a424-3cd8bb683e02" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:02373e412601432c507f861e86bc26dc"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:1693321725885e5b497baf6148aaf9ef"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "df222a6d-ec6c-4f0c-a424-3cd8bb683e02" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "some info 1" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ]
  }
   ,
  "_:02373e412601432c507f861e86bc26dc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T02:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ]
  }
   ,
  "_:1693321725885e5b497baf6148aaf9ef" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T02:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Joe', '{ 
  "http://www.itacispaces.org/Node25c281d3-456d-4c08-9e2e-db36748b81d0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:285de7612ffa7da3f39978cbbb0688f4"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "25c281d3-456d-4c08-9e2e-db36748b81d0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeff4a19bf-5d6a-4caa-a1a6-a1de144e2919"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "A member of violent splinter group is in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node0628771b-5d9a-4d60-b4b4-cd4a848cd688" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:483217349d59d25d37a9988c01f8c7ef"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "0628771b-5d9a-4d60-b4b4-cd4a848cd688" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode5c79c777-e15e-4684-b5b4-54a085e97b55"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Protests in Quish and Kish have been organised by group X" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:1ce980e76c275a91c1c919391f05af6f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:20:19Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6eb2f34e-54d8-48e9-9784-0e688195a8b6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNoded80e2187-d778-41c5-957f-49e31b2f5e30" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:2090b43184e436bcb6c6dcd341deee62" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:30:03Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode7a73a740-bcc7-4b75-91fa-739cb2cf86b3"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node383c095b-a535-466e-a8ef-1aa88ad89ac4" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:1ce980e76c275a91c1c919391f05af6f"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "383c095b-a535-466e-a8ef-1aa88ad89ac4" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6eb2f34e-54d8-48e9-9784-0e688195a8b6"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Mckelvey reinforced how vulnerable Kish is to the threat of dirty bombs." ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec8281f43-6eb0-48cc-a875-e80ac8651be3" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:572d9aaf4b1a022284adb64cc230b190"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c8281f43-6eb0-48cc-a875-e80ac8651be3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2891a6b7-8a9d-45bd-9e25-37baa374055a"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is a toxic non-waterborne bacteria in the Kish water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:3ac9e2ea40b775d0493b22ee5852a81f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T05:17:36Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodec5692c57-4125-4ef1-a497-57a8a3f7e9a9"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3ec90752-2980-4adb-97c4-d5574609f004" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e94cb3a97e1179bc847a5126b36487be"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3ec90752-2980-4adb-97c4-d5574609f004" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8165fad6-501d-4dcc-8ef4-8c1fd6dcb526"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Gas exploded at the pumping station" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node449802f9-e222-4e4a-be55-b22815dd8569" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b4dd6b8e52fce3a481b98c508f4bc978"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "449802f9-e222-4e4a-be55-b22815dd8569" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode39b2dc91-8b68-48f2-82fe-56ba6713a934"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "DG is a known member of splinter group" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:209ccf03d0ee8bc5cb450caa2dd4c233"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:dac44e6d6672ec09ec4e85ce4d3e8c36"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ]
  }
   ,
  "_:5b855518783fa7e163423d12e82ac2e3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:11:43Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode464562be-1d85-4c47-83bb-1f6fad19ce42"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Science_Magazine" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node63f07414-ae7a-409e-8226-c4e6b5c581a7" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:25f2f12bd561961d4e674d0b738f98ca"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "63f07414-ae7a-409e-8226-c4e6b5c581a7" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode4becfe16-f18d-48b5-afc7-a74bab1407f1"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Civil unrest intensified" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodedf222a6d-ec6c-4f0c-a424-3cd8bb683e02" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2a8dc0aee7323a7cdf2c91cc587bc409"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:a4e7943c193070eeb74d0aec6d0f0671"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "df222a6d-ec6c-4f0c-a424-3cd8bb683e02" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ] ,
    "http://www.itacispaces.org/ns#record" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#InitialInfo"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "some info 1" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode40ac9722-203c-4fde-ad7e-91c656e039c0" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Terrain_Expert"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodefb477bf4-7854-4b2a-b0df-e1b75beccf60" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:beac82ca900041a8f962ce6a6b3e4a55"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "fb477bf4-7854-4b2a-b0df-e1b75beccf60" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode88f0d41c-caed-44b2-8775-59438fc587fc"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Paramurderers of Chaos smuggled the substance across the border" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodefd85d1d6-11a8-4264-9676-68ea5502edff" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:b1bd2397285e9f01f72faad782290271" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:11:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode47b690a6-961c-4eb8-bd85-2bd65a4ba09f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node996d0ca6-6a3d-4092-9ae1-74ac61ff2c2f" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:6c50aebdbec6e07455a3ff67a22cc87a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "996d0ca6-6a3d-4092-9ae1-74ac61ff2c2f" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1d529c5b-f8ac-47e6-9def-468491aa8510"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Paramurderers of Chaos took the mountain route" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Police_Records" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:61599f5e9f1dde8c7c094b140bb79664" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:44:00Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodea703fa09-c110-4bef-8930-6506470a7903"
    }
     ]
  }
   ,
  "_:392a21ad77ede165095b7b736b11c51d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:27:25Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode84308cd2-70c3-4f25-a23a-9004c8689588"
    }
     ]
  }
   ,
  "_:5c2a964bbed59b1e301fa0e5dd16e026" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:04:09Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6d59d3ef-b7a8-426a-8670-b79bbe8e06b0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodec500b8ae-8286-4993-9928-7e3b85bcdd50" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:a4e7943c193070eeb74d0aec6d0f0671" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T02:05:22Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodec8f098e4-55d9-44c3-94b2-4f4baeb883c9" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Moira,Patrol_2:msg_j3"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/WaterTanksReport" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:3daa36d0ff50bd1597d1d4a86199e98b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9c0907a1-153d-4594-b7c3-1327719f7833"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodef850e44d-a53c-4d76-9697-08dc0bef3e44" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/TV_Interview"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode4c95b980-149c-4a0c-a551-d941c0d6ca52" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Water_Cont_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Border_Patrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode826d6266-aa22-4c93-9cdb-2fa8361ebe48" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_4a64dcb4-5c9f-4884-9311-3ce8e2c3e271"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode23b024cb-211b-44b1-a906-5f00ed302980" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_27a45017-67b7-4bac-9b3d-f4e874030750"
    }
     ]
  }
   ,
  "_:7019ee11969bbb3b5af44226b89ba67d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:20:59Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode21fa660c-5aa1-4bf4-bb2d-9acc4d4dc862"
    }
     ]
  }
   ,
  "_:077f26d2ab31808a6f7c7c25c236e376" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:33:36Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode474ed969-bfa9-41cb-8988-5d516614fde5"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node891155c8-8728-4338-85cf-163397b38f89" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:9f44b088310ffde835cb846356e820ff"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "891155c8-8728-4338-85cf-163397b38f89" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0e112d58-8e16-443d-ad51-35b102586a0d"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Group provides evidence FOR Local authorities and police are trained for attacks" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodedab75d95-9161-4dc5-848e-11175f8998bf" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node98c53f7b-50fc-4e8e-a6dd-1c57c03ce186" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:8dbe816c2311f3a15c3da4b9fb65f2de"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "98c53f7b-50fc-4e8e-a6dd-1c57c03ce186" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode13623a76-f9e2-4e45-ab70-7ea3609fd400"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Emergency response may be using local water supplies" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reuters" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node87e5a91a-6582-467e-b71b-278207f243a4" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fc3b5ef791cf17f89aae2e4ccaec301d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "87e5a91a-6582-467e-b71b-278207f243a4" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodec8f098e4-55d9-44c3-94b2-4f4baeb883c9"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Unidentified illness affects the local livestock in the rural area of Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:2c9eea48dd44e16d0d70a4ee4de0fc37" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-14T08:35:49Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeefa426e9-0f65-4a4f-9d0a-a070858e42b2"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node5c6860b4-fd9f-42f2-851b-3276205bf026" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:d1081ee54b16e05c1610adf79400c227"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "5c6860b4-fd9f-42f2-851b-3276205bf026" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode98930958-aa9a-4b7a-8866-5073e7ad717b"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "All members of violent splinter group from group X arrested following Quish protests" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Kish_police" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode894a0d67-b634-4eb2-8eb0-6a7c6eeed489" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_PX"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Vast_Police_Officer" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3df9a10a-a9b3-44e1-a886-0e7b7a185686" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:d95a0a8221020928715a7b040f15b63f"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3df9a10a-a9b3-44e1-a886-0e7b7a185686" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeb4fdb0c2-e11c-4e95-b59b-d64e7b553868"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Answer 7.38 is generally accepted as true" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeaac83224-159d-420e-8ed3-2308f7920997" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:9b2e3015f1d66e0e2fd5debaf6e883e5"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "aac83224-159d-420e-8ed3-2308f7920997" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef850e44d-a53c-4d76-9697-08dc0bef3e44"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Vincent Mckelvey of the Department of Homeland Security commented" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3b6225f9-bf59-4c90-ac4d-22e122c9f96c" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:d2050abe2d4e4ae5491c891cd792ae26"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3b6225f9-bf59-4c90-ac4d-22e122c9f96c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodec500b8ae-8286-4993-9928-7e3b85bcdd50"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The water may be contaminated" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Prov_Analysis_Node_1fdf3463-55fa-452b-ba95-4dcc63fa182f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodea10a59e8-9527-4fe8-a532-acf4a3bd38d0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:44bd48b3fba5a0afffc329e31022e4e2"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "a10a59e8-9527-4fe8-a532-acf4a3bd38d0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1a9c5c2e-5ce8-4c20-86a8-d4870e24352b"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "No suspicious activities at the border recorded" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode8e607274-3396-48bb-acf0-304381a796bd" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Vast_Police_Officer"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodedbfa4c52-b352-4c06-87d1-e16a6ad5a651" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:eb2fbc308749976fc48dcbcf1d5ea3bc"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "dbfa4c52-b352-4c06-87d1-e16a6ad5a651" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0c09341d-cd76-476c-959a-22241c72699e"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Answer Yes is generally accepted as true" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:af848dbc0e1d247c425080ae215b7843" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T11:27:12Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode511bdb0d-36ce-4647-878d-d67a53729b27"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Moira,Patrol_1:msg_3" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:d95a0a8221020928715a7b040f15b63f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeb4fdb0c2-e11c-4e95-b59b-d64e7b553868"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node6f7bea39-2c06-4019-b79a-f253d51b333e" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:26a89f148e4c3aded6fa2b48d00f17bc"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "6f7bea39-2c06-4019-b79a-f253d51b333e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode08ea8663-cb62-49e5-82ee-807911d075dc"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "A POI planted an IED in the basement of the pumping station" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Moira,Patrol_2:msg_m3" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:0ae45db619cfad75c747ef6ec45929b2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T06:32:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8e6d2e61-bc4b-49c8-8cdf-cfec3b52822e"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node2cfe1380-7070-45a1-878c-ca041b172ed9" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:aebbd685e080622ba53508f9a42d9063"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "2cfe1380-7070-45a1-878c-ca041b172ed9" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1635fc6d-c268-45a8-86c5-c05839f4ece4"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Breaking News, Kish Police carried out a training exercise to intervene in case of dirty bomb attack" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node208a932e-db1b-4aed-9e17-10a722d4180e" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:249c6751e778991db2bbf1598c00cbdb"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "208a932e-db1b-4aed-9e17-10a722d4180e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeec85d09b-7515-4692-937f-89ef0fc630e1"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The Network of Hate sold the dangerous substance to the Paramurderers of Chaos in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:13b2528c:15dc6a280a2:-7f82" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-09T11:07:35Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChate31f105e-0263-486e-891b-ed2a416d1027"
    }
     ]
  }
   ,
  "_:98d2e9a8fdc0620adfbd96d89350072b" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode22f2672b-c6bb-4cd3-b64b-dbf7c3ae918f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node27a45017-67b7-4bac-9b3d-f4e874030750" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e88578f4fadbd6891f717cb5a34e62b2"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "27a45017-67b7-4bac-9b3d-f4e874030750" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode3e85125e-2cc8-46c6-9983-add44d3d8424"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Amnesty International produce report on Quish police brutality" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode8e6d2e61-bc4b-49c8-8cdf-cfec3b52822e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Intelligence_Cell_G"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node5597346f-c7d2-4ef4-a882-d16adc55f723" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:69d452abef2614afa83308b280fb32d8"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "5597346f-c7d2-4ef4-a882-d16adc55f723" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9b0046d2-c1a0-4355-9505-32767b36727f"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Units have no evidence of altered gas concentration" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:88ccf8ae8fab393dffad4b79ea0dea2e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:35:39Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef058da1e-6c7d-47ca-939e-140d6e15899e"
    }
     ]
  }
   ,
  "_:f2bb0716557b3101b2456bacfe4de3e3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T05:13:46Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodea3432617-e93c-4af8-ad50-68ec3b41664f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3cbf6169-8c8e-4679-afb5-a0128342a875" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:5b855518783fa7e163423d12e82ac2e3"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3cbf6169-8c8e-4679-afb5-a0128342a875" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode464562be-1d85-4c47-83bb-1f6fad19ce42"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Person answering DG''s description seen in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:50ce7fecde140dab07dced65dfd43c42" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-14T05:22:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeed5c9203-2e7f-4a2d-95f0-fb70723dff9c"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Met_Office" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:346ac05b5b4cece25b3a2306561b9718" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:30:15Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded5153ad7-660c-4176-80dd-46089c14f843"
    }
     ]
  }
   ,
  "_:4cac6f611bdc6683f4df67a0a8406263" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T08:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode4ebc1bed-6046-42cd-b284-9ea95f27c58e"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Quish_police" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode951b77ca-f5ae-4317-a293-47b0b7109e8a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:817291b48483d0f10c1b0bd1caa245d6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T10:57:39Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpAccessd482ee66-a037-490e-90cd-114b52155132"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Kish_Press" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode3d80af3d-dd83-40be-a9c8-c06ed197f821" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node64caf098-a774-42ab-bc92-a0a2e5b3fd74" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b1bd2397285e9f01f72faad782290271"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "64caf098-a774-42ab-bc92-a0a2e5b3fd74" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode47b690a6-961c-4eb8-bd85-2bd65a4ba09f"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Violent protests in Quish are likely to be repeated in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:dac44e6d6672ec09ec4e85ce4d3e8c36" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode39b2dc91-8b68-48f2-82fe-56ba6713a934" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Group_X_insider"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode9376eb48-abdb-482e-896e-c2c3717f8e94" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_myFormContCQQuest"
    }
     ]
  }
   ,
  "_:d2050abe2d4e4ae5491c891cd792ae26" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:36:05Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodec500b8ae-8286-4993-9928-7e3b85bcdd50"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode98930958-aa9a-4b7a-8866-5073e7ad717b" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Quish_police"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node85c76fa1-8876-43b0-ac24-996a6f2e9e4e" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:a3cdf42760b751590401730ba52c66a9"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "85c76fa1-8876-43b0-ac24-996a6f2e9e4e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode7a8f9564-dbe3-46cd-aab8-98918482906c"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Colorless Bacteria may be still present in the water" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:209ccf03d0ee8bc5cb450caa2dd4c233" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4"
    }
     ]
  }
   ,
  "_:9a3663a2901448249ed199ed7fcf027f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:11:02Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef3426804-8afd-4a35-b2c1-9ae5375ec5a8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode015e65a4-12df-42f6-8504-8c212fb0f4a3" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:fe2ffbad4246953c9673d91fa9997402" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:56:38Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode84adf62e-2141-4554-8de7-da07676a0d45"
    }
     ]
  }
   ,
  "_:0077ebab512a20ad20369d3face44dfc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef803f1da-934d-45e2-b69a-804ca29971e5"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node2b6d4a46-3937-4032-be2a-1fa3efedae59" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:50ce7fecde140dab07dced65dfd43c42"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "2b6d4a46-3937-4032-be2a-1fa3efedae59" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeed5c9203-2e7f-4a2d-95f0-fb70723dff9c"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "An explosive gas has been released from the hygienisation units" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:ed3a6a9abf25d493aa4dda64d4bd1917" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:11:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode5cb884a4-18f9-41bb-9f47-14e43da0310a"
    }
     ]
  }
   ,
  "_:e94cb3a97e1179bc847a5126b36487be" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-14T05:22:52Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8165fad6-501d-4dcc-8ef4-8c1fd6dcb526"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node0c876b75-3fa4-4de4-b985-95804f2a2ec7" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:01b159e835607050718b6181269f4802"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "0c876b75-3fa4-4de4-b985-95804f2a2ec7" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6b9f90d3-5410-45da-96e9-998284efcb98"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Emergency response supplies contain biological agents that are damaging to human health" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode236e8b7c-88ff-416e-a72c-15dde696d946" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Quish_police"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node4bd94fa8-77d0-4909-bb4a-21cdac3d8054" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:dedd7ce72bf5daa08a7dabbbe6b0d7b0"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "4bd94fa8-77d0-4909-bb4a-21cdac3d8054" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode015e65a4-12df-42f6-8504-8c212fb0f4a3"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The attack is violent" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodea79e7f26-7ec1-4fb9-b68f-55fd3222ee96" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:a7496375481636bb1abdc4b55f09574c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T08:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9376eb48-abdb-482e-896e-c2c3717f8e94"
    }
     ]
  }
   ,
  "_:bc3a5214289e135609991093312b48fd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:09:42Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode826d6266-aa22-4c93-9cdb-2fa8361ebe48"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeec85d09b-7515-4692-937f-89ef0fc630e1" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNoded5153ad7-660c-4176-80dd-46089c14f843" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Miles" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode5cb884a4-18f9-41bb-9f47-14e43da0310a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Kish_Today_News" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3346531a-9087-472a-be65-a63c4b8d6955" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:98d2e9a8fdc0620adfbd96d89350072b"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3346531a-9087-472a-be65-a63c4b8d6955" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode22f2672b-c6bb-4cd3-b64b-dbf7c3ae918f"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Answer 7.38 may be plausibly be true" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodee22e091d-18a0-4578-8304-11e4ceb126b5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_4a64dcb4-5c9f-4884-9311-3ce8e2c3e271"
    }
     ]
  }
   ,
  "_:6c50aebdbec6e07455a3ff67a22cc87a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:18:24Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1d529c5b-f8ac-47e6-9def-468491aa8510"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodea297317c-acc3-4672-a418-8f278cf4a649" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode47b690a6-961c-4eb8-bd85-2bd65a4ba09f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Quish_police"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec6d69d25-8766-4bc5-b25b-30cb9bed1cc3" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:1b8fd876cd5b52af2b33d59591553050"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c6d69d25-8766-4bc5-b25b-30cb9bed1cc3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeb5d2b500-1e10-4188-b385-682d6d50538b"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Report concludes no evidence of torture" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node5068cd04-1ad3-4fa9-a682-7240922449e0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:4da4689258b360edbc9a0909e818b4ca"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "5068cd04-1ad3-4fa9-a682-7240922449e0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef97f9acf-aa3d-451e-9bfd-886de476169f"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Given that the group was asked What is the temperature of your cold water?" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNoded5f82410-bb33-4417-b9fa-ac81f9091e63" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:b0b7677c9a126055709d63171b81e1e3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:24:28Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodedab75d95-9161-4dc5-848e-11175f8998bf"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode2891a6b7-8a9d-45bd-9e25-37baa374055a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:a69a636e4afb8ba5b754b32b80f80cd0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:30:47Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode7c0aa808-2cfa-4193-89c6-5a5c31a5b2a4"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode7a73a740-bcc7-4b75-91fa-739cb2cf86b3" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Moira,Patrol_2:msg_m3"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node549f0b96-51eb-4df4-aebf-181ebb448461" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:26d1b5d739b592c6fa4e7698baf92fd8"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "549f0b96-51eb-4df4-aebf-181ebb448461" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0f78398e-e64b-4dd1-8be2-5cfe6402aae5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info \n- was generated by Water_Bacteria_Investigation\n- was informed by Aerial_Bacteria_Investigation\n- was generated at time 2014-09-06T07:56:40Z\n- was generated to satisfy goal Aerial_Bact_Study\n- was generated by using Bacteria_Data_Request" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node56e985dc-1bd0-4fbd-b6dd-3d33102936e3" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:ab5bb10cdd62bc7ad701cb0c2fb90df1"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "56e985dc-1bd0-4fbd-b6dd-3d33102936e3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode91e85bd1-5790-4db7-ba1d-b5bd204f2abe"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Group X violence was directed towards Quish police" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node5e1246ca-5549-456b-aa2f-8fee43727145" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:61599f5e9f1dde8c7c094b140bb79664"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "5e1246ca-5549-456b-aa2f-8fee43727145" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodea703fa09-c110-4bef-8930-6506470a7903"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is no evidence to show that the cause occurred" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:4a483a9a90223ea5b97e3f130c6f4255" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T04:05:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodebe8fb6e7-c6b1-49fa-95ad-61198924c3f2"
    }
     ]
  }
   ,
  "_:87446a1e8fc5648fb7869ff98bb88e09" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T05:07:48Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0dac5bcd-8374-4862-8cea-ee392c21e56a"
    }
     ]
  }
   ,
  "_:eb2fbc308749976fc48dcbcf1d5ea3bc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0c09341d-cd76-476c-959a-22241c72699e"
    }
     ]
  }
   ,
  "_:bbc69690ea8d4ca688e36186727d07e5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:34:56Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode66befb66-d6f6-4843-ad45-5e3c51cdaf4b"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec14491b2-13db-471e-a589-95c3e0e4e6ba" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e931df654922ac0d993a4c5d7be1728c"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c14491b2-13db-471e-a589-95c3e0e4e6ba" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode895f3998-ef79-4074-a215-64a058551fb1"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Answer 21.1 is generally accepted as true" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:9b2e3015f1d66e0e2fd5debaf6e883e5" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:23:18Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef850e44d-a53c-4d76-9697-08dc0bef3e44"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChate31f105e-0263-486e-891b-ed2a416d1027" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3346531a-9087-472a-be65-a63c4b8d6955"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25c281d3-456d-4c08-9e2e-db36748b81d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0628771b-5d9a-4d60-b4b4-cd4a848cd688"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded7a4bf74-e063-4e77-a400-e9dcfcc9a654"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node383c095b-a535-466e-a8ef-1aa88ad89ac4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec8281f43-6eb0-48cc-a875-e80ac8651be3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec6d69d25-8766-4bc5-b25b-30cb9bed1cc3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3712ac42-3b5d-4a54-8497-414d1116a323"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3ec90752-2980-4adb-97c4-d5574609f004"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5068cd04-1ad3-4fa9-a682-7240922449e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node449802f9-e222-4e4a-be55-b22815dd8569"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec16a2ae7-d95c-4c44-9cc1-2ee12a3a5196"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded301a120-3ff0-42dd-8baa-3e44c26f0719"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8cc12b90-aadd-4126-8c0f-9fe02bd14d00"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node63f07414-ae7a-409e-8226-c4e6b5c581a7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node549f0b96-51eb-4df4-aebf-181ebb448461"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb477bf4-7854-4b2a-b0df-e1b75beccf60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node56e985dc-1bd0-4fbd-b6dd-3d33102936e3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5e1246ca-5549-456b-aa2f-8fee43727145"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedff2db49-bf4a-4e39-82a9-7a7653e7661b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node996d0ca6-6a3d-4092-9ae1-74ac61ff2c2f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node653aa792-552d-46e9-ad82-3343d026f251"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec14491b2-13db-471e-a589-95c3e0e4e6ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node50bc60da-2610-441a-a482-5daaa4d5c50d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec5578b33-2cba-4dcf-89ac-ba71d2f9d3cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1e6c1377-940b-4954-bb07-880464b3bb7c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node04f73250-a377-4d75-a69a-c4a1cfaa6291"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c8083e6-be36-4e3a-8afe-cedf61385629"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node876a60cd-dbe7-488b-bf89-7577cae9db90"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb22ba095-aa52-483d-87d0-451557bd4fd5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node891155c8-8728-4338-85cf-163397b38f89"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6951a204-5ed4-4fab-acfb-792d2bd784cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node98c53f7b-50fc-4e8e-a6dd-1c57c03ce186"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node33daf6e5-8c62-4014-94f0-ad60a23da028"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node14d73ee8-3b36-4100-b4fc-f45aae44c963"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5cb40613-e451-4a40-80e0-5c3495d180c5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4d41f683-174e-47be-8d9a-64cc95a6b745"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node87e5a91a-6582-467e-b71b-278207f243a4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7ba236e2-e549-490c-b7e5-b03031f8b342"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5c6860b4-fd9f-42f2-851b-3276205bf026"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cde27df-9675-4d16-9bcc-c1c194a4669e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3c7e62fc-4dd5-45b2-8396-3d3a2b34ca65"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeffa3226-14de-412a-bb15-84fb18bed4e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3df9a10a-a9b3-44e1-a886-0e7b7a185686"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeaac83224-159d-420e-8ed3-2308f7920997"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c7ce910-dd8a-487a-8e16-b066824875c3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7783fbc5-cfbb-4990-b61e-f7ae3d21a0c1"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3b6225f9-bf59-4c90-ac4d-22e122c9f96c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb4b50d7-e578-4d51-a2ea-90fb7c2a5e52"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea10a59e8-9527-4fe8-a532-acf4a3bd38d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c63f8a9-5a7d-4c1d-84c8-f69f75fe2de0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedbfa4c52-b352-4c06-87d1-e16a6ad5a651"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6bbd1fa6-6cf8-4aff-a406-13248fcae3b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec73be65a-ceb9-4598-80a7-86fbf2947529"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4dd4fdbb-a5e7-429a-ab8e-addfebec41d3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6f7bea39-2c06-4019-b79a-f253d51b333e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0ebfaa8c-c0bd-485a-8f1f-8c57162c6479"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8a523a1c-6bf3-4a04-b2a9-5d1be4fe7c3e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6b4c1923-59f6-4b8a-98f1-8bdf98addbc6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node080eaa91-f744-4ea5-8c96-7b8328ac40af"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cfe1380-7070-45a1-878c-ca041b172ed9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded4736fbc-9e8f-40b0-b6e4-836f95c426fc"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeccdebd6-13e0-4fb7-81b0-bac7ac9d5019"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0671952-3434-4f7d-b140-366f3c690090"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node208a932e-db1b-4aed-9e17-10a722d4180e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodef2cca331-d1fb-4900-850b-9775e09f5ab4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0aaf46e-916b-44d5-b822-b2bdd4fd4463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node27a45017-67b7-4bac-9b3d-f4e874030750"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25846c97-29fd-4dd4-bc3e-fc7d9953f971"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5597346f-c7d2-4ef4-a882-d16adc55f723"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec7626f15-d6e2-4004-a2f7-36b2bb7e6c14"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3cbf6169-8c8e-4679-afb5-a0128342a875"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node345a3449-c22a-4969-a6bb-e7b3e4677779"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea11f8c38-d22c-4142-9850-ae1a0816a652"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec2fcb42c-f679-41f6-a010-65cd03e4c9f2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4eff4b87-6fa4-4a6b-935e-aba341d8c39b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node855eca9e-0c61-433b-bf64-cb8bb6f912e4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fde35e2-4f12-41ae-8def-e07d57982ebb"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8618ab58-ee5c-4dd9-973d-f31544237ba9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node64caf098-a774-42ab-bc92-a0a2e5b3fd74"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node126f370f-f826-4078-8401-44ff86537e7d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeac45d854-33df-465c-9338-ff863104f707"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node85c76fa1-8876-43b0-ac24-996a6f2e9e4e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodecd6266e4-cbeb-47b5-970c-434d1fad2033"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefe904bd2-7b01-4407-86ef-d3319dddce3e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node362fa2d5-b2cc-43c6-ae5f-7db31012bf33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c3ba37d-7830-4810-9ff0-8d49e5af6491"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb2be9264-e134-4435-b8c4-bb30084b84ae"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node864f1dfd-6876-4511-bd12-a813789de463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node580235a6-4e9a-48eb-9054-014c53cfd9b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3f5267e5-758c-4ce6-9958-f1c7294f8357"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b6d4a46-3937-4032-be2a-1fa3efedae59"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5dbf7e70-6a40-4293-bf2f-d6010bc96230"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefc62f503-deea-4e61-bc34-42d75f0a9d73"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5b24c94b-d4c7-4e12-9389-8c23aa4858f6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c876b75-3fa4-4de4-b985-95804f2a2ec7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeae2d3b23-a098-4dd8-8fc7-270cb0b1e427"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee6762039-36eb-4e60-81ef-81b840956eb5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded756a86a-b800-4fa0-bd67-35b834d95b33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b7c387b-8964-4b82-b417-a65baec4671b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4bd94fa8-77d0-4909-bb4a-21cdac3d8054"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee35a0fd3-2644-4c97-89df-aa881acc9f60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4b2356ab-d337-4e0d-a389-63f6a8975985"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4a64dcb4-5c9f-4884-9311-3ce8e2c3e271"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeefa426e9-0f65-4a4f-9d0a-a070858e42b2" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Chem_Toxicology_Journal"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec5578b33-2cba-4dcf-89ac-ba71d2f9d3cf" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b31ec623fe1fec57be6d7f112f04c221"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c5578b33-2cba-4dcf-89ac-ba71d2f9d3cf" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode894a0d67-b634-4eb2-8eb0-6a7c6eeed489"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Suspicious person is short and has blond hair" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodea3432617-e93c-4af8-ad50-68ec3b41664f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node04f73250-a377-4d75-a69a-c4a1cfaa6291" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:5915b5c168507094c176d2f9f1fc1433"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "04f73250-a377-4d75-a69a-c4a1cfaa6291" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1cd81abe-b4e6-4553-8aa8-77b3853a24b8"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Protesters in Kish started riots in Purple Street" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode84adf62e-2141-4554-8de7-da07676a0d45" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Amnesty_International"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode697f8c2a-91f5-4351-8f46-37fed45a4ef2" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Local_Police_NGO_report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode88f0d41c-caed-44b2-8775-59438fc587fc" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode574a62ee-c23c-46df-93ca-0040b0e809bf" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode8e26d7b0-575c-46e3-8167-c4b9bed67565" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Kish_Today_News"
    }
     ]
  }
   ,
  "_:572d9aaf4b1a022284adb64cc230b190" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-14T05:22:48Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2891a6b7-8a9d-45bd-9e25-37baa374055a"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node6951a204-5ed4-4fab-acfb-792d2bd784cf" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:ed3a6a9abf25d493aa4dda64d4bd1917"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "6951a204-5ed4-4fab-acfb-792d2bd784cf" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode5cb884a4-18f9-41bb-9f47-14e43da0310a"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Kish protest will be violent and difficult to control" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:57c2f133ef5c7d5c2741df2a5676b2ef" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:56:44Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeee76a631-062e-477b-bd83-3c33cadbbcfb"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node33daf6e5-8c62-4014-94f0-ad60a23da028" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:72374a8b86b7157ca13a3151fee4dd84"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "33daf6e5-8c62-4014-94f0-ad60a23da028" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode23b024cb-211b-44b1-a906-5f00ed302980"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info \n- was associated with Amnesty_International\n- was generated by CreateNodeb0a3e\n- was generated at time 2016-02-05T08:56:42Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:3885b485f708b85a63bcbd1d811b1f36" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T09:46:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodee6b29992-f2e6-4ca5-be32-72e7a388f67f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node14d73ee8-3b36-4100-b4fc-f45aae44c963" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e92947f4beb63dedad21366b06c79409"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "14d73ee8-3b36-4100-b4fc-f45aae44c963" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode44fb9ea3-3b8b-4891-8ff2-052a23db9f80"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "An IED exploded at the pumping station" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:cdc70487982457a6c46e94f2683d27b1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:56:37Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodea297317c-acc3-4672-a418-8f278cf4a649"
    }
     ]
  }
   ,
  "_:ad710bf8f4a95eb23bba677008a0b59f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T05:26:58Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode04d6a31f-b61a-4579-b702-3f2b6cde6a69"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3c7e62fc-4dd5-45b2-8396-3d3a2b34ca65" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:0077ebab512a20ad20369d3face44dfc"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3c7e62fc-4dd5-45b2-8396-3d3a2b34ca65" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef803f1da-934d-45e2-b69a-804ca29971e5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The provenance chain contains elements that lead us not to believe Ik." ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode1cd81abe-b4e6-4553-8aa8-77b3853a24b8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Kish_Today_Newspaper"
    }
     ]
  }
   ,
  "_:47fb5593b009730e6d94cfce87b86901" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T09:20:32Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8678df05-5aa4-4b18-a1b3-255d15eca881"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeeffa3226-14de-412a-bb15-84fb18bed4e0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:71fd1c27e534b9bf258c6db836823e87"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "effa3226-14de-412a-bb15-84fb18bed4e0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef33f74e9-cd5a-4b83-92e0-758f8f09af6c"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The Network of Hate is not connected to the Kish attack" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:5075bb79d66cfa08a2b34d1128f077ff" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:25:42Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodefec91652-5ed2-47c0-95d5-f338d75e8ac5"
    }
     ]
  }
   ,
  "_:07dfd7c7636c102bbfd890bfa5d47a03" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:26:41Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6a8790b6-dba3-4b59-9880-52a08b962fa4"
    }
     ]
  }
   ,
  "_:1736e03e5a1b2bd459e898e3f07252a3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2d2911d8-88a4-4708-8f39-81035b14d7ef"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode458deeb3-47f0-4eb6-b0be-42daf4a6d8cb" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/NGO_Medical_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node7c7ce910-dd8a-487a-8e16-b066824875c3" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3daa36d0ff50bd1597d1d4a86199e98b"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "7c7ce910-dd8a-487a-8e16-b066824875c3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9c0907a1-153d-4594-b7c3-1327719f7833"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Answer Yes may plausibly be true" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:81f4c02af518eb6e2798631bbbe3ad10" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:25:00Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode12d02e60-0efe-4b8b-bf90-d6daa09c3606"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node7783fbc5-cfbb-4990-b61e-f7ae3d21a0c1" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:4d83144bc0d2ec6c2c32dbd0ace1d698"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "7783fbc5-cfbb-4990-b61e-f7ae3d21a0c1" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef1350539-60d3-4f33-9bb6-e49c7741d6f5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Group provides evidence FOR Toxic Bacteria contaminated the local water system in Kish" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Minister_of_Foreign_Affairs" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node8c63f8a9-5a7d-4c1d-84c8-f69f75fe2de0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2641d13a10b76164c03ae241f1de0917"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "8c63f8a9-5a7d-4c1d-84c8-f69f75fe2de0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode5a7e9abd-dbb9-43c2-a8ec-bbc9f684172a"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Quish police used torture against members of group X" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:beac82ca900041a8f962ce6a6b3e4a55" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T05:18:05Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode88f0d41c-caed-44b2-8775-59438fc587fc"
    }
     ]
  }
   ,
  "_:3129a9fc8e828d5574ba668c44b81b21" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:42:53Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2e189cd6-8860-4092-b38d-2ba599a71762"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Moira,Patrol_2:msg_5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodec73be65a-ceb9-4598-80a7-86fbf2947529" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:8988688287581d44323c00f8b37764b5"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "c73be65a-ceb9-4598-80a7-86fbf2947529" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded92f7b08-f22e-455c-a269-ee864dc069e8"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Person leaving the red car has left at a hurried pace" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node6bbd1fa6-6cf8-4aff-a406-13248fcae3b9" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:a69a636e4afb8ba5b754b32b80f80cd0"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "6bbd1fa6-6cf8-4aff-a406-13248fcae3b9" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode7c0aa808-2cfa-4193-89c6-5a5c31a5b2a4"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There important differences between the cases that do not support this inference" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode9c0907a1-153d-4594-b7c3-1327719f7833" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeed5c9203-2e7f-4a2d-95f0-fb70723dff9c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode5a7e9abd-dbb9-43c2-a8ec-bbc9f684172a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeab9f1286-67cd-41c6-aa85-23d94428e010" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node6b4c1923-59f6-4b8a-98f1-8bdf98addbc6" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e030f77f924668929a5266c72a95e58a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "6b4c1923-59f6-4b8a-98f1-8bdf98addbc6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodefd85d1d6-11a8-4264-9676-68ea5502edff"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is another case C3 similar to C1 where A is false" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode9d14e0b8-8424-4d92-9f59-e78ee306d6c5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "_:26d1b5d739b592c6fa4e7698baf92fd8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:45:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0f78398e-e64b-4dd1-8be2-5cfe6402aae5"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNoded92f7b08-f22e-455c-a269-ee864dc069e8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CAT_POI_Report"
    }
     ]
  }
   ,
  "_:9f44b088310ffde835cb846356e820ff" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0e112d58-8e16-443d-ad51-35b102586a0d"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Chem_Toxicology_Journal" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:fa5942e1e83aff72c9edfc0b5395da89" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:30:21Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef34cd857-774e-4851-9d4a-c5783c3edb14"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode84308cd2-70c3-4f25-a23a-9004c8689588" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb0671952-3434-4f7d-b140-366f3c690090" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3bbcf784357b3c79784fbc8e035a4efd"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b0671952-3434-4f7d-b140-366f3c690090" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded5f82410-bb33-4417-b9fa-ac81f9091e63"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is an alternative cause that leads to the same effect" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:4d83144bc0d2ec6c2c32dbd0ace1d698" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T08:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef1350539-60d3-4f33-9bb6-e49c7741d6f5"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodef2cca331-d1fb-4900-850b-9775e09f5ab4" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:88ccf8ae8fab393dffad4b79ea0dea2e"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "f2cca331-d1fb-4900-850b-9775e09f5ab4" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef058da1e-6c7d-47ca-939e-140d6e15899e"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The people near the explosion are falling violently ill " ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode22f2672b-c6bb-4cd3-b64b-dbf7c3ae918f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "_:8f8a6b228f7ff9affc02bab0584faef4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:02:58Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0f5a90c4-6ad4-4c77-8054-6f3a359f1fcc"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Group_X_insider" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb0aaf46e-916b-44d5-b822-b2bdd4fd4463" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:d98b50dadc54e4644e3810b771d6f282"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b0aaf46e-916b-44d5-b822-b2bdd4fd4463" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode31efd59b-698f-420f-adc0-16f984e5e5f0"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "*Amnesty International produce report on Quish police brutality* is a credible information" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode8342c2f1-bd69-48a7-8c0d-241ff0fe6c78" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_myFormContCQQuest"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reporting21c72efe-3345-4fc3-8105-00886f1eedc4" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "_:cfad98514be5717ec9b90b70c51a4384" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:45:40Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6071d8c4-cb52-4b9c-93af-f014f25deb88"
    }
     ]
  }
   ,
  "_:1b8fd876cd5b52af2b33d59591553050" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T09:34:11Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeb5d2b500-1e10-4188-b385-682d6d50538b"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode474ed969-bfa9-41cb-8988-5d516614fde5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode8165fad6-501d-4dcc-8ef4-8c1fd6dcb526" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:5915b5c168507094c176d2f9f1fc1433" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T11:13:38Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode1cd81abe-b4e6-4553-8aa8-77b3853a24b8"
    }
     ]
  }
   ,
  "_:b5123279918e4d83cad7484026f70879" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T11:25:47Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode05391957-5f68-4989-b210-2794ff867db0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode6eb2f34e-54d8-48e9-9784-0e688195a8b6" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/TV_Interview"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode9b0046d2-c1a0-4355-9505-32767b36727f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/WaterTanksReport"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysiscec81d3f-fb25-47fa-9129-2801b9dc98b6" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "cec81d3f-fb25-47fa-9129-2801b9dc98b6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3346531a-9087-472a-be65-a63c4b8d6955"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25c281d3-456d-4c08-9e2e-db36748b81d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0628771b-5d9a-4d60-b4b4-cd4a848cd688"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded7a4bf74-e063-4e77-a400-e9dcfcc9a654"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node383c095b-a535-466e-a8ef-1aa88ad89ac4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec8281f43-6eb0-48cc-a875-e80ac8651be3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec6d69d25-8766-4bc5-b25b-30cb9bed1cc3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3712ac42-3b5d-4a54-8497-414d1116a323"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3ec90752-2980-4adb-97c4-d5574609f004"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5068cd04-1ad3-4fa9-a682-7240922449e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node449802f9-e222-4e4a-be55-b22815dd8569"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec16a2ae7-d95c-4c44-9cc1-2ee12a3a5196"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded301a120-3ff0-42dd-8baa-3e44c26f0719"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8cc12b90-aadd-4126-8c0f-9fe02bd14d00"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node63f07414-ae7a-409e-8226-c4e6b5c581a7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node549f0b96-51eb-4df4-aebf-181ebb448461"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb477bf4-7854-4b2a-b0df-e1b75beccf60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node56e985dc-1bd0-4fbd-b6dd-3d33102936e3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5e1246ca-5549-456b-aa2f-8fee43727145"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedff2db49-bf4a-4e39-82a9-7a7653e7661b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node996d0ca6-6a3d-4092-9ae1-74ac61ff2c2f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node653aa792-552d-46e9-ad82-3343d026f251"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec14491b2-13db-471e-a589-95c3e0e4e6ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node50bc60da-2610-441a-a482-5daaa4d5c50d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec5578b33-2cba-4dcf-89ac-ba71d2f9d3cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1e6c1377-940b-4954-bb07-880464b3bb7c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node04f73250-a377-4d75-a69a-c4a1cfaa6291"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c8083e6-be36-4e3a-8afe-cedf61385629"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node876a60cd-dbe7-488b-bf89-7577cae9db90"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb22ba095-aa52-483d-87d0-451557bd4fd5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6951a204-5ed4-4fab-acfb-792d2bd784cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node891155c8-8728-4338-85cf-163397b38f89"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node98c53f7b-50fc-4e8e-a6dd-1c57c03ce186"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5cb40613-e451-4a40-80e0-5c3495d180c5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node14d73ee8-3b36-4100-b4fc-f45aae44c963"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node33daf6e5-8c62-4014-94f0-ad60a23da028"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4d41f683-174e-47be-8d9a-64cc95a6b745"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node87e5a91a-6582-467e-b71b-278207f243a4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7ba236e2-e549-490c-b7e5-b03031f8b342"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3c7e62fc-4dd5-45b2-8396-3d3a2b34ca65"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5c6860b4-fd9f-42f2-851b-3276205bf026"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cde27df-9675-4d16-9bcc-c1c194a4669e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeffa3226-14de-412a-bb15-84fb18bed4e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3df9a10a-a9b3-44e1-a886-0e7b7a185686"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeaac83224-159d-420e-8ed3-2308f7920997"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c7ce910-dd8a-487a-8e16-b066824875c3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7783fbc5-cfbb-4990-b61e-f7ae3d21a0c1"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3b6225f9-bf59-4c90-ac4d-22e122c9f96c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb4b50d7-e578-4d51-a2ea-90fb7c2a5e52"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea10a59e8-9527-4fe8-a532-acf4a3bd38d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c63f8a9-5a7d-4c1d-84c8-f69f75fe2de0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedbfa4c52-b352-4c06-87d1-e16a6ad5a651"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec73be65a-ceb9-4598-80a7-86fbf2947529"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6bbd1fa6-6cf8-4aff-a406-13248fcae3b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4dd4fdbb-a5e7-429a-ab8e-addfebec41d3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6f7bea39-2c06-4019-b79a-f253d51b333e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8a523a1c-6bf3-4a04-b2a9-5d1be4fe7c3e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0ebfaa8c-c0bd-485a-8f1f-8c57162c6479"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6b4c1923-59f6-4b8a-98f1-8bdf98addbc6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node080eaa91-f744-4ea5-8c96-7b8328ac40af"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded4736fbc-9e8f-40b0-b6e4-836f95c426fc"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cfe1380-7070-45a1-878c-ca041b172ed9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeccdebd6-13e0-4fb7-81b0-bac7ac9d5019"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0671952-3434-4f7d-b140-366f3c690090"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node208a932e-db1b-4aed-9e17-10a722d4180e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodef2cca331-d1fb-4900-850b-9775e09f5ab4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0aaf46e-916b-44d5-b822-b2bdd4fd4463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node27a45017-67b7-4bac-9b3d-f4e874030750"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25846c97-29fd-4dd4-bc3e-fc7d9953f971"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5597346f-c7d2-4ef4-a882-d16adc55f723"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec7626f15-d6e2-4004-a2f7-36b2bb7e6c14"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea11f8c38-d22c-4142-9850-ae1a0816a652"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3cbf6169-8c8e-4679-afb5-a0128342a875"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node345a3449-c22a-4969-a6bb-e7b3e4677779"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec2fcb42c-f679-41f6-a010-65cd03e4c9f2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4eff4b87-6fa4-4a6b-935e-aba341d8c39b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node855eca9e-0c61-433b-bf64-cb8bb6f912e4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8618ab58-ee5c-4dd9-973d-f31544237ba9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fde35e2-4f12-41ae-8def-e07d57982ebb"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node126f370f-f826-4078-8401-44ff86537e7d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node64caf098-a774-42ab-bc92-a0a2e5b3fd74"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeac45d854-33df-465c-9338-ff863104f707"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodecd6266e4-cbeb-47b5-970c-434d1fad2033"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node85c76fa1-8876-43b0-ac24-996a6f2e9e4e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node362fa2d5-b2cc-43c6-ae5f-7db31012bf33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c3ba37d-7830-4810-9ff0-8d49e5af6491"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb2be9264-e134-4435-b8c4-bb30084b84ae"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node580235a6-4e9a-48eb-9054-014c53cfd9b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node864f1dfd-6876-4511-bd12-a813789de463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3f5267e5-758c-4ce6-9958-f1c7294f8357"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b6d4a46-3937-4032-be2a-1fa3efedae59"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5dbf7e70-6a40-4293-bf2f-d6010bc96230"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefc62f503-deea-4e61-bc34-42d75f0a9d73"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5b24c94b-d4c7-4e12-9389-8c23aa4858f6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c876b75-3fa4-4de4-b985-95804f2a2ec7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeae2d3b23-a098-4dd8-8fc7-270cb0b1e427"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee6762039-36eb-4e60-81ef-81b840956eb5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded756a86a-b800-4fa0-bd67-35b834d95b33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b7c387b-8964-4b82-b417-a65baec4671b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee35a0fd3-2644-4c97-89df-aa881acc9f60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4bd94fa8-77d0-4909-bb4a-21cdac3d8054"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4b2356ab-d337-4e0d-a389-63f6a8975985"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4a64dcb4-5c9f-4884-9311-3ce8e2c3e271"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fa9c6e37c50beb72d96dce1762ec6e5d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "417097cc-b0d0-43d5-9c10-cc2e04ca9bcd" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode3d80af3d-dd83-40be-a9c8-c06ed197f821"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "NON-waterborne bacteria contaminate the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:2641d13a10b76164c03ae241f1de0917" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T09:27:07Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode5a7e9abd-dbb9-43c2-a8ec-bbc9f684172a"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node855eca9e-0c61-433b-bf64-cb8bb6f912e4" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:87446a1e8fc5648fb7869ff98bb88e09"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "855eca9e-0c61-433b-bf64-cb8bb6f912e4" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0dac5bcd-8374-4862-8cea-ee392c21e56a"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Traces of a similar substance were discovered at the border between Kish and Vast" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node8618ab58-ee5c-4dd9-973d-f31544237ba9" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:62845099d607443e5724d908c48d94d6"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "8618ab58-ee5c-4dd9-973d-f31544237ba9" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8e26d7b0-575c-46e3-8167-c4b9bed67565"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Kish would conduct dirty bomb training exercise." ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Intelligence_Cell_G" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode12d02e60-0efe-4b8b-bf90-d6daa09c3606" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MOIRA" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:ab5bb10cdd62bc7ad701cb0c2fb90df1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T09:02:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode91e85bd1-5790-4db7-ba1d-b5bd204f2abe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodef33f74e9-cd5a-4b83-92e0-758f8f09af6c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:2a8dc0aee7323a7cdf2c91cc587bc409" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T02:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CAT_POI_Report" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:e030f77f924668929a5266c72a95e58a" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:30:35Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodefd85d1d6-11a8-4264-9676-68ea5502edff"
    }
     ]
  }
   ,
  "_:e92947f4beb63dedad21366b06c79409" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:30:13Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode44fb9ea3-3b8b-4891-8ff2-052a23db9f80"
    }
     ]
  }
   ,
  "_:40efde0582c4dda91324b1bcf13fed5f" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T07:19:54Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode574a62ee-c23c-46df-93ca-0040b0e809bf"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodea703fa09-c110-4bef-8930-6506470a7903" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "_:69d452abef2614afa83308b280fb32d8" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-18T03:39:55Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9b0046d2-c1a0-4355-9505-32767b36727f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb2be9264-e134-4435-b8c4-bb30084b84ae" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fe2ffbad4246953c9673d91fa9997402"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b2be9264-e134-4435-b8c4-bb30084b84ae" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode84adf62e-2141-4554-8de7-da07676a0d45"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Amnesty claim Quish police used torture against group X members last year" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node864f1dfd-6876-4511-bd12-a813789de463" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:0c83fa0335a881d82cf7e8e86ae12446"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "864f1dfd-6876-4511-bd12-a813789de463" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode9d14e0b8-8424-4d92-9f59-e78ee306d6c5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Group provides evidence AGAINST Local authorities and police are trained for attacks" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode0c09341d-cd76-476c-959a-22241c72699e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node5dbf7e70-6a40-4293-bf2f-d6010bc96230" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:077f26d2ab31808a6f7c7c25c236e376"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "5dbf7e70-6a40-4293-bf2f-d6010bc96230" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode474ed969-bfa9-41cb-8988-5d516614fde5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Local authorities and police are trained for attacks" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:da4b83b47ce7cc852d2fefcc5fb49365" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:17:15Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode40ac9722-203c-4fde-ad7e-91c656e039c0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode6b9f90d3-5410-45da-96e9-998284efcb98" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode48ee1d17-7033-488a-9c13-31ab34f42742" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodee6762039-36eb-4e60-81ef-81b840956eb5" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:392a21ad77ede165095b7b736b11c51d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "e6762039-36eb-4e60-81ef-81b840956eb5" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode84308cd2-70c3-4f25-a23a-9004c8689588"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The police plans a rescue operation exercise in case of dirty bomb" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode0f5a90c4-6ad4-4c77-8054-6f3a359f1fcc" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Noded756a86a-b800-4fa0-bd67-35b834d95b33" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:fa5942e1e83aff72c9edfc0b5395da89"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "d756a86a-b800-4fa0-bd67-35b834d95b33" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef34cd857-774e-4851-9d4a-c5783c3edb14"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Explosion at Kish pumping station" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode2e189cd6-8860-4092-b38d-2ba599a71762" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodedecfd626-132d-455d-ae17-df7acf22dbf8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Mayor_of_Kish_"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodee35a0fd3-2644-4c97-89df-aa881acc9f60" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2090b43184e436bcb6c6dcd341deee62"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "e35a0fd3-2644-4c97-89df-aa881acc9f60" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode7a73a740-bcc7-4b75-91fa-739cb2cf86b3"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The pumping station has exploded" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Pref_Analysis_Node_1b880c0b-b471-4aa8-beed-e5fa3d4e856a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node4a64dcb4-5c9f-4884-9311-3ce8e2c3e271" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:5c774c17d5808b5360e1685168caf03a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "4a64dcb4-5c9f-4884-9311-3ce8e2c3e271" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode236e8b7c-88ff-416e-a72c-15dde696d946"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Internal enquiry report published by Quish police" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode66befb66-d6f6-4843-ad45-5e3c51cdaf4b" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodef058da1e-6c7d-47ca-939e-140d6e15899e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodef803f1da-934d-45e2-b69a-804ca29971e5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Noded7a4bf74-e063-4e77-a400-e9dcfcc9a654" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:383fa87cfd3a11425f291e2c595ed599"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "d7a4bf74-e063-4e77-a400-e9dcfcc9a654" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeea3f0903-70ff-4916-a45f-aa3a90dcdc6e"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is a large protest in front of local factory" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:481f210c0d8254e8ef5541ff34cc9959" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:03:45Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded80e2187-d778-41c5-957f-49e31b2f5e30"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodefec91652-5ed2-47c0-95d5-f338d75e8ac5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node3712ac42-3b5d-4a54-8497-414d1116a323" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:47fb5593b009730e6d94cfce87b86901"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "3712ac42-3b5d-4a54-8497-414d1116a323" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8678df05-5aa4-4b18-a1b3-255d15eca881"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Kish protest will be peaceful" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode91e85bd1-5790-4db7-ba1d-b5bd204f2abe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3346531a-9087-472a-be65-a63c4b8d6955"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25c281d3-456d-4c08-9e2e-db36748b81d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0628771b-5d9a-4d60-b4b4-cd4a848cd688"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node383c095b-a535-466e-a8ef-1aa88ad89ac4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded7a4bf74-e063-4e77-a400-e9dcfcc9a654"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec8281f43-6eb0-48cc-a875-e80ac8651be3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec6d69d25-8766-4bc5-b25b-30cb9bed1cc3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3712ac42-3b5d-4a54-8497-414d1116a323"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3ec90752-2980-4adb-97c4-d5574609f004"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node449802f9-e222-4e4a-be55-b22815dd8569"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5068cd04-1ad3-4fa9-a682-7240922449e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec16a2ae7-d95c-4c44-9cc1-2ee12a3a5196"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded301a120-3ff0-42dd-8baa-3e44c26f0719"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8cc12b90-aadd-4126-8c0f-9fe02bd14d00"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node63f07414-ae7a-409e-8226-c4e6b5c581a7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node549f0b96-51eb-4df4-aebf-181ebb448461"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded855f306-be9a-40f7-a0d5-6d71b1a2b5ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb477bf4-7854-4b2a-b0df-e1b75beccf60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node56e985dc-1bd0-4fbd-b6dd-3d33102936e3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5e1246ca-5549-456b-aa2f-8fee43727145"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedff2db49-bf4a-4e39-82a9-7a7653e7661b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node996d0ca6-6a3d-4092-9ae1-74ac61ff2c2f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node653aa792-552d-46e9-ad82-3343d026f251"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4e83ad0f-3533-42ac-94d3-ad4d7bab015c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec14491b2-13db-471e-a589-95c3e0e4e6ba"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node50bc60da-2610-441a-a482-5daaa4d5c50d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec5578b33-2cba-4dcf-89ac-ba71d2f9d3cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1e6c1377-940b-4954-bb07-880464b3bb7c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node04f73250-a377-4d75-a69a-c4a1cfaa6291"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c8083e6-be36-4e3a-8afe-cedf61385629"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node876a60cd-dbe7-488b-bf89-7577cae9db90"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb22ba095-aa52-483d-87d0-451557bd4fd5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefcab8cb9-5b31-4ebf-a202-80d9821746b3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6951a204-5ed4-4fab-acfb-792d2bd784cf"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node891155c8-8728-4338-85cf-163397b38f89"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node98c53f7b-50fc-4e8e-a6dd-1c57c03ce186"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node33daf6e5-8c62-4014-94f0-ad60a23da028"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5cb40613-e451-4a40-80e0-5c3495d180c5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node14d73ee8-3b36-4100-b4fc-f45aae44c963"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4d41f683-174e-47be-8d9a-64cc95a6b745"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node87e5a91a-6582-467e-b71b-278207f243a4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7ba236e2-e549-490c-b7e5-b03031f8b342"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3c7e62fc-4dd5-45b2-8396-3d3a2b34ca65"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5c6860b4-fd9f-42f2-851b-3276205bf026"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cde27df-9675-4d16-9bcc-c1c194a4669e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeffa3226-14de-412a-bb15-84fb18bed4e0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3df9a10a-a9b3-44e1-a886-0e7b7a185686"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeaac83224-159d-420e-8ed3-2308f7920997"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c7ce910-dd8a-487a-8e16-b066824875c3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7783fbc5-cfbb-4990-b61e-f7ae3d21a0c1"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3b6225f9-bf59-4c90-ac4d-22e122c9f96c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefb4b50d7-e578-4d51-a2ea-90fb7c2a5e52"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea10a59e8-9527-4fe8-a532-acf4a3bd38d0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8c63f8a9-5a7d-4c1d-84c8-f69f75fe2de0"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodedbfa4c52-b352-4c06-87d1-e16a6ad5a651"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec73be65a-ceb9-4598-80a7-86fbf2947529"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6bbd1fa6-6cf8-4aff-a406-13248fcae3b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4dd4fdbb-a5e7-429a-ab8e-addfebec41d3"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6f7bea39-2c06-4019-b79a-f253d51b333e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0ebfaa8c-c0bd-485a-8f1f-8c57162c6479"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8a523a1c-6bf3-4a04-b2a9-5d1be4fe7c3e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node6b4c1923-59f6-4b8a-98f1-8bdf98addbc6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node080eaa91-f744-4ea5-8c96-7b8328ac40af"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2cfe1380-7070-45a1-878c-ca041b172ed9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded4736fbc-9e8f-40b0-b6e4-836f95c426fc"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeeccdebd6-13e0-4fb7-81b0-bac7ac9d5019"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node208a932e-db1b-4aed-9e17-10a722d4180e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0671952-3434-4f7d-b140-366f3c690090"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodef2cca331-d1fb-4900-850b-9775e09f5ab4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb0aaf46e-916b-44d5-b822-b2bdd4fd4463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node27a45017-67b7-4bac-9b3d-f4e874030750"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node25846c97-29fd-4dd4-bc3e-fc7d9953f971"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5597346f-c7d2-4ef4-a882-d16adc55f723"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec7626f15-d6e2-4004-a2f7-36b2bb7e6c14"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodea11f8c38-d22c-4142-9850-ae1a0816a652"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node345a3449-c22a-4969-a6bb-e7b3e4677779"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3cbf6169-8c8e-4679-afb5-a0128342a875"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node417097cc-b0d0-43d5-9c10-cc2e04ca9bcd"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodec2fcb42c-f679-41f6-a010-65cd03e4c9f2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4eff4b87-6fa4-4a6b-935e-aba341d8c39b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node855eca9e-0c61-433b-bf64-cb8bb6f912e4"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node8618ab58-ee5c-4dd9-973d-f31544237ba9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fde35e2-4f12-41ae-8def-e07d57982ebb"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node126f370f-f826-4078-8401-44ff86537e7d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node64caf098-a774-42ab-bc92-a0a2e5b3fd74"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeac45d854-33df-465c-9338-ff863104f707"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node85c76fa1-8876-43b0-ac24-996a6f2e9e4e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodecd6266e4-cbeb-47b5-970c-434d1fad2033"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefe904bd2-7b01-4407-86ef-d3319dddce3e"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node362fa2d5-b2cc-43c6-ae5f-7db31012bf33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1fdf3463-55fa-452b-ba95-4dcc63fa182f"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeffebea19-e42a-41a1-a215-bb8acd1aebd2"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node7c3ba37d-7830-4810-9ff0-8d49e5af6491"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb2be9264-e134-4435-b8c4-bb30084b84ae"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node580235a6-4e9a-48eb-9054-014c53cfd9b9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node864f1dfd-6876-4511-bd12-a813789de463"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node3f5267e5-758c-4ce6-9958-f1c7294f8357"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b6d4a46-3937-4032-be2a-1fa3efedae59"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5dbf7e70-6a40-4293-bf2f-d6010bc96230"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodefc62f503-deea-4e61-bc34-42d75f0a9d73"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node5b24c94b-d4c7-4e12-9389-8c23aa4858f6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c876b75-3fa4-4de4-b985-95804f2a2ec7"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeae2d3b23-a098-4dd8-8fc7-270cb0b1e427"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee6762039-36eb-4e60-81ef-81b840956eb5"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Noded756a86a-b800-4fa0-bd67-35b834d95b33"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node2b7c387b-8964-4b82-b417-a65baec4671b"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4bd94fa8-77d0-4909-bb4a-21cdac3d8054"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee35a0fd3-2644-4c97-89df-aa881acc9f60"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4b2356ab-d337-4e0d-a389-63f6a8975985"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node4a64dcb4-5c9f-4884-9311-3ce8e2c3e271"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysiscec81d3f-fb25-47fa-9129-2801b9dc98b6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/"
    }
     ]
  }
   ,
  "_:acf6feb0344597f61c2c1df006ef8052" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T09:36:42Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode48ee1d17-7033-488a-9c13-31ab34f42742"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/John_Doe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:26a89f148e4c3aded6fa2b48d00f17bc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:30:10Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode08ea8663-cb62-49e5-82ee-807911d075dc"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node8cc12b90-aadd-4126-8c0f-9fe02bd14d00" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:0ae45db619cfad75c747ef6ec45929b2"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "8cc12b90-aadd-4126-8c0f-9fe02bd14d00" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8e6d2e61-bc4b-49c8-8cdf-cfec3b52822e"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "DG has blond hair, and is short" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/TV_Interview" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeb3941a5f-2a01-4f2c-bcfb-bf41ac986c75" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodef34cd857-774e-4851-9d4a-c5783c3edb14" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeb5d2b500-1e10-4188-b385-682d6d50538b" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Quish_police"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode21fa660c-5aa1-4bf4-bb2d-9acc4d4dc862" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node139a6d45-9576-4066-9907-134f2c429f0b" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:cdc70487982457a6c46e94f2683d27b1"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "139a6d45-9576-4066-9907-134f2c429f0b" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodea297317c-acc3-4672-a418-8f278cf4a649"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There are bacteria in the water supply" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:b4dd6b8e52fce3a481b98c508f4bc978" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:11:46Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode39b2dc91-8b68-48f2-82fe-56ba6713a934"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode08ea8663-cb62-49e5-82ee-807911d075dc" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node50bc60da-2610-441a-a482-5daaa4d5c50d" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:9da16ea465b1f08b34cfd6522662cc48"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "50bc60da-2610-441a-a482-5daaa4d5c50d" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode4f79612f-53f7-4417-86eb-058cf9322b47"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Vast was under attack by the Network of Hate last month" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode4f79612f-53f7-4417-86eb-058cf9322b47" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode3e85125e-2cc8-46c6-9983-add44d3d8424" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Amnesty_International"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode1635fc6d-c268-45a8-86c5-c05839f4ece4" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Kish_Press"
    }
     ]
  }
   ,
  "_:285de7612ffa7da3f39978cbbb0688f4" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-02-05T08:34:36Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeff4a19bf-5d6a-4caa-a1a6-a1de144e2919"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node1e6c1377-940b-4954-bb07-880464b3bb7c" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:491991b8a0e5649b633e7b8e137f712a"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "1e6c1377-940b-4954-bb07-880464b3bb7c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodee22e091d-18a0-4578-8304-11e4ceb126b5"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "*Internal enquiry report published by Quish police* is a credible information" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:cdf1282a5d3b830a10aadd03b845d238" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-18T03:47:39Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodef588b30f-7b45-4291-b609-3313f2c8b4b4"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode2d2911d8-88a4-4708-8f39-81035b14d7ef" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273"
    }
     ]
  }
   ,
  "_:235beae33d6656aee3c6c7b7b97bc8dc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T08:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2a907d28-cd9f-4a7f-a515-b4f6b3210c34"
    }
     ]
  }
   ,
  "_:dedd7ce72bf5daa08a7dabbbe6b0d7b0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-10T06:38:49Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode015e65a4-12df-42f6-8504-8c212fb0f4a3"
    }
     ]
  }
   ,
  "_:df6150923a0b5ea4a0b6cd4424e0d9a9" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-09-07T08:56:56Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodeb3941a5f-2a01-4f2c-bcfb-bf41ac986c75"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node8c8083e6-be36-4e3a-8afe-cedf61385629" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3129a9fc8e828d5574ba668c44b81b21"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "8c8083e6-be36-4e3a-8afe-cedf61385629" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode2e189cd6-8860-4092-b38d-2ba599a71762"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "There is no evidence to show that the cause occurred" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol_PX" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodeea3f0903-70ff-4916-a45f-aa3a90dcdc6e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Kish_News_Press"
    }
     ]
  }
   ,
  "_:72374a8b86b7157ca13a3151fee4dd84" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:09:55Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode23b024cb-211b-44b1-a906-5f00ed302980"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb22ba095-aa52-483d-87d0-451557bd4fd5" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:07dfd7c7636c102bbfd890bfa5d47a03"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b22ba095-aa52-483d-87d0-451557bd4fd5" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode6a8790b6-dba3-4b59-9880-52a08b962fa4"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The weather was clear" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodec6944015-547f-4012-94d7-57acc36c47cd" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CS_Results_myFormContCQQuest"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node4d41f683-174e-47be-8d9a-64cc95a6b745" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:8f8a6b228f7ff9affc02bab0584faef4"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "4d41f683-174e-47be-8d9a-64cc95a6b745" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode0f5a90c4-6ad4-4c77-8054-6f3a359f1fcc"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "The Network of Hate has been involved in many other attacks in the region" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:8632303b97fb126d75c6e047476c3403" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-06T08:01:20Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode8342c2f1-bd69-48a7-8c0d-241ff0fe6c78"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CS_Results_a1566b42-9e48-4b2d-b3ff-be15a84f8273" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:3bbcf784357b3c79784fbc8e035a4efd" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2015-12-17T05:31:42Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded5f82410-bb33-4417-b9fa-ac81f9091e63"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node2cde27df-9675-4d16-9bcc-c1c194a4669e" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:346ac05b5b4cece25b3a2306561b9718"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "2cde27df-9675-4d16-9bcc-c1c194a4669e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNoded5153ad7-660c-4176-80dd-46089c14f843"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Fall-out from the explosion affected a large area" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Prov_Analysis_Node_4a64dcb4-5c9f-4884-9311-3ce8e2c3e271" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node94fb8d47-7068-4a1e-bd8f-73c5548aff92" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:7235544ca5b339549bc318759138e474"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "94fb8d47-7068-4a1e-bd8f-73c5548aff92" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode458deeb3-47f0-4eb6-b0be-42daf4a6d8cb"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Illness among young and elderly people in Kishshire caused by bacteria" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringdd34322b-4053-406f-95c6-081bd94f2af8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Local_Police_NGO_report" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:d98b50dadc54e4644e3810b771d6f282" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-07T03:09:55Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode31efd59b-698f-420f-adc0-16f984e5e5f0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodefb4b50d7-e578-4d51-a2ea-90fb7c2a5e52" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:4a483a9a90223ea5b97e3f130c6f4255"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "fb4b50d7-e578-4d51-a2ea-90fb7c2a5e52" ,
      "datatype" : "h', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Ellainfobox', '{ }', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Ella', '{ }', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('Abc', '{ 
  "http://www.itacispaces.org/CreateNodefaebec6d-1682-4659-89d6-27c4ee2e8d00" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Ella" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:f99f67cda3df3ca8e8da65e5d3033c02"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "f61c32e3-b3e6-43a7-9a5d-29bb6ec858c9" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Abc" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
   ,
  "_:13b2528c:15dc6a280a2:-7f7d" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-09T11:08:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat4e0024c7-1db7-4083-8fec-dfec57918b4e"
    }
     ]
  }
   ,
  "_:f99f67cda3df3ca8e8da65e5d3033c02" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-09T11:07:35Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9"
    }
     ]
  }
   ,
  "_:13b2528c:15dc6a280a2:-7f7e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-02T03:22:28Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodefaebec6d-1682-4659-89d6-27c4ee2e8d00"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodee64d1637-831b-4772-aa5a-3fe88457fea6" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:13b2528c:15dc6a280a2:-7f7e"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "e64d1637-831b-4772-aa5a-3fe88457fea6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodefaebec6d-1682-4659-89d6-27c4ee2e8d00"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat4e0024c7-1db7-4083-8fec-dfec57918b4e" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodee64d1637-831b-4772-aa5a-3fe88457fea6"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Miles"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis4e0024c7-1db7-4083-8fec-dfec57918b4e" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "4e0024c7-1db7-4083-8fec-dfec57918b4e" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:13b2528c:15dc6a280a2:-7f7d"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat4e0024c7-1db7-4083-8fec-dfec57918b4e"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of Abc" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/UK/US"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Miles" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/UK"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Miles" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysisf61c32e3-b3e6-43a7-9a5d-29bb6ec858c9" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('New_Chat_Room2', '{ 
  "_:8d3047049648ad8334c7a7b94d387e5e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-06-23T03:27:58Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Analyse_Prov_Chain_36264911-7520-458d-9edf-ef17e932a1dc"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysisaddd69eb-930b-4455-8b1b-40b539e7471f" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:c6c0e54300b87a4d0f4f4b473865d6f1"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "addd69eb-930b-4455-8b1b-40b539e7471f" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisaddd69eb-930b-4455-8b1b-40b539e7471f"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of New_Chat_Room2" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CISpaces_Prov_Service" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysisaddd69eb-930b-4455-8b1b-40b539e7471f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ]
  }
   ,
  "_:27fbc907760b2628005b3de99edd5d97" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-06-23T03:27:58Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Analyse_Prov_Chain_37d9ad4a-20ca-4b95-83e7-2a475dbc0673"
    }
     ]
  }
   ,
  "_:c6c0e54300b87a4d0f4f4b473865d6f1" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-06-23T03:27:02Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisaddd69eb-930b-4455-8b1b-40b539e7471f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Analyse_Prov_Chain_36264911-7520-458d-9edf-ef17e932a1dc" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_81990c96-14c4-4a09-8c53-118733effc10"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpaces_Prov_Service"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Analyse_Prov_Chain_37d9ad4a-20ca-4b95-83e7-2a475dbc0673" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_81990c96-14c4-4a09-8c53-118733effc10"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CISpaces_Prov_Service"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeffb9d071-36cf-4d17-abd9-32a0b069af09" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:8d3047049648ad8334c7a7b94d387e5e"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Analyse_Prov_Chain_36264911-7520-458d-9edf-ef17e932a1dc"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "ffb9d071-36cf-4d17-abd9-32a0b069af09" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "*Claim* is a credible information" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_81990c96-14c4-4a09-8c53-118733effc10"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node6c7a9a30-4d47-49b6-9b17-81511e7e3f93" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:27fbc907760b2628005b3de99edd5d97"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Analyse_Prov_Chain_37d9ad4a-20ca-4b95-83e7-2a475dbc0673"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "6c7a9a30-4d47-49b6-9b17-81511e7e3f93" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info \n- was associated with Joe\n- was generated by CreateNodeef5b5\n- was generated at time 2017-06-23T03:27:05Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Prov_Analysis_Node_81990c96-14c4-4a09-8c53-118733effc10"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Prov_Analysis_Node_81990c96-14c4-4a09-8c53-118733effc10" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('cde', '{ 
  "http://www.itacispaces.org/OnLeaveAnalysis53f430c6-d184-4fd5-bc87-2406238a64d6" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "53f430c6-d184-4fd5-bc87-2406238a64d6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:4eddb094f4852600b40a53c238c019e6"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat53f430c6-d184-4fd5-bc87-2406238a64d6"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis4b77f5ee-d55a-43d1-8303-044fadf529a9"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Ella" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/N/A"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Ella" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "_:00fc69eba55509e4efdb30d1351ff507" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:32:19Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode769c250f-45f5-49ab-a85c-ef1c6534341a"
    }
     ]
  }
   ,
  "_:9a05584a220cadf728d461f7411ada90" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:32:01Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChatcec81d3f-fb25-47fa-9129-2801b9dc98b6" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis07103c01-99f4-4c33-9141-d88aacab49b0"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChatb64c0286-0f86-49a1-b614-0053c7900b96" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysisfd6c2e14-f597-4aa8-9afa-25252e8fef9c"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1dfe5c25-430d-488e-941f-0139a282d00d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:a16804a5b843bcab8f486d845b577c96"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodecb82602b-ece4-4449-8bd0-16606ad6174b"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b714e00c-f5ee-4b8a-88a5-876511540898" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Claim" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat4b77f5ee-d55a-43d1-8303-044fadf529a9" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysisb64c0286-0f86-49a1-b614-0053c7900b96"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node1dfe5c25-430d-488e-941f-0139a282d00d"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:a16804a5b843bcab8f486d845b577c96" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:32:21Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNodecb82602b-ece4-4449-8bd0-16606ad6174b"
    }
     ]
  }
   ,
  "_:3a41b803bf80f7b0b87e543a1e7ab954" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-02T03:20:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChatcec81d3f-fb25-47fa-9129-2801b9dc98b6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode82fd175f-da2b-42c5-b16a-0d9b9057085f" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysisb64c0286-0f86-49a1-b614-0053c7900b96" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "b64c0286-0f86-49a1-b614-0053c7900b96" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b0210d35e372085570d974dacdadbe44"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChatb64c0286-0f86-49a1-b614-0053c7900b96"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysisfd6c2e14-f597-4aa8-9afa-25252e8fef9c"
    }
     ]
  }
   ,
  "_:63e0f4d85343e9c296a26076d351e129" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:37:23Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode82fd175f-da2b-42c5-b16a-0d9b9057085f"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNodecb82602b-ece4-4449-8bd0-16606ad6174b" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "_:0b1f469db76a13204b3ab9feedc0f6bc" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:37:38Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat4b77f5ee-d55a-43d1-8303-044fadf529a9"
    }
     ]
  }
   ,
  "_:e3a6bc0d69bd832a4731616a3dd5f6e3" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T02:01:49Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat07103c01-99f4-4c33-9141-d88aacab49b0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Joe" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/UK/US"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Joe" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/UK/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:b0210d35e372085570d974dacdadbe44" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:37:34Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChatb64c0286-0f86-49a1-b614-0053c7900b96"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChat07103c01-99f4-4c33-9141-d88aacab49b0" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis53f430c6-d184-4fd5-bc87-2406238a64d6"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis4b77f5ee-d55a-43d1-8303-044fadf529a9" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:0b1f469db76a13204b3ab9feedc0f6bc"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "4b77f5ee-d55a-43d1-8303-044fadf529a9" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat4b77f5ee-d55a-43d1-8303-044fadf529a9"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysisb64c0286-0f86-49a1-b614-0053c7900b96"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat79559144-da9c-48ee-8aef-7b601d324ef5" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysiscec81d3f-fb25-47fa-9129-2801b9dc98b6"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:00fc69eba55509e4efdb30d1351ff507"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode769c250f-45f5-49ab-a85c-ef1c6534341a"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "0c89d97a-dff4-4337-b9fe-b96058a21f63" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/CreateNode769c250f-45f5-49ab-a85c-ef1c6534341a" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/LeaveChat53f430c6-d184-4fd5-bc87-2406238a64d6" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis4b77f5ee-d55a-43d1-8303-044fadf529a9"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysisfd6c2e14-f597-4aa8-9afa-25252e8fef9c" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b86122593df9e3af0e9866e446c45666"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "fd6c2e14-f597-4aa8-9afa-25252e8fef9c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChatfd6c2e14-f597-4aa8-9afa-25252e8fef9c"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysiscec81d3f-fb25-47fa-9129-2801b9dc98b6" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:3a41b803bf80f7b0b87e543a1e7ab954"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "cec81d3f-fb25-47fa-9129-2801b9dc98b6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChatcec81d3f-fb25-47fa-9129-2801b9dc98b6"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnJoinAnalysis07103c01-99f4-4c33-9141-d88aacab49b0"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node1dfe5c25-430d-488e-941f-0139a282d00d" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:63e0f4d85343e9c296a26076d351e129"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "1dfe5c25-430d-488e-941f-0139a282d00d" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/CreateNode82fd175f-da2b-42c5-b16a-0d9b9057085f"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "Info" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ]
  }
   ,
  "_:13b2528c:15dc6a280a2:-7f81" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-09T11:07:35Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat79559144-da9c-48ee-8aef-7b601d324ef5"
    }
     ]
  }
   ,
  "_:4eddb094f4852600b40a53c238c019e6" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T02:01:38Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat53f430c6-d184-4fd5-bc87-2406238a64d6"
    }
     ]
  }
   ,
  "_:b86122593df9e3af0e9866e446c45666" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-31T01:37:09Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChatfd6c2e14-f597-4aa8-9afa-25252e8fef9c"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnLeaveAnalysis79559144-da9c-48ee-8aef-7b601d324ef5" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "79559144-da9c-48ee-8aef-7b601d324ef5" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:13b2528c:15dc6a280a2:-7f81"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/LeaveChat79559144-da9c-48ee-8aef-7b601d324ef5"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysiscec81d3f-fb25-47fa-9129-2801b9dc98b6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/N/A" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/OnJoinAnalysis07103c01-99f4-4c33-9141-d88aacab49b0" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e3a6bc0d69bd832a4731616a3dd5f6e3"
    }
     ] ,
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "07103c01-99f4-4c33-9141-d88aacab49b0" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/JoinChat07103c01-99f4-4c33-9141-d88aacab49b0"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/OnLeaveAnalysis53f430c6-d184-4fd5-bc87-2406238a64d6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "4f2a6e73-b02f-4f03-b72e-6ceef1d089be" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:9a05584a220cadf728d461f7411ada90"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of cde" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/JoinChatfd6c2e14-f597-4aa8-9afa-25252e8fef9c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Nodeb714e00c-f5ee-4b8a-88a5-876511540898"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Node0c89d97a-dff4-4337-b9fe-b96058a21f63"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/InitialAnalysis4f2a6e73-b02f-4f03-b72e-6ceef1d089be"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Joe"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('null', '{ }', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('USinfobox', '{ 
  "http://www.itacispaces.org/MOIRA" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportinga52f6003-44e4-4b73-a18d-870eff4c1911" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_41c9cbe2-d3be-4843-890c-4abc268f9193"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alun_patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiring9b6a8983-0560-4277-a2dd-7b68fd49b999" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "_:-26c4cf87:15d8448dbc0:-7ff0" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T02:00:08Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringac7afa8d-c338-48aa-9f05-d41298b45611"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodee2bae1b0-b519-4da4-83a0-0487fedd9c2c" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:b670bf28b97d4ffec36e97ba86b34217"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:abaf9b12f5c1db2ccbd41e7bed850d15"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "e2bae1b0-b519-4da4-83a0-0487fedd9c2c" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring3c3651f9-2b4d-489f-a41c-5ba236662dd8"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringf0f785cb-9704-4126-bd61-3b89076dd097"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "some info 3" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alice_Patrol_Report"
    }
     ]
  }
   ,
  "_:3212f928424d68d5b21f0b82230d1603" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:42:34Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringa52f6003-44e4-4b73-a18d-870eff4c1911"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MOIRA_Notif_e2bae1b0-b519-4da4-83a0-0487fedd9c2c" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/_hgf_" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "_:a4c5203af48058feb03a6b00105fd485" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:51Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting3c3651f9-2b4d-489f-a41c-5ba236662dd8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringd18c2166-6140-4b1d-a59f-47d35aa54832" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reporting3c3651f9-2b4d-489f-a41c-5ba236662dd8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_e2bae1b0-b519-4da4-83a0-0487fedd9c2c"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alice_Patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportingf0f785cb-9704-4126-bd61-3b89076dd097" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_e2bae1b0-b519-4da4-83a0-0487fedd9c2c"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alice_Patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/alun_patrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:e4c3b8629ae3a53c45c61d1bc1f9218c"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:21e1917eb410ae25e5f27d6136d3bc62"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting9b6a8983-0560-4277-a2dd-7b68fd49b999"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingd18c2166-6140-4b1d-a59f-47d35aa54832"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ]
  }
   ,
  "_:5c847292afd1127da8bdcc3490102d94" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:51Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingf0f785cb-9704-4126-bd61-3b89076dd097"
    }
     ]
  }
   ,
  "_:b670bf28b97d4ffec36e97ba86b34217" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:42:34Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring3c3651f9-2b4d-489f-a41c-5ba236662dd8"
    }
     ]
  }
   ,
  "_:2e5c01f32d74d96ec2be4598024a97e2" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:58:27Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringd18c2166-6140-4b1d-a59f-47d35aa54832"
    }
     ]
  }
   ,
  "_:c92d899376056358fbb26ce29639485c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:42:33Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring9b6a8983-0560-4277-a2dd-7b68fd49b999"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodeb3ff851d-79a1-4991-98b7-d53f557bbb22" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:-26c4cf87:15d8448dbc0:-7ff0"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "b3ff851d-79a1-4991-98b7-d53f557bbb22" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringac7afa8d-c338-48aa-9f05-d41298b45611"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "ndfghdn dfd df gkhl" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/bdfg_hgt_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Nodedf222a6d-ec6c-4f0c-a424-3cd8bb683e02" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:2e5c01f32d74d96ec2be4598024a97e2"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:c92d899376056358fbb26ce29639485c"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "df222a6d-ec6c-4f0c-a424-3cd8bb683e02" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiring9b6a8983-0560-4277-a2dd-7b68fd49b999"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringd18c2166-6140-4b1d-a59f-47d35aa54832"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "some info 1" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringa9af1d3a-5170-4a76-a8ff-99a323ccb3a8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alun_patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringa52f6003-44e4-4b73-a18d-870eff4c1911" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alun_patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Node41c9cbe2-d3be-4843-890c-4abc268f9193" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:880801854f6df24ad1b6d0cdb8ddb1fa"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:3212f928424d68d5b21f0b82230d1603"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.itacispaces.org/ns#nodeID" : [ { 
      "type" : "literal" ,
      "value" : "41c9cbe2-d3be-4843-890c-4abc268f9193" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringa9af1d3a-5170-4a76-a8ff-99a323ccb3a8"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringa52f6003-44e4-4b73-a18d-870eff4c1911"
    }
     ] ,
    "http://www.itacispaces.org/ns#infText" : [ { 
      "type" : "literal" ,
      "value" : "info0 two" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Node"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alun_patrol_Report"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/_hgf__Notif_b3ff851d-79a1-4991-98b7-d53f557bbb22" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Patrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MOIRA_Notif_41c9cbe2-d3be-4843-890c-4abc268f9193" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ]
  }
   ,
  "_:ca7c53c2221a8ec08086eafc1888478e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportinga9af1d3a-5170-4a76-a8ff-99a323ccb3a8"
    }
     ]
  }
   ,
  "_:abaf9b12f5c1db2ccbd41e7bed850d15" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:58:27Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringf0f785cb-9704-4126-bd61-3b89076dd097"
    }
     ]
  }
   ,
  "_:008d3d96ab19246867cc54205b20557e" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportinga52f6003-44e4-4b73-a18d-870eff4c1911"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/alice_Patrol_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:a4c5203af48058feb03a6b00105fd485"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:5c847292afd1127da8bdcc3490102d94"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting3c3651f9-2b4d-489f-a41c-5ba236662dd8"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingf0f785cb-9704-4126-bd61-3b89076dd097"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_e2bae1b0-b519-4da4-83a0-0487fedd9c2c"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiring3c3651f9-2b4d-489f-a41c-5ba236662dd8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alice_Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/bdfg_hgt" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/alun_patrol_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:ca7c53c2221a8ec08086eafc1888478e"
    }
    , { 
      "type" : "bnode" ,
      "value" : "_:008d3d96ab19246867cc54205b20557e"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportinga52f6003-44e4-4b73-a18d-870eff4c1911"
    }
    , { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportinga9af1d3a-5170-4a76-a8ff-99a323ccb3a8"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_41c9cbe2-d3be-4843-890c-4abc268f9193"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringf0f785cb-9704-4126-bd61-3b89076dd097" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alice_Patrol_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportingac7afa8d-c338-48aa-9f05-d41298b45611" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/_hgf__Notif_b3ff851d-79a1-4991-98b7-d53f557bbb22"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/bdfg_hgt"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Aquiringac7afa8d-c338-48aa-9f05-d41298b45611" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/bdfg_hgt_Report"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/_hgf_"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportingd18c2166-6140-4b1d-a59f-47d35aa54832" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/bdfg_hgt_Report" : { 
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:-26c4cf87:15d8448dbc0:-7fef"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingac7afa8d-c338-48aa-9f05-d41298b45611"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#PrimarySource"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasDerivedFrom" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/_hgf__Notif_b3ff851d-79a1-4991-98b7-d53f557bbb22"
    }
     ]
  }
   ,
  "_:-26c4cf87:15d8448dbc0:-7fef" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2016-03-16T01:51:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingac7afa8d-c338-48aa-9f05-d41298b45611"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reportinga9af1d3a-5170-4a76-a8ff-99a323ccb3a8" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_41c9cbe2-d3be-4843-890c-4abc268f9193"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/alun_patrol"
    }
     ]
  }
   ,
  "_:880801854f6df24ad1b6d0cdb8ddb1fa" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-07-27T01:58:27Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Aquiringa9af1d3a-5170-4a76-a8ff-99a323ccb3a8"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/Reporting9b6a8983-0560-4277-a2dd-7b68fd49b999" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#used" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MOIRA_Notif_df222a6d-ec6c-4f0c-a424-3cd8bb683e02"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Patrol"
    }
     ]
  }
   ,
  "_:e4c3b8629ae3a53c45c61d1bc1f9218c" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reporting9b6a8983-0560-4277-a2dd-7b68fd49b999"
    }
     ]
  }
   ,
  "_:21e1917eb410ae25e5f27d6136d3bc62" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2014-08-28T02:14:50Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Reportingd18c2166-6140-4b1d-a59f-47d35aa54832"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/alice_Patrol" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
}
', 0, null);
INSERT INTO GAIANDB.CISPACES_INFOPROV (WBOXID, PROVST, PLOCK, CHAINING) VALUES ('EllaChatRoom', '{ 
  "http://www.itacispaces.org/Ella" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ] ,
    "http://www.w3.org/ns/prov#actedOnBehalfOf" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/US"
    }
     ] ,
    "http://xmlns.com/foaf/0.1/name" : [ { 
      "type" : "literal" ,
      "value" : "Ella" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/MakeAnalysisea545f34-a31b-4a1a-9ef1-ed1c3db9ede6" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Activity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasAssociatedWith" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/Ella"
    }
     ]
  }
   ,
  "_:10fc731c292bcd2a29f1797e9a595d66" : { 
    "http://www.w3.org/ns/prov#atTime" : [ { 
      "type" : "literal" ,
      "value" : "2017-08-02T03:43:28Z" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#dateTime"
    }
     ] ,
    "http://www.w3.org/ns/prov#Activity" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisea545f34-a31b-4a1a-9ef1-ed1c3db9ede6"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/US" : { 
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Agent"
    }
     ]
  }
   ,
  "http://www.itacispaces.org/InitialAnalysisea545f34-a31b-4a1a-9ef1-ed1c3db9ede6" : { 
    "http://www.itacispaces.org/ns#analysisID" : [ { 
      "type" : "literal" ,
      "value" : "ea545f34-a31b-4a1a-9ef1-ed1c3db9ede6" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#qualifiedGeneration" : [ { 
      "type" : "bnode" ,
      "value" : "_:10fc731c292bcd2a29f1797e9a595d66"
    }
     ] ,
    "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.w3.org/ns/prov#Entity"
    }
     ] ,
    "http://www.w3.org/ns/prov#wasGeneratedBy" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/MakeAnalysisea545f34-a31b-4a1a-9ef1-ed1c3db9ede6"
    }
     ] ,
    "http://www.itacispaces.org/ns#location" : [ { 
      "type" : "literal" ,
      "value" : "Workbox of EllaChatRoom" ,
      "datatype" : "http://www.w3.org/2001/XMLSchema#string"
    }
     ] ,
    "http://www.w3.org/ns/prov#type" : [ { 
      "type" : "uri" ,
      "value" : "http://www.itacispaces.org/ns#Analysis"
    }
     ]
  }
}
', 0, null);