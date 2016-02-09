import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Scrabble {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String word = request.queryParams("scrabbleWord");
      int score = scrabbleScore(word);
      model.put("word", score);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }

  public static Integer scrabbleLetterScore(String letter) {
    HashMap<String, Integer> alphabet = new HashMap();
    alphabet.put("A", 1);
    alphabet.put("B", 3);
    alphabet.put("C", 3);
    alphabet.put("D", 2);
    alphabet.put("E", 1);
    alphabet.put("F", 4);
    alphabet.put("G", 2);
    alphabet.put("H", 4);
    alphabet.put("I", 1);
    alphabet.put("J", 8);
    alphabet.put("K", 5);
    alphabet.put("L", 1);
    alphabet.put("M", 3);
    alphabet.put("N", 1);
    alphabet.put("O", 1);
    alphabet.put("P", 3);
    alphabet.put("Q", 10);
    alphabet.put("R", 1);
    alphabet.put("S", 1);
    alphabet.put("T", 1);
    alphabet.put("U", 1);
    alphabet.put("V", 4);
    alphabet.put("W", 4);
    alphabet.put("X", 8);
    alphabet.put("Y", 4);
    alphabet.put("Z", 10);
    Integer score = alphabet.get(letter);
    return score;
    // score += alphabet.get(word.charAt(0));

    // for (int i = 0; i <word.length(); i++) {
    // }



  }
  public static Integer scrabbleScore(String word) {
    Integer wordScore = 0;
    String upperCaseWord = word.toUpperCase();
    String[] letterArray = upperCaseWord.split("");

    for (Integer i = 0; i < letterArray.length; i++) {
      Integer letterScore = scrabbleLetterScore(letterArray[i]);
      wordScore = wordScore + letterScore;
    }
    return wordScore;
  }
}
