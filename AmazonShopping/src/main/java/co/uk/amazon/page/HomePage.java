package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import co.uk.amazon.base.PageBase;
import co.uk.amazon.util.PropertiesUtil;

public class HomePage extends PageBase {

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBoxWE;

	@FindBy(xpath = "//*[@id='nav-searchbar']/div[1]/input")
	public WebElement goButtonWE;

	@FindBy(xpath = "//*[@id='reg-login-form']/form/div/p/input")
	public WebElement loginWE;

	@FindBy(linkText = "Login")
	public WebElement loginLinkWE;

	public HomePage(WebDriver driver) throws Exception {
		super(driver);
		driver.manage().deleteAllCookies();
		driver.get(new PropertiesUtil("properties/allProperties")
				.getValue("URL"));
		driver.manage().window().maximize();
	}

	public SearchResultsPage searchProduct(String product) throws Exception {
		assertTrue("Search Box TextField is not displayed",
				searchBoxWE.isDisplayed());
		enter(searchBoxWE, product);
		assertTrue("Go Button is not displayed", goButtonWE.isDisplayed());
		click(goButtonWE);
		return new SearchResultsPage(driver);
	}

}