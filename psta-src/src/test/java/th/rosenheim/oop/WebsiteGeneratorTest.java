package th.rosenheim.oop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WebsiteGeneratorTest {

  private static WebsiteGenerator generator;

  @BeforeAll
  public static void setUp() {
    generator = new WebsiteGenerator();
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
  }

  @Test
  public void testCity1() {
    City city = new SmallCity("Rosenheim", WeatherType.CLOUDY);

    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=“wetter_kleinstadt_rosenheim.html“>Rosenheim</a> | <a href=“wetter_grossstadt_muenchen.html“>München</a> | <a href=“wetter_grossstadt_koeln.html“>Köln</a><p>In Rosenheim ist es bewölkt.</p></body></html>";
    String actual = generator.generatePage(city);

    assertEquals(expected, actual);
  }

  @Test
  public void testCity2() {
    City city =
        new BigCity(
            "München", WeatherType.RAINY, List.of("Schwabing", "Sendling", "Lehel", "Nymphenburg"));

    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=“wetter_kleinstadt_rosenheim.html“>Rosenheim</a> | <a href=“wetter_grossstadt_muenchen.html“>München</a> | <a href=“wetter_grossstadt_koeln.html“>Köln</a><p>In München ist es regnerisch.</p><p>Dies trifft auch für Schwabing, Sendling, Lehel, Nymphenburg zu.</p></body></html>";
    String actual = generator.generatePage(city);

    assertEquals(expected, actual);
  }

  @Test
  public void testCity3() {
    City city =
        new BigCity(
            "Köln",
            WeatherType.SUNNY,
            List.of("Raderthal", "Ehrenfeld", "Nippes", "Poll", "Esch", "Pesch", "Kalk"));

    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=“wetter_kleinstadt_rosenheim.html“>Rosenheim</a> | <a href=“wetter_grossstadt_muenchen.html“>München</a> | <a href=“wetter_grossstadt_koeln.html“>Köln</a><p>In Köln ist es sonnig.</p><p>Dies trifft auch für Raderthal, Ehrenfeld, Nippes, Poll, Esch, Pesch, Kalk zu.</p></body></html>";
    String actual = generator.generatePage(city);

    assertEquals(expected, actual);
  }
}
