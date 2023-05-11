package setup.basic;

/**
 * Setting string values from properties files.
 */
public class SetupConstants {

  public static final  FileControlUtil fileControlURL;
  public static final  FileControlUtil fileControlUser;

  static {
    try {
      fileControlURL = new FileControlUtil(FileControlUtil.URL_DATA_PROPERTIES);
      fileControlUser = new FileControlUtil(FileControlUtil.USER_PROPERTIES);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static  String BASE_URL = fileControlURL.getValue("BASE_URL");
  public static  String MAN_SECTION_URL = fileControlURL.getValue("MAN_SECTION_URL");
  public static  String BAGS_SECTION_URL = fileControlURL.getValue("BAGS_URL");
  public static final String USER_EMAIL = fileControlUser.getValue("EMAIL");
  public static final String USER_PASS = fileControlUser.getValue("PASS");

  public static final int ELEMENT_DETECTION_TIMEOUT = 4;
  public static final int PAGE_LOAD_TIME = 10;
}
