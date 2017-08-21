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
    "prem",
    "cqs",
    "id",
    "assump"
})
public class _83383de0E63a4e939a44025b65e41e53_ {

    @JsonProperty("prem")
    private List<String> prem = null;
    @JsonProperty("cqs")
    private List<Object> cqs = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("assump")
    private List<Object> assump = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("prem")
    public List<String> getPrem() {
        return prem;
    }

    @JsonProperty("prem")
    public void setPrem(List<String> prem) {
        this.prem = prem;
    }

    @JsonProperty("cqs")
    public List<Object> getCqs() {
        return cqs;
    }

    @JsonProperty("cqs")
    public void setCqs(List<Object> cqs) {
        this.cqs = cqs;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("assump")
    public List<Object> getAssump() {
        return assump;
    }

    @JsonProperty("assump")
    public void setAssump(List<Object> assump) {
        this.assump = assump;
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
		return "_83383de0E63a4e939a44025b65e41e53_ [prem=" + prem + ", cqs=" + cqs + ", id=" + id + ", assump=" + assump
				+ ", additionalProperties=" + additionalProperties + "]";
	}

    
}
