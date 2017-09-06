1) image.jsp and text.jsp contains forms that call InfoServHttp with a POST action. 

2) in info.InfoServHttp.java 
Method doPost() expects the following parameters from html form:

-   dest: required (recipient of infobox)
- 	stream: not required - default "DefaultStream" (associated group of documents this document was derived from in the provenance chain)
-  	text : text to be shown in the infobox
- 	source: required source of this information (associated actor/agent in the provenance chain)
-   did:   document id (document from which this info was derived from in the provenance chain)
- 	lprov: not in use (pairs of <key,value> elements)


P.S. to see how these fields get populated inspect n-prov in the workbox. 


3) Generate new parameters:
- nodeID: create random id in format UUID
- timep: create timestamp of input
		 
4) Then create an HashMap corresponding to json format: 

{
  "surr": "me",
  "stream": "collect",
  "dest": "Joe",
  "info": [
    {
      "lprov": {
        " Key": "Value"
      },
      "dtg": "2016/04/22 15:07:06",
      "text": "new text ",
      "source": "xxx8",
      "nodeID": "0bc021dc-51e9-4c61-aaed-94022dc4aa61"
    }
  ]
}


5) Call InfoInput and post the new info through method postInfoTrans()

This inserts the new info into the gaian database. Cispaces pulls info from infoservice, hence next time CISpaces calls the information gets sent to the dest. 


6)Here some general information about handling provenance. this is not necessary for inputting information. 


P.S. same method is called by MCS for Moira input. "stream" field is the pivot so must be used. 

The correspondent populated tables in Gaian are: 
- CISPACES_INFOND only inserted if different id & affiliation
- CISPACES_INFOPROV update provenance model in JENA-JSON format. The appropriate model used in this part is the username+"infobox" model. Prov service will read this
model to import and record the provenance of the nodes in the analysis workbox.

Note: the provenance model for each worbox id is saved as a string in Apache Jena JSon format representing RDF data. 
This is a string and when it reaches the max dimension specified on the web.xml file the system initialise a new entry and the string get split. 
When reading a function called chaining will read all the relevant chain where the provenance string is and reassemble them back. Write on the database will use a
lock so that other users cannot read this untill all the chaining has been resolved. 
