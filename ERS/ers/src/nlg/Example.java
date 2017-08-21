package nlg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodes",
    "edges",
    "node_pos"
})
public class Example {

    @JsonProperty("nodes")
    private List<Node> nodes = null;
    @JsonProperty("edges")
    private List<Edge> edges = null;
    @JsonProperty("node_pos")
    private NodePos nodePos;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nodes")
    public List<Node> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @JsonProperty("edges")
    public List<Edge> getEdges() {
        return edges;
    }

    @JsonProperty("edges")
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @JsonProperty("node_pos")
    public NodePos getNodePos() {
        return nodePos;
    }

    @JsonProperty("node_pos")
    public void setNodePos(NodePos nodePos) {
        this.nodePos = nodePos;
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
		return "Example [nodes=" + nodes + ", edges=" + edges + ", nodePos=" + nodePos + ", additionalProperties="
				+ additionalProperties + "]";
	}

    
}
