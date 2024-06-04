package th.rosenheim.oop;

import java.io.IOException;
import java.util.List;

/** Main Class */
public class App {
  /**
   * Main Method
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    WebsiteGenerator generator = new WebsiteGenerator();

    // create default cities
    generator.addCity(new SmallCity("Rosenheim", WeatherType.CLOUDY));
    generator.addCity(
        new BigCity(
            "München",
            WeatherType.RAINY,
            List.of("Schwabing", "Sendling", "Lehel", "Nymphenburg")));
    generator.addCity(
        new BigCity(
            "Köln",
            WeatherType.SUNNY,
            List.of("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk")));

    // generate websites
    try {
      generator.generateWebsites();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
