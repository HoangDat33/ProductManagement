/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dat
 */
public class Product {
    private int ID;
    private String name;
    private String location;
    private int price;
    private Date expiryDate;
    private Date dateOfManufacture;
    private String Category;
    private StoreKeeper storeKeeper;
    private Date ReceiptDate;

    public Product() {
    }

    public Product(int ID, String name, String location, int price, 
            Date expiryDate, Date dateOfManufacture, String Category, 
            StoreKeeper storeKeeper, Date ReceiptDate) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.Category = Category;
        this.storeKeeper = storeKeeper;
        this.ReceiptDate = ReceiptDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public StoreKeeper getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }

    public Date getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-3s|%-15s|%-10s|%-10s|%-20s|%-20s|%-15s|%-20s|%-15s\n", ID,
                name, location, price,dateFormat.format(expiryDate),
                dateFormat.format(dateOfManufacture), Category,storeKeeper.getStoreKeeperName()
                ,dateFormat.format(ReceiptDate));
    }
    
    
    
}
