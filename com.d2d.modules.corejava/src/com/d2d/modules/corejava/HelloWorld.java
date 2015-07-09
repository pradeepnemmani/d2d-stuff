package com.d2d.modules.corejava;

public class HelloWorld {
	public HelloWorld() {
		System.out.println("HelloWorld Constructor");
	}

	public void display() {
		System.out.println("In display() method");
	}

	public static void main(String[] args) {
		System.out.println("The argument is:" + args[0]);
		HelloWorld hello = new HelloWorld();
		hello.display();

	}

}
