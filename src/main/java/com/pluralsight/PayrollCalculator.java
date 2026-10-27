package com.pluralsight;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {
    public static void main(String[] args) throws Exception {

        File file = new File("employees.csv");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Employee[] employees = new Employee[8];
        String line;
        int index = 1;

        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split("\\|");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            double hoursWorked = Double.parseDouble(parts[2]);
            double payRate = Double.parseDouble(parts[3]);

            employees[index] = new Employee(id, name, hoursWorked, payRate);
            System.out.printf("ID: %d | Name: %s | Pay: %.2f\n", employees[index].getEmployeeId(), employees[index].getName(), employees[index].getPayRate());
        }
    }
}
