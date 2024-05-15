package th.rosenheim.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SmallCityTest {

  private static SmallCity smallCity;

  @BeforeAll
  public static void setUp() {
    smallCity = new SmallCity("Test City", WeatherType.SUNNY);
  }

  @Test
  public void testGetContent() {
    String expected = "<p>In Test City ist es sonnig.</p>";
    String actual = smallCity.getContent();

    assertEquals(expected, actual);
  }

  @Test
  public void testGetUrl() {
    String expected = "wetter_kleinstadt_test_city.html";
    String actual = smallCity.getUrl();

    assertEquals(expected, actual);
  }
}
