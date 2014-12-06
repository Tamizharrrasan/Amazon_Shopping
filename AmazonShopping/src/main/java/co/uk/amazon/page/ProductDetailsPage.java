package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.uk.amazon.base.PageBase;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(className = "a-dropdown-container")
	public WebElement quantityDropDownWE;

	@FindBy(xpath = "//div[@id='a-popover-1']/div/div/ul/li[3]/a")
	public WebElement selectQuantity;

	@FindBy(name = "proceedToCheckout")
	public WebElement proceedCheckoutWE;

	public EditShoppingBasketPage changeQuantity() throws Exception {
		new WebDriverWait(driver, 20)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.className("a-dropdown-container")));
		assertTrue("Quantity drop down is not displayed",
				quantityDropDownWE.isDisplayed());
		click(quantityDropDownWE);
		selectQuantity.click();
		proceedCheckoutWE.click();
		return new EditShoppingBasketPage(driver);
	}

}