package com.bestbuy.model;

public class ProductPojo {

/*
{
	"name": "New Product",
	"type": "Hard Good",
	"upc": "12345676",
	"price": 99.99,
	"description": "This is a placeholder request for creating a new product.",
	"model": "NP12345"
}
 */

  private String productName;
  private String productType;
  private String productUPC;
  private double productPrice;
  private String productDesc;
  private String productModel;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductUPC() {
        return productUPC;
    }

    public void setProductUPC(String productUPC) {
        this.productUPC = productUPC;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
}
