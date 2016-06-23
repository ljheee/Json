package com.ljheee.entity;

import java.util.ArrayList;

public class User {

	String name;
	int age;
	Address address;
	
	ArrayList<String> phones = new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}
