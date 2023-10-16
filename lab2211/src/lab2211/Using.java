/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2211;

import Controller.ProductList;

/**
 *
 * @author ADMIN
 */
public class Using {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] options = {"Add", "Search", "Display", "Update","Delete","save", "Quit"};
        String fileName = "D:\\javacode\\lab2211\\product.txt";
        ProductList list = new ProductList();
        list.loadFromFile(fileName);
        int choice;
        do {
            System.out.println("\n---------------Product Management Program---------------");
            choice = Menu.getchoice(options);
            switch (choice) {
                case 1:
                    System.out.println("\n---------------New Product---------------");
                    list.addProduct();
                    break;
                case 2:
                    System.out.println("\n---------------Search---------------");
                    list.searchProduct();
                    break;
                case 3:
                    System.out.println("\n---------------All Product---------------");
                    list.displayProduct();
                    break;
                case 4:
                    System.out.println("\n---------------Update---------------");
                    list.updateProduct();
                    break;
                case 5:
                    System.out.println("\n---------------Delete---------------");
                    list.deleteProduct();
                    break;
                case 6:
                    System.out.println("\n---------------Save to File---------------");
                    list.saveToFile("product.txt");
                    break;
                case 7:
                    System.out.println("GoodBye!!!");
                    break;
            }
        } while (choice < options.length);

    }
}
