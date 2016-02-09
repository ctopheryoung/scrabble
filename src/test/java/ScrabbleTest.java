import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest {

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    Scrabble scrabble = new Scrabble();
    Integer score = 1;
    assertEquals(score, scrabble.scrabbleScore("A"));
  }
  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_10() {
    Scrabble scrabble = new Scrabble();
    Integer score = 10;
    assertEquals(score, scrabble.scrabbleScore("Z"));
  }
}
