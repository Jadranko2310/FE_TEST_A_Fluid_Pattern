package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import setup.basic.DriverSetup;
import setup.pom.BasePage;

/**
 * Defining web elements and base methods that can be performed for this page.
 * Constructor defining driver and url for TestNG to navigate.
 */
@Getter
@Setter
public class HomePage extends BasePage {

  public HomePage(WebDriver driver, String url) {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  /**
   * Static constructor. We can call it by proceeding driver and url parameter.
   */
  public static HomePage using(WebDriver driver, String url) {
    return new HomePage(driver, url);
  }


  //ELEMENT SECTION
  @FindBy(name = "q")
  WebElement searchStoreEntry;

  @FindBy(xpath = "//div[2]/ol/li/div")
  WebElement productImageBtn;

  @FindBy(xpath = "//nav/ul/li[3]/a/span[2]")
  WebElement dropDownBtn;

  @FindBy(xpath = "//div[4]/div[1]/div[1]/div[1]/a/span/span[2]")
  WebElement shopPerformanceBtn;

  @FindBy(xpath = "//ol/li[1]/div/a/span/span/img")
  WebElement firstItemBtn;

  @FindBy(xpath = "//header/div[1]/div/ul/li[2]/a")
  WebElement logInBtn;

  @FindBy(id = "email")
  WebElement emailEntry;

  @FindBy(id = "pass")
  WebElement passEntry;

  @FindBy(id = "send2")
  WebElement logInConfirmBtn;

  @FindBy(xpath = "//header/div[1]/div/ul/li[2]/span/button")
  WebElement dropDownAfterSignInBtn;

  @FindBy(xpath = "//header/div[1]/div/ul/li[1]/span")
  WebElement userWelcomeMessage;

  @FindBy(id = "email-error")
  WebElement emailErrorMessage;

  @FindBy(id = "pass-error")
  WebElement passErrorMessage;


  //METHOD SECTION

  /**
   * Will navigate to url, check if one element is visible.
   */
  public HomePage checkIfHomePageIsNavigated() {
    waitForElementToBeClickable(getSearchStoreEntry(), driver);
    sendText(getSearchStoreEntry(), "something");
    enter(getSearchStoreEntry());
    waitForElementVisibility(getProductImageBtn(), driver);
    return this;
  }

  /**
   * Will enter the email and password and click the "log in" option".
   */
  public HomePage logInUser(String email, String password) {
    clickElement(getLogInBtn());
    waitForElementVisibility(getLogInConfirmBtn(), driver);
    sendText(getEmailEntry(), email);
    sendText(getPassEntry(), password);
    clickElement(getLogInConfirmBtn());
    return this;
  }

  /**
   * Will assert that user is not logged in
   * and that system is showing validation messages.
   */
  @SuppressWarnings("ALL")
  public HomePage validateLogInWarningMessage(String emailErrorMsg, String passErrorMsg) {
    Assert.assertEquals(emailErrorMessage.getText(), emailErrorMsg);
    Assert.assertEquals(passErrorMessage.getText(), passErrorMsg);
    return this;
  }

  /**
   * \
   * Will select "man option" on home page and verify if navigated to "Man" page by
   * checking if the element is visible.
   */

  @SuppressWarnings("ALL")
  public HomePage navigateToFirstAvailableManProduct() {
    waitForElementToBeClickable(dropDownBtn, driver);
    clickElement(dropDownBtn);
    waitForElementToBeClickable(firstItemBtn, driver);
    return this;
  }
}

