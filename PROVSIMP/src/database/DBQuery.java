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
 * @version     2.0  
 * @since 		July 2017    
 * 
 *  Provenance models are inevitably large. Here we use chaining in case we run out of space.
 *  We also assume that if the node is inserted no modifications are allowed
 *  Furthermore if two calls are trying to add the same node, only the first node gets inserted
 *  The rest gets deleted. 
 *
 *   //all the SQL queries are handled here
 */


package database;


 

import java.util.ArrayList;
import java.util.HashMap;

import java.util.UUID;


public class DBQuery {
   
	protected DBConnect dbcn;
	private String provsize ="4000";
	private int limit=4000;
	public DBQuery(String ps){
		dbcn=new DBConnect(); //connection is handled internally
		provsize=ps;
		limit=Integer.parseInt(provsize);
		
	}
	
//*******************************************************************************TABLES!!
  
	
	 
	 public void createTableProv() {
		 //this table is for the nodes and their provenance 
			String query="CREATE TABLE CISPACES_INFOPROV ( nodeid VARCHAR (255), provst VARCHAR( "+provsize+" ), chaining VARCHAR (72), ";
			query+="CONSTRAINT CISPACES_INFOPROV_pk PRIMARY KEY (nodeid))";
			dbcn.updateSQL(query);
	 }
	 

//*******************************************************************INSERT AND RETRIEVE PROV MODELS WITH CHAINING
	public ArrayList getChainList(String name){
		
	String sql;
	sql = "SELECT * FROM CISPACES_INFOPROV" +
	      " WHERE nodeid = '" + name + "' ";
	//System.out.println(sql+ " ");
 
	String chain=null;
	 
	 ArrayList clobs=new ArrayList();
	 ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

	 if(rs!=null && rs.size()>0){
	 	HashMap<String, Object> res=rs.get(0);

			chain=(String) res.get("chaining");

			
			while(chain!=null){
				// System.out.println("***"+chain+"****");
				clobs.add(chain);
				sql = "SELECT * FROM CISPACES_INFOPROV" +
					      " WHERE nodeid = '" + chain + "' ";
				ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);
				//System.out.println(sql);
				if(rsc!=null && rsc.size()>0){
					HashMap<String, Object> rsce=rsc.get(0);
					chain=(String) rsce.get("chaining");
					//System.out.println(chain);
				}
				
			}
	
	} 
	
	return clobs;
	
}
	
	

	public void insertModel(String mod,String name) {
 //System.out.println(name+""+mod);
		if(!existNode(name)){
			String 	sql="INSERT INTO CISPACES_INFOPROV (nodeid) VALUES "
					+ "( '"+name+"')";
		//	System.out.println(sql);
			dbcn.updateSQL(sql);
			
		if(mod.length()>limit){
		//	 System.out.println("PROBLEM!!!!!!");
			ArrayList clobs=new ArrayList();
			String left=mod;
			String item;
			while(left.length()>limit){
				item=left.substring(0,limit-2);
				left=left.substring(limit-2,left.length());
				clobs.add(item);				
			}
			clobs.add(left);
			//now new line in database first clob
		
			sql=" UPDATE CISPACES_INFOPROV " +
					  " SET provst = '"+(String)clobs.get(0)+"' "+
				      " WHERE nodeid = '" + name + "'";
			dbcn.updateSQL(sql);
			
			for(int i=1;i<clobs.size();i++){
				String pid=UUID.randomUUID().toString();
				//update id of the one before!
				 sql="UPDATE CISPACES_INFOPROV " +
						  " SET chaining = '"+pid+"' "+
					      " WHERE nodeid = '" + name + "' ";
			// System.out.println(sql);
				dbcn.updateSQL(sql);
				//insert new line
				sql="INSERT INTO CISPACES_INFOPROV (nodeid) VALUES "
						+ "( '"+pid+"' )";
				dbcn.updateSQL(sql);
				//insert new clob
				sql="UPDATE CISPACES_INFOPROV " +
						  " SET provst = '"+(String)clobs.get(i)+"' "+
					      " WHERE nodeid = '" + pid + "'";
				dbcn.updateSQL(sql);
				
				//now set name
				name=pid;
			}
			
		}else{
			sql=" UPDATE CISPACES_INFOPROV " +
				  " SET provst = '"+mod+"' "+
			      " WHERE nodeid = '" + name + "'";
			dbcn.updateSQL(sql);
		
		}
		
		}
	}



	
	public String getModel(String name) {
		String sql;
		sql = "SELECT * FROM CISPACES_INFOPROV" +
		      " WHERE nodeid = '" + name + "' ";
		//System.out.println(sql+ " ");
		String model=null;
		String chain=null;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
			HashMap<String, Object> res=rs.get(0);
				model=(String) res.get("provst");
				chain=(String) res.get("chaining");
				String othermod;
			 
				while(chain!=null){
					//System.out.println("***"+chain+"****");
				 
					sql = "SELECT * FROM CISPACES_INFOPROV" +
						      " WHERE nodeid = '" + chain + "' ";
					ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);

					if(rsc!=null && rsc.size()>0){
						HashMap<String, Object> rsce=rsc.get(0);
						othermod=(String) rsce.get("provst");
						chain=(String) rsce.get("chaining");
						model+=othermod;
					}
					
				}
				 
				
			
				
			}
		
	
		return model;
		
		
	}
	public boolean isBlackListed(String name){
		if(existTable("CISPACES_BLACKLIST")){
		String sql;
		sql = "SELECT * FROM CISPACES_BLACKLIST" +
		      " WHERE name = '" + name + "'";
		 ArrayList clobs=new ArrayList();
		 ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		 if(rs.isEmpty()){
			 return false;
		 }else{
			 return true;
		 }
		}return false;
	}
	



	 
		//******************************************************************GENERAL 
	public boolean existTable(String table) {
			// TODO Auto-generated method stub
			return dbcn.existTable(table);
		}

	
	public boolean existNode(String nodeID){

			String sql;
			sql = "SELECT * FROM CISPACES_INFOPROV" +
			      " WHERE nodeid = '" + nodeID + "'";
			 ArrayList clobs=new ArrayList();
			 ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
			 if(rs.isEmpty()){
				 return false;
			 }else{
				 return true;
			 }
	}


	public void closeDataBase() {
		dbcn.forceClose();
		
	}

 




	
	 
 

		
 
}
