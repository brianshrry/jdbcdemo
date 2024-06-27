package com.bakery.jdbcdemo.model;

public class Employee {
	Integer eid;
	String name;
	Integer phone;
	String email;
	Integer age;
	Integer salary;
	String schedule;
	public Employee(Integer eid, String name, Integer phone,
			String email, Integer age, Integer salary, 
			String schedule) {
		this.eid = eid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.schedule = schedule;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name 
				+ ", phone=" + phone +", email=" + email + ", age=" + age
				+ ", salary=" + salary + ", schedule=" + schedule + "]";
	}
}
