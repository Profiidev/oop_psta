package th.rosenheim.oop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BigCityTest {

  private static BigCity bigCity;

  @BeforeAll
  public static void setUp() {
    bigCity =
        new BigCity("Test City", WeatherType.RAINY, Arrays.asList("Teil 1", "Teil 2", "Teil 3"));
  }

  @Test
  public void testGetContent() {
    String expected =
        "<p>In Test City ist es regnerisch.</p><p>Dies trifft auch für Teil 1, Teil 2, Teil 3 zu.</p>";
    String actual = bigCity.getContent();

    assertEquals(expected, actual);
  }

  @Test
  public void testGetUrl() {
    String expected = "wetter_grossstadt_test_city.html";
    String actual = bigCity.getUrl();

    assertEquals(expected, actual);
  }
}
