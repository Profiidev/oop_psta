package th.rosenheim.oop;

import java.util.List;
import java.util.stream.Collectors;

public class BigCity extends City {
  private static final String CITY_PARTS_TEMPLATE = "<p>Dies trifft auch für %s zu.</p>";
  private static String URL_TEMPLATE = "wetter_grossstadt_%s";

  private List<Tuple<String, WeatherType>> cityParts;

  public String getContent() {
    String cityPart = super.getBaseContent();

    List<String> similarCityParts = cityParts.stream()
        .filter(pair -> pair._1 == weather)
        .map(pair -> pair._0)
        .collect(Collectors.toList());

    String cityParts = String.format(CITY_PARTS_TEMPLATE, String.join(", ", similarCityParts));

    return cityPart + cityParts;
  }

  public String getUrl() {
    return super.getUrlWithTemplate(URL_TEMPLATE);
  }
}
