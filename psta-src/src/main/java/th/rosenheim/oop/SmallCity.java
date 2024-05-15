package th.rosenheim.oop;

public class SmallCity extends City {
  private static String URL_TEMPLATE = "wetter_kleinstadt_%s";

  public String getContent() {
    return super.getBaseContent();
  }

  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
