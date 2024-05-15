package th.rosenheim.oop;

public enum WeatherType {
  SUNNY("sonnig"),
  RAINY("regnerisch"),
  CLOUDY("bewölkt");

  public final String text;

  private WeatherType(String text) {
    this.text = text;
  }
}
