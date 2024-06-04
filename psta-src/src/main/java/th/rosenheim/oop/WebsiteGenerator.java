package th.rosenheim.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Class for generating the websites and index.html file */
public class WebsiteGenerator {
  private static final String OUT_DIR = "out/";
  private static final String TEMPLATE = "<html><body>%s%s</body></html>";
  private static final String NAME_TEMPLATE = "<h1>Die Wetter-App</h1>";
  private static final String NAVIGATION_TEMPLATE = "<a href=\"%s\">%s</a>";

  private List<City> cities;

  /** Creates a new empty website generator. */
  public WebsiteGenerator() {
    this.cities = new ArrayList<>();
  }

  /**
   * Returns the navigation part of the website including all cities as HTML.
   *
   * @return the navigation part as HTML
   */
  private String getNavigation() {
    StringBuilder navigation = new StringBuilder();
    navigation.append(NAME_TEMPLATE);

    List<String> cityParts =
        cities.stream()
            .map(city -> String.format(NAVIGATION_TEMPLATE, city.getUrl(), city.name))
            .toList();
    navigation.append(String.join(" | ", cityParts));

    return navigation.toString();
  }

  /**
   * Returns the fully generated page of the given city as HTML including the nav part.
   *
   * @param city the city to generate the page for
   * @return the page of the city as HTML
   */
  public String generatePage(City city) {
    return String.format(TEMPLATE, getNavigation(), city.getContent());
  }

  /**
   * Generates the websites for all cities and writes them to the output directory ("out").
   *
   * @throws IOException if creating the directories or writing to a file fails
   */
  public void generateWebsites() throws IOException {
    Files.createDirectories(Path.of(OUT_DIR));
    Files.write(
        Path.of(OUT_DIR + "index.html"), String.format(TEMPLATE, getNavigation(), "").getBytes());

    for (City city : cities) {
      String page = generatePage(city);
      Files.write(Path.of(OUT_DIR + city.getUrl()), page.getBytes());
    }
  }

  /**
   * Adds a city to the Website
   *
   * @param city city to add
   */
  public void addCity(City city) {
    cities.add(city);
  }
}
