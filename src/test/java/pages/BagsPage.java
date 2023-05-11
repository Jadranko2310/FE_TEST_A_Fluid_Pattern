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
 * Web elements and user action methods for "Bags Page".
 */
@Getter
@Setter
public class BagsPage extends BasePage {
  public BagsPage(WebDriver driver, String url) {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  public static BagsPage using(WebDriver driver, String url) {
    return new BagsPage(driver, url);
  }

  // ELEMENT SECTION -- important to switch to tags, id or some other css locator.


  @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[1]/div[1]")
  WebElement styleSideFilterDropDown;

  @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[1]/a")
  WebElement backpackFilterSelection;

  @FindBy(xpath = "//div[3]/ol/li[1]/div/div/strong/a")
  WebElement drivenBackPackProductName;

  @FindBy(id = "sorter")
  WebElement sorterDropDownBtn;

  @FindBy(xpath = "//div[2]/div[3]/select/option[2]")
  WebElement productNameFilter;

  @FindBy(css = "input[type='text'][name='Compete Track Tote']")
  WebElement firstProductByAlphabetOrder;


  //METHOD SECTION

  /** Filtering product by style.
   */
  public BagsPage filterProductByStyle() {
    styleSideFilterDropDown.click();
    backpackFilterSelection.click();
    return this;
  }

  /**
   * Asserting that product list is filtered.
   */
  @SuppressWarnings("UnusedReturnValue")
  public BagsPage verifyThatProductListIsFilteredByStyle() {
    Assert.assertEquals(getTextFromElement(drivenBackPackProductName), "Driven Backpack");
    return this;
  }

}