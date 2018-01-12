
package jsonfactory.models.request.scoreOrganization;

import java.util.ArrayList;
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
    "organizationUris",
    "weights"
})
public class ScoreOrganization {

    @JsonProperty("organizationUris")
    private List<String> organizationUris = new ArrayList<String>();
    @JsonProperty("weights")
    private Weights weights;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScoreOrganization() {
    }

    /**
     * 
     * @param weights
     * @param organizationUris
     */
    public ScoreOrganization(List<String> organizationUris, Weights weights) {
        super();
        this.organizationUris = organizationUris;
        this.weights = weights;
    }

    @JsonProperty("organizationUris")
    public List<String> getOrganizationUris() {
        return organizationUris;
    }

    @JsonProperty("organizationUris")
    public void setOrganizationUris(List<String> organizationUris) {
        this.organizationUris = organizationUris;
    }

    public ScoreOrganization withOrganizationUris(List<String> organizationUris) {
        this.organizationUris = organizationUris;
        return this;
    }

    @JsonProperty("weights")
    public Weights getWeights() {
        return weights;
    }

    @JsonProperty("weights")
    public void setWeights(Weights weights) {
        this.weights = weights;
    }

    public ScoreOrganization withWeights(Weights weights) {
        this.weights = weights;
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

    public ScoreOrganization withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
