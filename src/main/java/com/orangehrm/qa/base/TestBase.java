package com.orangehrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.qa.util.TestUtil;

public class TestBase
	{

		public static WebDriver driver;
		public static Properties prop;

		public TestBase()
			{
				try
					{
						prop = new Properties();
						FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
								+ "/src/main/java/com/orangehrm" + "/qa/config/config.properties");
						prop.load(ip);
					}
				catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
			}

		public static void initialization()
			{
				String browserName = prop.getProperty("browser");

				if (browserName.equals("chrome"))
					{
						System.setProperty("webdriver.chrome.driver",
								"C:\\Users\\admin\\Desktop\\Selessentials\\chromedriver.exe");
						driver = new ChromeDriver();
					}
				else if (browserName.equals("FF"))
					{
						System.setProperty("webdriver.gecko.driver",
								"C:\\Users\\admin\\Desktop\\Selessentials\\geckodriver.exe");
						driver = new FirefoxDriver();
					}

				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

				driver.get(prop.getProperty("url"));

			}

		public static void failed_screenshot(String Methodname)
			{

				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// this code i copied from stack overflow and modified it so that we can include
				// methodname and time taken date taken in the filename itself..
				SimpleDateFormat formatter = new SimpleDateFormat("_dd.MM.yyyy _hh.mm.ss aa"); // if not working change
																								// small hh to HH
				Date date = new Date();
				String Dateandtime = formatter.format(date);
				try
					{
						FileUtils.copyFile(src, new File("D://Classwork//OrangeHRMTest//screenshots//Failed//"
								+ Methodname + Dateandtime.toString() + ".png"));
					}
				catch (Exception e)
					{

						System.out.println(e.getMessage());
					}

			}

		public static void Passed_screenshot(String Methodname)
			{

				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// this code i copied from stack overflow and modified it so that we can include
				// methodname and time taken date taken in the filename itself..
				SimpleDateFormat formatter = new SimpleDateFormat("_dd.MM.yyyy _hh.mm.ss aa"); // if not working change
																								// small hh to HH
				Date date = new Date();
				String Dateandtime = formatter.format(date);
				try
					{
						FileUtils.copyFile(src, new File("D://Classwork//OrangeHRMTest//screenshots//Passed//"
								+ Methodname + Dateandtime.toString() + ".png"));
					}
				catch (Exception e)
					{

						System.out.println(e.getMessage());
					}

			}

	}
