package com.orangehrm.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangehrm.qa.base.TestBase;

/**
 * @author : Harish Date : Nov 20, 2020 Time : 10:18:10 PM
 */
public class TestUtil extends TestBase implements ITestListener
	{
		// from here you can manage your timeouts..
		public static long PAGE_LOAD_TIMEOUT = 40;
		public static long IMPLICIT_WAIT = 150;

		// sometimes the element is on frame so it takes time to detect it or it gives
		// element not interactable exception in this type of cases the element is on
		// the main frame so we need to handle it
		public void switchToFrame()
			{
				driver.switchTo().frame("mainpanel");
			}

		//test
		//test 123
		// these are unimplemented methods from interface ITestListener
		// just use this result obj and perform actions for certain events ..
		public void onTestStart(ITestResult result)
			{
				// TODO Auto-generated method stub

			}

		public void onTestSuccess(ITestResult result)
			{
				// TODO Auto-generated method stub
				Passed_screenshot(result.getMethod().getMethodName());

			}

		public void onTestFailure(ITestResult result)
			{

				// calling the failed scrrenshot method here ok it is accepting a parameter
				// string
				// and i.e. the method name we want in our method..
				failed_screenshot(result.getMethod().getMethodName());

			}

		public void onTestSkipped(ITestResult result)
			{
				// TODO Auto-generated method stub

			}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result)
			{
				// TODO Auto-generated method stub

			}

		public void onStart(ITestContext context)
			{
				// TODO Auto-generated method stub

			}

		public void onFinish(ITestContext context)
			{
				// TODO Auto-generated method stub

			}

	}
