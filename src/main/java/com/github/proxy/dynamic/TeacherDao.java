package com.github.proxy.dynamic;

public class TeacherDao implements ITeacherDao {


	public void teach() {
		System.out.println(" 老师授课中.... ");
	}

	public void sayHello(String name) {
		System.out.println("hello " + name);
	}
	
}
