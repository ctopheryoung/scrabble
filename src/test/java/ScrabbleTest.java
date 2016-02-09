import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleTest {

  @Test
  public void scrabbleLetterScore_returnsAScrabbleScoreForALetter_1() {
    Scrabble scrabble = new Scrabble();
    Integer score = 1;
    assertEquals(score, scrabble.scrabbleLetterScore("A"));
  }
  @Test
  public void scrabbleLetterScore_returnsAScrabbleScoreForALetter_10() {
    Scrabble scrabble = new Scrabble();
    Integer score = 10;
    assertEquals(score, scrabble.scrabbleLetterScore("Z"));
  }

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForAWord_8() {
    Scrabble scrabble = new Scrabble();
    Integer score = 8;
    assertEquals(score, scrabble.scrabbleScore("hello"));
  }
}
