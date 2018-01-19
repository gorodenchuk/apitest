package testconfig.headers;

import java.util.HashMap;
import java.util.Map;

public interface IHeaders {

    Map<String, String> headers = new HashMap<>();

    Map<String, ?> setHeaders();
}
