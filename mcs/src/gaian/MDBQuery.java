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
 * @since 		August 2015           
 *   
 */

package gaian;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
 
 


public class MDBQuery {
private String provsize ="1 M";
private DBConnect dbcn;
private int limit=1000000;

	public MDBQuery(DBConnect d){
		dbcn=d;
	}
 
	

	public void createMoiraUpdates() {
		//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
		String query="CREATE TABLE CISPACES_MOIRAUPDS ( nodeid VARCHAR (255), text VARCHAR (1000), id VARCHAR (255), source VARCHAR (127), dtg VARCHAR (127), "
				+ " top_prov VARCHAR (127), rationale VARCHAR (2000), used INT, ";
		query+="CONSTRAINT CISPACES_MOIRAUPDS_pk PRIMARY KEY (nodeid))";
		dbcn.updateSQL(query);
	}

	
	
	public void createTableMoiraCards() {
		String query="CREATE TABLE CISPACES_MOIRASET ( settings VARCHAR (255), value VARCHAR (255),";
		query+="CONSTRAINT CISPACES_MOIRASET_pk PRIMARY KEY (settings))";
		dbcn.updateSQL(query);
		query="INSERT INTO CISPACES_MOIRASET (settings, value) VALUES "
				+ "( 'lasttime' ,"
				+ " '-1' )";
		//System.out.println(query);
		dbcn.updateSQL(query);
	}
	
	
	 public void createMoiraProv() {
			String query="CREATE TABLE CISPACES_MOIRAPROV ( wboxid VARCHAR (255), provst CLOB( "+provsize+" ), chaining VARCHAR (72), ";
				query+="CONSTRAINT CISPACES_MOIRAPROV_pk PRIMARY KEY (wboxid))";
				dbcn.updateSQL(query);
				query="INSERT INTO CISPACES_MOIRAPROV (wboxid) VALUES "
						+ "( 'default' )";
				//System.out.println(query);
				dbcn.updateSQL(query);
				
				
		 }
	public void createTableMoiraQueries() {
		
		String query="CREATE TABLE CISPACES_MOIRAQS ( id VARCHAR (255), queryid VARCHAR (255), ciuser VARCHAR (255), shared INT, query VARCHAR (255), node VARCHAR (1000), dtg VARCHAR (72), last_msg VARCHAR (72), ";
		query+="CONSTRAINT CISPACES_MOIRAQS_pk PRIMARY KEY (id))";
		//System.out.println(query);
		dbcn.updateSQL(query);
	}
	 public boolean insertNewQuery(String user, String ask, int shared, String nodeID, String allID, String text, String dtg) {
		// id | queryid | ciuser |shared | query |
		String query="INSERT INTO CISPACES_MOIRAQS ( id, queryid, ciuser, shared, query, node, dtg ) VALUES "
				+ "( '"+allID+"',"
				+ 	"'"+nodeID+"',"
				+ 	"'"+user+"',"
				+ 	""+shared+","
				+ 	"'"+ask+"',"
				+ 	"'"+text+"',"
				+ 	"'"+dtg+"'"
						+ " )";
		//System.out.println(query);
		return dbcn.updateSQL(query);
		
	} 
	

