package th.rosenheim.oop;

import java.util.List;

public abstract class City {
  protected static String CITY_TEMPLATE = "<p>In %s ist es %s.</p>";

  private static List<Tuple<String, String>> TO_REPLACE = List.of(
      new Tuple<>(" ", "_"),
      new Tuple<>("ä", "ae"),
      new Tuple<>("ö", "oe"),
      new Tuple<>("ü", "ue"));

  protected String name;
  protected WeatherType weather;

  public abstract String getContent();

  public abstract String getUrl();

  protected String getBaseContent() {
    return String.format(CITY_TEMPLATE, name, weather.text);
  }

  protected String getUrlWithTemplate(String template) {
    return String.format(template, nameToURL());
  }

  protected String nameToURL() {
    String name = this.name.toLowerCase();
    for (Tuple<String, String> pair : TO_REPLACE) {
      name = name.replace(pair._0, pair._1);
    }
    return name;
  }
}
