package th.rosenheim.oop;

import java.util.List;

/** Big City with Cityparts */
public class BigCity extends City {
  private static final String CITY_PARTS_TEMPLATE = "<p>Dies trifft auch für %s zu.</p>";
  private static final String URL_TEMPLATE = "wetter_grossstadt_%s.html";

  private List<String> cityParts;

  /**
   * Creates a new big city with the given name, weather type and city parts.
   *
   * @param name the name of the big city
   * @param weather the weather type of the big city
   * @param cityParts the list of city parts associated with the big city
   */
  public BigCity(String name, WeatherType weather, List<String> cityParts) {
    this.cityParts = cityParts;
    super.name = name;
    super.weather = weather;
  }

  /**
   * Returns the weather info of the big city and cityParts as HTML.
   *
   * @return the weather info of the big city and cityParts as HTML
   */
  public String getContent() {
    String cityPart = super.getBaseContent();

    String cityPartsConcat = "";
    if (cityParts.size() > 1) {
      cityPartsConcat = String.join(", ", cityParts.subList(0, cityParts.size() - 1));
      cityPartsConcat += " und " + cityParts.get(cityParts.size() - 1);
    } else {
      cityPartsConcat = cityParts.get(0);
    }
    String cityPartsPart = String.format(CITY_PARTS_TEMPLATE, cityPartsConcat);

    return cityPart + cityPartsPart;
  }

  /**
   * Returns the file name of the big city.
   *
   * @return the file name of the big city
   */
  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
