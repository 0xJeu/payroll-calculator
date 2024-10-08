package com.plurasight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        try {
            Scanner keyboard = new Scanner(System.in);

            //Get user input
            System.out.print("Enter the name of the file employee file to process: ");
            String readFileName = keyboard.nextLine();

            System.out.print("Enter the name of the file employee file to process: ");
            String writeFileName = keyboard.nextLine();

            //Read CSV
            FileReader fileReader = new FileReader("src/main/resources/" + readFileName);
            BufferedReader bufReader = new BufferedReader(fileReader);

            //Write new CSV
            FileWriter fileWriter = new FileWriter("src/main/resources/" + writeFileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //Set variables
            String input;
            int employeeID;
            String name;
            double hoursWorked;
            double payRate;

            //Using a while loop will allow for each line in the CSV to be read and used for writing the new file
            while ((input = bufReader.readLine()) != null){
                String [] splitData = input.split(Pattern.quote("|"));
                employeeID = Integer.parseInt(splitData[0]);
                name = splitData[1];
                hoursWorked = Double.parseDouble(splitData[2]);
                payRate = Double.parseDouble(splitData[3]);

                // Create a new object using the Employee Class
                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);

                //Write content to new file
                String text = String.format("%d|%s|%.2f \n", employee.getEmployeeID(),employee.getName(),employee.getGrossPay());
                bufWriter.write(text);

            }

            System.out.println("Completed.");

            // Release file
            bufReader.close();
            bufWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
