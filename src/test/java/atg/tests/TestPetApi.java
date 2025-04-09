package atg.tests;

import io.restassured.response.Response;
import org.example.Client;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TestPetApi {


    // POST Request
    @Test
    public void PetCreateTest1() {
        File requestBody = new File("src/test/resources/request.json");
        Response response = Client.sendPostRequest("/v2/pet", requestBody);

        // Print the response
        System.out.println("Test1 Response Body: ");
        response.prettyPrint();

        // Response Code
        assertEquals(response.getStatusCode(), 200);

        // Response
        Long id = response.jsonPath().getLong("id");
        assertNotNull(id, "Id is not null");
        assertEquals(response.jsonPath().getString("category.name"), "string");
        assertEquals(response.jsonPath().getString("name"), "doggie");
        assertEquals(response.jsonPath().getList("photoUrls").get(0), "string");

        // To assert the tags
        List<Map<String, Object>> tags = response.jsonPath().getList("tags");
        assertEquals(tags.get(0).get("name"), "string");

        assertEquals(response.jsonPath().getString("status"), "available");

    }

    // GetRequest
    @Test
    public void GetPetByAvlTest2() {
        Response response = Client.sendGetRequest("/v2/pet/findByStatus?status=available");

        // Print the response
        System.out.println("Test1 Response Body: ");
        response.prettyPrint();

        //Response Status
        assertEquals(response.getStatusCode(), 200);
    }
}
