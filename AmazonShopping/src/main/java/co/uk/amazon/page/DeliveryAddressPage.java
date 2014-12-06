package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;

public class DeliveryAddressPage extends PageBase {

	public DeliveryAddressPage(WebDriver driver) throws Exception {
		super(driver);

	}

	@FindBy(name = "useSelectedAddress")
	public WebElement deliverAddressWE;

	public VerifyDeliveryAddressPage clickDeliverAddress() throws Exception {
		assertTrue("Delivery Address is not displayed",
				deliverAddressWE.isDisplayed());
		deliverAddressWE.click();

		return new VerifyDeliveryAddressPage(driver);
	}

}