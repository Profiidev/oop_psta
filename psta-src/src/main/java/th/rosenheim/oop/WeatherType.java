package th.rosenheim.oop;

/**
 * All possible Weather types
 */
public enum WeatherType {
  /**
   * Sunny
   */
  SUNNY("sonnig"),
  /**
   * rainy
   */
  RAINY("regnerisch"),
  /**
   * cloudy
   */
  CLOUDY("bewölkt");

  /**
   * The Display text
   */
  public final String text;

  /**
   * Creates a new weather type with the given display text.
   *
   * @param text the display text
   */
  private WeatherType(String text) {
    this.text = text;
  }
}
