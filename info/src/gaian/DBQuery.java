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
 * @since 		September 2014           
 *   
 */

package gaian;

import infocontrol.InfoProvBuild;
import infocontrol.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.UUID;


 


public class DBQuery {
private final int MAXL=3;
private DBConnect dbcn;
private String provsize ="1 M";
private int limit=1000000;
	public DBQuery(DBConnect d){
		dbcn=d;
	}
	/*
	 *  Table CISPACES_INFOTMP
	 *  |id|username|lastset|lasttime|affiliation|
	 *  Table CISPACES_INFOND
	 *  |id|affiliation|setid|text|
	 * 
	 */
	
	public void createTableInfo(String table, String[] st, String intst, String nodeid) {
		String query="CREATE TABLE "+table+" ( "+nodeid+" VARCHAR (255), ";
		for(int i=0;i<st.length;i++){
			query+=st[i]+" VARCHAR (255), ";
		}
		query+=intst+" INT, ";
		query+="CONSTRAINT "+table+"_pk PRIMARY KEY ("+nodeid+","+st[0]+"))";
		dbcn.updateSQL(query);
		
	}
	
	 public void createTableProv(String table) {
			String query="CREATE TABLE "+table+" ( wboxid VARCHAR (255), provst CLOB( "+provsize+" ), plock SMALLINT, chaining VARCHAR (72), ";
			query+="CONSTRAINT "+table+"_pk PRIMARY KEY (wboxid))";
			dbcn.updateSQL(query);
			//System.out.println(query);
			// for this I insert the value defModel 
 
		 
		//System.out.println(query);
		dbcn.updateSQL(query);
	}
	
	public void createTableCurAnaly(String table, String[] st, String nodeid) {
		String query="CREATE TABLE "+table+" ( "+nodeid+" VARCHAR (255), ";
		for(int i=0;i<st.length;i++){
			query+=st[i]+" VARCHAR (255), ";
		}
		query+="CONSTRAINT "+table+"_pk PRIMARY KEY ("+nodeid+"))";
		dbcn.updateSQL(query);
		
	}
	
	public void createTableSets(String table, String[] st, String intst) {
		String query="CREATE TABLE "+table+" ( id INTEGER NOT NULL GENERATED ALWAYS AS"
				+ " IDENTITY (START WITH 1, INCREMENT BY 1), ";
		for(int i=0;i<st.length;i++){
			query+=st[i]+" VARCHAR (255), ";
		}
		query+=intst+" INT, ";
		query+="CONSTRAINT "+table+"_pk PRIMARY KEY (id))";
		dbcn.updateSQL(query);
	}

	public void createTableEdge(String table){
		String query="CREATE TABLE " + table + " ( edgeid varchar(255), tonodeid varchar(255), fromnodeid varchar(255), formedgeid varchar(255)," +
				"sessionid varchar(255),";
		query+="CONSTRAINT CISPACES_EDGE_pk (edgeid))";
        System.out.println("EXECUTING QUERY TO CREATE EDGE TABLE");
        dbcn.updateSQL(query);
	}

	public boolean existTable(String table) {
		// TODO Auto-generated method stub
		return dbcn.existTable(table);
	}
	
	

