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
    "83383de0-e63a-4e93-9a44-025b65e41e53"
})
public class PremAssump {

    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    private _83383de0E63a4e939a44025b65e41e53_ _83383de0E63a4e939a44025b65e41e53;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    public _83383de0E63a4e939a44025b65e41e53_ get83383de0E63a4e939a44025b65e41e53() {
        return _83383de0E63a4e939a44025b65e41e53;
    }

    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    public void set83383de0E63a4e939a44025b65e41e53(_83383de0E63a4e939a44025b65e41e53_ _83383de0E63a4e939a44025b65e41e53) {
        this._83383de0E63a4e939a44025b65e41e53 = _83383de0E63a4e939a44025b65e41e53;
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
		return "PremAssump [_83383de0E63a4e939a44025b65e41e53=" + _83383de0E63a4e939a44025b65e41e53
				+ ", additionalProperties=" + additionalProperties + "]";
	}

    
}
