package com.bakery.jdbcdemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bakery.jdbcdemo.model.Employee;

public class DB implements DAO {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;

	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver.class");
			System.out.println("Driver loaded...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createConnection() {
		try {
			String user = "root";
			String password = "1234";
			String database = "mydb";

			String url = "jdbc:mysql://localhost/" + database;

			connection = DriverManager.getConnection(url, user, password);

			System.out.println("Connection created...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Close.");
			}else {
				System.err.println("Connection does not exist...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployee(Employee employee) {
		try {
			String sql = "insert into Employee values(null, '"+employee.getName()
			+"', "+employee.getPhone()+", '"+employee.getEmail()+"', "+employee.getAge()
			+", "+employee.getSalary()+", '"+employee.getSchedule()+"')";
			System.out.println("SQL: "+sql);
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			
			String message = result > 0 ? "Employee "+employee.getName()+
					" created successfully..." : 
						"Employee "+employee.getName()+" not created successfully...";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			String sql = "update Employee set name = ?, phone = ?, email = ? where eid = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getPhone());
			preparedStatement.setString(3, employee.getEmail());
			
			int result = preparedStatement.executeUpdate();
			
			String message = result > 0 ? "Employee "+employee.getName()+" updated successfully" :
				"Employee "+employee.getName()+" not updated succesfully";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try {
			String sql = "delete from Employee where eid = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, employee.getEid());
			
			int result = preparedStatement.executeUpdate();
			
			String message = result > 0 ? "Employee "+employee.getEid()+" deleted successfully..." :
				"Employee "+employee.getEid()+" not deleted successfully";
			System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			String sql = "select * from Employee";
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet set = preparedStatement.executeQuery();
			
			while(set.next()) {
				Employee employee = new Employee(null, sql, null, sql, null, null, sql);
				employee.setEid(set.getInt(1));
				employee.setName(set.getString(2));
				employee.setPhone(set.getInt(3));
				employee.setEmail(set.getString(4));
				employee.setAge(set.getInt(5));
				employee.setSalary(set.getInt(6));
				employee.setSchedule(set.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
}