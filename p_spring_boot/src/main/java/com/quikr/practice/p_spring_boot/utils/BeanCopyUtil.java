package com.quikr.practice.p_spring_boot.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

import com.quikr.practice.p_spring_boot.vo.Department;

public class BeanCopyUtil {

	public static Object copy(Object source, Object target) {
		if(source == null) 
			return null;
		if(target == null) {
			try {
				Constructor<? extends Object> cons = source.getClass().getConstructor();
				target = cons.newInstance();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(source, target);
		return target;
	}
	
	public static void main(String[] args) {
		Department source = new Department();
		source.setName("Inf Tech");
		source.setCode("IT");
		Department target = null;
		target = (Department) copy(source, target);
		System.out.println(target);
	}
}
