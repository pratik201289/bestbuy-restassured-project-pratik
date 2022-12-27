package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given().
                when().
                get("/stores").
                then().statusCode(200);
    }

    //1. Extract the limit
    @Test
    public void test001() {
        //response.log().all();
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. 2. Extract the total
    @Test
    public void test002() {
        //response.log().all();
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of Total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        //response.log().all();
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store Name : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        //response.log().all();
        List<String> allStoreName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The All Store Name is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        //response.log().all();
        List<Integer> allStoreID = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The All Store ID  is : " + allStoreID);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        //response.log().all();

        List<Objects> sizeofData = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Size of Data is : " + sizeofData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        //response.log().all();
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}"); //important
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of St Cloud : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        //response.log().all();
        List<String> addressOfRochester = response.extract().path("data.findAll{it.name == 'Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Address of  StoreName : " + addressOfRochester);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        //response.log().all();
        List<String> allServices = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the services of 8th store : " + allServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeServices of the store where service name = Windows Store
    @Test
    //left
    public void test010() {
        //response.log().all();
        List<String> storeService = response.extract().path("data.services.findAll{it.name == 'Windows Store'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store Services : " + storeService);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        //response.log().all();
       List <Integer> storeIDAll = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store IDs : " + storeIDAll);
        System.out.println("------------------End of Test---------------------------");
    }
    //12. Get id of all the store
    @Test
    public void test012() {
        //response.log().all();
        List <Integer> storeID = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store IDs : " + storeID);
        System.out.println("------------------End of Test---------------------------");
    }
    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        //response.log().all();
      List <String> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store Name : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        //List<HashMap<String, ?>> productListMap = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        //HashMap<String, ?> productMap = productListMap.get(0);
        //int id = (Integer) productMap.get("id");

        List <?> totalService = response.extract().path("data.find{it.name == 'Rochester'}.services");
        //int Size = (Integer)totalService.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total Number of Services : " + totalService.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<?> services = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Created At : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List <HashMap <String,?>> totalService = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total Number of Services : " + totalService);
        System.out.println("------------------End of Test---------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test017() {
        List <HashMap <Objects,?>> zipCode = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Zip Number of All Store : " + zipCode);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List <HashMap <String,?>> zipStore = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Zip Number of All Store : " + zipStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeServices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List <HashMap <String,?>> storeService = response.extract().path("data[2].services.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store Service of Mongolia Home Theater : " + storeService);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List <HashMap <Objects,?>> latStore = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of All Store : " + latStore);
        System.out.println("------------------End of Test---------------------------");
    }

}
