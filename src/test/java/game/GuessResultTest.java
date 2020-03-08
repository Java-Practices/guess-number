package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class GuessResultTest {
    
    @Test
    void test_game_result_happy_path() {
        Map<String, String> guessRecord = new LinkedHashMap<>();
        guessRecord.put("1234", "0A1B");
        guessRecord.put("1235", "0A0B");
        guessRecord.put("1264", "0A2B");
        guessRecord.put("1764", "0A2B");
        GuessResult guessResult = new GuessResult(guessRecord);
        String result = guessResult.getResult();
        String except = "1234 0A1B\n" +
                "1235 0A0B\n" +
                "1264 0A2B\n" +
                "1764 0A2B";
        Assertions.assertEquals(except, result);
        Assertions.assertEquals(GameResult.NORMAL, guessResult.getGameResult());
    }
    
    @Test
    void test_game_result_win_happy_path() {
        Map<String, String> guessRecord = new LinkedHashMap<>();
        guessRecord.put("1234", "0A1B");
        guessRecord.put("1235", "0A0B");
        guessRecord.put("1264", "0A2B");
        guessRecord.put("1764", "4A0B");
        GuessResult guessResult = new GuessResult(guessRecord);
        GameResult result = guessResult.getGameResult();
        Assertions.assertEquals(GameResult.WIN, result);
    }
    
    @Test
    void test_game_result_lost_happy_path() {
        Map<String, String> guessRecord = new LinkedHashMap<>();
        guessRecord.put("1234", "0A1B");
        guessRecord.put("1235", "0A0B");
        guessRecord.put("1264", "0A2B");
        guessRecord.put("1764", "0A2B");
        guessRecord.put("1864", "0A3B");
        guessRecord.put("9864", "0A4B");
        GuessResult guessResult = new GuessResult(guessRecord);
        GameResult result = guessResult.getGameResult();
        Assertions.assertEquals(GameResult.LOST, result);
    }
    
}