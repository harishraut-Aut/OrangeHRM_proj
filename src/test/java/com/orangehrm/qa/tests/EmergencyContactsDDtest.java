package com.orangehrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.dataproviders.Emergencycontacts_dataprovider;
import com.orangehrm.qa.pages.Emergency_contacts_Datadriven;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.MyInfo;
//i was debugging this code for many days and found a solution finally from stack overflow..
// always always give location of your data provider class 
//i missed that many times so that is why my previous 2 datadriven tests i didnt used dataprovider
//here im using one and also i have created a program to extract data from excel sheet you can use it for free
//its under dataproviders package.. 

public class EmergencyContactsDDtest extends TestBase
	{
		Emergency_contacts_Datadriven Ec;
		LoginPage lp;
		HomePage hp;
		MyInfo mi;
		Emergency_contacts_Datadriven ecdd;

		public EmergencyContactsDDtest()
			{
				super();
			}

		@BeforeTest
		public void setUp()
			{
				initialization();
				Ec = new Emergency_contacts_Datadriven();
				lp = new LoginPage();
				hp = new HomePage();
				mi = new MyInfo();
				ecdd = new Emergency_contacts_Datadriven();
				// this is proper page chaining im doing cause im returning evrytime object of
				// landing page
				lp.login(prop.getProperty("username"), prop.getProperty("password"));

				hp.clickon_myinfo();

				mi.click_on_emergency_contacts();

			}

		@Test(dataProvider = "test1data", dataProviderClass = Emergencycontacts_dataprovider.class)
		public void addEmergencycontacts(String Name, String Relationship, String Mobile)
			{
				// always put the button here like add or any button (inside the loop ok ) cause
				// when 1st loop will
				// execute it will try to find again that element to perform the next loop
				// operation
				ecdd.Clickon_addcontacts();
				ecdd.clearName();
				ecdd.enterName(Name);
				ecdd.clearRelationship();
				ecdd.enterRelationship(Relationship);
				ecdd.clearMobile();
				ecdd.enterMobile(Mobile);
				ecdd.clickSaveContact();
				boolean flag = ecdd.Successfullysavedmsg();// this is returning boolean value so storing it in vflag
				Assert.assertTrue(flag);// if flag is false assertion will fail...
			}

		@AfterTest
		public void end()
			{
				driver.close();
			}
	}
