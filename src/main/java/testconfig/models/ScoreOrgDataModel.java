package testconfig.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonfactory.models.request.scoreOrganization.ScoreOrganization;
import jsonfactory.models.request.scoreOrganization.Weights;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ScoreOrgDataModel {

    private static final String BUSSINESSPS = "bussinessPs";
    private static final String COMPETITOR = "competitor";
    private static final String OWNERS = "ownerS";
    private static final String SUPPLIER = "supplier";

    ScoreOrganization scoreOrganization = new ScoreOrganization();
    Weights weights = new Weights();
    ObjectMapper mapper = new ObjectMapper();

    public String modelWithListOfOrgs(List<String> organizationUris, String bussinessPs, String competitor, String ownerS, String supplier)
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

    public String modelWithListOfOrgs(Map<String,String> testData)
            throws JsonProcessingException {

        scoreOrganization.setOrganizationUris(Arrays.asList(testData.get("OrgUri")));
        weights.setBusinessPartnership(testData.get("BussinessPartnerShipValue"));
        weights.setCompetitor(testData.get("CompetitorValue"));
        weights.setOwnership(testData.get("OwnerShipValue"));
        weights.setSupplier(testData.get("SupplierValue"));
        scoreOrganization.withWeights(weights);

        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);
        return jsonString;
    }

    public String modelWithListOfOrgsButWithougtWeights(List<String> organizationUris)
            throws JsonProcessingException {
        ScoreOrganization scoreOrganization = new ScoreOrganization();

        scoreOrganization.setOrganizationUris(organizationUris);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);
        return jsonString;
    }

    public String modelWithUriAndOneWeight(List<String> organizationUris, String weightName, String value) throws Exception {
        scoreOrganization.setOrganizationUris(organizationUris);
        scoreOrganization.withWeights(weightFactory(weightName, value));
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);

        return jsonString;
    }

    public String modelWithUriAndOneWeight(Map<String,String> testData) throws Exception {
        System.out.println(testData.get("OrgId"));
        System.out.println(testData.get("WeightName"));
        System.out.println(Double.valueOf(testData.get("WeightValue")));

        scoreOrganization.setOrganizationUris(Arrays.asList(testData.get("OrgId")));
        scoreOrganization.withWeights(weightFactory(testData.get("WeightName"), testData.get("WeightValue")));
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);

        return jsonString;
    }

    public String modelWithOneWeightOnly (String weightName, String value) throws Exception {

        scoreOrganization.withWeights(weightFactory(weightName, value));
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(scoreOrganization);

        return jsonString;
    }


    private Weights weightFactory (String weightName, String value) throws Exception {
        Weights weights = new Weights();

        if(BUSSINESSPS.equals(weightName)) {
            weights.setBusinessPartnership(value);

        } else if(COMPETITOR.equals(weightName)) {
            weights.setCompetitor(value);

        } else if(OWNERS.equals(weightName)) {
            weights.setOwnership(value);

        } else if(SUPPLIER.equals(weightName)) {
            weights.setSupplier(value);

        }
        else {
            throw new Exception("Could not find weight");
        }
        return weights;
    }

}
