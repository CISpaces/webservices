package provncontrol.pdatastr;

public class TPref {
	private String ndA;
	private String ndB;
	private String elemA;
	private String elemB;
	private TPref pdA;
	private TPref pdB;
	public TPref(String A,String B, String C, String D) {
		//A more preferred 
		//B less preferred
		 ndA=A;
		 ndB=B;
		 elemA=C;
		 elemB=D;
	}
	public TPref(String A,String B) {
		 ndA=A;
		 ndB=B;
		 elemA=null;
		 elemB=null;
	}
	
	public TPref(TPref p_left, TPref p_right, String n1, String n2) {
		 pdA=p_left;
		 pdB=p_right;
		 elemA=n1;
		 elemB=n2;
	}
	public String getNdA() {
		return ndA;
	}
	public void setNdA(String ndA) {
		this.ndA = ndA;
	}
	public String getNdB() {
		return ndB;
	}
	public void setNdB(String ndB) {
		this.ndB = ndB;
	}
	public String getElemA() {
		return elemA;
	}
	public void setElemA(String elemA) {
		this.elemA = elemA;
	}
	public String getElemB() {
		return elemB;
	}
	public void setElemB(String elemB) {
		this.elemB = elemB;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TPref))
             return false;
        TPref cc=(TPref)obj;
        if(cc.ndB.equals(ndB) && cc.ndA.equals(ndA) && cc.elemB.equals(elemB) && cc.elemA.equals(elemA)){
        	//System.out.println("Is this call ever");
        	return true;
        }else{
        	return false;
        }
        
	}
	
	
	@Override
	public String toString(){
		return elemA+"<"+elemB+"<"+ndA+"<"+ndB;
	}
	public TPref getPdA() {
		return pdA;
	}
	public void setPdA(TPref pdA) {
		this.pdA = pdA;
	}
	public TPref getPdB() {
		return pdB;
	}
	public void setPdB(TPref pdB) {
		this.pdB = pdB;
	}
	

}
