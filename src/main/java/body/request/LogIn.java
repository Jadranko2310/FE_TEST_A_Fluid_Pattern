package body.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Log In body.
 */
@Getter
@Setter
public class LogIn {
  public String email;

  public String password;

  public LogIn(String username, String password) {
    this.email = username;
    this.password = password;
  }
}
