
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
    "pageContent",
    "pageNumber",
    "totalElements",
    "totalPages"
})
public class ScoringResults {

    @JsonProperty("pageContent")
    private List<PageContent> pageContent = new ArrayList<PageContent>();
    @JsonProperty("pageNumber")
    private int pageNumber;
    @JsonProperty("totalElements")
    private int totalElements;
    @JsonProperty("totalPages")
    private int totalPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScoringResults() {
    }

    /**
     * 
     * @param totalElements
     * @param pageNumber
     * @param pageContent
     * @param totalPages
     */
    public ScoringResults(List<PageContent> pageContent, int pageNumber, int totalElements, int totalPages) {
        super();
        this.pageContent = pageContent;
        this.pageNumber = pageNumber;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    @JsonProperty("pageContent")
    public List<PageContent> getPageContent() {
        return pageContent;
    }

    @JsonProperty("pageContent")
    public void setPageContent(List<PageContent> pageContent) {
        this.pageContent = pageContent;
    }

    public ScoringResults withPageContent(List<PageContent> pageContent) {
        this.pageContent = pageContent;
        return this;
    }

    @JsonProperty("pageNumber")
    public int getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ScoringResults withPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    @JsonProperty("totalElements")
    public int getTotalElements() {
        return totalElements;
    }

    @JsonProperty("totalElements")
    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public ScoringResults withTotalElements(int totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    @JsonProperty("totalPages")
    public int getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ScoringResults withTotalPages(int totalPages) {
        this.totalPages = totalPages;
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

    public ScoringResults withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
