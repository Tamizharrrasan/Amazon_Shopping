package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;

public class VerifyDeliveryAddressPage extends PageBase {

	public VerifyDeliveryAddressPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//input[@class='a-button-text']")
	public WebElement continueWE;

	public DeliveryOptionsPage clickContinue() throws Exception {
		assertTrue("Continue Button is not displayed", continueWE.isDisplayed());
		continueWE.click();
		return new DeliveryOptionsPage(driver);
	}

}