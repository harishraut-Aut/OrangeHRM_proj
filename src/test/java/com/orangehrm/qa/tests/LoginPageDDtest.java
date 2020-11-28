package com.orangehrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.dataproviders.LoginPageDD_dataprovider;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageDDtest extends TestBase

	{
		//this test im running using my own utility and proper DD and page chaining approach 
		//im using utility created by me Excelutilfinal..
		LoginPage lp;
		HomePage hp;

		public LoginPageDDtest()
			{
				super();

			}

		@BeforeMethod
		public void start()
			{
				initialization();
				lp = new LoginPage();

			}

		@Test(dataProvider = "test2data", dataProviderClass = LoginPageDD_dataprovider.class)
		public void verifyLoginIdPasswords(String username, String password)
			{
				lp.clearUsernamefield();
				lp.enterUserName(username);
				lp.clearPasswordfield();
				lp.enterPassword(password);
				lp.clickonLoginBtn();
				lp.VerifLogindetails();

			}

		@AfterMethod
		public void end()
			{
				driver.close();
			}

	}
