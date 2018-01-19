package testconfig.headers;

import java.util.Map;

public class GetHeader implements IHeaders {

    @Override
    public Map<String, ?> setHeaders() {
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
