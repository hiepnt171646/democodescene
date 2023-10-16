/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2211;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Menu {
    public static int getchoice(Object[] options) {
        for (int i=0;i<options.length;i++)
        {System.out.println((i+1)+"-"+ options[i]);    }
        System.out.println("choose 1..."+ options.length +":");
        Scanner sc=new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
    public static int getChoice(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose 1..." + options.length + ": ");
        return Integer.parseInt(sc.nextLine());
    }
}
