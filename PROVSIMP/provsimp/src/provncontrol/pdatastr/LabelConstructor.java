package provncontrol.pdatastr;


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
 * @since 		October 2014           
 *   
 */


 

public class LabelConstructor {

	 

	public static String getLabActivityRules(String label) {
		if(label.startsWith("CISpAccess")){
			label=label.substring(0,15);
		}else
		if(label.startsWith("Aquiring")){
				label=label.substring(0,11);
		}else
	    if(label.startsWith("Reporting")){
				label=label.substring(0,12);
		}else
		if(label.startsWith("CreateNode")){
			label=label.substring(0,15);
		}else if(label.startsWith("ThinkNode")){
			label=label.substring(0,14);
		}else
		if(label.startsWith("MakeAnalysis")){
			label=label.substring(0,15);
		}else
			if(label.startsWith("LoadFile")){
				label=label.substring(0,12);
			}else
		if(label.startsWith("Inspect")){
			label=label.substring(0,12);
		}else
		if(label.startsWith("Update")){
			label=label.substring(0,10);
		}else
		if(label.startsWith("JoinChat")){
			label=label.substring(0,12);
		}else
		if(label.startsWith("Recovery")){
			label=label.substring(0,12);
		}else
		if(label.startsWith("Prepare_CS_Task")){
				label=label.substring(0,15);
		}else
		if(label.startsWith("Create_CS_RI")){
					label=label.substring(0,12);
		}else
		if(label.startsWith("Process_CS_Res")){
				label=label.substring(0,14);
		}else
		if(label.startsWith("Analyse_CS_Res")){
				label=label.substring(0,14);
		}else
		if(label.startsWith("Analyse_Prov_Chain")){
				label=label.substring(0,20);
		}else
		if(label.startsWith("Analyse_Pref_Chain")){
				label=label.substring(0,20);
		}else
		if(label.startsWith("Collect_CS_Res")){
				label=label.substring(0,14);
		}else
		if(label.startsWith("Save")){
			label=label.substring(0,8);
		}else
			if(label.startsWith("LoadFromFile")){
				label=label.substring(0,16);
			}
		
		return label;
	}

	public static String getLabEntityRules(String label) {
	//	System.out.println(label);
		 if(label.startsWith("Node")){
			label=label.substring(0,8);
		}else if(label.contains("_Notif_")){
			label=label.substring(0,label.lastIndexOf("_")+4);
		}else if(label.startsWith("Prov_analysis_node")){
			label=label.substring(0,22);
		}else{
			if(label.length()>22)
			label=label.substring(0,20);
		} 
		return label;
	}

	public static String getLabAnalysisRules(String label) {
		if(label.startsWith("InitialAnalysis")){
			label=label.substring(0,20);
		}else if(label.startsWith("AccessAnalysis")){
			label=label.substring(0,18);
		}else if(label.startsWith("PROVAnalysis")){
			label=label.substring(0,16);
		}else if(label.startsWith("PREFAnalysis")){
				label=label.substring(0,16);
		}else if(label.startsWith("CurrentAnalysis")){
			label=label.substring(0,18);
		}else if(label.startsWith("OnJoinAnalysis")){
			label=label.substring(0,18);
		}else if(label.startsWith("OnLoadAnalysis")){
			label=label.substring(0,15);
		}else if(label.startsWith("CSAnalysis")){
			label=label.substring(0,14);
		}else{
			if(label.length()>42)
			label=label.substring(0,label.length()-36);//id length
		}
		return label;
	}
}
