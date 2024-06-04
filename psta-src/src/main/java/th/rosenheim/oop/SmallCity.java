package th.rosenheim.oop;

/** Small City without Cityparts */
public class SmallCity extends City {
  private static final String URL_TEMPLATE = "wetter_kleinstadt_%s.html";

  /**
   * Creates a new small city with the given name and weather.
   *
   * @param name the name of the city
   * @param weather the weather of the city
   */
  public SmallCity(String name, WeatherType weather) {
    super.name = name;
    super.weather = weather;
  }

  /**
   * Returns the weather info of the city as HTML.
   *
   * @return the weather info of the city as HTML
   */
  public String getContent() {
    return super.getBaseContent();
  }

  /**
   * Returns the file name of the city.
   *
   * @return the file name of the city
   */
  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
