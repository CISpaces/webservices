package askpapipref;

public class Pref {
		private String right;
		private String left;
		private String pred;
		private String id;
		private String oppid;
		private String complete_pred;
		public Pref(String a,String b,String p,String i, String opp){
			left=a;
			right=b;
			pred=p;
			id=i;
			oppid=opp;
		}
		public String getRight() {
			return right;
		}
		public void setRight(String right) {
			this.right = right;
		}
		public String getLeft() {
			return left;
		}
		public void setLeft(String left) {
			this.left = left;
		}
		public String getPred() {
			return pred;
		}
		public void setPred(String pred) {
			this.pred = pred;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		@Override
		public boolean equals(Object obj) {
		       if (! (obj instanceof Pref) ) return false;

		       final Pref other = (Pref) obj;
		       if (pred != other.pred)
		           return false;
		       return true;
		   }
		public String getOppid() {
			return oppid;
		}
		public void setOppid(String oppid) {
			this.oppid = oppid;
		}
		
		public String toString(){
			return "["+id+":"+pred+"]";
		}
		public String getComplete_pred() {
			return complete_pred;
		}
		public void setComplete_pred(String complete_pred) {
			this.complete_pred = complete_pred;
		}
}
