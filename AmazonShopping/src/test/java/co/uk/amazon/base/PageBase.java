package co.uk.amazon.base;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*Select drop down bu Visible Text */
	public Select select(WebElement webElement, String name) {
		elementDisplayed(webElement);
		Select selectedElement = new Select(webElement);
		selectedElement.selectByVisibleText(name);
		return selectedElement;
	}
	/*Select drop down by Value */
	public Select selectByValue(WebElement webElement, String name) {
		elementDisplayed(webElement);
		webElement.sendKeys(name);
		Select selectedElement = new Select(webElement);
		selectedElement.selectByValue(name);
		return selectedElement;
	}
	/*Click the Element */
	public void click(WebElement webElement) {
		elementDisplayed(webElement);
		webElement.click();
	}
	/*Tick the checkbox*/
	public void check(WebElement webElement) {
		elementDisplayed(webElement);
		webElement.click();
	}
	/*Enter the text in the text box */
	public void enter(WebElement webElement, String text) {
		elementDisplayed(webElement);
		webElement.sendKeys(text);
	}
	/*Get the entered text */
	public String getEnteredText(WebElement webElement) {
		elementDisplayed(webElement);
		return webElement.getAttribute("value");
	}

	public void getSelectedElement(WebElement dropDownElement) {
		dropDownElement.getText();
	}

	public boolean isElementSelected(Select selectedWebElement,
			String elementTitle) {

		if (selectedWebElement.getFirstSelectedOption().getText()
				.equals(elementTitle)) {
			return true;
		} else
			return false;
	}

	public void getAlertText(Alert alert) {
		alert.getText();
	}

	public void elementDisplayed(final WebElement element) {
		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = waits.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element.findElement(By.xpath("."));
			}

		});
		try {
			foo.isDisplayed();

		} catch (Exception e) {

		}
	}
	
	public void presenceOfElement(WebElement element){
		new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element));
	}

	public static void unExpectedException(Exception e) {
		fail(new StringBuilder(128).append("Unexpected exception :  ")
				.append(e.getMessage()).toString());
	}
}
