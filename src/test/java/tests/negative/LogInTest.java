package tests.negative;

import body.request.LogInWarningMessage;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests.data.DataProviderLogIn;


/**
 * Iterative negative tests. Sending negative attributes
 * and asserting validation messages.
 */
public class LogInTest extends BaseTest {

  /**
   * Calling data provider and iterating test.
   */
  @Test(dataProvider = "Log In Data", dataProviderClass = DataProviderLogIn.class)
  public void negativeLogin(body.request.LogIn login, LogInWarningMessage warningMessage) {
    HomePage.using(driver, url.getHomePageUrl())
            .logInUser(login.email, login.password)
            .validateLogInWarningMessage(
                    warningMessage.emailWarning,
                    warningMessage.passwordWarning);
  }
}
