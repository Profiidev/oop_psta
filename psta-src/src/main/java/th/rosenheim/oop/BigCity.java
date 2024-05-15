package th.rosenheim.oop;

import java.util.List;

public class BigCity extends City {
  private static final String CITY_PARTS_TEMPLATE = "<p>Dies trifft auch für %s zu.</p>";
  private static final String URL_TEMPLATE = "wetter_grossstadt_%s.html";

  private List<String> cityParts;

  public BigCity(String name, WeatherType weather, List<String> cityParts) {
    this.cityParts = cityParts;
    super.name = name;
    super.weather = weather;
  }

  public String getContent() {
    String cityPart = super.getBaseContent();
    String cityPartsPart = String.format(CITY_PARTS_TEMPLATE, String.join(", ", cityParts));

    return cityPart + cityPartsPart;
  }

  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
