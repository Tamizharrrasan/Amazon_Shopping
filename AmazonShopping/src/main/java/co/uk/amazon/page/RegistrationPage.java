package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(id = "enterAddressFullName")
	public WebElement fullNameWE;

	@FindBy(id = "enterAddressAddressLine1")
	public WebElement addressLineOneWE;

	@FindBy(id = "enterAddressAddressLine2")
	public WebElement addressLineTwoWE;

	@FindBy(id = "enterAddressPostalCode")
	public WebElement postCodeWE;

	@FindBy(id = "enterAddressPhoneNumber")
	public WebElement phoneNumberWE;

	@FindBy(name = "shipToThisAddress")
	public WebElement nameWE;

	@FindBy(id = "enterAddressCity")
	public WebElement cityWE;

	@FindBy(id = "enterAddressStateOrRegion")
	public WebElement countryWE;

	public DeliveryAddressPage enterAddress(String fullName,
			String adddressOne, String addressTwo, String city, String country,
			String postCode, String phoneNumber) throws Exception {
		assertTrue("Full Name TextField is not displayed",
				fullNameWE.isDisplayed());
		enter(fullNameWE, fullName);
		assertTrue("Address OneTextField is not displayed",
				addressLineOneWE.isDisplayed());
		enter(addressLineOneWE, adddressOne);
		assertTrue("Address Two TextField is not displayed",
				addressLineTwoWE.isDisplayed());
		enter(addressLineTwoWE, addressTwo);
		assertTrue("city TextField is not displayed", cityWE.isDisplayed());
		enter(cityWE, city);
		assertTrue("Country TextField is not displayed",
				countryWE.isDisplayed());
		enter(countryWE, country);
		assertTrue("Post Code TextField is not displayed",
				postCodeWE.isDisplayed());
		enter(postCodeWE, postCode);
		assertTrue("Phone Number is not displayed", phoneNumberWE.isDisplayed());
		enter(phoneNumberWE, phoneNumber);
		assertTrue("Ship to Address TextField is not displayed",
				nameWE.isDisplayed());
		click(nameWE);

		return new DeliveryAddressPage(driver);
	}

}
