package org.example;

import java.util.HashMap;
import java.util.Map;

public class ConfigApi {

    private static final String BASE_URL = "https://petstore.swagger.io";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static Map<String, String> getDefaultHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("content-type","application/json");
        return headers;
    }
}
