
package jsonfactory.models.response.scoringResults;

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
    "id",
    "company",
    "createdDate",
    "lastUpdatedDate",
    "source",
    "organizations",
    "relevanceScore",
    "title",
    "relationType"
})
public class PageContent {

    @JsonProperty("id")
    private String id;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    @JsonProperty("source")
    private String source;
    @JsonProperty("organizations")
    private List<Organization> organizations = new ArrayList<Organization>();
    @JsonProperty("relevanceScore")
    private double relevanceScore;
    @JsonProperty("title")
    private String title;
    @JsonProperty("relationType")
    private String relationType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PageContent() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param relationType
     * @param source
     * @param organizations
     * @param company
     * @param relevanceScore
     * @param lastUpdatedDate
     * @param createdDate
     */
    public PageContent(String id, Company company, String createdDate, String lastUpdatedDate, String source, List<Organization> organizations, double relevanceScore, String title, String relationType) {
        super();
        this.id = id;
        this.company = company;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.source = source;
        this.organizations = organizations;
        this.relevanceScore = relevanceScore;
        this.title = title;
        this.relationType = relationType;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public PageContent withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    public PageContent withCompany(Company company) {
        this.company = company;
        return this;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public PageContent withCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    @JsonProperty("lastUpdatedDate")
    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @JsonProperty("lastUpdatedDate")
    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public PageContent withLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public PageContent withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("organizations")
    public List<Organization> getOrganizations() {
        return organizations;
    }

    @JsonProperty("organizations")
    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public PageContent withOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
        return this;
    }

    @JsonProperty("relevanceScore")
    public double getRelevanceScore() {
        return relevanceScore;
    }

    @JsonProperty("relevanceScore")
    public void setRelevanceScore(double relevanceScore) {
        this.relevanceScore = relevanceScore;
    }

    public PageContent withRelevanceScore(double relevanceScore) {
        this.relevanceScore = relevanceScore;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public PageContent withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("relationType")
    public String getRelationType() {
        return relationType;
    }

    @JsonProperty("relationType")
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public PageContent withRelationType(String relationType) {
        this.relationType = relationType;
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

    public PageContent withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
