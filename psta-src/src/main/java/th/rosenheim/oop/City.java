package th.rosenheim.oop;

import java.util.List;

public abstract class City {
  protected static final String CITY_TEMPLATE = "<p>In %s ist es %s.</p>";

  // invalid characters and their replacements
  private static final List<Tuple<String, String>> TO_REPLACE =
      List.of(
          new Tuple<>(" ", "_"),
          new Tuple<>("ä", "ae"),
          new Tuple<>("ö", "oe"),
          new Tuple<>("ü", "ue"));

  protected String name;
  protected WeatherType weather;

  public abstract String getContent();

  public abstract String getUrl();

  /**
   * Returns the weather info of the city as HTML.
   *
   * @return the base weather info of the city as HTML
   */
  protected String getBaseContent() {
    return String.format(CITY_TEMPLATE, name, weather.text);
  }

  /**
   * Returns the file name of the city with the given template.
   *
   * @param template the template to use
   * @return the file name of the city
   */
  protected String getUrlWithTemplate(String template) {
    return String.format(template, nameToURL());
  }

  /**
   * Returns the name of the city as a URL and replaces invalid characters.
   *
   * @return the parsed name of the city
   */
  protected String nameToURL() {
    String name = this.name.toLowerCase();
    for (Tuple<String, String> pair : TO_REPLACE) {
      name = name.replace(pair._0, pair._1);
    }
    return name;
  }
}
