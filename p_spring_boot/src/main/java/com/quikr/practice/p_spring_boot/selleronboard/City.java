package com.quikr.practice.p_spring_boot.selleronboard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CITY")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String GSTN;
	private String name;
	private String address;
	private int pin;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGSTN() {
		return GSTN;
	}
	public void setGSTN(String gSTN) {
		GSTN = gSTN;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", GSTN=" + GSTN + ", address=" + address + ", pin=" + pin + ", location="
				+ location + "]";
	}
	
}