	public String getLastMsg(String queryID) {
		String sql;
		sql = "SELECT last_msg FROM CISPACES_MOIRAQS" +
		      " WHERE id = '"+queryID+"'";
		 
		String text = null;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
			HashMap<String, Object> res=rs.get(0); 
					text=(String) res.get("last_msg");
					if(text==null || text.equals("")){
						text=null;
					}
			//	System.out.println("jj");
		}
				 
		
		return text;
	}

	
 	public boolean insertNewUpdate(String id, String text, String nodeid, String source, String dtg, String top, String msg_id, String rationale,ArrayList is_to) {
		//		//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
		//dbc.insertNewUpdate(id,text,nodeid,prov_data[0],prov_data[1],prov_data[2]);
 		
 		//check exists user + query ID 
 		
 		String sql = "SELECT ciuser FROM CISPACES_MOIRAQS" +
 			      " WHERE id = '"+id+"'";
 			 
 			boolean test=false;
 			ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

 			if(rs!=null && rs.size()>0){
 				HashMap<String, Object> res=rs.get(0);

 					 String user=(String) res.get("ciuser");
 					 if(is_to.contains(user)){
 						 test=true;
 					 }
 				//	System.out.println("jj");
 			}
 					 
 			 
 		
 		if(test){
 		
 		
		String query="INSERT INTO CISPACES_MOIRAUPDS ( nodeid, text, id, source, dtg, top_prov, rationale, used) VALUES "
				+ "( '"+nodeid+"',"
				+ 	"'"+text+"',"
				+ 	"'"+id+"',"
				+ 	"'"+source+"',"
				+ 	"'"+dtg+"',"
				+ 	"'"+top+"',"
				+ 	"'"+rationale+"',"
				+ 	"0"
						+ " )";
		//System.out.println(query);
		dbcn.updateSQL(query);
		 sql=" UPDATE CISPACES_MOIRAQS " +
					  " SET last_msg =  '"+msg_id+"'" +
				      " WHERE id = '"+id+"'";
		 dbcn.updateSQL(sql);
 		}
 		return test;
	 
		
	} 
	
	public void deleteQuery(String allID) {
		String query="DELETE FROM CISPACES_MOIRAQS " +
				 " WHERE id = '" + allID + "' ";
		dbcn.updateSQL(query);
		query="DELETE FROM CISPACES_MOIRAUPDS " +
				 " WHERE id = '" + allID + "' ";
		dbcn.updateSQL(query);
		
	}



	public long getLastTime() {
		String sql;
		sql = "SELECT value FROM CISPACES_MOIRASET" +
		      " WHERE settings = 'lasttime'";
		long time = -1;
		String text;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
					 
					text=(String) res.get("value");
				    time=Long.parseLong(text);
				 
			//	System.out.println("jj");
				}
		}
		return time;
	}
		

	public void insertNewMsg(String user, String text, String queryID,String dtg) {
		//		//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
		//dbc.insertNewUpdate(id,text,nodeid,prov_data[0],prov_data[1],prov_data[2]);
		String nodeid=UUID.randomUUID().toString();
		String query="INSERT INTO CISPACES_MOIRAUPDS ( nodeid, text, id, source, dtg, top_prov, used ) VALUES "
				+ "( '"+nodeid+"',"
				+ 	"'"+text+"',"
				+ 	"'"+queryID+"',"
				+ 	"'"+user+"',"
				+ 	"'"+dtg+"',"
				+ 	"'XXXX',"
				+ 	"1"
						+ " )";
		//System.out.println(query);
		dbcn.updateSQL(query);
		
	}
	
	/*	sql = "SELECT * FROM CISPACES_MOIRAQS, CISPACES_MOIRAUPDS " +
		      " WHERE CISPACES_MOIRAQS.ciuser = '"+user+"' AND "
	      		+ "CISPACES_MOIRAUPDS.used = 0 AND CISPACES_MOIRAQS.id=CISPACES_MOIRAUPDS.id";*/

	public   ArrayList<String[]> getAllUpdates(String queryID) {
		String sql;
		sql = "SELECT * FROM CISPACES_MOIRAUPDS " +
			      " WHERE id = '"+queryID+"' AND "
			      		+ "used = 0 ";
		//System.out.println(sql);
		ArrayList<String[]> result=new ArrayList<String[]>();
		 
		ArrayList<String> done=new ArrayList<String>();
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
				String[] data=new String[6];
				data[0]=(String) res.get("text");
				data[1]=(String) res.get("top_prov");
				data[2]=(String) res.get("dtg");
				data[3]=(String) res.get("nodeid");
				data[4]=(String) res.get("source"); 
				data[5]=(String) res.get("rationale");
				//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
				// id | nodeid | ciuser |shared | query |
				result.add(data);
				done.add((String) res.get("id"));
			}
			 
		 
			}  
		for(String id:done){
			updateUsedUpdate(id);
		}
		
			 
		return result;
		
	}

	private void updateUsedUpdate(String id) {
		String  sql=" UPDATE CISPACES_MOIRAUPDS " +
				  " SET used =  1 " +
			      " WHERE id = '"+id+"'";
		dbcn.updateSQL(sql);
	}



	public ArrayList<String> getAllQueryIds(String user) {
		 
		String sql;
		sql = "SELECT id FROM CISPACES_MOIRAQS" +
		      " WHERE ciuser = '"+user+"'";
		ArrayList<String> result=new ArrayList<String>();
		String id;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
					id=(String) res.get("id");
				    result.add(id);
			//	System.out.println("jj");
				}
				 
			 
		}  
		return result;
	}
	 
 
	public void insertNewTime(String lasttime) {
		String  sql=" UPDATE CISPACES_MOIRASET " +
				  " SET value =  '"+lasttime+"'" +
			      " WHERE settings = 'lasttime'";
		dbcn.updateSQL(sql);
	}

	
	
	 public void insertModel(String mod) {
		// System.out.println(mod);

			ArrayList clobs=getChainList();
			//System.out.println(sql+ " ");
	 
			Iterator iter=clobs.iterator();
			String clob;
			while(iter.hasNext()){
						//now remove clobs 
				clob=(String) iter.next();
				String query="DELETE FROM CISPACES_MOIRAPROV " +
								 " WHERE wboxid = '" + clob + "' ";
				dbcn.updateSQL(query);
			}
				   
			String sql=" UPDATE CISPACES_MOIRAPROV " +
							  " SET chaining =  null "+
						      " WHERE wboxid = 'default'";
			dbcn.updateSQL(sql);
 
			//now I have cleared everything except the top one!
		
	
		if(mod.length()>limit){
			//System.out.println("PROBLEM!!!!!!");
			clobs=new ArrayList();
			String left=mod;
			String item;
			while(left.length()>limit){
				item=left.substring(0,limit-2);
				left=left.substring(limit-2,left.length());
				clobs.add(item);				
			}
			clobs.add(left);
			//now new line in database first clob
		
			sql=" UPDATE CISPACES_MOIRAPROV " +
					  " SET provst = ? "+
				      " WHERE wboxid = 'default'";
			dbcn.insertClob(sql, (String)clobs.get(0));
			String name="default";
			for(int i=1;i<clobs.size();i++){
				String pid=UUID.randomUUID().toString();
				//update id of the one before!
				 sql="UPDATE CISPACES_MOIRAPROV " +
						  " SET chaining = '"+pid+"' "+
					      " WHERE wboxid = '" + name + "' ";
			//	System.out.println(sql);
				dbcn.updateSQL(sql);
				//insert new line
				sql="INSERT INTO CISPACES_MOIRAPROV (wboxid) VALUES "
						+ "( '"+pid+"' )";
				dbcn.updateSQL(sql);
				//insert new clob
				sql="UPDATE CISPACES_MOIRAPROV " +
						  " SET provst = ? "+
					      " WHERE wboxid = '" + pid + "'";
				dbcn.insertClob(sql, (String)clobs.get(i));
				
				//now set name
				name=pid;
			}
			
		}else{
			//System.out.println("this is ok!");
			sql=" UPDATE CISPACES_MOIRAPROV " +
				  " SET provst = ? "+
			      " WHERE wboxid = 'default'";
			dbcn.insertClob(sql, mod);
		
		}
		
		
	}
	public void insertNullModel() {
		String  sql=" UPDATE CISPACES_MOIRAPROV " +
				  " SET provst =  null "+
			      " WHERE wboxid = 'default'";
		dbcn.updateSQL(sql);
	}


	public String getModel() {
	 
		String sql;
		sql = "SELECT * FROM CISPACES_MOIRAPROV" +
		      " WHERE wboxid = 'default' ";
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
				//	System.out.println("***"+chain+"****");
				 
					sql = "SELECT * FROM CISPACES_MOIRAPROV" +
						      " WHERE wboxid = '" + chain + "' ";
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
	 
	public ArrayList getChainList(){
		
		String sql;
		sql = "SELECT * FROM CISPACES_MOIRAPROV" +
		      " WHERE wboxid = 'default' ";
		//System.out.println(sql+ " ");
	 
		String chain=null;
		 
		 ArrayList clobs=new ArrayList();
			ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

			if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
				chain=(String) res.get("chaining");

				
				while(chain!=null){
					//System.out.println("***"+chain+"****");
					clobs.add(chain);
					sql = "SELECT * FROM CISPACES_MOIRAPROV" +
						      " WHERE wboxid = 'default' ";
					ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);

					if(rsc!=null && rsc.size()>0){
						HashMap<String, Object> rsce=rs.get(0);
					 
						chain=(String) rsce.get("chaining");
					}
					 
				}
			 
				 
				
			}
		 
		
		return clobs;
		
	} 
	 
	
	 
	 
	 
	 
	 
	public boolean existTable(String table) {
		// TODO Auto-generated method stub
		return dbcn.existTable(table);
	}

	public boolean queryTest() {
		return dbcn.tryConnect();
		
	}



	public String[] getAllQueryData(String queryID) {
		String sql;
		sql = "SELECT shared,node,query,ciuser,dtg,queryid FROM CISPACES_MOIRAQS" +
		      " WHERE id = '"+queryID+"'";
		String[] result=new String[6];
	 
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
			HashMap<String, Object> res=rs.get(0);
					result[0]=""+res.get("shared");
					result[1]=(String) res.get("node");
					result[2]=(String) res.get("query");
					result[3]=(String) res.get("ciuser");
					result[4]=(String) res.get("dtg");
					result[5]=(String) res.get("queryid");
			//	System.out.println("jj");
				}
				 
			 
		  
		return result;
	}



	public ArrayList<String[]> getAllHistory(String queryID) {
		String sql;
		sql = "SELECT * FROM CISPACES_MOIRAUPDS " +
		      " WHERE id = '"+queryID+"' AND "
		      		+ "used = 1 ";
		//System.out.println(sql);
		ArrayList<String[]> result=new ArrayList<String[]>();
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
				String[] data=new String[4];
				data[0]=(String) res.get("text");
				data[1]=(String) res.get("top_prov");
				data[2]=(String) res.get("dtg");
				data[3]=(String) res.get("rationale");
				//id (IDaLL) | Text | nodeid (cispacesid) |source | dtg | top_prov (to extract model) || int used (0no 1yes) | 
				// id | nodeid | ciuser |shared | query |
				result.add(data);
			}
			 
		 
			}  
		return result;
		
	}



	public ArrayList<HashMap> getAllQueries(String user) {
		String sql;
		sql = "SELECT query,id FROM CISPACES_MOIRAQS" +
		      " WHERE ciuser = '"+user+"'";
		HashMap result=new HashMap();
		ArrayList<HashMap> list=new ArrayList<HashMap>();
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
				
				
		 
					result=new HashMap();
					result.put("query_text",(String)res.get("query"));
					result.put("query_id",(String)res.get("id"));
					list.add(result);
			//	System.out.println("jj");
				}
				 
			 
		}  
		return list;
	}

 


 

}


