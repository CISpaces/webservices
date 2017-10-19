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
		Extension for the provenance analysis
 */
package database;

import java.util.ArrayList;
import java.util.HashMap;

import provncontrol.pdatastr.Couple;

public class DBNQuery extends DBQuery{

	
	
	public DBNQuery(String ps){
		super(ps);
	}
	
	
	//*******************************************************************************TABLES!!
	  
		 public void createTableProvEleme() {
				String query="CREATE TABLE CISPACES_PELEM ( username VARCHAR (255), element VARCHAR (255), value INT, type SMALLINT, ";
				query+="CONSTRAINT CISPACES_PELEM_pk PRIMARY KEY (username,element))";
				dbcn.updateSQL(query);
		 }
		 
		 public void createTableProvPathExisting() {
				String query="CREATE TABLE CISPACES_PEXIST ( username VARCHAR (255), arg VARCHAR (1000),   ";
				query+="CONSTRAINT CISPACES_PEXIST_pk PRIMARY KEY (username,arg))";
				dbcn.updateSQL(query);
		 }
		 
		 
		 public void createTablePaths() {
				String query="CREATE TABLE CISPACES_PATHS (username VARCHAR (255), ndid VARCHAR (255), pathid VARCHAR (255), title VARCHAR (255), hint VARCHAR (255), arg VARCHAR (1000),"
						+ "prem1 VARCHAR (550), prem2 VARCHAR (500), used SMALLINT, ";
				query+="CONSTRAINT CISPACES_PATHS_pk PRIMARY KEY (ndid,pathid))";
				dbcn.updateSQL(query);
		 }
	
	
			
	//******************************************************************OTHER QUERIES
			
		 public void insertPaths(String wboxid,String node,String id, String title, String hint, String p1, String p2,  String arg){
			 String sql;
				sql = "SELECT * FROM CISPACES_PEXIST " +
					      " WHERE username = '"+wboxid+"' AND arg = '"+p2+"' ";
				// username, affiliation, curshared, wboxid, curindivid
				 
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
				int used=0;
				if(rs!=null && rs.size()>0){
					used=1;
				}
				arg=arg.replaceAll("'","''");
				hint=hint.replaceAll("'","''");
				p1=p1.replaceAll("'","''");
			String query="INSERT INTO CISPACES_PATHS (username, ndid, pathid, title, hint, arg, prem1, prem2,   used) VALUES "
					+ "( '"+wboxid+"' ,"
					+ " '"+node+"' ,"
					+ " '"+id+"' ,"
					+ " '"+title+"' ,"
					+ " '"+hint+"' ,"
					+ " '"+arg+"' ,"
					+ " '"+p1+"' ,"
					+ " '"+p2+"' ,"
					+ " "+used+" "
							+ " )";
			//System.out.println(query);
			dbcn.updateSQL(query);
			 
		 }
		 
			public ArrayList getPaths(String node, String wboxid) {
				ArrayList array=new ArrayList();
				String arg=null;
				String sql;
				sql = "SELECT pathid FROM CISPACES_PATHS" +
					      " WHERE ndid = '"+node+"' AND username = '"+wboxid+"'";
				// username, affiliation, curshared, wboxid, curindivid
				 
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

				if(rs!=null && rs.size()>0){
					
						for(HashMap<String, Object> res:rs){
						
						
							
							arg=(String) res.get("pathid");
							array.add(arg);
						//System.out.println("jj");
						}
					 
						
						 
				} 
				return array;
			
		}
			
			public ArrayList getInfoPathUnused(String wboxid,String node) {
				ArrayList array=null;
				 
				String sql;
				sql = "SELECT pathid, title, hint, arg FROM CISPACES_PATHS" +
					      " WHERE ndid = '"+node+"' AND used=0 AND username = '"+wboxid+"'";
				// username, affiliation, curshared, wboxid, curindivid
				// System.out.println(sql);
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

				if(rs!=null && rs.size()>0){
					array=new ArrayList();
						for(HashMap<String, Object> res:rs){
							HashMap str=new HashMap();
							str.put("pathid", res.get("pathid"));
							str.put("title",res.get("title"));
							str.put("hint",res.get("hint"));
							str.put("hint",res.get("arg"));
							array.add(str);
						//System.out.println("jj");
						}
					
				
						 
				} 
		 
				return array;
			
		}
			
			 
			public String[] getppc(String wboxid, String node, String pid) {
				 
				
				String[] arg=null;
				String sql;
				sql = "SELECT prem1,prem2 FROM CISPACES_PATHS" +
				      " WHERE pathid = '"+pid+"' AND ndid = '"+node+"' AND username = '"+wboxid+"'";
				// username, affiliation, curshared, wboxid, curindivid
				 
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);

