package com.neotech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
//public static void main(String[] args) {
//	
//	System.out.println("Mustafa");
//	method1();
//	System.out.println("Sabah");
//	
//	
//}
//	public static void method1() {
//		
//	}
//	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Starting to keep logs");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Saving logs...");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Load browser,get ready for test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Quit the browser after performing the test");
	}

	@Test
	public void test1() {
		System.out.println("Adding Employee");
	}

	@Test
	public void test2() {
		System.out.println("Removing an employee");
	}

}
