package com.bakery.jdbcdemo;

import java.util.List;

import com.bakery.jdbcdemo.db.DB;
import com.bakery.jdbcdemo.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
        DB db = new DB();
        db.createConnection();
        
        // info for new employee
        /* Employee employee = new Employee(1, "First Last",
        		1234567890, "first@last.com", 20, 50000, "m-f, 9a-5p");
        System.out.println(employee); */
        
        // to create, update, or delete an employee from db
        /* db.createEmployee(employee);
        db.updateEmployee(employee);
        db.deleteEmployee(employee); */
        
        // to list all employees
        List<Employee> employees = db.getAllEmployees();
        for(Employee employee : employees) {
        	System.out.println(employee);
        }
        db.closeConnection();
    }
}
