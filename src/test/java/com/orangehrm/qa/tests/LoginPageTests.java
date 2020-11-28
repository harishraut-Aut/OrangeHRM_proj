package com.orangehrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageTests extends TestBase
	{
		LoginPage loginPage;
		HomePage homePage;

		// here we need to call superclass constructor cause it will initialize
		// properies method in testbase class
		public LoginPageTests()
			{
				super();
			}

		@BeforeMethod
		public void setUp()
			{
				initialization();
				loginPage = new LoginPage();
			}

		@Test(priority = 1)
		public void loginPageTitleTest()
			{
				String title = loginPage.verify_title();
				Assert.assertEquals(title, "OrangeHRM");
			}

		@Test(priority = 2)
		public void OHRMlogoImageTest()
			{
				boolean flag = loginPage.verify_logo();
				Assert.assertTrue(flag);
			}

		@Test(priority = 3)
		public void loginTest()
			{
				homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			}

		@Test(priority = 4)
		public void validate_Forgotpasswordlink()
			{
				boolean flag = loginPage.Forgotpasswordlink();

				Assert.assertTrue(flag);
			}

		@Test(priority = 5)
		public void validate_invalidpwdmsg()
			{
				loginPage.login("admin", "pwd");
				boolean flag = loginPage.verify_invalidmsg();
				Assert.assertTrue(flag);
			}

		@AfterMethod
		public void tearDown()
			{
				driver.quit();
			}

	}
