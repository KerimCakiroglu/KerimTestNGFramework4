package com.neotech.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	@Test
	public void test1() {
		String expected = "Ferhat";
		String actual = "Burak";

		Assert.assertEquals(actual, expected);

		// if this test failed, whatever come after this will not execute
		System.out.println("hi There!");

	}

	public void test2() {
		int expected = 15;
		int actual = 5;

		Assert.assertEquals(actual, expected, "Numbers did not match!");

	}

	public void test3() {
		// when we login to the dashboard we expect this menu:
		ArrayList<String> expectedList = new ArrayList<>();

		expectedList.add("Admin");
		expectedList.add("PIM");
		expectedList.add("Time");
		expectedList.add("About");

		// let us assume that we run the last,
		// we get the elements we have populated
		// the list with values

		ArrayList<String> actualList = new ArrayList<>();

		actualList.add("Admin");
		actualList.add("PIM");
		actualList.add("About");
		actualList.add("Time");

		Assert.assertEquals(actualList, expectedList);

	}

	@Test
	public void test4() {
		boolean result = true;
		// we expect it to be false, but it is true --> test fails
		Assert.assertFalse(result);
	}

	@Test
	public void softAssert() {
		SoftAssert softAssert = new SoftAssert();

		String expected = "Sefa";
		String actual = "Arin";

		softAssert.assertEquals(actual, expected);

//		boolean result = true;
//		// we expect it to be false, but it is tru --> test fails
//		Assert.assertFalse(result);

		int num1 = 6;
		int num2 = 6;

		softAssert.assertEquals(num1, num2);

		// this is the REAL CHECK!!!
		softAssert.assertAll();
	}
}
