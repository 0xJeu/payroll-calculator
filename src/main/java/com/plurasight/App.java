package com.plurasight;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        try {
            //Load CSV
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            //Set variables
            String input;
            int count = 1;
            int employeeID;
            String name;
            double hoursWorked;
            double payRate;

            //Using a while loop will allow for each line in the CSV to be read and used
            while ((input = bufReader.readLine()) != null){
                String [] splitData = input.split(Pattern.quote("|"));
                employeeID = Integer.parseInt(splitData[0]);
                name = splitData[1];
                hoursWorked = Double.parseDouble(splitData[2]);
                payRate = Double.parseDouble(splitData[3]);

                // Create a new object using the Employee Class
                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);

                //Print results with desired formatting
                System.out.printf("""
                        Employee #%d:
                        Id: %s
                        Name: %s
                        Gross Pay: %.2f\s
                        \n""",count, employee.getEmployeeID(), employee.getName(), employee.getGrossPay());
                count++;
            }


            // Release file
            bufReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
