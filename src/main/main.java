/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import display.Display;
import getData.GetData;
import entity.*;
import java.util.ArrayList;

/**
 *
 * @author Dat
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        GetData getData = new GetData();
        Manager manager = new Manager();
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<StoreKeeper> storeKeeperList = new ArrayList<>();
        //loop use to run again program until user choose 6 (exit)
        while (true) {
            //Step 1: Display menu
            display.displayMenu();
            //Step 2: Ask user select an option from 1 to 6
            int option = getData.getUserChoice("Enter your choise from 1 to 6: ", 1, 6);
            //Step 3: Do option selected by user
            switch(option){
                //1. Add Storekeeper
                case 1: 
                    manager.addStoreKeeper(storeKeeperList);
                    break;
                //2. Add product
                case 2: 
                    manager.addProduct(storeKeeperList, productList);
                    break;
                //3. Update product
                case 3: 
                    manager.updateProduct(storeKeeperList, productList);
                    break;
                //4. Search product by Name, Category, Storekeeper, ReceiptDate
                case 4: 
                    manager.searchProduct(storeKeeperList, productList);
                    break;
                //5. Sort product by Expiry date, Date of manufacture
                case 5: 
                    manager.sortProduct(productList);
                    break;
                //6. Exit
                case 6: 
                    System.exit(0);
                    break;    
            }
        }
    }
}

