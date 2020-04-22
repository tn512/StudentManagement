package studentmanagementsystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    //get input integer number between min and max
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        //force user input exectly integer number
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    //get input double number between min and max
    public double inputDouble(String mess, double min, double max) {

        //force user input exectly double number
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + "\n");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number.");
            }
        }
    }

    //get non-empty string
    public String inputString(String mess) {
        System.out.print(mess);
        //force user input exectly non-empty string
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }

    //get Y-N question
    public int inputYesNo(String mess) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                return 1;
            } else if (input.equals("N") || input.equals("n")) {
                return 0;
            } else {
                System.out.print("Wrong input!");
            }
        }
    }

    public float inputFloat(String mess) {

        //force user input exectly double number
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                float number = Float.parseFloat(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an float number.\n");
            }
        }
    }

    public int inputPositiveDecimal(String mess) {
        //force user input exectly integer number
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.print("Please input a positive decmal.\n");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer number.\n");
            }
        }
    }

    public boolean checkNull(String value) {
        return value.isEmpty();
    }

    public boolean checkNumber(String value) {
        try {
            double num = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return true; //Not number 
        }
        return false; //Number
    }

    public boolean checkPositiveInteger(String value) {
        try {
            int num = Integer.parseInt(value);
            if (num <= 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return true; //Not number 
        }
    }
    
    public boolean validateDate(String dateBirth){
        if(dateBirth.trim().equals("")){
            return false;
        } else {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            df.setLenient(false);
            try{
                Date d = df.parse(dateBirth);
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }
}
