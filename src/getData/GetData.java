/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dat
 */
public class GetData {

    public int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Requires the user to enter a number in range until it is correct
        while (true) {
            System.out.println(msg);
            try {
                String inputString = sc.nextLine();
                //Check inputString is empty or not, if empty, ask to re-enter
                if (inputString.isEmpty()) {
                    System.out.println("Input cannot be empty!!!");
                } else {
                    int number = Integer.parseInt(inputString);
                    //check posNumber in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Please enter a number from " + min + " to " + max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter integer number !!");
            }
        }
    }

    public int getUserChoice(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                //check input is empty or not
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    //check number in range or not 
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Please enter number from " + min + " to " + max + " !!!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter number from " + min + " to " + max + " !!!");
            }
        }
    }

    public String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty...");
            } else {
                return input;
            }
        }
    }

    public String getStringWRegex(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty...");
            } else {
                //check input with regex
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println("Error format, enter again!!");
                }
            }
        }
    }

    public Date getDate(String msg, String regex) {
        Scanner sc = new Scanner(System.in);
        Date inputDate;
        String input;
        //ask user enter until it correct
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty...");
            } //check regex 
            else if (!input.matches(regex)) {
                System.out.println("Input is wrong, please enter follow đ/MM/yyyy.");
            }
            try {
                inputDate = dateFormat.parse(input);
                break;
            } catch (Exception e) {
                System.out.println("Date does not exist!");
            }
        }
        return inputDate;
    }

}
