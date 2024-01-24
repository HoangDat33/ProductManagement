/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import entity.StoreKeeper;
import java.util.ArrayList;
import entity.Product;

/**
 *
 * @author Dat
 */
public class Display {

    public void displayMenu() {
        System.out.println("Main menu:\n"
                + "1.Add Storekeeper\n"
                + "2.Add product\n"
                + "3.Update product\n"
                + "4.Search product by Name, Category, Storekeeper, ReceiptDate\n"
                + "5.Sort product by Expiry date, Date of manufacture\n"
                + "6.Exit");
    }

    public void displayStorekeeper(ArrayList<StoreKeeper> storeList) {
        if (storeList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Storekeeper List: ");
            System.out.format("%-5s|%-20s\n", "ID", "Name");
            //loop use to access each element of arraylist from begining to the end
            for (StoreKeeper storekeeper : storeList) {
                System.out.format(storekeeper.toString()+"\n");
            }
        }
    }

    public void displayProductList(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Product list: ");
            System.out.format("%-3s|%-15s|%-10s|%-10s|%-20s|%-20s|%-15s|%-20s|%-15s\n",
                    "Id", "Name", "Location", "Price", "Manufacture date", "Expiry date",
                    "Category", "Storekeeper", "Receipt date");
            //loop use to access each element of arraylist from begining to the end
            for (Product product : productList) {
                System.out.format(product.toString());
            }
        }
    }
    public void displayProduct(Product product){
        System.out.format("%-3s|%-15s|%-10s|%-10s|%-20s|%-20s|%-15s|%-20s|%-15s\n", 
                "Id", "Name", "Location", "Price", "Manufacture date", "Expiry date",
                    "Category", "Storekeeper", "Receipt date");
        System.out.format(product.toString()+"\n");
    }

    public void menuSearch() {
        System.out.println("Menu search: \n"
                + "1. Name\n"
                + "2. Category\n"
                + "3. Storekeeper\n"
                + "4. ReceiptDate");
    }

}
