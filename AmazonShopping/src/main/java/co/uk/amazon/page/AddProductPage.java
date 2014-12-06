package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;

public class AddProductPage extends PageBase {

	public AddProductPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(id = "a-autoid-0-announce")
	public WebElement editBasket;

	public ProductDetailsPage clickEditBasket() throws Exception {
		assertTrue("Edit Basket button is not displayed",
				editBasket.isDisplayed());
		editBasket.click();
		return new ProductDetailsPage(driver);
	}

}