
package jsonfactory.models.request.scoreOrganization;

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
    "businessPartnership",
    "competitor",
    "ownership",
    "supplier"
})
public class Weights {

    @JsonProperty("businessPartnership")
    private Double businessPartnership;
    @JsonProperty("competitor")
    private Double competitor;
    @JsonProperty("ownership")
    private Double ownership;
    @JsonProperty("supplier")
    private Double supplier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weights() {
    }

    /**
     * 
     * @param ownership
     * @param businessPartnership
     * @param competitor
     * @param supplier
     */
    public Weights(Double businessPartnership, Double competitor, Double ownership, Double supplier) {
        super();
        this.businessPartnership = businessPartnership;
        this.competitor = competitor;
        this.ownership = ownership;
        this.supplier = supplier;
    }

    @JsonProperty("businessPartnership")
    public Double getBusinessPartnership() {
        return businessPartnership;
    }

    @JsonProperty("businessPartnership")
    public void setBusinessPartnership(Double businessPartnership) {
        this.businessPartnership = businessPartnership;
    }

    public Weights withBusinessPartnership(Double businessPartnership) {
        this.businessPartnership = businessPartnership;
        return this;
    }

    @JsonProperty("competitor")
    public Double getCompetitor() {
        return competitor;
    }

    @JsonProperty("competitor")
    public void setCompetitor(Double competitor) {
        this.competitor = competitor;
    }

    public Weights withCompetitor(Double competitor) {
        this.competitor = competitor;
        return this;
    }

    @JsonProperty("ownership")
    public Double getOwnership() {
        return ownership;
    }

    @JsonProperty("ownership")
    public void setOwnership(Double ownership) {
        this.ownership = ownership;
    }

    public Weights withOwnership(Double ownership) {
        this.ownership = ownership;
        return this;
    }

    @JsonProperty("supplier")
    public Double getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(Double supplier) {
        this.supplier = supplier;
    }

    public Weights withSupplier(Double supplier) {
        this.supplier = supplier;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Weights withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
