package com.cleancode.classes;

public class Employee {

	private String name;
	private double salary;
	private Role role;

	String getName() {
		return name;
	}

	double getSalary() {
		return salary;
	}

	Role getRole() {
		return role;
	}
}

class EmailService {
	void sendEmail() {
		// logic
	}
}

class PayrollCalculator {
	void calculateYearBonus(Employee employee) {
		// logic
	}
}