				if(rs!=null && rs.size()>0){
					HashMap<String, Object> res=rs.get(0);
							arg=new String[2];
							arg[0]=(String) res.get("prem1");
							arg[1]=(String) res.get("prem2");
						 
						 
						//System.out.println("jj");
						}
			
						sql = " UPDATE CISPACES_PATHS " +
								  " SET used = 1"+
							      " WHERE pathid = '"+pid+"' AND ndid = '"+node+"' AND username = '"+wboxid+"'";
						dbcn.updateSQL(sql);
			
				return arg;
			
		}
	 	public void addPExists(String text, String wboxid) {
				// System.out.println("do I come here?");
				String sql;
				sql = "SELECT * FROM CISPACES_PEXIST " +
					      " WHERE username = '"+wboxid+"' AND arg = '"+text+"' ";
				// username, affiliation, curshared, wboxid, curindivid
				 
				ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
				if(rs!=null && rs.size()>0){
					 
				}else{
					String  query="INSERT INTO CISPACES_PEXIST (username,arg) VALUES "+
							"('"+wboxid+"','"+text+"')"; 
				 	 dbcn.updateSQL(query);
				}
				
				
			} 
			
			public ArrayList[] getPelements(String user) {
				String sql = "SELECT * FROM CISPACES_PELEM" +
					      " WHERE username = '" + user + "' ";
				
				ArrayList<HashMap<String,Object>> rsc=dbcn.execSQL(sql);
				if(rsc!=null && rsc.size()>0){
					ArrayList a=new ArrayList();
					ArrayList b=new ArrayList();
					ArrayList c=new ArrayList();
					for(HashMap<String, Object> res:rsc){
						int type=(int) res.get("type");
						Couple couple=new Couple((String) res.get("element"),(int) res.get("value"));
					 switch(type){
					 case 0:
						 a.add(couple);
						 break;
					 case 1:
						 b.add(couple);
						 break;
					 case 2:
						 c.add(couple);
						 break;
					 }
					}
					ArrayList[] tot=new ArrayList[3];
					tot[0]=a;
					tot[1]=b;
					tot[2]=c;
					return tot;
				}else{
					return null;
				}
				
			}

			public void addPelemTuple(String user, String elem, double max, int type) {
				int mx=(int)Math.round(max);
				String  query="INSERT INTO CISPACES_PELEM (username, element, value, type) VALUES "+
						"('"+user+"','"+elem+"',"+mx+","+type+")"; 
			 	 dbcn.updateSQL(query);
				
			}
			

			public void removePelemTuple(String user, String element) {
				String  query="DELETE FROM CISPACES_PELEM WHERE "+
						"username = '"+user+"' AND element='"+element+"'"; 
			 	 dbcn.updateSQL(query);
			}

			public void removeAllPExisting(String wboxid) {
				String  query="DELETE FROM CISPACES_PEXIST WHERE "+
						"username = '"+wboxid+"' "; 
			 	 dbcn.updateSQL(query);
			}
			 public void updatePelemTuple(String user, String elem, double val, int type) {
					int vl=(int)Math.round(val);
					String sql;
					sql = "SELECT * FROM CISPACES_PELEM " +
						      " WHERE username = '"+user+"' AND element = '"+elem+"' ";
					// username, affiliation, curshared, wboxid, curindivid
					 
					ArrayList<HashMap<String,Object>> rs=dbcn.execSQL(sql);
					if(rs!=null && rs.size()>0){
						String  query="UPDATE CISPACES_PELEM "
								+ " SET value = "+vl+" WHERE "
								+ " username= '"+user+"' AND element='"+elem+"' "; 
					 	 dbcn.updateSQL(query);
					}else{
						addPelemTuple(user,elem,val,type);
					}
					
				}
	
}
