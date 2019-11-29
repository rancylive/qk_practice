package com.practice.whiteboard.dynamic_pojo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

public class ClassGenerationUtil {

	public static Class<?> generateClass() throws CannotCompileException, NotFoundException {
		ClassPool pool=ClassPool.getDefault();
		pool.find("String.class");
		CtClass cls = pool.makeClass("com.ranjan.practice.NewClass");
		//cls.addField(new CtField(pool.get("String.class"), "field1", cls));
		cls.setSuperclass(pool.get("codersliberty.dynamic_pojo.AbstractPojo"));
		return cls.toClass();
	}
	
	public static void main(String[] args) {
		try {
			Class<?> cls = generateClass();
			AbstractPojo obj = (AbstractPojo) cls.newInstance();
			
			String str = new String();
		} catch (CannotCompileException | NotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
