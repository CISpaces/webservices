import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;

import prov.PatternBuilder;
 
import prov.TimeHelper;

public class runmain {

	public static void main(String[] args) {
		testAddNodes();
		System.out.println("Running...\n");
		testOnSave();
		testOnLoad();
		CopyNode();
		GetNode();
	}
	
	
		private static void GetNode() {
			 String oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"getnode\","
				 		+ "\"user\":\"Joe\",\"nodeID\":\"ebfd5885-8749-432e-96b1-b1178b4dffb6\",\"obf\":true}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 
	
			 System.out.println(oux);
			 //returns:
			 //obf on
			 
			 
			 
			   oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"getnode\","
				 		+ "\"user\":\"Joe\",\"nodeID\":\"01c731fe-c3f3-4f62-891e-db2ec29e7f44\",\"obf\":false}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 
			 System.out.println(oux);
			 //returns:
			 
			 
			   oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"getnode\","
				 		+ "\"user\":\"Joe\",\"nodeID\":\"7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"obf\":true}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 
			 System.out.println(oux);
			 //returns:
			 
			 
			   oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"getnode\","
				 		+ "\"user\":\"Joe\",\"nodeID\":\"7305115e-ba09-4683-a5c1-4c30d7b4746f\",\"obf\":false}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 
			 System.out.println(oux);
			 //returns:
			 
 
			   oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"getnode\","
				 		+ "\"user\":\"Joe\",\"nodeID\":\"075ae3b7-ac89-472f-9cb2-cd2cd48178ad\",\"obf\":false}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 System.out.println(oux);
		//this fails
		
	}


		private static void CopyNode() {
			
			 String oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"copynode\","
				 		+"\"from\":\"ebfd5885-8749-432e-96b1-b1178b4dffb6\","
				 		+ "\"to\":\"ebfd5885-8778-432e-96b1-b1178b4dffb6\"}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 System.out.println("\n"+oux);
			 System.out.println("\n\n");
	}


		//node 1 with long prov 
		
