package utils;

import java.util.Comparator;

import provncontrol.pdatastr.Couple;





public class OrdComparator implements Comparator{
 
	public int compare(Object o1, Object o2) {
		//return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second. 
		//o1<o2 return int<0
		//o1=o2 return 0
		//o1>o2 return int>0
		Couple t1=(Couple) o1;
		Couple t2=(Couple) o2;
	    //compareTo in date 
		//the value 0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; 
		//and a value greater than 0 if this Date is after the Date argument.
		//return t1.getTimestamp().compareTo(t2.getTimestamp());
 
		if(t1.getVal()<t2.getVal()){
			//System.out.println("min"+t1.getTimestamp()+""+t2.getTimestamp());
			return -1;
		}else {if(t1.getVal()==t2.getVal()){
			return 0;
		}else {
			//System.out.println("mag"+t1.getTimestamp()+""+t2.getTimestamp());
			return 1;
		}}
		
	}
	
	 
}
