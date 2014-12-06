package co.uk.amazon.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import co.uk.amazon.page.AddProductPage;
import co.uk.amazon.page.DeliveryAddressPage;
import co.uk.amazon.page.DeliveryOptionsPage;
import co.uk.amazon.page.EditShoppingBasketPage;
import co.uk.amazon.page.HomePage;
import co.uk.amazon.page.ProductDescriptionPage;
import co.uk.amazon.page.ProductDetailsPage;
import co.uk.amazon.page.RegistrationPage;
import co.uk.amazon.page.SearchResultsPage;
import co.uk.amazon.page.SignInPage;
import co.uk.amazon.page.VerifyDeliveryAddressPage;
import co.uk.amazon.util.PropertiesUtil;

public class TC_Shop_IPhone {

	private static WebDriver driver;
	public static PropertiesUtil allProperties = null;

	private static final String PROPERTIES = "properties/allProperties";

	@BeforeClass
	public static void initializeClass() throws FileNotFoundException,
			IOException {
		allProperties = new PropertiesUtil(PROPERTIES);
		/**
		 * Use the below code snippet to execute in chrome driver. Change the
		 * path of the driver
		 */
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\_000_Tamizh_Office\\Automation\\chromedriver_win32\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities
				.setCapability("chrome.binary",
						"C:\\_000_Tamizh_Office\\Automation\\chromedriver_win32\\chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		  driver = new ChromeDriver(capabilities);
		 

		//driver = new FirefoxDriver();

	}

	@Before
	public void setupTest() {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
	}

	/**
	 * Test case to buy IPhone 6 From amazon.co.uk by adding to basket, and
	 * editing the quantity to 3. Enter the sign in details and mandatory fields
	 * and continue till payment page
	 */
	@Test
	public void testIPhone_Shopping() throws Exception {

		String emailId = "Auto" + UUID.randomUUID().toString().substring(0, 5)
				+ "@gmail.com";

		HomePage homePage = new HomePage(driver);

		SearchResultsPage resultPage = homePage.searchProduct(allProperties
				.getValue("PRODUCT"));

		ProductDescriptionPage descriptionPage = resultPage.clickThirdPhone();

		AddProductPage addProduct = descriptionPage.addToBasket();

		ProductDetailsPage detailsPage = addProduct.clickEditBasket();

		EditShoppingBasketPage editShopping = detailsPage.changeQuantity();

		SignInPage signIn = editShopping.signIn(emailId);

		RegistrationPage registration = signIn.register(
				allProperties.getValue("CUSTOMER_NAME"), emailId,
				allProperties.getValue("PASSWORD"));

		DeliveryAddressPage addressPage = registration.enterAddress(
				allProperties.getValue("FULL_NAME"),
				allProperties.getValue("ADDRESS1"),
				allProperties.getValue("ADDRESS2"),
				allProperties.getValue("CITY"),
				allProperties.getValue("COUNTRY"),
				allProperties.getValue("POST_CODE"),
				allProperties.getValue("PHONE_NUMBER"));

		VerifyDeliveryAddressPage verifyAddress = addressPage
				.clickDeliverAddress();

		DeliveryOptionsPage optionsPage = verifyAddress.clickContinue();

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
