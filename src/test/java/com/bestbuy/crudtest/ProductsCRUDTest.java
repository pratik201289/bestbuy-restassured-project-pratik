package com.bestbuy.crudtest;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsCRUDTest extends TestBase {

//    static ValidatableResponse response;

    @Test
    public void addProducts() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setProductName("Louis Vuitton");
        productPojo.setProductType("Clothing");
        productPojo.setProductUPC("1234");
        productPojo.setProductPrice(99.99);
        productPojo.setProductDesc("Famous Brand");
        productPojo.setProductModel("NP12345");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(productPojo)
                        .when()
                        .post("/products");
        response.then().statusCode(201).log().all();
        response.prettyPrint();
    }
    @Test
    public void test002() {
    }

    @Test
    public void test003() {

    }

    @Test
    public void test004() {

    }

}
