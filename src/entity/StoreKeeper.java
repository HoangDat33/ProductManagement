/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Dat
 */
public class StoreKeeper {
    private int storeKeeperID;
    private String storeKeeperName;

    public StoreKeeper() {
    }

    public StoreKeeper(int storeKeeperID, String storeKeeperName) {
        this.storeKeeperID = storeKeeperID;
        this.storeKeeperName = storeKeeperName;
    }

    public int getStoreKeeperID() {
        return storeKeeperID;
    }

    public void setStoreKeeperID(int storeKeeperID) {
        this.storeKeeperID = storeKeeperID;
    }

    public String getStoreKeeperName() {
        return storeKeeperName;
    }

    public void setStoreKeeperName(String storeKeeperName) {
        this.storeKeeperName = storeKeeperName;
    }

    @Override
    public String toString() {
        return String.format("%-5d|%-20s", storeKeeperID,storeKeeperName);
    }
    
    
}
