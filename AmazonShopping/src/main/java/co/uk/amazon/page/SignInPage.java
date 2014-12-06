package co.uk.amazon.page;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import co.uk.amazon.base.PageBase;

public class SignInPage extends PageBase {

	public SignInPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(id = "ap_customer_name")
	public WebElement customerNameWE;

	@FindBy(id = "ap_email_check")
	public WebElement emailWE;

	@FindBy(id = "ap_password")
	public WebElement passwordWE;

	@FindBy(id = "ap_password_check")
	public WebElement reenterPasswordWE;

	@FindBy(id = "continue-input")
	public WebElement createAccountButtonWE;

	public RegistrationPage register(String customerName, String email,
			String password) throws Exception {

		new WebDriverWait(driver, 20).until(ExpectedConditions
				.presenceOfElementLocated(By.id("ap_customer_name")));
		assertTrue("Customer Name TextField is not displayed",
				customerNameWE.isDisplayed());
		enter(customerNameWE, customerName);
		assertTrue("Email id TextField is not displayed", emailWE.isDisplayed());
		enter(emailWE, email);
		assertTrue("Password TextField is not displayed",
				passwordWE.isDisplayed());
		enter(passwordWE, password);
		assertTrue("ReEnter Password TextField is not displayed",
				reenterPasswordWE.isDisplayed());
		enter(reenterPasswordWE, password);
		assertTrue("Create Account Button is not displayed",
				createAccountButtonWE.isDisplayed());
		createAccountButtonWE.click();
		return new RegistrationPage(driver);
	}

}