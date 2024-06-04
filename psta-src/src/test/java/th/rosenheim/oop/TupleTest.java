package th.rosenheim.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TupleTest {

  @Test
  public void testTuple() {
    Tuple<Integer, String> tuple = new Tuple<>(10, "Hello");
    assertEquals(10, tuple._0());
    assertEquals("Hello", tuple._1());

    Tuple<String, Integer> tuple2 = new Tuple<>("World", 20);
    assertEquals("World", tuple2._0());
    assertEquals(20, tuple2._1());

    Tuple<String, String> tuple3 = new Tuple<>("Hello", "World");
    assertEquals("Hello", tuple3._0());
    assertEquals("World", tuple3._1());
  }
}
