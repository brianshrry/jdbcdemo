package com.bakery.jdbcdemo.db;

import java.util.List;

import com.bakery.jdbcdemo.model.Employee;

public interface DAO {
	void createConnection();
	void closeConnection();
	
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	List<Employee> getAllEmployees();
}
