package body.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Body for Log In validation messages. Can be used
 * for negative test cases.
 */
@Getter
@Setter
public class LogInWarningMessage {

  public String emailWarning;
  public String passwordWarning;

  public LogInWarningMessage(String emailWarning, String passwordWarning) {
    this.emailWarning = emailWarning;
    this.passwordWarning = passwordWarning;
  }
}
