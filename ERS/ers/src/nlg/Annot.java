package nlg;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conc",
    "prem_assump",
    "id"
})
public class Annot {

    @JsonProperty("conc")
    private Conc conc;
    @JsonProperty("prem_assump")
    private PremAssump premAssump;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("conc")
    public Conc getConc() {
        return conc;
    }

    @JsonProperty("conc")
    public void setConc(Conc conc) {
        this.conc = conc;
    }

    @JsonProperty("prem_assump")
    public PremAssump getPremAssump() {
        return premAssump;
    }

    @JsonProperty("prem_assump")
    public void setPremAssump(PremAssump premAssump) {
        this.premAssump = premAssump;
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
		return "Annot [conc=" + conc + ", premAssump=" + premAssump + ", id=" + id + ", additionalProperties="
				+ additionalProperties + "]";
	}

    
}
