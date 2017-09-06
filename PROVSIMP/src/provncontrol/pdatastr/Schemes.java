/******************************************************************************
 * This research was sponsored by the U.S. Army Research Laboratory and the
 * U.K. Ministry of Defence under the Biennial Program Plane 2013 (BPP13),
 * Project 6, Task 3: Collaborative Intelligence Analysis.
 * The U.S. and U.K. Governments are authorized to reproduce and distribute
 * reprints for Government purposes notwithstanding any copyright notation
 * hereon.
 * **************************************************************************
 *
 * 
 * 
 * @author      Alice Toniolo  
 * @version     1.0  
 * @since 		July 2017          
 *   
 */


package provncontrol.pdatastr;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Logger;

import com.google.gson.internal.LinkedTreeMap;

import utils.JsonHelper;

public class Schemes {
	private static Logger log;
	private HashSet Assump;
	private HashSet DefCQs;
	private JsonHelper jsh;
	private String scheme_str;
	
	public Schemes(){
		log=Logger.getLogger(getClass().getName());
		jsh=new JsonHelper();
	 
		loadSchemes();
		
		}

	private void loadSchemes() {
			String line = getString();
	        HashMap schemes=jsh.convertInputMap(line);
	        Assump=new HashSet();//assumption list of annotation
	        DefCQs=new HashSet();//assumption list of crital questions that result in a contradictory relationship
	        Iterator iter=schemes.keySet().iterator();
	        LinkedTreeMap map;
        	LinkedTreeMap assump;
        	LinkedTreeMap connect;
        	Iterator itt;
        	String st;
        	ArrayList li;
	        while(iter.hasNext()){
	        	  map=(LinkedTreeMap)schemes.get(iter.next());
	        	  assump=(LinkedTreeMap)map.get("assump");
	        	  connect=(LinkedTreeMap)map.get("connect");
	        	  itt=assump.keySet().iterator();
	        	  while(itt.hasNext()){
	        		  st=(String) itt.next();
	        		  Assump.add(st);
	        		  if(connect.containsKey(st)){
	        			  li=(ArrayList) connect.get(st);
	        			  DefCQs.addAll(li);
	        		  }
	        	  }
	        }
	        //System.out.println(Assump+"\n"+DefCQs);
		 
		
	}

private String getString(){
	//this returns the string with all the arg schemes contained in argSchemesJSON.txt
 
	String temp= "{\"LPV\":{\"cqs\":{\"CQPV4\":{\"cqansw\":\"There are provenance elements that should have been included for believing Ik.\",\"cqquest\":\"Are there provenance elements that should have been included for believing Ik?\"},\"CQPV2\":{\"cqansw\":\"Info Ik is not supported by evidence.\",\"cqquest\":\"Is info Ik supported by evidence?\"},\"CQPV3\":{\"cqansw\":\"The provenance chain contains elements that lead us not to believe Ik.\",\"cqquest\":\"Does the provenance chain contain elements that lead us not to believe Ik?\"},\"CQPV1\":{\"cqansw\":\"Info Ik is not consistent with other information.\",\"cqquest\":\"Is info Ik consistent with other information?\"}},\"assump\":{\"APV3\":{\"aannot\":\"There is evidential support for Ik\"},\"APV1\":{\"aannot\":\"There are no missing provenance elements required to believe Ik\"},\"APV2\":{\"aannot\":\"There are no provenance elements against believing Ik\"}},\"annot\":\"Provenance\",\"type\":\"RA\",\"prem\":{\"PPV2\":{\"pannot\":\"The provenance chain infers Info Ik\"},\"PPV1\":{\"pannot\":\"Info Ik is a credible information\"}},\"connect\":{\"APV3\":[\"CQPV2\"],\"APV1\":[\"CQPV4\"],\"APV2\":[\"CQPV3\"],\"CPV1\":[\"CQPV1\"],\"PPV2\":[\"CQPV3\",\"CQPV4\"],\"PPV1\":[\"CQPV2\"]},\"conc\":{\"CPV1\":{\"cannot\":\"Info Ik may plausibly be true\"}}},\"LPK\":{\"cqs\":{\"CQPK5\":{\"cqansw\":\"This claim is not consistent with other experts' claims\",\"cqquest\":\"Is the claim consistent with other experts' claims?\"},\"CQPK3\":{\"cqansw\":\"The source did not assert this claim\",\"cqquest\":\"Is it the case that the source has asserted the claim?\"},\"CQPK4\":{\"cqansw\":\"This claim is not supported by evidence\",\"cqquest\":\"Is the claim supported by evidence?\"},\"CQPK1\":{\"cqansw\":\"The source is not in a position to know about this claim\",\"cqquest\":\"Is the source in a position to know about the claim made?\"},\"CQPK2\":{\"cqansw\":\"The expert is not a reliable/trustworthy source\",\"cqquest\":\"Is the source reliable/trustworthy?\"}},\"assump\":{\"APK2\":{\"aannot\":\"There is evidence for A\"},\"APK1\":{\"aannot\":\"The source is reliable\"}},\"annot\":\"Position to know\",\"type\":\"RA\",\"prem\":{\"PPK2\":{\"pannot\":\"E asserts that A is true\"},\"PPK1\":{\"pannot\":\"E is in a position to know whether A is true\"}},\"connect\":{\"PPK2\":[\"CQPK3\",\"CQPK4\"],\"PPK1\":[\"CQPK2\",\"CQPK1\"],\"APK2\":[\"CQPK4\"],\"APK1\":[\"CQPK2\"],\"CPK1\":[\"CQPK5\"]},\"conc\":{\"CPK1\":{\"cannot\":\"A may plausibly be true\"}}},\"LID\":{\"cqs\":{\"CQID5\":{\"cqansw\":\"There is an exception to property Q that undermines the association between actor and event\",\"cqquest\":\"Is there an exception to property Q that undermines the association between actor and event?\"},\"CQID3\":{\"cqansw\":\"The actor does not fit the property Q\",\"cqquest\":\"Does the actor fit property Q?\"},\"CQID4\":{\"cqansw\":\"There is another actor that fits the same property\",\"cqquest\":\"Are there other actors that fit the same property?\"},\"CQID1\":{\"cqansw\":\"There is no evidence to show that the event E happened\",\"cqquest\":\"Has the event E happened?\"},\"CQID2\":{\"cqansw\":\"The event does not require property Q\",\"cqquest\":\"Does the event require property Q?\"}},\"assump\":{\"AID1\":{\"aannot\":\"No exception to Q discards the association of E to A\"}},\"annot\":\"Identification\",\"type\":\"RA\",\"prem\":{\"PID2\":{\"pannot\":\"To perform event E, actor must have property Q (e.g. same loc, res)\"},\"PID1\":{\"pannot\":\"An event E appears to be associated with actor A\"},\"PID3\":{\"pannot\":\"Actor A has property Q\"}},\"connect\":{\"PID2\":[\"CQID2\"],\"PID1\":[\"CQID1\"],\"AID1\":[\"CQID5\"],\"CID1\":[\"CQID4\"],\"PID3\":[\"CQID3\",\"CQID5\"]},\"conc\":{\"CID1\":{\"cannot\":\"A is associated with E\"}}},\"LEO\":{\"cqs\":{\"CQEO6\":{\"cqansw\":\"This claim is not supported by evidence\",\"cqquest\":\"Is the claim supported by evidence?\"},\"CQEO4\":{\"cqansw\":\"The expert is not a reliable source\",\"cqquest\":\"Is the expert reliable as a source?\"},\"CQEO5\":{\"cqansw\":\"This claim is not consistent with other experts' claims\",\"cqquest\":\"Is the claim consistent with other experts' claims?\"},\"CQEO2\":{\"cqansw\":\"The expert is not an expert source in the field of this claim\",\"cqquest\":\"Is the expert an expert source in the field of the claim made?\"},\"CQEO3\":{\"cqansw\":\"The expert did not assert this claim\",\"cqquest\":\"Is it the case that the expert has asserted the claim?\"},\"CQEO1\":{\"cqansw\":\"The expert is not credible in his/her field of expertise\",\"cqquest\":\"Is the expert credible in some field?\"}},\"assump\":{\"AEO3\":{\"aannot\":\"There is evidence for A\"},\"AEO1\":{\"aannot\":\"The expert is credible in the domain\"},\"AEO2\":{\"aannot\":\"The expert is a reliable source\"}},\"annot\":\"Expert Opinion\",\"type\":\"RA\",\"prem\":{\"PEO1\":{\"pannot\":\"E is an expert in domain S containing A\"},\"PEO2\":{\"pannot\":\"E asserts that A  is plausible\"}},\"connect\":{\"PEO1\":[\"CQEO1\",\"CQEO4\",\"CQEO2\"],\"AEO3\":[\"CQEO6\"],\"AEO1\":[\"CQEO1\"],\"AEO2\":[\"CQEO4\"],\"CEO1\":[\"CQEO5\"],\"PEO2\":[\"CQEO3\",\"CQEO6\"]},\"conc\":{\"CEO1\":{\"cannot\":\"A may plausibly be true\"}}},\"LAN\":{\"cqs\":{\"CQAN2\":{\"cqansw\":\"The previous case is not similar to the current case\",\"cqquest\":\"Is the previous case similar to the current case?\"},\"CQAN1\":{\"cqansw\":\"There is no evidence for the previous case to be plausible\",\"cqquest\":\"Is there evidence for the previous case to be plausible?\"},\"CQAN4\":{\"cqansw\":\"There important differences between the cases that do not support this inference\",\"cqquest\":\"Are there important differences between the cases?\"},\"CQAN3\":{\"cqansw\":\" The similarity between the cases is not relevant for this inference\",\"cqquest\":\"Is the similarity between the cases relevant for this inference?\"},\"CQAN5\":{\"cqansw\":\"There is another case C3 similar to C1 where A is false\",\"cqquest\":\"Is there some other case C3 similar to C1, but in which A is false?\"}},\"assump\":{\"AAN2\":{\"aannot\":\"There is no important difference between C1 and C2\"},\"AAN1\":{\"aannot\":\"There is a relevant  similarity about feature F between C1 and C2\"}},\"annot\":\"Analogy\",\"type\":\"RA\",\"prem\":{\"PAN2\":{\"pannot\":\"A is true in case C1\"},\"PAN1\":{\"pannot\":\"Case C1 is similar to case C2\"}},\"connect\":{\"PAN2\":[\"CQAN1\"],\"PAN1\":[\"CQAN2\",\"CQAN3\",\"CQAN4\"],\"AAN2\":[\"CQAN4\"],\"AAN1\":[\"CQAN3\"],\"CAN1\":[\"CQAN5\"]},\"conc\":{\"CAN1\":{\"cannot\":\"A may plausibly be true in C2\"}}},\"LCS\":{\"cqs\":{\"CQCS3\":{\"cqansw\":\"This claim is not consistent with others' claims\",\"cqquest\":\"Is the claim consistent with others' claims?\"},\"CQCS2\":{\"cqansw\":\"The group is not in a position to know about K\",\"cqquest\":\"Is the group in a position to know about K?\"},\"CQCS4\":{\"cqansw\":\"The group does not present characteristics appropriate for answering K\",\"cqquest\":\"Does the group present characteristics appropriate for answering K?\"},\"CQCS1\":{\"cqansw\":\"This claim A is not supported by evidence\",\"cqquest\":\"Is the claim A supported by evidence?\"}},\"assump\":{\"ACS3\":{\"aannot\":\"The claim A is supported by evidence\"},\"ACS1\":{\"aannot\":\"The group is in a position to know about K\"},\"ACS2\":{\"aannot\":\"The group presents characteristics appropriate for answering K\"}},\"annot\":\"Crowdsourcing\",\"type\":\"RA\",\"prem\":{\"PCS1\":{\"pannot\":\"Given that the group was asked K\"},\"PCS2\":{\"pannot\":\"Answer A is generally accepted as true\"}},\"connect\":{\"CCS1\":[\"CQCS3\"],\"PCS1\":[\"CQCS2\",\"CQCS4\"],\"PCS2\":[\"CQCS1\"],\"ACS3\":[\"CQCS1\"],\"ACS1\":[\"CQCS2\"],\"ACS2\":[\"CQCS4\"]},\"conc\":{\"CCS1\":{\"cannot\":\"Answer A may plausibly be true\"}}},\"LPP\":{\"cqs\":{\"CQPP4\":{\"cqansw\":\"There is a different reason for Ik not to be credible.\",\"cqquest\":\"Is there a different reason for Ik not to be credible?\"},\"CQPP2\":{\"cqansw\":\"There is  an exception to CrtX such that Ik is not preferred to Ij.\",\"cqquest\":\"Is there an exception to CrtX such that Ik is not preferred to Ij?\"},\"CQPP3\":{\"cqansw\":\"There is a different reason for believing that Ik is not preferred to Ij.\",\"cqquest\":\"Is there a different reason for believing that Ik is not preferred to Ij?\"},\"CQPP1\":{\"cqansw\":\"There is a different criterion such that Ik is not preferred to Ij.\",\"cqquest\":\"Is there a different criterion such that Ik is not preferred to Ij?\"}},\"assump\":{\"APP1\":{\"aannot\":\"There is no exception to CrtX such that Ik is not preferred to Ij\"}},\"annot\":\"Preference\",\"type\":\"RA\",\"prem\":{\"PPP1\":{\"pannot\":\"The provenance chain infers Info Ik is credible\"},\"PPP2\":{\"pannot\":\"CrtX infers prov Ik is preferred than Prov Ij\"}},\"connect\":{\"CPP1\":[\"CQPP3\"],\"PPP1\":[\"CQPP4\"],\"PPP2\":[\"CQPP1\",\"CQPP2\"],\"APP1\":[\"CQPP2\"]},\"conc\":{\"CPP1\":{\"cannot\":\"Ik may be preferred to Ij\"}}},\"LCE\":{\"cqs\":{\"CQCE5\":{\"cqansw\":\"There is an exception to the causal rule that impedes the effect to occur\",\"cqquest\":\"Is there any exception to the causal rule that impedes the effect to occur?\"},\"CQCE4\":{\"cqansw\":\"The relationship between  the cause and  the effect is not a causal relationship\",\"cqquest\":\"Is the relationship between  the cause and  the effect a causal relationship?\"},\"CQCE7\":{\"cqansw\":\"The effect has not occurred.\",\"cqquest\":\"Has the effect occurred?\"},\"CQCE6\":{\"cqansw\":\"The cause has not happened before the effect\",\"cqquest\":\"Has the cause happened before the effect?\"},\"CQCE1\":{\"cqansw\":\"There is no evidence to show that the cause occurred\",\"cqquest\":\"Is there evidence to show that the cause occurred?\"},\"CQCE3\":{\"cqansw\":\"There is not a general rule that connects the cause to the effect\",\"cqquest\":\"Is there a general rule that connects the cause to the effect?\"},\"CQCE2\":{\"cqansw\":\"There is an alternative cause that leads to the same effect\",\"cqquest\":\"Is there any other different cause that leads to the same effect?\"}},\"assump\":{\"ACE1\":{\"aannot\":\"There is a causal relationship between cause and effect\"},\"ACE2\":{\"aannot\":\"There are no verified exceptions to the causal rule\"},\"ACE3\":{\"aannot\":\"The cause has happened before the effect\"}},\"annot\":\"Cause to effect\",\"type\":\"RA\",\"prem\":{\"PCE2\":{\"pannot\":\"Cause occurs\"},\"PCE1\":{\"pannot\":\"Generally, if a cause occurs, the effect would also occur\"}},\"connect\":{\"ACE1\":[\"CQCE4\"],\"ACE2\":[\"CQCE5\"],\"CCE1\":[\"CQCE7\"],\"PCE2\":[\"CQCE1\",\"CQCE2\"],\"PCE1\":[\"CQCE3\",\"CQCE6\",\"CQCE4\",\"CQCE5\"],\"ACE3\":[\"CQCE6\"]},\"conc\":{\"CCE1\":{\"cannot\":\"Effect will occur\"}}}}";
	if(scheme_str!=null){
		return scheme_str;
	}else{
		return temp;
	}
}

public HashSet getCQs() {
	// TODO Auto-generated method stub
	return DefCQs;
}

	
	
	

}
