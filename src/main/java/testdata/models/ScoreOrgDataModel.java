package testdata.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonfactory.models.request.scoreOrganization.ScoreOrganization;
import jsonfactory.models.request.scoreOrganization.Weights;
import java.util.Arrays;
import java.util.List;

public class ScoreOrgDataModel {

    ScoreOrganization scoreOrganization = new ScoreOrganization();
    Weights weights = new Weights();
    ObjectMapper mapper = new ObjectMapper();

    public String modelWithOneOrgUri(Double bussinessPs, Double competitor, Double ownerS, Double supplier)
            throws JsonProcessingException {
        scoreOrganization.setOrganizationUris(Arrays.asList("http://feed.thomsonreuters.com/1-4297034757"));
        weights.setBusinessPartnership(bussinessPs);
        weights.setCompetitor(competitor);
        weights.setOwnership(ownerS);
        weights.setSupplier(supplier);
        scoreOrganization.withWeights(weights);

        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);
        return jsonString;
    }

    public String modelWithListOfOrgs(List<String> organizationUris, Double bussinessPs, Double competitor, Double ownerS, Double supplier)
            throws JsonProcessingException {
        scoreOrganization.setOrganizationUris(organizationUris);
        weights.setBusinessPartnership(bussinessPs);
        weights.setCompetitor(competitor);
        weights.setOwnership(ownerS);
        weights.setSupplier(supplier);
        scoreOrganization.withWeights(weights);

        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);
        return jsonString;
    }


}
