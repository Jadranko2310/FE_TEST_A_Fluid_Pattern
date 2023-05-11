package setup.basic;

import java.util.Properties;

/**
 * Enables reading value from properties.
 */
public class FileControlUtil {

  public Properties properties;

  public static final String URL_DATA_PROPERTIES = "URL.properties";
  public static final String USER_PROPERTIES = "User.properties";

  public FileControlUtil(String file) throws Exception {
    this.properties = new Properties();
    properties.load(getClass().getResourceAsStream("/" + file));
  }

  public String getValue(String propertyKey) {
    return properties.getProperty(propertyKey);
  }
}
