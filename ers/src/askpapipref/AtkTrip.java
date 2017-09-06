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
 * @since 		November 2014           
 *   
 */



package askpapipref;

public class AtkTrip {
	private String argument;
	private String where;
	public AtkTrip() {
		argument="";
		where="";
		
	}

	public AtkTrip(String a,String w) {
		argument=a;
		where=w;
	}
	
	
	
	@Override
	public boolean equals(Object o){
	    if(o instanceof AtkTrip){
	    	AtkTrip toCompare = (AtkTrip) o;
	        if(this.argument.equals(toCompare.getArgument()) && this.where.equals(toCompare.getWhere())){
	        	return true;
	        }
	    }
	    return false;
	}





	public String getArgument() {
		return argument;
	}





	public void setArgument(String argument) {
		this.argument = argument;
	}





	public String getWhere() {
		return where;
	}





	public void setWhere(String where) {
		this.where = where;
	}
	
	
	public String toString(){
		return argument+"("+where+")";
	}
}