		private static void testOnLoad() {
			 String p="{\"@graph\":[{\"@id\":\"_:b0\",\"Activity\":\"http://www.itacispaces.org/Prepare_CS_Task_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"atTime\":\"2015-04-05T11:23:00Z\"},{\"@id\":\"_:b1\",\"Activity\":\"http://www.itacispaces.org/Collect_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"atTime\":\"2015-04-14T04:00:03Z\"},{\"@id\":\"_:b10\",\"Activity\":\"http://www.itacispaces.org/Aquiring12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"atTime\":\"2017-07-17T02:20:58Z\"},{\"@id\":\"_:b2\",\"Activity\":\"http://www.itacispaces.org/CreateNodec7c6782d-7dab-4996-8291-9b6ad94db6a9\",\"atTime\":\"2016-07-20T09:45:30Z\"},{\"@id\":\"_:b3\",\"Activity\":\"http://www.itacispaces.org/Create_CS_RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"atTime\":\"2015-04-05T11:23:00Z\"},{\"@id\":\"_:b4\",\"Activity\":\"http://www.itacispaces.org/CreateNode9d580000-805d-4cdf-ac21-3957f7efe486\",\"atTime\":\"2014-09-07T08:56:37Z\"},{\"@id\":\"_:b5\",\"Activity\":\"http://www.itacispaces.org/Process_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"atTime\":\"2015-04-05T11:23:00Z\"},{\"@id\":\"_:b6\",\"Activity\":\"http://www.itacispaces.org/Reporting12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"atTime\":\"2014-08-28T02:14:50Z\"},{\"@id\":\"_:b7\",\"Activity\":\"http://www.itacispaces.org/Reporting12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"atTime\":\"2014-08-28T02:14:50Z\"},{\"@id\":\"_:b8\",\"Activity\":\"http://www.itacispaces.org/CreateNodec205cad2-c4a1-4e46-a657-486fc21b1a47\",\"atTime\":\"2016-07-20T09:27:25Z\"},{\"@id\":\"_:b9\",\"Activity\":\"http://www.itacispaces.org/Aquiring12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"atTime\":\"2017-07-17T02:20:58Z\"},{\"@id\":\"http://www.itacispaces.org/A_Patrol\",\"@type\":\"prov:Agent\"},{\"@id\":\"http://www.itacispaces.org/A_Patrol_Report\",\"@type\":\"prov:Entity\",\"qualifiedGeneration\":[\"_:b6\",\"_:b7\"],\"type\":\"prov:PrimarySource\",\"wasDerivedFrom\":\"http://www.itacispaces.org/Moira_Notif_7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Reporting12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\"},{\"@id\":\"http://www.itacispaces.org/Aquiring12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"@type\":\"Activity\",\"used\":\"http://www.itacispaces.org/A_Patrol_Report\",\"wasAssociatedWith\":\"http://www.itacispaces.org/Moira\"},{\"@id\":\"http://www.itacispaces.org/CISpaces_HDC_Service\",\"@type\":\"prov:Agent\"},{\"@id\":\"http://www.itacispaces.org/CISpaces_of_pippo\",\"@type\":\"prov:Agent\"},{\"@id\":\"http://www.itacispaces.org/Collect_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"Activity\",\"used\":\"http://www.itacispaces.org/TASK_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"wasAssociatedWith\":\"http://www.itacispaces.org/CISpaces_of_pippo\"},{\"@id\":\"http://www.itacispaces.org/CreateNode9d580000-805d-4cdf-ac21-3957f7efe486\",\"@type\":\"Activity\",\"wasAssociatedWith\":\"http://www.itacispaces.org/Joe\"},{\"@id\":\"http://www.itacispaces.org/CreateNodec205cad2-c4a1-4e46-a657-486fc21b1a47\",\"@type\":\"Activity\",\"wasAssociatedWith\":\"http://www.itacispaces.org/Joe\"},{\"@id\":\"http://www.itacispaces.org/CreateNodec7c6782d-7dab-4996-8291-9b6ad94db6a9\",\"@type\":\"Activity\",\"wasAssociatedWith\":\"http://www.itacispaces.org/Joe\"},{\"@id\":\"http://www.itacispaces.org/Create_CS_RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"Activity\",\"wasAssociatedWith\":\"http://www.itacispaces.org/pippo\"},{\"@id\":\"http://www.itacispaces.org/Data_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"prov:Entity\",\"qualifiedGeneration\":\"_:b1\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Collect_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"},{\"@id\":\"http://www.itacispaces.org/EX_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"prov:Entity\",\"qualifiedGeneration\":\"_:b5\",\"wasDerivedFrom\":\"http://www.itacispaces.org/RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Process_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"},{\"@id\":\"http://www.itacispaces.org/Joe\",\"@type\":\"prov:Agent\"},{\"@id\":\"http://www.itacispaces.org/Moira\",\"@type\":\"prov:Agent\"},{\"@id\":\"http://www.itacispaces.org/Moira_Notif_7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"@type\":\"prov:Entity\"},{\"@id\":\"http://www.itacispaces.org/Node01c731fe-c3f3-4f62-891e-db2ec29e7f44\",\"@type\":\"prov:Entity\",\"infText\":\"Susan may not own a phone\",\"nodeID\":\"01c731fe-c3f3-4f62-891e-db2ec29e7f44\",\"qualifiedGeneration\":\"_:b8\",\"type\":\"cisp:Node\",\"wasGeneratedBy\":\"http://www.itacispaces.org/CreateNodec205cad2-c4a1-4e46-a657-486fc21b1a47\"},{\"@id\":\"http://www.itacispaces.org/Node7305115e-ba09-4683-a5c1-4c30d7b4746f\",\"@type\":\"prov:Entity\",\"infText\":\"There are bacteria in the water supply\",\"nodeID\":\"7305115e-ba09-4683-a5c1-4c30d7b4746f\",\"qualifiedGeneration\":\"_:b4\",\"type\":\"cisp:Node\",\"wasGeneratedBy\":\"http://www.itacispaces.org/CreateNode9d580000-805d-4cdf-ac21-3957f7efe486\"},{\"@id\":\"http://www.itacispaces.org/Node7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"@type\":\"prov:Entity\",\"infText\":\"There is a person named John Doe and is in Kish.\",\"nodeID\":\"7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"qualifiedGeneration\":[\"_:b9\",\"_:b10\"],\"type\":\"cisp:Node\",\"wasDerivedFrom\":\"http://www.itacispaces.org/A_Patrol_Report\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Aquiring12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\"},{\"@id\":\"http://www.itacispaces.org/Nodeac7cc9f1-a29b-4e10-b4b4-94b2a93c7a1c\",\"@type\":\"prov:Entity\",\"infText\":\"Susan can only access internet at home\",\"nodeID\":\"ac7cc9f1-a29b-4e10-b4b4-94b2a93c7a1c\",\"qualifiedGeneration\":\"_:b2\",\"type\":\"cisp:Node\",\"wasGeneratedBy\":\"http://www.itacispaces.org/CreateNodec7c6782d-7dab-4996-8291-9b6ad94db6a9\"},{\"@id\":\"http://www.itacispaces.org/Nodeebfd5885-8749-432e-96b1-b1178b4dffb6\",\"@type\":\"prov:Entity\",\"infText\":\"A Toxic Bacteria contaminated the local water system in Kish\",\"nodeID\":\"ebfd5885-8749-432e-96b1-b1178b4dffb6\",\"qualifiedGeneration\":\"_:b0\",\"type\":\"cisp:Node\",\"wasDerivedFrom\":\"http://www.itacispaces.org/EX_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Prepare_CS_Task_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"},{\"@id\":\"http://www.itacispaces.org/Prepare_CS_Task_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"Activity\",\"used\":\"http://www.itacispaces.org/EX_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"wasAssociatedWith\":\"http://www.itacispaces.org/CISpaces_of_pippo\"},{\"@id\":\"http://www.itacispaces.org/Process_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"Activity\",\"used\":[\"http://www.itacispaces.org/TASK_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"http://www.itacispaces.org/Data_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"http://www.itacispaces.org/RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"],\"wasAssociatedWith\":[\"http://www.itacispaces.org/CISpaces_HDC_Service\",\"http://www.itacispaces.org/CISpaces_of_pippo\"],\"wasInformedBy\":\"http://www.itacispaces.org/Collect_CS_Res_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"},{\"@id\":\"http://www.itacispaces.org/RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"prov:Entity\",\"qualifiedGeneration\":\"_:b3\",\"type\":\"cisp:Goal\",\"wasGeneratedBy\":\"http://www.itacispaces.org/Create_CS_RI_83603dc6-44cd-43e1-8bc9-7a9d2b345742\"},{\"@id\":\"http://www.itacispaces.org/Reporting12d56f7c-fc4f-43dc-9540-6fc4beb0bf66\",\"@type\":\"Activity\",\"used\":\"http://www.itacispaces.org/Moira_Notif_7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"wasAssociatedWith\":\"http://www.itacispaces.org/A_Patrol\"},{\"@id\":\"http://www.itacispaces.org/TASK_83603dc6-44cd-43e1-8bc9-7a9d2b345742\",\"@type\":\"prov:Entity\"},{\"@id\":\"http://www.itacispaces.org/pippo\",\"@type\":\"prov:Agent\"}],\"@context\":{\"infText\":{\"@id\":\"http://www.itacispaces.org/ns#infText\"},\"nodeID\":{\"@id\":\"http://www.itacispaces.org/ns#nodeID\"},\"qualifiedGeneration\":{\"@id\":\"http://www.w3.org/ns/prov#qualifiedGeneration\",\"@type\":\"@id\"},\"type\":{\"@id\":\"http://www.w3.org/ns/prov#type\",\"@type\":\"@id\"},\"wasDerivedFrom\":{\"@id\":\"http://www.w3.org/ns/prov#wasDerivedFrom\",\"@type\":\"@id\"},\"wasGeneratedBy\":{\"@id\":\"http://www.w3.org/ns/prov#wasGeneratedBy\",\"@type\":\"@id\"},\"Activity\":{\"@id\":\"http://www.w3.org/ns/prov#Activity\",\"@type\":\"@id\"},\"atTime\":{\"@id\":\"http://www.w3.org/ns/prov#atTime\",\"@type\":\"http://www.w3.org/2001/XMLSchema#dateTime\"},\"used\":{\"@id\":\"http://www.w3.org/ns/prov#used\",\"@type\":\"@id\"},\"wasAssociatedWith\":{\"@id\":\"http://www.w3.org/ns/prov#wasAssociatedWith\",\"@type\":\"@id\"},\"wasInformedBy\":{\"@id\":\"http://www.w3.org/ns/prov#wasInformedBy\",\"@type\":\"@id\"},\"owl\":\"http://www.w3.org/2002/07/owl#\",\"rdf\":\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\",\"xsd\":\"http://www.w3.org/2001/XMLSchema#\",\"rdfs\":\"http://www.w3.org/2000/01/rdf-schema#\",\"cisp\":\"http://www.itacispaces.org/ns#\",\"prov\":\"http://www.w3.org/ns/prov#\",\"foaf\":\"http://xmlns.com/foaf/0.1/\"}}";
			 String node="[{\"text\":\"Pro\",\"dtg\":\"2016/08/14 18:28:00\",\"annot\":{\"id\":\"N/A\"},\"nodeID\":\"ebfd1111-8749-432e-96b1-b1178b4dffb6\",\"source\":\"Joe\",\"type\":\"RA\"},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Mark said she does not own a phone\",\"input\":\"INFO\",\"dtg\":\"2016/08/14 18:27:40\",\"type\":\"I\",\"nodeID\":\"ebfd5885-8749-432e-96b1-b1178b4dffb6\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Mark said she does not own a phone\",\"input\":\"INFO\",\"dtg\":\"2016/08/14 18:27:40\",\"type\":\"I\",\"nodeID\":\"7305115e-ba09-4683-a5c1-4c30d7b4746f\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan liked Billy’s blog page posted during the weekend\",\"input\":\"INFO\",\"dtg\":\"2016/07/20 09:27:23\",\"type\":\"I\",\"nodeID\":\"7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan can only access internet at home\",\"input\":\"INFO\",\"dtg\":\"2016/07/20 09:45:30\",\"type\":\"I\",\"nodeID\":\"ac7cc9f1-a29b-4e10-b4b4-94b2a93c7a1c\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"text\":\"Con\",\"dtg\":\"2016/07/20 09:27:54\",\"annot\":{\"cq_ans_node_id\":null,\"as_pro_node_uuid\":null,\"cq_id\":null},\"nodeID\":\"16f822c2-9b2b-436a-af3f-17b36212f05f\",\"source\":\"Joe\",\"type\":\"CA\"},{\"text\":\"Con\",\"dtg\":\"2016/07/20 09:27:56\",\"annot\":{\"cq_ans_node_id\":null,\"as_pro_node_uuid\":null,\"cq_id\":null},\"nodeID\":\"08b6fb7f-6363-4d64-b9ba-06824cecefc0\",\"source\":\"Joe\",\"type\":\"CA\"},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan may not own a phone\",\"input\":\"CLAIM\",\"dtg\":\"2016/07/20 09:27:25\",\"type\":\"I\",\"nodeID\":\"01c731fe-c3f3-4f62-891e-db2ec29e7f44\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"text\":\"Pro\",\"dtg\":\"2016/07/20 09:27:32\",\"annot\":{\"id\":\"N/A\"},\"nodeID\":\"e310be5c-f47c-4390-a265-d272a694bf3d\",\"source\":\"Joe\",\"type\":\"RA\"}]";
			 String oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"load\","
				 		+"\"nodes\":"+node+","
				 		+"\"prov\":"+p+"}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 System.out.println("\n"+oux);
			 System.out.println("\n\n");
			
	}


