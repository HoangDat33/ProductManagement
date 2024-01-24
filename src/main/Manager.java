/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import display.Display;
import entity.Product;
import entity.StoreKeeper;
import getData.GetData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Dat
 */
public class Manager {

    GetData getData = new GetData();
    Display display = new Display();

    private boolean checkDuplicateStore(ArrayList<StoreKeeper> storeKeeperList, String name) {
        boolean isExist = false;
        for (StoreKeeper keeper : storeKeeperList) {
            if (keeper.getStoreKeeperName() == name) {
                isExist = true;
            }
        }
        return isExist;
    }

    public void addStoreKeeper(ArrayList<StoreKeeper> storeKeeperList) {
        while (true) {
            System.out.println("Add Store Keeper: ");
            display.displayStorekeeper(storeKeeperList);
            String storeName = getData.getString("Enter new storekeeper:");
            //check duplicate name
            if (checkDuplicateStore(storeKeeperList, storeName)) {
                System.out.println("Storekeeper is exist!Enter again...");
            } else {
                //check list is empty or not
                if (storeKeeperList.isEmpty()) {
                    StoreKeeper newStore = new StoreKeeper(1, storeName);
                    storeKeeperList.add(newStore);
                    System.out.println("Add successfuly store keeper!!");
                    display.displayStorekeeper(storeKeeperList);
                    break;
                } else {
                    int idLastStore = storeKeeperList.get(storeKeeperList.size() - 1)
                            .getStoreKeeperID();
                    StoreKeeper newStore = new StoreKeeper(idLastStore + 1, storeName);
                    storeKeeperList.add(newStore);
                    System.out.println("Add successfuly store keeper!!");
                    display.displayStorekeeper(storeKeeperList);
                    break;
                }
            }
        }

    }

