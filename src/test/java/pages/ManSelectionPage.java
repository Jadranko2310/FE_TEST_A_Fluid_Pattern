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
 * Man section Page. Web elements and methods.
 */
@Getter
@Setter
public class ManSelectionPage extends BasePage {
  public ManSelectionPage(WebDriver driver, String url) {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  // ELEMENTS SECTION

  @FindBy(xpath = "//div[3]/div/div/ol/li[1]/div")
  WebElement firstProduct;
  @FindBy(xpath = "//ol/li[1]/div/div/strong/a")
  WebElement productDescription;

  @SuppressWarnings("ALL")
  @FindBy(id = "product-addtocart-button")
  WebElement addToCard;

  @SuppressWarnings("ALL")
  @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span")
  WebElement purchaseSelectionHeadline;

  @FindBy(xpath = "//form/div[1]/div/div/div[1]/div/div[2]")
  WebElement smallSizeSelectionBtn;

  @FindBy(id = "qty")
  WebElement numberOfItemsEntryField;

  @FindBy(xpath = "//*[@id=\"option-label-color-93-item-52\"]")
  WebElement colorSelectionBtn;

  @SuppressWarnings("ALL")
  @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
  WebElement purchaseConfirmationMessage;


  // METHODS SECTION
  /**
   * Will check if the first product is present.
   */
  @SuppressWarnings("UnusedReturnValue")
  public ManSelectionPage verifyThatFirstProductIsPresent() {
    Assert.assertEquals(getTextFromElement(productDescription), "Argus All-Weather Tank");
    return this;
  }

  /**
   * Will navigate and wait for element visibility.
   */
  public ManSelectionPage navigateToAddToCardSection() {
    hoverOverElement(firstProduct, driver);
    firstProduct.click();
    waitForElementVisibility(purchaseSelectionHeadline, driver);
    return this;
  }

  /**
   * Will check if purchase title is present after selecting the item.
   */
  public ManSelectionPage verifyIfPurchasePageTitleIsPresent() {
    waitForElementVisibility(purchaseSelectionHeadline, driver);
    Assert.assertEquals(purchaseSelectionHeadline.getText(), "Argus All-Weather Tank");
    return this;
  }

  /**
   * Will select product details before purchase.
   */
  public ManSelectionPage chooseProductDetails(String nmbOfItems) {
    waitForElementToBeClickable(smallSizeSelectionBtn, driver);
    smallSizeSelectionBtn.click();
    sendText(numberOfItemsEntryField, nmbOfItems);
    colorSelectionBtn.click();
    return this;
  }

  /**
   * Will select final "add to cart" option.
   */
  public ManSelectionPage finishPurchase() {
    waitForElementToBeClickable(addToCard, driver);
    addToCard.click();
    return this;
  }

  /**
   * Will verify if the purchase is successfully finished.
   */
  @SuppressWarnings("ALL")
  public ManSelectionPage verifyIfPurchaseIsFinished() {
    waitForElementVisibility(purchaseConfirmationMessage, driver);
    Assert.assertEquals(purchaseConfirmationMessage.getText(),
            "You added Argus All-Weather Tank to your shopping cart.");
    return this;
  }

  /**
   * Static constructor. We can call it by proceeding driver and url parameter.
   */
  public static ManSelectionPage using(WebDriver driver, String url) {
    return new ManSelectionPage(driver, url);
  }
}