	public User existUser(User usertry) {
		String sql;
		sql = "SELECT * FROM CISPACES_INFOTMP" +
		      " WHERE username = '" + usertry.getUser() + "' AND affiliation = '"+usertry.getAff()+"'";
		//System.out.println(sql+ " ");
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		User user=null;
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> map=rs.get(0);
				user=new User();
				user.setAff((String) map.get("affiliation"));
				user.setTimeS((String) map.get("lasttime"));
				user.setLastset((int) map.get("lastset"));
				user.setUser((String) map.get("username"));
		}
		return user;
	}

	public User createUser(User user,InfoProvBuild ipb, boolean rand_gen) {
		user.setLastset(0);
		user.setTime(System.currentTimeMillis());
		//|id|username|lastset|lasttime|affiliation|
		String query="INSERT INTO CISPACES_INFOTMP (username, lasttime, affiliation, lastset) VALUES "
				+ "( '"+user.getUser()+"' ,"
				+ " '"+user.getTime()+"' ,"
				+ " '"+user.getAff()+"' ,"
				+ " "+user.getLastset()+" "
						+ " )";
		//System.out.println(query);
		dbcn.updateSQL(query);
	 
		
		ArrayList test=checkSet(0,user.getAff());
		if(test==null && rand_gen){
			createNewSet(0,user.getAff(),ipb,user.getUser());
		}
		
		
		
		
		return user;
	}

	public ArrayList checkSet(int setToRead, String aff) {
		String sql;
		sql = "SELECT nodeID,text FROM CISPACES_INFOND" +
		      " WHERE affiliation = '"+aff+"' AND setid = "+setToRead+"";
		//System.out.println(sql+ " ");
		//Table CISPACES_INFOND
		// *  |id|affiliation|setid|text|
		ArrayList list=null;
		HashMap map;
		String text,id;
		 
		
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
	 
		if(rs!=null && rs.size()>0){
				list=new ArrayList();
				for(HashMap<String, Object> res:rs){
					map=new HashMap();
					text=(String) res.get("text");
					id=(String) res.get("nodeid");
					map.put("text",text);
					map.put("nodeID", id);
                    list.add(map);
				 
			//	System.out.println("jj");
				}
				 
		}
				 
		 
		return list;
	}
		
	public void checkOrAddInfo(String user,String text,String cispid) {
		String sql;
		sql = "SELECT nodeID FROM CISPACES_INFOND" +
		      " WHERE text = '"+text+"'";
		//System.out.println(sql+ " ");
		int id = 0;
		//Table CISPACES_INFOND
		// *  |id|affiliation|setid|text|
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
				id=(int) res.get("nodeid");
					//System.out.println(id);
		}
		sql="SELECT id FROM CISPACES_NODEMAP" +
				      " WHERE id = "+id;
			//	System.out.println(sql);
		rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
					id=(int) res.get("id");
					//this is already there not interested
		}else{
					sql="INSERT INTO CISPACES_NODEMAP (id, cisp_id, username) VALUES "
							+ "( "+id+" ,"
							+ " '"+cispid+"' ,"
							+ " '"+user+"' )";	 
				//  System.out.println(sql);
					 dbcn.updateSQL(sql);
					
		}
	
				 
		
	}
	
	 // username, affiliation, curshared, wboxid, curindivid
		public String refreshAnalysis(String user) {
			String sql;
			String pid=UUID.randomUUID().toString();
			sql = " UPDATE CISPACES_CURANALY " +
				  " SET curindivid = '"+pid+"'"+
			      " WHERE username = '" + user + "'";
			dbcn.updateSQL(sql);
			return pid;
			
		}

	public ArrayList createNewSet(int setToRead, String aff,InfoProvBuild ipb, String username) {
	
		ArrayList list=new ArrayList();
		
	     String query;
		String info;String nodeid;
		HashMap map;
		for(int i=0;i<MAXL;i++){
			//create random infonode
			 nodeid=UUID.randomUUID().toString();
			 info=nodeid.replace("-", " ");
			 info="Info "+info;
			//create prov of random
			 ipb.createRandomProv(nodeid,info,username);
			String lprov=null;
			// *  |id|affiliation|setid|text|
			query="INSERT INTO CISPACES_INFOND (nodeID, affiliation, text, setid,lprov) VALUES "
					+ "( '"+nodeid+"' ,"
					+ " '"+aff+"' ,"
					+ " '"+info+"' ,"
					+ " "+setToRead+","
					+ " '"+lprov+"')";	 
		//	 System.out.println(query);
			 dbcn.updateSQL(query);
			 map=new HashMap();
			 map.put("text",info);
			 map.put("nodeID", nodeid);
			 list.add(map);
			 
		}
		return list;
	}
	
	

	public void changeEntry(long now, User user) {
		// TODO Auto-generated method stub
		String sql;
		sql = " UPDATE CISPACES_INFOTMP " +
			  " SET lastset = "+(user.getLastset()+1)+", lasttime = '"+now+"'"+
		      " WHERE username = '" + user.getUser() + "' AND affiliation = '"+user.getAff()+"'";
		dbcn.updateSQL(sql);
	}

	public ArrayList getAllInfo(int lastset, String aff, String user) {
		String sql;
		sql = "SELECT text,nodeID FROM CISPACES_INFOND" +
		      " WHERE affiliation = '"+aff+"' AND setid <= "+lastset;
		//System.out.println(sql+ " ");
		//Table CISPACES_INFOND
		// *  |id|affiliation|setid|text|
		ArrayList list=new ArrayList();
		HashMap map;
		String text,id;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
					map=new HashMap();
					text=(String) res.get("text");
					id=(String) res.get("nodeid");
					map.put("text",text);
					map.put("nodeID", id);
                    list.add(map);
				}
		}
		sql = "SELECT nodeID,text FROM CISPACES_INFOND" +
								" WHERE affiliation = '"+user+"' AND setid = 1";
		rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
			ArrayList other=new ArrayList();
		
				for(HashMap<String, Object> res:rs){
							map=new HashMap();
							text=(String) res.get("text");
							id=(String) res.get("nodeid");
							map.put("text",text);
							map.put("nodeID", id);
		                    other.add(map);
						 
					//	System.out.println("jj");
			}
				list.addAll(other);
		} 
					 
						
			 
				if(list.isEmpty()){
					return null;
				}else{
					//System.out.println(list);
					return list;
				}
		
	}

	 
	public String getCurAnalyID(String user) {
		String sql;
		sql = "SELECT curindivid FROM CISPACES_CURANALY" +
		      " WHERE username = '"+user+"'";
		//System.out.println(sql+ " ");
		//Table CISPACES_INFOND
		// *  |id|affiliation|setid|text|
 
		String id =null;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
				id=(String) res.get("curindivid"); 
				//System.out.println("jj");
		}
		return id;
	}

	
	public ArrayList getChainList(String name){
		
	String sql;
	sql = "SELECT * FROM CISPACES_INFOPROV" +
	      " WHERE wboxid = '" + name + "' ";
	//System.out.println(sql+ " ");
 
	String chain=null;
	ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
	ArrayList clobs=new ArrayList();
	if(rs!=null && rs.size()>0){
			HashMap<String, Object> res=rs.get(0);
			chain=(String) res.get("chaining");
			while(chain!=null){
				//System.out.println("***"+chain+"****");
				clobs.add(chain);
				sql = "SELECT * FROM CISPACES_INFOPROV" +
					      " WHERE wboxid = '" + chain + "' ";
				ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);
				if(rsc!=null && rsc.size()>0){
						HashMap<String, Object> ris=rsc.get(0);
						chain=(String) ris.get("chaining");
				}
				 
			}
	}  
	return clobs;
	
}

	public void insertModel(String mod,String name) {
			ArrayList clobs=getChainList(name);
			//System.out.println(sql+ " ");
	 
			Iterator iter=clobs.iterator();
			String clob;
			while(iter.hasNext()){
						//now remove clobs 
				clob=(String) iter.next();
				String query="DELETE FROM CISPACES_INFOPROV " +
								 " WHERE wboxid = '" + clob + "' ";
				dbcn.updateSQL(query);
			}
				   
			String sql=" UPDATE CISPACES_INFOPROV " +
							  " SET chaining =  null "+
						      " WHERE wboxid = '" + name + "'";
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
		
			sql=" UPDATE CISPACES_INFOPROV " +
					  " SET provst = ? "+
				      " WHERE wboxid = '" + name + "'";
			dbcn.insertClob(sql, (String)clobs.get(0));
			
			for(int i=1;i<clobs.size();i++){
				String pid=UUID.randomUUID().toString();
				//update id of the one before!
				 sql="UPDATE CISPACES_INFOPROV " +
						  " SET chaining = '"+pid+"' "+
					      " WHERE wboxid = '" + name + "' ";
			//	System.out.println(sql);
				dbcn.updateSQL(sql);
				//insert new line
				sql="INSERT INTO CISPACES_INFOPROV (wboxid) VALUES "
						+ "( '"+pid+"' )";
				dbcn.updateSQL(sql);
				//insert new clob
				sql="UPDATE CISPACES_INFOPROV " +
						  " SET provst = ? "+
					      " WHERE wboxid = '" + pid + "'";
				dbcn.insertClob(sql, (String)clobs.get(i));
				
				//now set name
				name=pid;
			}
			
		}else{
			//System.out.println("this is ok!");
			sql=" UPDATE CISPACES_INFOPROV " +
				  " SET provst = ? "+
			      " WHERE wboxid = '" + name + "'";
		dbcn.insertClob(sql, mod);
		
		}
		
	}
	public void insertNullModel(String name) {
		String  sql=" UPDATE CISPACES_INFOPROV " +
				  " SET provst =  null "+
			      " WHERE wboxid = '" + name + "'";
		dbcn.updateSQL(sql);
	}


	public String getModel(String name) {
		String sql;
		sql = "SELECT * FROM CISPACES_INFOPROV" +
		      " WHERE wboxid = '" + name + "' ";
		//System.out.println(sql+ " ");
		String model=null;
		String chain=null;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
				model= (String) res.get("provst");
				chain=(String)res.get("chaining");
				String othermod;
			 
				while(chain!=null){
				//	System.out.println("***"+chain+"****");
				 
					sql = "SELECT * FROM CISPACES_INFOPROV" +
						      " WHERE wboxid = '" + chain + "' ";
					ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);
					 
					if(rsc!=null && rsc.size()>0){
							HashMap<String, Object> ris=rs.get(0);
						othermod=(String) ris.get("provst");
						chain=(String) ris.get("chaining");
						model+=othermod;
					}
				}	
		}  
		//System.out.println(model);
		return model;
		
	}
	 public void setLock(String name, int value){
		  String  sql=" UPDATE CISPACES_INFOPROV " +
					  " SET plock = "+value+" "+
				      " WHERE wboxid = '" + name + "'";
			dbcn.updateSQL(sql);
	   }

	 public boolean checkLock(String name) {
			String sql;
			sql = "SELECT * FROM CISPACES_INFOPROV" +
			      " WHERE wboxid = '" + name + "' ";
			//System.out.println(sql+ " ");
			int lockint;
			boolean lock = false;
			ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
	//	System.out.println(rs);
			if(rs!=null && rs.size()>0){
					HashMap<String, Object> res=rs.get(0);
					lockint=(int) res.get("plock");
					 
					
					if(lockint==0){
						lock=false;
					}else if(lockint==1){
						lock=true;
					}
					 
				}else{
					String query="INSERT INTO CISPACES_INFOPROV (wboxid, plock) VALUES "
							+ "( '"+name+"' ,"
							+ " 0 "
									+ " )";
					//System.out.println(query);
					dbcn.updateSQL(query);
					lock=false;
			} 
			return lock;
		}

	public boolean setRWLock() {
		String sql;
		sql = "SELECT * FROM CISPACES_INFOTMP" +
			  " WHERE username = 'b0f9f703-844c-4b70-aaaa-897d204fc24e' AND affiliation='99d42973-d0ba-4082-88f8-dcc2522cf796'";

	//	 System.out.println(sql+ " ");
	 
		boolean resp=false;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
	 
		if(rs!=null && rs.size()>0){
				HashMap<String, Object> res=rs.get(0);
				int lockint = (int) res.get("lastset");
				//System.out.println(lockint);
				if(lockint==0){
					sql=" UPDATE CISPACES_INFOTMP " +
							  " SET lastset = 1 "+
							  " WHERE username = 'b0f9f703-844c-4b70-aaaa-897d204fc24e' AND affiliation='99d42973-d0ba-4082-88f8-dcc2522cf796'";
					dbcn.updateSQL(sql);
					//System.out.println("got here?");
					resp=true;
				}else{  
					
					resp=false;
				}
				 
			}else{
				setUserDefault();
				resp=false;
			} 
		return resp;
	}

	public void unsetRWLock() {
		String sql=" UPDATE CISPACES_INFOTMP " +
				  " SET lastset = 0 "+
				  " WHERE username = 'b0f9f703-844c-4b70-aaaa-897d204fc24e' AND affiliation='99d42973-d0ba-4082-88f8-dcc2522cf796'";
		dbcn.updateSQL(sql);
		//System.out.println("got here and?");
		
	}

	public boolean insertNewNode(String nodeid, String dest, String info,int setToAdd, String lprov) {
		String sql = "SELECT nodeID,affiliation FROM CISPACES_INFOND" +
			      " WHERE nodeID = '"+nodeid+"' AND affiliation = '"+dest+"'";
			 boolean res=true;
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
			 
				if(rs!=null && rs.size()>0){
						res=false;
						}else{
							info=info.replaceAll("'","''");
							String query = "INSERT INTO CISPACES_INFOND (nodeID, affiliation, text, setid, lprov ) VALUES "
									+ "( '"+nodeid+"' ,"
									+ " '"+dest+"' ,"
									+ " '"+info+"' ,"
									+ " "+setToAdd+" ,"
									+ " '"+lprov+"' "
											+ ")";	 
							//	 System.out.println(query);
							dbcn.updateSQL(query);
							res=true;
						}   
		return res;
	}

	public ArrayList checkUserInfo(String user) {
		String sql;
		sql = "SELECT nodeID,text FROM CISPACES_INFOND" +
		      " WHERE affiliation = '"+user+"' AND setid = 0";
		//System.out.println(sql+ " ");
		//Table CISPACES_INFOND
		// *  |id|affiliation|setid|text|
		ArrayList list=null;
		HashMap map;
		String text,id;
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		 
		if(rs!=null && rs.size()>0){
				list=new ArrayList();
				for(HashMap<String, Object> res:rs){
					map=new HashMap();
					text=(String) res.get("text");
					id=(String) res.get("nodeid");
					map.put("text",text);
					map.put("nodeID", id);
                    list.add(map);
				 
			//	System.out.println("jj");
				}
				sql = " UPDATE CISPACES_INFOND " +
					  " SET setid = 1 "+
				      " WHERE affiliation = '" + user + "'";
				dbcn.updateSQL(sql);	
		} 
		return list;
	}

	public int getNextSet(String dest) {
		//check if dest is affiliation
		String sql;
		boolean isaff=false;
		sql = "SELECT DISTINCT affiliation FROM CISPACES_INFOTMP ";
			    
			//System.out.println(sql+ " ");
			 
			
			ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
			 
			if(rs!=null && rs.size()>0){
					
					for(HashMap<String, Object> res:rs){
			
					if(res.get("affiliation").equals(dest)){
				 	 isaff=true;
				 	 break;
					} 
				}
				 
			} 
			
		if(!isaff){
			return 0;
			//this could be both because it is a name or because the group has not been starting yet
		}else{
	 	int max=0;
		
		sql = "SELECT  affiliation, MAX(setid) FROM CISPACES_INFOND " +
		      " GROUP BY affiliation ";
		//System.out.println(sql+ " ");
		rs=dbcn.execSQL(sql);
		 
		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> res:rs){
	
				if(res.get("affiliation").equals(dest)){
					max = (int) res.get("2");
				} 
			}
		} 
		
		int res=0;
		
		sql = "SELECT  affiliation, MAX(lastset) FROM CISPACES_INFOTMP " +
		      " GROUP BY affiliation ";
		//System.out.println(sql+ " ");
	    rs=dbcn.execSQL(sql);
		 
		if(rs!=null && rs.size()>0){
				for(HashMap<String, Object> chk:rs){
				if(chk.get("affiliation").equals(dest)){
			 	res = (int) chk.get("2");
				} 
			}
		} 
		if(res>max){
			max=res;
		}
		max++;
		return max;
		}
	}

	public void setUserDefault() {
		String sql;
		sql = "SELECT * FROM CISPACES_INFOTMP" +
		      " WHERE username = 'b0f9f703-844c-4b70-aaaa-897d204fc24e' AND affiliation='99d42973-d0ba-4082-88f8-dcc2522cf796'";
		//System.out.println(sql+ " ");
		ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
		 
		if(rs!=null && rs.size()>0){
				 
				//do nothing
			}else{
				User user=new User();
				user.setUser("b0f9f703-844c-4b70-aaaa-897d204fc24e");
				user.setTime(System.currentTimeMillis());
				user.setAff("99d42973-d0ba-4082-88f8-dcc2522cf796");
				user.setLastset(0);
				String query="INSERT INTO CISPACES_INFOTMP (username, lasttime, affiliation, lastset) VALUES "
						+ "( '"+user.getUser()+"' ,"
						+ " '"+user.getTime()+"' ,"
						+ " '"+user.getAff()+"' ,"
						+ " "+user.getLastset()+" "
							+ " )";
				//System.out.println(query);
				dbcn.updateSQL(query);
			}
			 
		 
		
	}

	public void closeDataBase() {
		dbcn.forceClose();
		
	}

 

	
	

	 


 

}



