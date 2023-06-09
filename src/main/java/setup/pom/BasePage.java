package setup.pom;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.basic.SetupConstants;


/**
 * Basic actions on Pages.
 */
@SuppressWarnings("ALL")
@Getter
@Setter
public class BasePage {
  protected WebDriver driver;


  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public void sendText(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }

  public void enter(WebElement element) {
    element.sendKeys(Keys.ENTER);
  }

  public void downKey(WebElement element) {
    element.sendKeys(Keys.DOWN);
  }

  public void upKey(WebElement element) {
    element.sendKeys(Keys.UP);
  }

  public String getTextFromElement(WebElement element) {
    return element.getText();
  }

  public boolean isEnabled(WebElement element) {
    return element.isEnabled();
  }

  public boolean isDisplayed(WebElement element) {
    return element.isDisplayed();
  }

  public void selectViaVisibleText(WebElement element, String text) {
    Select dropDown = new Select(element);
    dropDown.selectByVisibleText(text);
  }

  public void selectByValue(WebElement element, String value) {
    Select dropDown = new Select(element);
    dropDown.selectByValue(value);
  }

  public void hoverOverElement(WebElement element, WebDriver driver) {
    Actions hover = new Actions(driver);
    hover.moveToElement(element).build().perform();
  }

  public void clickOnHoveredElement(WebElement element, WebDriver driver) {
    Actions hover = new Actions(driver);
    hover.moveToElement(element).click().build().perform();
  }

  /**
   * Will wait for defined number of seconds for web element to be visible.
   */
  public void waitForElementVisibility(WebElement element, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(SetupConstants.ELEMENT_DETECTION_TIMEOUT));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  /**
   * Will wait for defined number of seconds for web element to be clickable.
   */
  public void waitForElementToBeClickable(WebElement element, WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(SetupConstants.ELEMENT_DETECTION_TIMEOUT));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void hitEnter() {
    Keys enter = Keys.ENTER;
  }
}
