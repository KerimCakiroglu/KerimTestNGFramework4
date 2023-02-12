package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.PersonalDetailsPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "excelData", groups = { "addEmployee", "regression" })
	public void addEmployee(String firstName, String lastName, String userName, String password) {
//		String firstName = "KKKAngelina";
//		String lastName = "KKKJolie";
//		String userName = "KKKBradPitt";
//		String password = "KKKFiruz@123";

		// All the pages are initialized at the beginning!!!
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetails = new PersonalDetailsPageElements();

		// Printing to the console
		System.out.println("Test Data: " + firstName + " " + lastName);
		// Logging information to the test report
		test.info("Test Data: " + firstName + " " + lastName);

		// Login
		test.info("Loging in...");
		login.adminLogin();

		wait(1);

		dashboard.PIM.click();
		dashboard.addEmployeeLink.click();
		wait(1);

		// New Employee Data
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);

		// Get EmployeeId for validation
		String expectedEmpId = addEmployee.employeeId.getAttribute("value");

		// We are selecting 'Canadian Regional HQ' from location drop-down
		selectDropdown(addEmployee.location, "Canadian Regional HQ");
		wait(1);

		// I am using JavaScript Click because click() didn't work
		jsClick(addEmployee.checkboxLoginDetails);

		wait(1);

		// Provide username & password for the New Employee
		sendText(addEmployee.userName, userName);
		sendText(addEmployee.password, password);
		sendText(addEmployee.confirmPassword, password);

		wait(1);

		click(addEmployee.saveButton);

		wait(1);

		waitForVisibility(personalDetails.pimPersonalDetailsForm);

		// Validation
		test.info("Validating the new Employee");
		String actualEmpId = personalDetails.employeeId.getAttribute("value");

		Assert.assertEquals(actualEmpId, expectedEmpId, "Id's do NOT match!");
	}

	@DataProvider(name = "excelData")
	public Object[][] createData() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/src/test/resources/testdata/Excel.xlxs",
				"employee");
	}

}
