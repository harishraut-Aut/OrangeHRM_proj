package com.orangehrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.dataproviders.MyinfoDD_dataprovider;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.MyInfo;

public class MyInfoPersonalDetailsDDtest extends TestBase
	{
		LoginPage loginPage;
		HomePage hp;
		MyInfo mi;

		@BeforeMethod
		public void setUp()
			{
				initialization();
				loginPage = new LoginPage();
				hp = new HomePage();
				loginPage.login(prop.getProperty("username"), prop.getProperty("password")).clickon_myinfo();
				// through loginpage object you can perform actions on homepage since we have
				// returned homepages object
				mi = new MyInfo();

			}

		@Test(dataProvider = "test3data", dataProviderClass = MyinfoDD_dataprovider.class)
		public void validatemyinfodetails(String firstname, String middlename, String lastname, String licenseexpdate,
				String gender, String nationality)
			{
				mi.clickonsavebtn();
				mi.clearfirstname();
				mi.enterfirstname(firstname);
				mi.clearmiddlename();
				mi.entermiddlename(middlename);
				mi.clearlastname();
				mi.enterlastname(lastname);
				mi.clearlicenseexpdate();
				mi.enterlicenseexpdate(licenseexpdate);
				mi.entergender(gender);
				mi.enternationality(nationality);//after selecting nationality we need to click save then only we can check for saved succesfully msg
				mi.clickonsavebtn();
				mi.validatingmyinfodetails();

			}

		@AfterMethod
		public void end()
			{
				driver.close();
			}

	}
