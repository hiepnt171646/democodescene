/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class product implements Comparable<product>{
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;

    public product(String productID, String productName, double unitPrice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public product(String id) {
        this.productID = id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     @Override
    public int compareTo(product otherProduct) {
        // Compare products based on quantity in ascending order
        return Integer.compare(otherProduct.quantity, this.quantity);
    }
    @Override
    public String toString() {
        return productID + "," + productName + "," + unitPrice + "," + quantity + "," + status ;
    }
     @Override
    public boolean equals(Object obj) {
        product v = (product) obj;
        return this.productID.equals(v.productID);
    }

    

   

}
