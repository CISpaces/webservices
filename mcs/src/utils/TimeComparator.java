package utils;

import java.util.Comparator;

import org.joda.time.DateTime;

 


public class TimeComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		//return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second. 
		//o1<o2 return int<0
		//o1=o2 return 0
		//o1>o2 return int>0
		String[] t1=(String[]) o1;
		String[] t2=(String[]) o2;
	    //compareTo in date 
		//the value 0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; 
		//and a value greater than 0 if this Date is after the Date argument.
		//return t1.getTimestamp().compareTo(t2.getTimestamp());
		
		String dtg1=t1[2];
		String dtg2=t2[2];
		TimeExtender timex=new TimeExtender();
		DateTime date1=timex.parseToDateCIS(dtg1);
		DateTime date2=timex.parseToDateCIS(dtg2);
		
		
		
		
		if(date1.compareTo(date2)<0){
			//System.out.println("min"+t1.getTimestamp()+""+t2.getTimestamp());
			return -1;
		}else {if(date1.compareTo(date2)==0){
			return 0;
		}else {
			//System.out.println("mag"+t1.getTimestamp()+""+t2.getTimestamp());
			return 1;
		}}
	}

}
