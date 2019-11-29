package com.practice.whiteboard.dynamic_enum;

public enum City {
	DELHI,
	MUMBAI;

	public static void createInstance() throws InstantiationException, IllegalAccessException {
		City city = City.class.newInstance();
		
	}
}