		private static void testOnSave() {
			 String node="[{\"text\":\"Pro\",\"dtg\":\"2016/08/14 18:28:00\",\"annot\":{\"id\":\"N/A\"},\"nodeID\":\"ebfd1111-8749-432e-96b1-b1178b4dffb6\",\"source\":\"Joe\",\"type\":\"RA\"},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Mark said she does not own a phone\",\"input\":\"INFO\",\"dtg\":\"2016/08/14 18:27:40\",\"type\":\"I\",\"nodeID\":\"ebfd5885-8749-432e-96b1-b1178b4dffb6\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Mark said she does not own a phone\",\"input\":\"INFO\",\"dtg\":\"2016/08/14 18:27:40\",\"type\":\"I\",\"nodeID\":\"7305115e-ba09-4683-a5c1-4c30d7b4746f\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan liked Billy’s blog page posted during the weekend\",\"input\":\"INFO\",\"dtg\":\"2016/07/20 09:27:23\",\"type\":\"I\",\"nodeID\":\"7b91425e-c47f-44ca-abcf-2700c0bffb0f\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan can only access internet at home\",\"input\":\"INFO\",\"dtg\":\"2016/07/20 09:45:30\",\"type\":\"I\",\"nodeID\":\"ac7cc9f1-a29b-4e10-b4b4-94b2a93c7a1c\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"text\":\"Con\",\"dtg\":\"2016/07/20 09:27:54\",\"annot\":{\"cq_ans_node_id\":null,\"as_pro_node_uuid\":null,\"cq_id\":null},\"nodeID\":\"16f822c2-9b2b-436a-af3f-17b36212f05f\",\"source\":\"Joe\",\"type\":\"CA\"},{\"text\":\"Con\",\"dtg\":\"2016/07/20 09:27:56\",\"annot\":{\"cq_ans_node_id\":null,\"as_pro_node_uuid\":null,\"cq_id\":null},\"nodeID\":\"08b6fb7f-6363-4d64-b9ba-06824cecefc0\",\"source\":\"Joe\",\"type\":\"CA\"},{\"source\":\"Joe\",\"eval\":\"V\",\"text\":\"Susan may not own a phone\",\"input\":\"CLAIM\",\"dtg\":\"2016/07/20 09:27:25\",\"type\":\"I\",\"nodeID\":\"01c731fe-c3f3-4f62-891e-db2ec29e7f44\",\"annot\":{\"conc\":{},\"prem_assump\":{}}},{\"text\":\"Pro\",\"dtg\":\"2016/07/20 09:27:32\",\"annot\":{\"id\":\"N/A\"},\"nodeID\":\"e310be5c-f47c-4390-a265-d272a694bf3d\",\"source\":\"Joe\",\"type\":\"RA\"}]";
				 String oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
				 		+ "\"action\":\"save\","
				 		+"\"nodes\":"+node+","
				 		+ "\"user\":\"Joe\"}"
				 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
			 oux=oux.replaceAll("\n", "");
			 System.out.println("\n"+oux);
			 System.out.println("\n\n");
		   
			 
			 
		
		
		}


