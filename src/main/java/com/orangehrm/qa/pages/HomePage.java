package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class HomePage extends TestBase
	{

		public HomePage()
			{

				PageFactory.initElements(driver, this);
			}

		@FindBy(xpath = "//a[@id='welcome']")
		WebElement wecomebtn;

		@FindBy(xpath = "//a[contains(text(),'Logout')]")
		WebElement logoutbtn;

		@FindBy(xpath = "//b[contains(text(),'My Info')]")
		WebElement myinfo;

		public MyInfo clickon_myinfo()
			{

				myinfo.click();
				return new MyInfo();
				// returning Myinfo cause object cause its our next landing page so through this
				// we can do page chaining

			}

		public void Logout()
			{
				wecomebtn.click();
				logoutbtn.click();
			}

		public void verifyWelcomebutton()
			{
				boolean isPresent = driver.findElements(By.xpath("//a[@id='welcome']")).size() > 0;
				if (isPresent == true)
					{
						Logout();
					}
			}

	}
