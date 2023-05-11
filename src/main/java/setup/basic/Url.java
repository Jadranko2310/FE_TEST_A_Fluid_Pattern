package setup.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * URL for pages.
 */
@Getter
@Setter
public class Url {
  public String homePageUrl;

  public String manSelectionPageUrl;

  public String bagsSectionPageUrl;

  /**
   * Constructor taking url values from predefined constant.
   */
  public Url() {
    this.homePageUrl = SetupConstants.BASE_URL;
    this.manSelectionPageUrl = SetupConstants.MAN_SECTION_URL;
    this.bagsSectionPageUrl = SetupConstants.BAGS_SECTION_URL;
  }
}
