package nlg;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "target",
    "source",
    "formEdgeID",
    "edgeID"
})
public class Edge {

    @JsonProperty("target")
    private String toID;
    @JsonProperty("source")
    private String fromID;
    @JsonProperty("formEdgeID")
    private Object formEdgeID;
    @JsonProperty("edgeID")
    private String edgeID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("target")
    public String getToID() {
        return toID;
    }

    @JsonProperty("target")
    public void setToID(String toID) {
        this.toID = toID;
    }

    @JsonProperty("source")
    public String getFromID() {
        return fromID;
    }

    @JsonProperty("source")
    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    @JsonProperty("formEdgeID")
    public Object getFormEdgeID() {
        return formEdgeID;
    }

    @JsonProperty("formEdgeID")
    public void setFormEdgeID(Object formEdgeID) {
        this.formEdgeID = formEdgeID;
    }

    @JsonProperty("edgeID")
    public String getEdgeID() {
        return edgeID;
    }

    @JsonProperty("edgeID")
    public void setEdgeID(String edgeID) {
        this.edgeID = edgeID;
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
		return "Edge [target=" + toID + ", source=" + fromID + ", formEdgeID=" + formEdgeID + ", edgeID=" + edgeID
				+ ", additionalProperties=" + additionalProperties + "]"+"\n";
	}

    
}

