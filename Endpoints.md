# CISpaces Web Service Calls

## VC web service

Handles the version control of the graph analysis.

There is a  ``` HTTP_requests_inputs_outputs.pdf ``` file in docs folder that gives information about different HTTP request made by different web services.

Source file: ``` VC/src/main/java/vcservlet/VCServlet.java```

- VC/rest/getInfo

 Shows the message ``` Hello Jersey``` the web service is running successfully.

- VC/rest/history

  Gets version of the graph from history table

- VC/rest/getAnalysis

 Gets the last analysis user worked on and loads the analysis to workbox

 ``` JSON response:
 {"nodes":[{"input":"PREF","eval":"N\/A","dtg":"2017-09-26 13:49:28.0","islocked":"false","text":"PREF","source":"user","cmt":"N\/A","type":"P","annot":"N\/A","graphID":"de9f57b3-3183-43ec-a34c-10eb33158081","nodeID":"db66b909-b866-4479-ca8c-db575c043405","uncert":"Confirmed"},{"input":"INFO","eval":"N\/A","dtg":"2017-09-26 13:49:11.0","islocked":"false","text":"INFO","source":"user","cmt":"N\/A","type":"I","annot":"N\/A","graphID":"de9f57b3-3183-43ec-a34c-10eb33158081","nodeID":"f4f7285b-fabe-42a2-9238-4703e1072d27","uncert":"Confirmed"},{"input":"PRO","eval":"N\/A","dtg":"2017-09-26 13:49:12.0","islocked":"false","text":"PRO","source":"user","cmt":"N\/A","type":"RA","annot":"N\/A","graphID":"de9f57b3-3183-43ec-a34c-10eb33158081","nodeID":"39a08ad2-8dd7-4940-c067-45a4dd8f7efe","uncert":"Confirmed"}],"edges":[{"edgeID":"3af37733-4034-401f-930d-0544e93e4956","islocked":"false","source":"39a08ad2-8dd7-4940-c067-45a4dd8f7efe","formedgeid":"null","graphID":"de9f57b3-3183-43ec-a34c-10eb33158081","target":"db66b909-b866-4479-ca8c-db575c043405"},{"edgeID":"7f8c8fac-c9e4-4bb7-935b-b31233f10a3c","islocked":"false","source":"f4f7285b-fabe-42a2-9238-4703e1072d27","formedgeid":"null","graphID":"de9f57b3-3183-43ec-a34c-10eb33158081","target":"39a08ad2-8dd7-4940-c067-45a4dd8f7efe"}]} ```

- VC/rest/login

 Handles the login request. Checks username and password

- VC/rest/new

  Makes a new graph request

- VC/rest/save

 Saves the current graph on workbox

- VC/rest/edge/{edgeid}:

 ``` POST ``` request adds edge.

 ``` DELETE ``` request deletes edge.

- VC/rest/node/{nodeid}

 ``` POST``` request adds node.
 
 ``` DELETE``` request deletes node.


- VC/rest/updateAnalysis

 Update the analysis after a history is imported and saved as the current version.


## ERS web Service

This web services uses the NLG to do the entity reasoning.

There is a ``` ersdoc.txt ``` in the ers folder that gives details of JSON request and response made.

Source file: ``` ers/src/ers/ERSServlet.java```

- ers/rest/WriteRules

 This web service performs entity reasoning to the graph and returns the claims made by the reasoner.
 
 If there is an error in the graph structure, it returns an error response.


## PROVSIMP Web Service

This web service keeps the provenance data for the analysis.

This webservice is not called by VC web service, so it is not clear how the request and response are being made by it.

There is a ``` provsimpdoc.txt``` in the PROVSIMP folder that gives details of JSON request and response made.

Source file: ``` PROVSIMP/src/provsimp/ProvSimpServlet.java ```

- provsimp/rest/ProcProv

This web service saves the graph and all the proveneance data as RDF in the database.


## Info Web Service

Info web service used to handle the log in feature. Now, this is done by the VC web service.

There is a ``` infodoc.txt``` in the info folder that gives details of JSON request and response made.

- info/rest/PostInfo

Source file: ``` info/src/info/INFInputServlet.java```

This used to creates the graph and tracks provenance of the graph.

- info/rest/GetInfo

Source file: ``` info/src/info/INFOServlet.java```

A request is made with username, password and affiliation. True or false response is made if it is successful or not.