		private static void testAddNodes() {

		String ers="CISpaces_ERS_Service";
		String hdc="CISpaces_HDC_Service";
		String cus="CISpaces_of_pippo";
		CSProvBuild csprov=new CSProvBuild(ers,hdc,cus);
		String node1="ebfd5885-8749-432e-96b1-b1178b4dffb6";
				//UUID.randomUUID().toString();
		//{formAnalysis={, 
		String des="Given that A Toxic Bacteria contaminated the local water system in Kish, is the claim supported by evidence?";
		String title="A Toxic Bacteria contaminated the local water system in Kish", 
		String ="2015-04-20 12:48:12.4812, ";
	    String crowdloc="UK/US";
		//, userID=83603dc6-44cd-43e1-8bc9-7a9d2b345742, locations=[UK/US], nQues=2.0, ques=[{queID=1, queType=MultiChoice, srcUrl=http%3A%2F%2Flocalhost%3A8080%2Fhdcpictures%2Ftap_water.png, ansOptions=[White, Yellow, Brown, Clear ], que=What is the color of your tap water?, ansValues=[Con, Pro, Pro, Con]}, {queID=0, queType=Numerical, Pro=[20.0, 1.0E308], srcUrl=http%3A%2F%2Flocalhost%3A8080%2Fhdcpictures%2Ftap_water.png, que=What is the temperature of your cold water?, Con=[1.0E-308, 19.0]}], queStat=[{queType=Numerical, count={std=2.6012817353502227, mean=21.1, right=25.0, left=17.0}, ratio={}, queID=0, maxAnsLen=2.0}, {queType=MultiChoice, count={Brown=0.125, Clear=0.5416666666666666, White=0.125, Yellow=0.20833333333333334}, ratio={}, queID=1, maxAnsLen=6.0}], formID=myFormCont, }, user=Joe}
	    String formID="83603dc6-44cd-43e1-8bc9-7a9d2b345742";
	    ArrayList locations=new ArrayList();
	    locations.add("UK");
	    locations.add("US");
	    String createTime="201504051123";
	    String lastTime="2015-04-14 16:00:37.037";
	    String timestamp="2015-04-20 12:48:12.4812";
		csprov.createCSProvDefault(title,node1,"pippo",formID,des,crowdloc,locations,createTime,lastTime,timestamp);
		HashMap provmap=csprov.getSerialisedCSProv();
		JsonHelper jsh=new JsonHelper();
	//	System.out.println("node1 "+node1+":"+jsh.convertInputJson(provmap));
		
		
		//node 2 with short provenance
		String string="Everything normal in Kish, UK";
		 PatternBuilder prov = new PatternBuilder();
		 TimeHelper time = new TimeHelper();
		 HashMap in=new HashMap();
		 String node2="01c731fe-c3f3-4f62-891e-db2ec29e7f44";
		 String[] ij=new String[]{node2,string};//String[0:id,1:text,2:cispid]  
		 in.put("nodeID", node2);
		 in.put("text",string);
		String timep=time.now();
		 prov.makeGenerationPattern(ij, "M_SPOT_Report", "HandOver_M", "Patrol_M", time.now());
		 Model mod= prov.getModel();
		 StringWriter out = new StringWriter();
		 mod.write(out, "RDF/JSON");
		 String result = out.toString();
		// System.out.println("node2 "+node2+":"+result);
		 
		 //node 3 with meta information 
		 String node3="7b91425e-c47f-44ca-abcf-2700c0bffb0f";
		 
		 HashMap mp=new HashMap();
		 mp.put("stream", "Moira");
		 mp.put("nodeID", node3);
		 mp.put("text", "There is a person named John Doe and is in Kish.");
		 mp.put("source", "A Patrol");
		 mp.put("dtg", "2014/08/28 02:14:50");
	 
	//	 System.out.println("node3 "+node3+":"+jsh.convertInputJson(mp));
		 
		 
		 //node 4 with cispaces info
		 String node4="7305115e-ba09-4683-a5c1-4c30d7b4746f";
		 String x="{\"source\":\"Joe\",\"uncert\":\"Probable\",\"eval\":\"N/A\",\"text\":\"There are bacteria in the water supply\",\"input\":\"CLAIM\",\"dtg\":\"2014/09/07 20:56:37\",\"type\":\"I\",\"nodeID\":\""+node4+"\",\"annot\":{\"conc\":{\"d0f55def-96ff-4439-97cd-ee13ee525838\":{\"cqs\":[],\"conc\":[\"CEO1\"],\"id\":\"LEO\"}},\"prem_assump\":{\"005a5a82-090e-41a2-a123-e4b3cbac57f4\":{\"prem\":[\"PCE2\"],\"cqs\":[],\"id\":\"LCE\",\"assump\":[]},\"3886e3da-cbdb-487e-9cf1-8a88c19b0f1d\":{\"prem\":[\"PCE2\"],\"cqs\":[],\"id\":\"LCE\",\"assump\":[]}}}}"; //node 4 as node made by cispaces 
	//	 System.out.println("node4 "+node4+":"+x);
		 
		 String node5="075ae3b7-ac89-472f-9cb2-cd2cd48178ad";
		 //now post string
		 String oux="curl -X POST -H \"Content-Type: application/json\" -d '{"
			 		+ "\"action\":\"addnodes\",\"nodes\":{"
			 		+ "\""+node1+"\":{\"prov\":"+jsh.convertInputJson(provmap)+"}," 
			 		+ "\""+node5+"\":{\"blabla\":{}}," 
			 		+ "\""+node2+"\":{\"prov\":"+result+"}," 
			 		+ "\""+node3+"\":{\"meta\":"+jsh.convertInputJson(mp)+"}," 
			 		+ "\""+node4+"\":{\"cisp\":"+x+"}}}" 
			 		+ "' http://localhost:8080/provsimp/rest/ProcProv";
		 oux=oux.replaceAll("\n", "");
		 
		 System.out.println(oux);
		 System.out.println(node1+":"+node2+":"+node3+":"+node4+":"+node5);

	}
		
		/*
		 * ::: 
	http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%22ebfd5885-8749-432e-96b1-b1178b4dffb6%22,%22obf%22:false,%22user%22:%22Joe%22%7D
  	http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%2201c731fe-c3f3-4f62-891e-db2ec29e7f44%22,%22obf%22:false,%22user%22:%22Joe%22%7D
    http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%227b91425e-c47f-44ca-abcf-2700c0bffb0f%22,%22obf%22:false,%22user%22:%22Joe%22%7D
    http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%227305115e-ba09-4683-a5c1-4c30d7b4746f%22,%22obf%22:false,%22user%22:%22Joe%22%7D
    http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%22075ae3b7-ac89-472f-9cb2-cd2cd48178ad%22,%22obf%22:false,%22user%22:%22Joe%22%7D
    http://localhost:8080/provgraphs/Prov?action=printprov&json=%7B%22request%22:%22getprovnode%22,%22nodeID%22:%22ac7cc9f1-a29b-4e10-b4b4-94b2a93c7a1c%22,%22obf%22:false,%22user%22:%22Joe%22%7D
		 * 
		 */

}
