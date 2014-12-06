package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.uk.amazon.base.PageBase;

public class ProductDescriptionPage extends PageBase {

	public ProductDescriptionPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(name = "submit.add-to-cart")
	public WebElement addBasketWE;

	public AddProductPage addToBasket() throws Exception {
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.presenceOfElementLocated(By.name("submit.add-to-cart")));
		assertTrue("Add to Basket button is not displayed",
				addBasketWE.isDisplayed());
		addBasketWE.click();
		return new AddProductPage(driver);
	}

}