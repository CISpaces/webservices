package utils;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;

public class PatternExtender extends PatternBuilder{
	
	public void makeSimpleUsedPattern(Object a1,String p1,Object ag1){
	    Resource aa1,agg1,pp1;
	   //this already checks for existing ones!Brilliant!!!
		//make different entities/actors
		aa1=getCISEntity(a1);
		agg1=getCISAgent(ag1);
		createActivity(p1);
		pp1=getResource(NS.URICISP+p1);
		//need to add 2 relationships 
		addUsed(pp1, aa1);
		addWasAssociatedWith(pp1, agg1);
	}
	
	
	public void makeSimpleInformedPattern(Object a1,String p1,String p2){
		  Resource aa1,pp1,pp2;
		  aa1=getCISEntity(a1);
		  //need to add 3 relationships 
		  createActivity(p1);
		  createActivity(p2);
		 
		  pp1=getResource(NS.URICISP+p1);
		  pp2=getResource(NS.URICISP+p2);
		  
		  addWasInformedBy(pp1,pp2);
		  addUsed(pp1,aa1);
		  addUsed(pp2,aa1);
		}


	public void addUsersToGenerationExt(String string, ArrayList<String> from) {
		ArrayList newfrom=new ArrayList();
		for(String user:from){
			user=user.replaceAll(" ", "_");
			newfrom.add(user);
		}
		addUsersToGeneration(string,newfrom);
		
	}


	public void addWasInformedPattern(String p1, String p2) {
		  Resource pp1,pp2;
	 
		  //need to add 3 relationships 
		  createActivity(p1);
		  createActivity(p2);
		 
		  pp1=getResource(NS.URICISP+p1);
		  pp2=getResource(NS.URICISP+p2);
		  
		  addWasInformedBy(pp1,pp2);
		
	}


	public void addUsedExt(String p1, Object a1) {
		createActivity(p1);
		Resource aa1=getCISEntity(a1);
		Resource  pp1=getResource(NS.URICISP+p1);
		addUsed(pp1,aa1);
		
	}


	
	
}
