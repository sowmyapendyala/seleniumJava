package org.example;

import io.restassured.response.Response;

import java.io.File;

public class ApiRel {
    public static void main(String[] args) {
        // POST Request
        File requestBody = new File("src/main/resources/request.json");
        Response postResponse = Client.sendPostRequest("v2/pet", requestBody);
        System.out.println("Response Status: " + postResponse.getStatusCode());
        System.out.println("Response Body: " + postResponse.getBody());


        // GET Request
        Response getResponse = Client.sendGetRequest("v2/pet/findByStatus?status=available");
        System.out.println("Response Status: " + getResponse.getStatusCode());
        System.out.println("Response Body: " + getResponse.getBody().asString());
    }
}