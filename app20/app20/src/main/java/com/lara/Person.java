package com.lara;

public class Person {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("this is  SetFirstName Method: " + firstName);
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("this is  SetlastName Method: " + lastName);
		this.lastName = lastName;
	}
}
