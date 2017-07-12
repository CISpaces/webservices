package data;

import java.util.ArrayList;

public class Rationale {
public ArrayList premises;
public ArrayList conclusions;
public String rule_name;

public Rationale(ArrayList premises, ArrayList conclusions, String rule_name) {
 
	this.premises = premises;
	this.conclusions = conclusions;
	this.rule_name = rule_name;
}

}
