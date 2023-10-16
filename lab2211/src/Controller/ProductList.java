/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Object.product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import lab2211.Menu;
import validation.Inputter;

/**
 *
 * @author lanvy
 */
public class ProductList extends ArrayList<product> {

    public ProductList() {
        super();
    }

    public boolean loadFromFile(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] token = line.split(",");
                String id = Inputter.Normalize(token[0].trim());
                String name = Inputter.Normalize(token[1].trim());
                double price = Double.parseDouble(token[2].trim());
                int quantity = Integer.parseInt(token[3].trim());
                String status = Inputter.Normalize(token[4].trim());
                product v = new product(id, name, price, quantity, status);
                this.add(v);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
//public boolean saveToFile(String fileName) {
//    File f = new File(fileName);
//    if (!f.exists()) {
//        return false;
//    }
//    try {
//        FileWriter fw = new FileWriter(f);
//        PrintWriter pw = new PrintWriter(fw);
//        for (product v : this) {
//            pw.println(v);
//        }
//        pw.close();
//        fw.close();
//    } catch (Exception e) {
//        System.out.println(e);
//    }
//    return true;
//}
    public boolean saveToFile(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (product v : this) {
                pw.println(v);
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void addProduct() {
        String id,name;
        int pos;
         String[] options = {"Available", "Not Available"};
        do {
            id = Inputter.getNonBlank("Product ID:");
            pos = this.indexOf(id);
            if (pos >= 0) {
                System.out.println("Product duplicated!!!\n");
            }
        } while (pos >= 0);
        
        
        do {
            name = Inputter.getStringN("Enter Product Name: ", 5).toUpperCase();
            
            pos = this.indexOf(name);
            if (pos >= 0) {
                System.out.println("Product name duplicated!!!\n");
            }
        } while (pos >= 0);
        
        double price = Inputter.getDouble("Enter Unit Price (0 ~ 10000): ", 0.0, 10000.0);
        int quantity = Inputter.getInt("Enter Quantity  (0 ~ 1000): ", 0, 1000);
        //String status = Inputter.getRegex("Status: ", "^(Available|Not Available)$");
        String status = options[Menu.getChoice(options) - 1];
        product v = new product(id, name, price, quantity, status);
        this.add(v);
        System.out.println("Product Added!!!\n");
    }

    public void searchProduct() {
        String sID, sName;
        int pos, choice;
        String[] options = {"Search By ID", "Search By Name", "Return"};
        boolean duplicated = false;
        do {
            choice = Menu.getchoice(options);
            switch (choice) {
                case 1:
                    sID = Inputter.getNonBlank("ID For Search: ").toUpperCase();
                    pos = this.indexOf(new product(sID));
                    if (pos >= 0) {
                        System.out.println("Found:  " + this.get(pos) + "\n");
                    } else {
                        System.out.println("Not Found!!!\n");
                    }
 
                    break;
                case 2:
                    sName = Inputter.getNonBlank("Name For Search: ").toUpperCase();
                    for (product v : this) {
                        String vName = v.getProductName().toUpperCase();
                        if (v.getProductName().indexOf(sName) >= 0) {
                            System.out.println("Found:  " + v + "\n");
                            duplicated = true;
                        }
                    }
                    if (duplicated == false) {
                        System.out.println("Not Found!!!\n");
                    }
 
                    break;
            }
        } while (choice < options.length);
    }

    public void updateProduct() {
        String uID;
        int pos;    
        uID = Inputter.getNonBlank("ID For Update: ").toUpperCase();
        
        pos = this.indexOf(new product(uID));
        if (pos < 0) {
            System.out.println("ProductID does not exist!!!\n");
            return;
        }
        product v = this.get(pos);

        //update Name
        String uName = Inputter.checkEmpty("ENTER Name For Update: ");
        if (!uName.isEmpty()) {
            v.setProductName(uName);
        } else {
            uName = v.getProductName();
        }

        //update Price
        Double uPrice = Inputter.getDouble("ENTER Price For Update: ");
        if (uPrice > 0) {
            v.setUnitPrice(uPrice);
        } else {
            uPrice = v.getUnitPrice();
        }
        

        //update Quantity
        int uQuantity = Inputter.getInt("ENTER Quantity For Update: ");
         if (uQuantity >0) {
            v.setQuantity(uQuantity);
        } else {
            uQuantity = v.getQuantity();
        }

        //update status
        String ustatus = Inputter.getString("Enter Status (\"Available\" or \"Not Available\"): ", 0, null, "Available", "Not Available");
        if (!ustatus.isEmpty()) {
            v.setStatus(ustatus);
        } else {
            ustatus = v.getStatus();
        }

    }

    public void displayProduct() {
        if (this.isEmpty()) {
            System.out.println("No Product Found!!!\n");
            return;
        } else {
            Collections.sort(this, new Comparator<product>() {
                @Override
                public int compare(product o1, product o2) {
                    return Integer.compare(o2.getQuantity(), o1.getQuantity());
                }
            });
            for (product v : this) {
                String format = "Product ID: %s, Product Name: %s, Unit Price: %.2f, Quantity: %d, Status: %s";
            System.out.println(String.format(format, 
                v.getProductID(), 
                v.getProductName(), 
                v.getUnitPrice(), 
                v.getQuantity(), 
                v.getStatus()
            ));
            }
        }
    }
    public void deleteProduct() {
    String id;
    int pos;
    id = Inputter.getNonBlank("ID For Delete: ");
    pos = this.indexOf(new product(id));
    if (pos < 0) {
        System.out.println("Productname does not exist!!!\n");
        return;
    }
    this.remove(pos);
    System.out.println("Product deleted!!!\n");
}
    
}

