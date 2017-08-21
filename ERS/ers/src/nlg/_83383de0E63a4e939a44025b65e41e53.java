package nlg;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cqs",
    "conc",
    "id"
})
public class _83383de0E63a4e939a44025b65e41e53 {

    @JsonProperty("cqs")
    private List<Object> cqs = null;
    @JsonProperty("conc")
    private List<String> conc = null;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cqs")
    public List<Object> getCqs() {
        return cqs;
    }

    @JsonProperty("cqs")
    public void setCqs(List<Object> cqs) {
        this.cqs = cqs;
    }

    @JsonProperty("conc")
    public List<String> getConc() {
        return conc;
    }

    @JsonProperty("conc")
    public void setConc(List<String> conc) {
        this.conc = conc;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
		return "_83383de0E63a4e939a44025b65e41e53 [cqs=" + cqs + ", conc=" + conc + ", id=" + id
				+ ", additionalProperties=" + additionalProperties + "]";
	}

    
}
