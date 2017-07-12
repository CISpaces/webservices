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
import java.sql.Connection;
 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

 


public class DBConnect {

		private static Logger log;
		
		private Connection dbCon;
 

		public DBConnect(){
		//	System.out.println("-"+dbURL+"-"+ dbDriver+"-"+ dbUname+"-"+dbPass+"-");

			log=Logger.getLogger(getClass().getName());
		}

		private synchronized boolean connect(){
			try {
	            Context initContext = new InitialContext();
	            Context envContext = (Context) initContext.lookup("java:/comp/env");
	            javax.sql.DataSource dataSource = (javax.sql.DataSource) envContext.lookup("jdbc/myDB");
	            dbCon = dataSource.getConnection();
	            return true;
	            
	        } catch (NamingException | SQLException e) {
	        	log.log(Level.SEVERE,"GAIAN DB CONNECTION",e);
	            e.printStackTrace();
	            return false;
	        }
		}

	 

		public synchronized ArrayList<HashMap<String,Object>> execSQL(String sql){
			ArrayList<HashMap<String,Object>> result = null;
			ResultSet rs = null;
			Statement s = null;
			try{
				connect();
				s= dbCon.createStatement();
				rs= s.executeQuery(sql);
		 
			result=convertResultSetToList(rs);
			
			}catch(Exception e){
				log.log(Level.SEVERE,"GAIAN DB CONNECTION",e);
				
			}finally{
			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    if (s != null) {
			        try {
			            s.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    if (dbCon != null) {
			        try {
			        	dbCon.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			}
			return result;
		}
		
		public synchronized boolean updateSQL(String sql){
			boolean res=false;
			Statement s = null;
			try{
				connect();
				s = dbCon.createStatement();
				//System.out.println(sql);
				s.executeUpdate(sql);
		
				res=true;
			}catch(Exception e){
				log.log(Level.SEVERE,"GAIAN DB CONNECTION",e);
				res=false;
			}finally{
			    if (s != null) {
			        try {
			            s.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    if (dbCon != null) {
			        try {
			        	dbCon.close();
			        } catch (SQLException e) { /* ignored */}
			    } 
			}
			return res;
		}
		
		public synchronized void insertClob(String updateStatement, String clob){
			//only one update per query!!!
			PreparedStatement ps = null;
			 try{
			connect();
			 ps = dbCon.prepareStatement(updateStatement);
				      ps.setString(1,clob); 
				      ps.executeUpdate();
				      ps.close();
			 }catch(Exception e){
					log.log(Level.SEVERE,"GAIAN DB CONNECTION",e);
				}
			 finally{
				
				    if (ps != null) {
				        try {
				            ps.close();
				        } catch (SQLException e) { /* ignored */}
				    }
				    if (dbCon != null) {
				        try {
				        	dbCon.close();
				        } catch (SQLException e) { /* ignored */}
				    }
			 }
			
		}
		
		public synchronized boolean existTable(String table){
			Statement s = null;
			boolean res=false;
			ResultSet rs = null;
			try {
				connect();
				String sql= "SELECT * FROM "+table;
				s=dbCon.createStatement();
				rs= s.executeQuery(sql);
		 
			
			// check if "employee" table is there
				if(rs!=null){
					res=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.log(Level.INFO,"TABLE NOT FOUND");
				res=false;
			} finally {
				   if (rs != null) {
				        try {
				            rs.close();
				        } catch (SQLException e) { /* ignored */}
				    }
				    if (s != null) {
				        try {
				           s.close();
				        } catch (SQLException e) { /* ignored */}
				    }
				    if (dbCon != null) {
				        try {
				        	dbCon.close();
				        } catch (SQLException e) { /* ignored */}
				    }
			 
			}
			//System.out.println(res);
			return res;
		}

		public boolean tryConnect(){
			boolean test=connect();
			if (dbCon != null) {
		        try {
		        	dbCon.close();
		        } catch (SQLException e) { /* ignored */}
		    }
			return test;
		} 
	
		private ArrayList<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
		    ResultSetMetaData md = rs.getMetaData();
		    int columns = md.getColumnCount();
		    ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

		    while (rs.next()) {
		        HashMap<String,Object> row = new HashMap<String, Object>(columns);
		        for(int i=1; i<=columns; ++i) {
		        	//import org.apache.derby.client.am.Clob;
		        	Object test=rs.getObject(i);
		        	if(test instanceof java.sql.Clob){
		        		test=rs.getString(i);
		        	}
		            row.put(md.getColumnName(i).toLowerCase(),test);
		        }
		        list.add(row);
		    }

		    return list;
		}

		 

		public void forceClose() {
			 if (dbCon != null) {
			        try {
			        	dbCon.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			
		}
	    
	   

}


/*
 * A database connection pool creates and manages a pool of connections to a database. Recycling and reusing already existing connections to a database is more efficient than opening a new connection.

There is one problem with connection pooling. A web application has to explicitly close ResultSet's, Statement's, and Connection's. Failure of a web application to close these resources can result in them never being available again for reuse, a database connection pool "leak". This can eventually result in your web application database connections failing if there are no more available connections.

There is a solution to this problem. The Apache Commons DBCP can be configured to track and recover these abandoned database connections. Not only can it recover them, but also generate a stack trace for the code which opened these resources and never closed them.

To configure a DBCP DataSource so that abandoned database connections are removed and recycled add the following attribute to the Resource configuration for your DBCP DataSource:

removeAbandoned="true"
When available database connections run low DBCP will recover and recycle any abandoned database connections it finds. The default is false.

Use the removeAbandonedTimeout attribute to set the number of seconds a database connection has been idle before it is considered abandoned.

removeAbandonedTimeout="60"
The default timeout for removing abandoned connections is 300 seconds.

The logAbandoned attribute can be set to true if you want DBCP to log a stack trace of the code which abandoned the database connection resources.

logAbandoned="true"
The default is false.
*/
