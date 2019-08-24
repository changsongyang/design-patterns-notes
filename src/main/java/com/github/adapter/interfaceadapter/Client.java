package com.github.adapter.interfaceadapter;

public class Client {
	public static void main(String[] args) {
		
		AbsAdapter absAdapter = new AbsAdapter() {
			@Override
			public void m1() {

				System.out.println("使用了 m1 的方法");
			}
		};
		
		absAdapter.m1();
	}
}
