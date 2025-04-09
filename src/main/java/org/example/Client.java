package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

public class Client {

    public static Response sendPostRequest(String endpoint, File requestBody) {
        RestAssured.baseURI = ConfigApi.getBaseUrl();
        RequestSpecification request = RestAssured.given();

        for (Map.Entry<String, String> entry : ConfigApi.getDefaultHeaders().entrySet()) {
            request.header(entry.getKey(), entry.getValue());
        }

        request.body(requestBody);

        return request.post(endpoint);
    }

    public static Response sendGetRequest(String endpoint) {
        RestAssured.baseURI = ConfigApi.getBaseUrl();
        RequestSpecification request = RestAssured.given();

        for (Map.Entry<String, String> entry: ConfigApi.getDefaultHeaders().entrySet()) {
            request.header(entry.getKey(), entry.getValue());

        }
        return request.get(endpoint);
    }
}
