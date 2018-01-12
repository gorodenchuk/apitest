package testdata.headers;

import java.util.Map;

public class ScoringStatusHeader implements IHeaders {

    @Override
    public Map<String, ?> setHeaders() {
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
