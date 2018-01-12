package testdata.headers;

import java.util.Map;

public class ScoreOrganizationsHeader implements IHeaders {

    @Override
    public Map<String, ?> setHeaders() {
        headers.put("Accept", "text/html");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
