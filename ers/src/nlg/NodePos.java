package nlg;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "07be8c64-214e-48cf-99d1-fbd55b4362b9",
    "3f907368-27d2-4630-b31c-ed744d8b0b88",
    "0e47686c-67ee-4008-a8cb-6689e116b17a",
    "83383de0-e63a-4e93-9a44-025b65e41e53"
})
public class NodePos {

    @JsonProperty("07be8c64-214e-48cf-99d1-fbd55b4362b9")
    private List<Double> _07be8c64214e48cf99d1Fbd55b4362b9 = null;
    @JsonProperty("3f907368-27d2-4630-b31c-ed744d8b0b88")
    private List<Double> _3f90736827d24630B31cEd744d8b0b88 = null;
    @JsonProperty("0e47686c-67ee-4008-a8cb-6689e116b17a")
    private List<Double> _0e47686c67ee4008A8cb6689e116b17a = null;
    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    private List<Double> _83383de0E63a4e939a44025b65e41e53 = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("07be8c64-214e-48cf-99d1-fbd55b4362b9")
    public List<Double> get07be8c64214e48cf99d1Fbd55b4362b9() {
        return _07be8c64214e48cf99d1Fbd55b4362b9;
    }

    @JsonProperty("07be8c64-214e-48cf-99d1-fbd55b4362b9")
    public void set07be8c64214e48cf99d1Fbd55b4362b9(List<Double> _07be8c64214e48cf99d1Fbd55b4362b9) {
        this._07be8c64214e48cf99d1Fbd55b4362b9 = _07be8c64214e48cf99d1Fbd55b4362b9;
    }

    @JsonProperty("3f907368-27d2-4630-b31c-ed744d8b0b88")
    public List<Double> get3f90736827d24630B31cEd744d8b0b88() {
        return _3f90736827d24630B31cEd744d8b0b88;
    }

    @JsonProperty("3f907368-27d2-4630-b31c-ed744d8b0b88")
    public void set3f90736827d24630B31cEd744d8b0b88(List<Double> _3f90736827d24630B31cEd744d8b0b88) {
        this._3f90736827d24630B31cEd744d8b0b88 = _3f90736827d24630B31cEd744d8b0b88;
    }

    @JsonProperty("0e47686c-67ee-4008-a8cb-6689e116b17a")
    public List<Double> get0e47686c67ee4008A8cb6689e116b17a() {
        return _0e47686c67ee4008A8cb6689e116b17a;
    }

    @JsonProperty("0e47686c-67ee-4008-a8cb-6689e116b17a")
    public void set0e47686c67ee4008A8cb6689e116b17a(List<Double> _0e47686c67ee4008A8cb6689e116b17a) {
        this._0e47686c67ee4008A8cb6689e116b17a = _0e47686c67ee4008A8cb6689e116b17a;
    }

    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    public List<Double> get83383de0E63a4e939a44025b65e41e53() {
        return _83383de0E63a4e939a44025b65e41e53;
    }

    @JsonProperty("83383de0-e63a-4e93-9a44-025b65e41e53")
    public void set83383de0E63a4e939a44025b65e41e53(List<Double> _83383de0E63a4e939a44025b65e41e53) {
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
		return "NodePos [_07be8c64214e48cf99d1Fbd55b4362b9=" + _07be8c64214e48cf99d1Fbd55b4362b9
				+ ", _3f90736827d24630B31cEd744d8b0b88=" + _3f90736827d24630B31cEd744d8b0b88
				+ ", _0e47686c67ee4008A8cb6689e116b17a=" + _0e47686c67ee4008A8cb6689e116b17a
				+ ", _83383de0E63a4e939a44025b65e41e53=" + _83383de0E63a4e939a44025b65e41e53 + ", additionalProperties="
				+ additionalProperties + "]"+"\n";
	}
    
    

}

