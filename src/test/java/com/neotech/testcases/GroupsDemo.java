package com.neotech.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupsDemo {

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("Starting to keep logs");

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("Saving logs...");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("Load browser,get ready for test");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("Quit the browser after performing the test");
	}

	@Test(priority = 2, groups = { "group1", "group2" })
	public void test1() {
		System.out.println("Adding Employee");
	}

	@Test(groups = "group1", dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Removing an employee");
	}

}
