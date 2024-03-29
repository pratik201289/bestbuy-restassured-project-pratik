package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given().
                when().
                get("/products").
                then().statusCode(200);
    }

    //21. Extract the limit
    @Test
    public void test0021() {
        //response.log().all();
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void test0022() {
        //response.log().all();
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void test0023() {
        //response.log().all();
        String productNameFifth = response.extract().path("data.name[4]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Fifth Product Name is : " + productNameFifth);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        //response.log().all();
        List<String> allProductName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the Name of Products " + allProductName);
        System.out.println("------------------End of Test---------------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        //response.log().all();
        List<String> allProductName = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the ID of Products " + allProductName);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void test026() {
        //response.log().all();
        List<Objects> alldataSize = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of Total Size: " + alldataSize.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027() {
        //response.log().all();
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All values: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028() {
        //response.log().all();
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Model Name of Energizer - N Cell E90 Batteries (2-Pack): " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test029() {
        List<String> allCat = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Categories: " + allCat);
        System.out.println("------------------End of Test---------------------------");

    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<String> allCat = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get categories of the store where product id = 150115: " + allCat);
        System.out.println("------------------End of Test---------------------------");
    }

    //  31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<HashMap<String, ?>> desc = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Descriptions: " + desc);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<HashMap<String, ?>> ids = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Ids: " + ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<HashMap<String, ?>> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Product Name: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test //left
    public void test034() {
        List <?> totalService = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Cat Total : " + totalService.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
       List<String> createdAt= response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
   @Test
    public void test036(){
        List <HashMap <String,?>> allCat = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
       System.out.println("------------------StartingTest---------------------------");
       System.out.println("Name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)” : " + allCat);
       System.out.println("------------------End of Test---------------------------");
   }
    //37. Find the manufacturer of all the products
    @Test
    public void test037(){
        List<String> allManuFacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Manufacturer Name : " + allManuFacturer);
        System.out.println("------------------End of Test---------------------------");
    }
    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test038(){
        List <HashMap <String,?>> img = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is = Energizer: " + img);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039(){
        List<String> createdAt= response.extract().path("data.findAll{it.price > 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Cat Total : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    //40. Find the uri of all the products
   @Test
    public void test040(){
        List <HashMap <String,?>> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get All Cat Total : " + url);
        System.out.println("------------------End of Test---------------------------");
    }
}

