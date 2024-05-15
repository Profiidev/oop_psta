package th.rosenheim.oop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WebsiteGenerator {
  private static final String OUT_DIR = "out/";
  private static final String TEMPLATE = "<html><body>%s%s</body></html>";
  private static final String NAME_TEMPLATE = "<h1>Die Wetter-App</h1>";
  private static final String NAVIGATION_TEMPLATE = "<a href=\"%s\">%s</a>";

  private List<City> cities;

  public WebsiteGenerator() {
    this.cities = new ArrayList<>();
  }

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

  public String generatePage(City city) {
    return String.format(TEMPLATE, getNavigation(), city.getContent());
  }

  public void generateWebsites() throws IOException {
    Files.createDirectories(Path.of(OUT_DIR));
    Files.write(Path.of(OUT_DIR + "index.html"), getNavigation().getBytes());

    for (City city : cities) {
      String page = generatePage(city);
      Files.write(Path.of(OUT_DIR + city.getUrl()), page.getBytes());
    }
  }

  public void addCity(City city) {
    cities.add(city);
  }
}
