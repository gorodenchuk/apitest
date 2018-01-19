
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
    private String businessPartnership;
    @JsonProperty("competitor")
    private String competitor;
    @JsonProperty("ownership")
    private String ownership;
    @JsonProperty("supplier")
    private String supplier;
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
    public Weights(String businessPartnership, String competitor, String ownership, String supplier) {
        super();
        this.businessPartnership = businessPartnership;
        this.competitor = competitor;
        this.ownership = ownership;
        this.supplier = supplier;
    }

    @JsonProperty("businessPartnership")
    public String getBusinessPartnership() {
        return businessPartnership;
    }

    @JsonProperty("businessPartnership")
    public void setBusinessPartnership(String businessPartnership) {
        this.businessPartnership = businessPartnership;
    }

    public Weights withBusinessPartnership(String businessPartnership) {
        this.businessPartnership = businessPartnership;
        return this;
    }

    @JsonProperty("competitor")
    public String getCompetitor() {
        return competitor;
    }

    @JsonProperty("competitor")
    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public Weights withCompetitor(String competitor) {
        this.competitor = competitor;
        return this;
    }

    @JsonProperty("ownership")
    public String getOwnership() {
        return ownership;
    }

    @JsonProperty("ownership")
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Weights withOwnership(String ownership) {
        this.ownership = ownership;
        return this;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Weights withSupplier(String supplier) {
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
