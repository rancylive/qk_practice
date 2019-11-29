package com.practice.whiteboard.dynamic_enum;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class DynamicEnumUtil {
	@SuppressWarnings("unchecked")
	private static <T extends Enum<T>> T createEnumInstance(String name, Type type) {
		return Enum.valueOf((Class<T>) type, name);
	}

	public void set(String name, Field field) throws IllegalArgumentException, IllegalAccessException {
		Enum<?> enum1 = DynamicEnumUtil.createEnumInstance(name, field.getType());
		field.set(this, enum1);
	}

	public static void main1(String[] args) {
		String name = "DELHI";
		String value = "DLH";
		Field field;
		try {
			System.out.println(City.DELHI);
			field = City.class.getDeclaredField(name);
			
			//new DynamicEnumUtil().set(name, field);
			System.out.println(City.DELHI);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}
	public static void main(String[] args) {
		try {
			City.createInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
