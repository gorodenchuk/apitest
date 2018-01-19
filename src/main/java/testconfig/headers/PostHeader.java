package testconfig.headers;

import java.util.Map;

public class PostHeader implements IHeaders {

    @Override
    public Map<String, ?> setHeaders() {
        headers.put("Accept", "text/html");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
