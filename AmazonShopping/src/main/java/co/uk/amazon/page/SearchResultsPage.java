package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;

public class SearchResultsPage extends PageBase {

	public SearchResultsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='result_2']/div/div/div/div[2]/div[1]/a/h2")
	public WebElement productWE;

	public ProductDescriptionPage clickThirdPhone() throws Exception {
		assertTrue("Products are not listed", productWE.isDisplayed());
		productWE.click();

		return new ProductDescriptionPage(driver);
	}

}