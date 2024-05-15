package th.rosenheim.oop;

public class SmallCity extends City {
  private static final String URL_TEMPLATE = "wetter_kleinstadt_%s.html";

  public SmallCity(String name, WeatherType weather) {
    super.name = name;
    super.weather = weather;
  }

  public String getContent() {
    return super.getBaseContent();
  }

  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
