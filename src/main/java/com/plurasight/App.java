package com.plurasight;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            int count = 1;
            int employeeID;
            String name;
            double hoursWorked;
            double payRate;

            while ((input = bufReader.readLine()) != null){
                String [] splitData = input.split(Pattern.quote("|"));
                employeeID = Integer.parseInt(splitData[0]);
                name = splitData[1];
                hoursWorked = Double.parseDouble(splitData[2]);
                payRate = Double.parseDouble(splitData[3]);

                Employee employee = new Employee(employeeID, name, hoursWorked, payRate);


                System.out.printf("""
                        Employee #%d:
                        Id: %s
                        Name: %s
                        Gross Pay: %.2f\s
                        \n""",count, employee.getEmployeeID(), employee.getName(), employee.getGrossPay());
                count++;
            }


            bufReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
