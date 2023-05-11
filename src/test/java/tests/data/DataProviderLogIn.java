package tests.data;

import body.request.LogIn;
import body.request.LogInWarningMessage;
import org.testng.annotations.DataProvider;
import setup.pom.PomConstants;

/**
 * Providing data for log in edge cases.
 */
public class DataProviderLogIn {

  /**
   * Invalid data.
   */
  @DataProvider(name = "Log In Data")
  public Object[][] logInData() {
    return new Object[][]{
            {
            new LogIn("", ""),
            new LogInWarningMessage(PomConstants.REQUIRED_FIELD_ERROR, PomConstants.REQUIRED_FIELD_ERROR)
            },
            {
            new LogIn("email.email.com", ""),
            new LogInWarningMessage(PomConstants.INVALID_EMAIL_FORMAT,
                    PomConstants.REQUIRED_FIELD_ERROR)
            },
            {
            new LogIn("@gmail.com@gmail.com", ""),
            new LogInWarningMessage(PomConstants.INVALID_EMAIL_FORMAT,
                    PomConstants.REQUIRED_FIELD_ERROR)
            }
    };
  }
}
