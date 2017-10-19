package provncontrol.pdatastr;

import java.util.ArrayList;

public class Couple {

	public double val;
	public String element;

	public Couple(String el, int vl) {
		element=el;
		val=(double)vl;
	}
	public Couple(String el, double vl) {
		element=el;
		val=vl;
	}
	public Couple(ArrayList array) {
		element=(String) array.get(0);
		val=(int) array.get(1);
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}
	
	public ArrayList toArray(){
		ArrayList list=new ArrayList();
		list.add(element);	
		list.add(val);
		return list;
	
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Couple))
             return false;
        Couple cc=(Couple)obj;
        if(cc.element.equals(element) && cc.val==val){
        	return true;
        }else{
        	return false;
        }
        
	}
	
	@Override
	public String toString(){
		return element+":"+val;
	}
	
	

}
