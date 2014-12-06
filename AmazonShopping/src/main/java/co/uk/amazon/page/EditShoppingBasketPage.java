package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.uk.amazon.base.PageBase;

public class EditShoppingBasketPage extends PageBase {

	public EditShoppingBasketPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(id = "ap_signin_create_radio")
	public WebElement newCustomerRadioButtonWE;

	@FindBy(id = "ap_email")
	public WebElement emailWE;

	@FindBy(id = "signInSubmit-input")
	public WebElement signInButtonWE;

	public SignInPage signIn(String email) throws Exception {

		new WebDriverWait(driver, 20).until(ExpectedConditions
				.presenceOfElementLocated(By.id("ap_signin_create_radio")));
		assertTrue("New Customer drop down is not displayed",
				newCustomerRadioButtonWE.isDisplayed());
		newCustomerRadioButtonWE.click();
		assertTrue("Email Text box is not displayed", emailWE.isDisplayed());
		enter(emailWE, email);
		assertTrue("Sign In Button is not displayed",
				signInButtonWE.isDisplayed());
		signInButtonWE.click();
		return new SignInPage(driver);
	}

}