    private boolean checkDuplicateIdProduct(ArrayList<Product> productList, int id) {
        boolean isExist = false;
        //loop use to access each element of arraylist from begining to the end
        for (Product product : productList) {
            //compare variable id with product id in list
            if (product.getID() == id) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public void addProduct(ArrayList<StoreKeeper> storeKeeperList, ArrayList<Product> productList) {
        //check storekeeper is empty or not
        if (storeKeeperList.isEmpty()) {
            System.out.println("Store keeper is empty, can't add product!");
            int addStoreKeeper = getData.getInteger("Do you want add store keeper?"
                    + ":\n1.Yes\n2.No ", 1, 2);
            if (addStoreKeeper == 1) {
                addStoreKeeper(storeKeeperList);
            }
        } else {
            System.out.println("Add product: ");
            display.displayProductList(productList);
            int newPID;
            //loop util enter correct
            while (true) {
                newPID = getData.getInteger("Enter product ID: ", 0, Integer.MAX_VALUE);
                //check duplicate ID
                if (checkDuplicateIdProduct(productList, newPID)) {
                    System.out.println("Product is exist!Enter again...");
                } else {
                    break;
                }
            }
            String newPName = getData.getString("Enter product name: ");
            String newPLocation = getData.getString("Enter product location: ");
            int newPPrice = getData.getInteger("Enter produc price: ", 1, Integer.MAX_VALUE);
            Date newDOMenu, newExpriD;
            //Enter util date correct
            while (true) {
                newDOMenu = getData.getDate("Enter date of manufactor: ", "(\\d{1,2}[/]){2}\\d{4}");
                Date today = new Date();
                //compare with today
                if (newDOMenu.before(today)) {
                    break;
                } else {
                    System.out.println("Date of manufactor must before today!!");
                }
            }
            //Enter util date correct 
            while (true) {
                newExpriD = getData.getDate("Enter expry date: ", "(\\d{1,2}[/]){2}\\d{4}");
                //compare with date of manu factor
                if (newExpriD.after(newDOMenu)) {
                    break;
                } else {
                    System.out.println("Expiry date must after date of manufactor!!");
                }
            }
            String newCategory = getData.getString("Enter category: ");
            StoreKeeper store = null;
            while (store == null) {
                display.displayStorekeeper(storeKeeperList);
                int chooseStore = getData.getInteger("Choose storekeeper: ", 1, storeKeeperList.size());
                //access all element in list storekeeper
                for (StoreKeeper storeKP : storeKeeperList) {
                    //check id selected by user with id in list
                    if (storeKP.getStoreKeeperID() == chooseStore) {
                        store = new StoreKeeper(storeKP.getStoreKeeperID(), storeKP.getStoreKeeperName());
                        break;
                    }
                }
            }
            Date newRecDate;
            while (true) {
                newRecDate = getData.getDate("Enter receipt date: ", "(\\d{1,2}[/]){2}\\d{4}");
                Date today = new Date();
                //compare recript date with DOmanu and to day
                if (newRecDate.after(newDOMenu) && newRecDate.before(today)) {
                    break;
                } else {
                    System.out.println("Receipt date must after Date of manufacture"
                            + "and before today!!!");
                }
            }
            Product newProduct = new Product(newPID, newPName, newPLocation,
                    newPPrice, newDOMenu, newExpriD, newCategory, store, newRecDate);
            productList.add(newProduct);
            System.out.println("Add product successfuly!");
            display.displayProductList(productList);
        }
    }

    public int searchProductByID(ArrayList<Product> productList, int ID) {
        int indexProduct = -1;
        if (productList.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            //access all element in list
            for (Product product : productList) {
                //check product's ID in list with input ID
                if (product.getID() == ID) {
                    indexProduct = productList.indexOf(product);
                    break;
                }
            }
        }
        return indexProduct;
    }

    public void updateProduct(ArrayList<StoreKeeper> storeKeeperList, ArrayList<Product> productList) {
        System.out.println("Update product: ");
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!!!");
        } else {
            display.displayProductList(productList);
            int searchProductID = getData.getInteger("Enter product "
                    + "you want update ID: ", 0, Integer.MAX_VALUE);
            int indexUpdateProduct = searchProductByID(productList, searchProductID);
            //check id exist in list or no
            if (indexUpdateProduct == -1) {
                System.out.println("Don't have this product in list!");
            } else {
                int newID;
                //loop util get correct ID
                while (true) {
                    newID = getData.getInteger("Enter product ID: ", 0, Integer.MAX_VALUE);
                    boolean existInList = checkDuplicateIdProduct(productList, newID);
                    if (existInList != true) {
                        break;
                    } else {
                        System.out.println("ID is exist!Enter again...");
                    }
                }
                String newPName = getData.getString("Enter product name: ");
                String newPLocation = getData.getString("Enter product location: ");
                int newPPrice = getData.getInteger("Enter produc price: ", 1, Integer.MAX_VALUE);
                Date newDOMenu, newExpriD;
                //Enter util date correct
                while (true) {
                    newDOMenu = getData.getDate("Enter date of manufactor: ", "(\\d{1,2}[/]){2}\\d{4}");
                    Date today = new Date();
                    //compare with today
                    if (newDOMenu.before(today)) {
                        break;
                    } else {
                        System.out.println("Date of manufactor must after today!!");
                    }
                }
                //Enter util date correct 
                while (true) {
                    newExpriD = getData.getDate("Enter expry date: ", "(\\d{1,2}[/]){2}\\d{4}");
                    //compare with date of manu factor
                    if (newExpriD.after(newDOMenu)) {
                        break;
                    } else {
                        System.out.println("Expiry date must after date of manufactor!!");
                    }
                }
                String newCategory = getData.getString("Enter category: ");
                StoreKeeper store = null;
                while (store == null) {
                    display.displayStorekeeper(storeKeeperList);
                    int chooseStore = getData.getInteger("Choose storekeeper: ", 1, storeKeeperList.size());
                    //access all element in list storekeeper
                    for (StoreKeeper storeKP : storeKeeperList) {
                        //check id selected by user with id in list
                        if (storeKP.getStoreKeeperID() == chooseStore) {
                            store = new StoreKeeper(storeKP.getStoreKeeperID(), storeKP.getStoreKeeperName());
                            break;
                        }
                    }
                }
                Date newRecDate;
                while (true) {
                    newRecDate = getData.getDate("Enter receipt date: ", "(\\d{1,2}[/]){2}\\d{4}");
                    Date today = new Date();
                    //compare recript date with to day
                    if (newRecDate.after(newDOMenu) && newRecDate.before(today)) {
                        break;
                    } else {
                        System.out.println("Receipt date must after Date of manufacture"
                                + "and before today!!!");
                    }
                }
                Product newUProduct = new Product(newID, newPName, newPLocation,
                        newPPrice, newRecDate, newRecDate, newCategory, store, newRecDate);
                productList.set(indexUpdateProduct, newUProduct);
                System.out.println("Update successfuly!");
                display.displayProductList(productList);
            }
        }
    }

    public void searchProduct(ArrayList<StoreKeeper> storeKeeperList, ArrayList<Product> productList) {
        System.out.println("Search product: ");
        //check list of product is empty or not
        if (productList.isEmpty()) {
            System.out.println("List of product is empty!");
        } else {
            display.menuSearch();
            int optionChoosed = getData.getInteger("Enter you chooise: ", 1, 4);
            switch (optionChoosed) {
                //search by name
                case 1:
                    searchByName(productList);
                    break;
                //search by category
                case 2:
                    searchByCategory(productList);
                    break;
                //search by storekeeper
                case 3:
                    searchByStorekeeper(productList, storeKeeperList);
                    break;
                //search by receiptDate
                case 4:
                    searchByReceiptDate(productList);
                    break;
            }
        }
    }

    public void sortProduct(ArrayList<Product> productList) {
        System.out.println("Sort product: ");
        //check list is empty or not
        if (productList.isEmpty()) {
            System.out.println("List of product is empty!");
        } else {
            System.out.println("Origin list: ");
            display.displayProductList(productList);
            //access from last element to second element of product list
            //after each loop one element is sorted
            for (int i = productList.size() - 1; i > 0; i--) {
                //Use a loop to access from the second to the last element of the unsort array
                for (int j = 0; j < i; j++) {
                    //Compare expiry date of two consecutive elements in product list
                    if (productList.get(j).getExpiryDate().compareTo
        (productList.get(j + 1).getExpiryDate()) > 0) {
                        Product temp = productList.get(j);
                        productList.set(j, productList.get(j + 1));
                        productList.set(j + 1, temp);
                    } else if (productList.get(j).getExpiryDate().compareTo
        (productList.get(j + 1).getExpiryDate()) == 0) {
                        //compare manufacture of date
                        if (productList.get(j).getDateOfManufacture().compareTo
        (productList.get(j + 1).getDateOfManufacture()) > 0) {
                            Product temp = productList.get(j);
                            productList.set(j, productList.get(j + 1));
                            productList.set(j + 1, temp);
                        }
                    }
                }
            }
            System.out.println("Sorted list: ");
            display.displayProductList(productList);
        }
    }

    private void searchByName(ArrayList<Product> productList) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String searchName = getData.getString("Enter name you want search: ");
        //access all element in list
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                listProduct.add(product);
            }
        }
        if (listProduct.isEmpty()) {
            System.out.println("Don't have product with this name in list!!");
        } else {
            display.displayProductList(listProduct);
        }
    }

    private void searchByCategory(ArrayList<Product> productList) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String searchCategory = getData.getString("Enter category you want search: ");
        //access all element in list
        for (Product product : productList) {
            if (product.getCategory().equalsIgnoreCase(searchCategory)) {
                listProduct.add(product);
            }
        }
        if (listProduct.isEmpty()) {
            System.out.println("Don't have product with this category in list!!");
        } else {
            display.displayProductList(listProduct);
        }

    }

    private void searchByStorekeeper(ArrayList<Product> productList, ArrayList<StoreKeeper> storeKeeperList) {
        ArrayList<Product> listProduct = new ArrayList<>();
        StoreKeeper store = null;
        display.displayStorekeeper(storeKeeperList);
        int chooseStore = getData.getInteger("Choose storekeeper: ", 1, storeKeeperList.size());
        //access all element in list product
        for (Product product : productList) {
            if (product.getStoreKeeper().getStoreKeeperID() == chooseStore) {
                listProduct.add(product);
            }
        }
        //check have element in finded list
        if (listProduct.isEmpty()) {
            System.out.println("Don't have product in list!!");
        } else {
            display.displayProductList(listProduct);
        }

    }

    private void searchByReceiptDate(ArrayList<Product> productList) {
        ArrayList<Product> listProduct = new ArrayList<>();
        Date searchRecDate = getData.getDate("Enter receipt date: ", "(\\d{1,2}[/]){2}\\d{4}");
        //access all element in list
        for (Product product : productList) {
            //check recDate want search with all recDate in list
            if (product.getReceiptDate().compareTo(searchRecDate) == 0) {
                listProduct.add(product);
            }
        }
        //check have element in finded list
        if (listProduct.isEmpty()) {
            System.out.println("Don't have product in list!!");
        } else {
            display.displayProductList(listProduct);
        }

    }

}
