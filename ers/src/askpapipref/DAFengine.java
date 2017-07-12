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
 
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

import net.sf.jargsemsat.datastructures.DungAF;
public class DAFengine implements AFengine{
private   DungAF dunaf;
	public DAFengine(ArrayList args, ArrayList atks) {
	//	 System.out.println(args+":"+atks);
		dunaf=new DungAF(args,atks);
		//contains all the arguments for Engine as Strings[2] (head, tail) in a ArrayList 
				// and two-element String-arrays ([attacker, attacked])

	}
   
	
	 
 
	
	
	
	public HashSet<HashSet<String>> evaluatePreferred(){
		long startTime = System.currentTimeMillis();
		HashSet<HashSet<String>> pippo=dunaf.getPreferredExts();
		 //	Iterator iter=pippo.iterator();
	/*	System.out.println("\n\n*** Your preferred extensions are:");
		Iterator it;
		while(iter.hasNext()){
			it=((HashSet<String>) iter.next()).iterator();
			while(it.hasNext())
			System.out.print(" "+it.next());
			System.out.println(" and ");
		} */
		//long endTime   = System.currentTimeMillis();
	//	long totalTime = endTime - startTime;
		//System.out.println(totalTime);
		return pippo;
	}
	
 
}
