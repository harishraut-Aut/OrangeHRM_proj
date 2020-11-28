package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class PhtographPage extends TestBase
	{

		public PhtographPage()
			{
				PageFactory.initElements(driver, this);
			}

		@FindBy(xpath = "//input[@id='photofile']")
		WebElement choosefile;

		@FindBy(xpath = "//input[@id='btnSave']")
		WebElement uploadBtn;

		@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[3]/div")
		WebElement Uploadsuccesfullmsg;

		@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[3]/div")
		WebElement validationfailedmsg;

		public void uploadphoto(String filepath)
			{
				choosefile.sendKeys(filepath);

			}

		public boolean verifysuccessmsg()
			{
				return Uploadsuccesfullmsg.isDisplayed();
			}

		public void clickonuploadbtn()
			{
				uploadBtn.click();
			}

		public boolean verifyfailedmsg()
			{
				return validationfailedmsg.isDisplayed();
			}
	}
