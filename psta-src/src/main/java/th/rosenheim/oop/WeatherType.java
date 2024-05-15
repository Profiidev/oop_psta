package th.rosenheim.oop;

public enum WeatherType {
  SUNNY("sonnig"),
  RAINY("regnerisch"),
  CLOUDY("bewölkt");

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
