package com.orangehrm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.MyInfo;
import com.orangehrm.qa.pages.PhtographPage;

//adding this listener annotation in every class is painful ok so we can add it directly to our xml file
//@Listeners(TestUtil.class)
public class MyInfo_PhotographTest extends TestBase
	{
		LoginPage lp;
		HomePage hp;
		MyInfo mi;
		PhtographPage pg;

		public MyInfo_PhotographTest()
			{
				super();
			}

		@BeforeMethod
		public void StartUp()
			{
				initialization();
				lp = new LoginPage();
				lp.login(prop.getProperty("username"), prop.getProperty("password"));

				hp = new HomePage();
				hp.clickon_myinfo();

				mi = new MyInfo();
				mi.clickon_ChangePhoto();

				pg = new PhtographPage();

			}

		@Test
		public void uploadphotounder1mb()
			{
				pg.uploadphoto(
						"D:\\Classwork\\OrangeHRMTest\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\1021kb.jpg");
				pg.clickonuploadbtn();
				boolean flag = pg.verifysuccessmsg();
				Assert.assertTrue(flag);
			}

		@Test
		public void uploadphotoover1mb()
			{
				pg.uploadphoto(
						"D:\\Classwork\\OrangeHRMTest\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\1.1mbDemo.png");
				pg.clickonuploadbtn();
				boolean flag = pg.verifyfailedmsg();
				Assert.assertTrue(flag);
			}

		@AfterMethod
		public void End()
			{
				driver.close();
			}
	}
