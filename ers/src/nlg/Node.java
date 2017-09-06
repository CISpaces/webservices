package nlg;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "uncert",
    "eval",
    "text",
    "input",
    "dtg",
    "commit",
    "type",
    "nodeID",
    "annot"
})
public class Node{

    @JsonProperty("source")
    private String source;
    @JsonProperty("uncert")
    private String uncert;
    @JsonProperty("eval")
    private String eval = "null";
    @JsonProperty("text")
    private String text;
    @JsonProperty("input")
    private String input = "null";
    @JsonProperty("dtg")
    private String dtg;
    @JsonProperty("commit")
    private String commit;
    @JsonProperty("type")
    private String type;
    @JsonProperty("nodeID")
    private String nodeID;
    @JsonProperty("annot")
    private Annot annot;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("uncert")
    public String getUncert() {
        return uncert;
    }

    @JsonProperty("uncert")
    public void setUncert(String uncert) {
        this.uncert = uncert;
    }

    @JsonProperty("eval")
    public String getEval() {
        return eval;
    }

    @JsonProperty("eval")
    public void setEval(String eval) {
        this.eval = eval;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("input")
    public String getInput() {
        return input;
    }
    
    

    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }
    
    @JsonProperty("dtg")
    public String getDtg() {
        return dtg;
    }

    @JsonProperty("dtg")
    public void setDtg(String dtg) {
        this.dtg = dtg;
    }

    @JsonProperty("commit")
    public String getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(String commit) {
        this.commit = commit;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("nodeID")
    public String getNodeID() {
        return nodeID;
    }

    @JsonProperty("nodeID")
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    @JsonProperty("annot")
    public Annot getAnnot() {
        return annot;
    }

    @JsonProperty("annot")
    public void setAnnot(Annot annot) {
        this.annot = annot;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
	public String toString() {
		return "Node [source=" + source + ", uncert=" + uncert + ", eval=" + eval + ", text=" + text + ", input="
				+ input + ", dtg=" + dtg + ", commit=" + commit + ", type=" + type + ", nodeID=" + nodeID + ", annot="
				+ annot + ", additionalProperties=" + additionalProperties + "]" +"\n";
	}

	
	
    
   
}
