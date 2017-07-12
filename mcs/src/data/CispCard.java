package data;

import java.util.ArrayList;
import java.util.HashMap;

public class CispCard {
public ArrayList sources;
public boolean to_cispaces;
public String nodeID;
public String forwarded_from;
public Rationale[] rationale;

public CispCard(ArrayList sources, boolean to_cispaces, String nodeID, String forwarded_from, Rationale[] rationale) {
	this.sources = sources;
	this.to_cispaces = to_cispaces;
	this.nodeID = nodeID;
	this.forwarded_from=forwarded_from;
	this.rationale=rationale;
}


}
