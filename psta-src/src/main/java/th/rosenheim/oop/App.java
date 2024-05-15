package th.rosenheim.oop;

import java.io.IOException;
import java.util.List;

public class App {
  public static void main(String[] args) {
    WebsiteGenerator generator = new WebsiteGenerator();
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

    try {
      generator.generateWebsites();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
