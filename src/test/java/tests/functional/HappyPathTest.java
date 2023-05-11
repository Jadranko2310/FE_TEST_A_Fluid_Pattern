package tests.functional;


import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;
import pages.ManSelectionPage;
import setup.basic.SetupConstants;
import tests.BaseTest;

/**
 * Testing basic flow.
 */
public class HappyPathTest extends BaseTest {

  @Test
  public void baseFlow() {
    HomePage.using(driver, url.homePageUrl)
            .checkIfHomePageIsNavigated()
            .logInUser(SetupConstants.USER_EMAIL, SetupConstants.USER_PASS)
            .navigateToFirstAvailableManProduct();
    ManSelectionPage.using(driver, url.manSelectionPageUrl)
            .verifyThatFirstProductIsPresent();
  }

  @Test
  public void purchase() {
    ManSelectionPage.using(driver, url.manSelectionPageUrl)
            .navigateToAddToCardSection()
            .verifyIfPurchasePageTitleIsPresent()
            .chooseProductDetails("2")
            .finishPurchase()
            .verifyIfPurchaseIsFinished();
  }

  @Test
  public void filterProductByStyle() {
    BagsPage.using(driver, url.bagsSectionPageUrl)
            .filterProductByStyle()
            .verifyThatProductListIsFilteredByStyle();
  }
}
