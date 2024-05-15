package th.rosenheim.oop;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AppTest {

  @BeforeAll
  static void setUp() {
    App.main(new String[0]);
  }

  @Test
  void testIndex() throws IOException {
    String expected =
        "<h1>Die Wetter-App</h1><a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a> | <a href=\"wetter_grossstadt_muenchen.html\">München</a> | <a href=\"wetter_grossstadt_koeln.html\">Köln</a>";
    String actual = new String(Files.readAllBytes(Paths.get("out/index.html")));

    assertEquals(expected, actual);
  }

  @Test
  void testCity1() throws IOException {
    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a> | <a href=\"wetter_grossstadt_muenchen.html\">München</a> | <a href=\"wetter_grossstadt_koeln.html\">Köln</a><p>In Rosenheim ist es bewölkt.</p></body></html>";
    String actual =
        new String(Files.readAllBytes(Paths.get("out/wetter_kleinstadt_rosenheim.html")));

    assertEquals(expected, actual);
  }

  @Test
  void testCity2() throws IOException {
    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a> | <a href=\"wetter_grossstadt_muenchen.html\">München</a> | <a href=\"wetter_grossstadt_koeln.html\">Köln</a><p>In München ist es regnerisch.</p><p>Dies trifft auch für Schwabing, Sendling, Lehel, Nymphenburg zu.</p></body></html>";
    String actual =
        new String(Files.readAllBytes(Paths.get("out/wetter_grossstadt_muenchen.html")));

    assertEquals(expected, actual);
  }

  @Test
  void testCity3() throws IOException {
    String expected =
        "<html><body><h1>Die Wetter-App</h1><a href=\"wetter_kleinstadt_rosenheim.html\">Rosenheim</a> | <a href=\"wetter_grossstadt_muenchen.html\">München</a> | <a href=\"wetter_grossstadt_koeln.html\">Köln</a><p>In Köln ist es sonnig.</p><p>Dies trifft auch für Raderthal, Ehrenfeld, Nippes, Poll, Esch, Pesch, Kalk zu.</p></body></html>";
    String actual = new String(Files.readAllBytes(Paths.get("out/wetter_grossstadt_koeln.html")));

    assertEquals(expected, actual);
  }
}
