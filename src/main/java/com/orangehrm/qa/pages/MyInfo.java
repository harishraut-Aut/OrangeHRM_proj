package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.orangehrm.qa.base.TestBase;

public class MyInfo extends TestBase
	{
		// this is myinfo tqabs elements and respective methods use them in myinfo test
		// ok tomake a proper data driven test
		public MyInfo()
			{
				PageFactory.initElements(driver, this);

			}

		@FindBy(xpath = "//a[contains(text(),'Emergency Contacts')]")
		WebElement EmergencyContacts;

		@FindBy(xpath = "//img[@id='empPic']")
		WebElement changephotobtn;

		public PhtographPage clickon_ChangePhoto()
			{
				changephotobtn.click();
				return new PhtographPage();

			}

		public Emergency_contacts_Datadriven click_on_emergency_contacts()
			{
				EmergencyContacts.click();
				return new Emergency_contacts_Datadriven();
			}

		@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
		WebElement firstname;

		@FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
		WebElement middlename;

		@FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
		WebElement lastname;

		@FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
		WebElement licenseexpdate;

		@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
		WebElement gender;

		@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
		WebElement nationality;

		@FindBy(xpath = "//input[@id='btnSave']")
		WebElement savebtn;

		public void clickonsavebtn()
			{
				savebtn.click();
			}

		public void clearfirstname()
			{
				firstname.clear();
			}

		public void clearmiddlename()
			{
				middlename.clear();
			}

		public void clearlastname()
			{
				lastname.clear();
			}

		public void clearlicenseexpdate()
			{
				licenseexpdate.clear();
			}

		public void enterfirstname(String firstname)
			{
				this.firstname.sendKeys(firstname);
			}

		public void entermiddlename(String middlename)
			{
				this.middlename.sendKeys(middlename);
			}

		public void enterlastname(String lastname)
			{
				this.lastname.sendKeys(lastname);
			}

		public void enterlicenseexpdate(String licenseexpdate)
			{
				this.licenseexpdate.sendKeys(licenseexpdate);
			}

		public void entergender(String gender)
			{

				String radiobtn2 = "Female";
				String actual = gender;
				if (actual.equalsIgnoreCase(radiobtn2))
					{
						driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
					}
				else
					{
						driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();

					}
			}

		public void enternationality(String nationality)
			{

				Select sel = new Select(driver.findElement(By.xpath("//select[@id='personal_cmbNation']")));
				// sel.deselectAll();
				sel.selectByVisibleText(nationality);

				try
					{
						Thread.sleep(1000);
					}
				catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

		public void validatingmyinfodetails()
			{
				boolean isPresent = driver.findElements(By.xpath("//*[@id=\"pdMainContainer\"]/div[2]/div")).size() > 0;
				if (isPresent == true)
					{

						System.out.println("Saved");
					}
				else
					{

						String message = "couldnt save details..";
						Assert.assertTrue(false, message);
						System.out.println("Not Saved");
					}

			}

	}
