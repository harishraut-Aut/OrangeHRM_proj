package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.qa.base.TestBase;

public class Emergency_contacts_Datadriven extends TestBase
	{
		public Emergency_contacts_Datadriven()
			{
				PageFactory.initElements(driver, this);
			}

		@FindBy(xpath = "//a[contains(text(),'Emergency Contacts')]")
		WebElement EmergencyContacts;

		@FindBy(xpath = "//input[@id='btnAddContact']")
		WebElement AddcontactBtn;

		@FindBy(xpath = "//input[@id='btnSaveEContact']")
		WebElement contactsaveBtn;

		@FindBy(xpath = "//*[@id=\"listEmegrencyContact\"]/div[2]/div")
		WebElement SavedSuccesfullymsg;

		@FindBy(xpath = "//input[@id='emgcontacts_name']")
		WebElement Name;

		@FindBy(xpath = "//input[@id='emgcontacts_relationship']")
		WebElement Relationship;

		@FindBy(xpath = "//input[@id='emgcontacts_mobilePhone']")
		WebElement Mobile;

		public Emergency_contacts_Datadriven clickon_Addemergencycontacts()
			{
				EmergencyContacts.click();
				return this;

			}

		public Emergency_contacts_Datadriven Clickon_addcontacts()
			{
				AddcontactBtn.click();
				return this;
			}

		public Boolean Successfullysavedmsg()
			{
				Boolean flag = SavedSuccesfullymsg.isDisplayed();
				Assert.assertTrue(flag);
				return flag;
			}

		public Emergency_contacts_Datadriven clickSaveContact()
			{
				contactsaveBtn.click();
				return this;
			}

		public Emergency_contacts_Datadriven clearName()
			{
				Name.clear();
				return this;
			}

		public Emergency_contacts_Datadriven clearRelationship()
			{
				Relationship.clear();
				return this;
			}

		public Emergency_contacts_Datadriven clearMobile()
			{
				Mobile.clear();
				return this;
			}

		// hardcoding this values ok and this values will come from dataprovider itself
		public void enterName(String Name)
			{
				// using this keyword to refer Name variable of this class..
				this.Name.sendKeys(Name);
			}

		public void enterRelationship(String Relationship)
			{
				this.Relationship.sendKeys(Relationship);
			}

		public void enterMobile(String Mobile)
			{
				this.Mobile.sendKeys(Mobile);
			}
	}
