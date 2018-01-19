package bo;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;

public class ScoringStatusLogic {

    private static Logger Log = Logger.getLogger(ScoringStatusLogic.class.getName());

    public static Double checkProgressStatus(String jsonDataSourceString) {
        Double jsonpathCreatorProgressToken;

        String jsonpathCreatorProgressPath = "$.progress";
        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        jsonpathCreatorProgressToken = jsonContext.read(jsonpathCreatorProgressPath);
        Log.info(jsonpathCreatorProgressToken + "         progress status");

        return jsonpathCreatorProgressToken;
    }
}
