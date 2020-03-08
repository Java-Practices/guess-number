package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameTest {
    private static Game game;
    
    @BeforeAll
    static void setUp() {
        game = new Game();
    }
    
    @Test
    void test_guess_return_1A0B_when_input_1567() {
        String result = game.guess(Arrays.asList(1, 5, 6, 7));
        Assertions.assertEquals("1A0B", result);
    }
    
    @Test
    void test_guess_return_0A2B_when_input_2478() {
        String result = game.guess(Arrays.asList(2, 4, 7, 8));
        Assertions.assertEquals("0A2B", result);
    }
    
    @Test
    void test_guess_return_1A2B_when_input_0324() {
        String result = game.guess(Arrays.asList(0, 3, 2, 4));
        Assertions.assertEquals("1A2B", result);
    }
    
    @Test
    void test_guess_return_0A0B_when_input_5678() {
        String result = game.guess(Arrays.asList(5, 6, 7, 8));
        Assertions.assertEquals("0A0B", result);
    }
    
    @Test
    void test_guess_return_0A4B_when_input_4321() {
        String result = game.guess(Arrays.asList(4, 3, 2, 1));
        Assertions.assertEquals("0A4B", result);
    }
    
    @Test
    void test_guess_return_4A0B_when_input_1234() {
        String result = game.guess(Arrays.asList(1, 2, 3, 4));
        Assertions.assertEquals("4A0B", result);
    }
    
    @Test
    void test_game_over_return_false() {
        Game tempGame = new Game();
        tempGame.guess(Arrays.asList(1, 5, 6, 7));
        boolean result = tempGame.isOver();
        Assertions.assertFalse(result);
    }
    
    @Test
    void test_game_over_return_true() {
        Game tempGame = new Game();
        tempGame.guess(Arrays.asList(1, 2, 3, 4));
        boolean result = tempGame.isOver();
        Assertions.assertTrue(result);
    }
    
    @Test
    void test_game_win_result_string() {
        Game tempGame = new Game();
        tempGame.guess(Arrays.asList(1, 2, 3, 4));
        boolean result = tempGame.isOver();
        Assertions.assertTrue(result);
        String expected = "1234 4A0B\n" +
                "Congratulations, you win!";
        Assertions.assertEquals(expected, tempGame.getResult());
    }
    
    @Test
    void test_game_lost_result_string() {
        Game tempGame = new Game();
        tempGame.guess(Arrays.asList(0, 2, 3, 4));
        tempGame.guess(Arrays.asList(6, 2, 3, 4));
        tempGame.guess(Arrays.asList(7, 2, 3, 4));
        tempGame.guess(Arrays.asList(8, 2, 3, 4));
        tempGame.guess(Arrays.asList(9, 2, 3, 4));
        tempGame.guess(Arrays.asList(5, 2, 3, 4));
        boolean result = tempGame.isOver();
        Assertions.assertTrue(result);
        String expected = "0234 3A0B\n" +
                "6234 3A0B\n" +
                "7234 3A0B\n" +
                "8234 3A0B\n" +
                "9234 3A0B\n" +
                "5234 3A0B\n" +
                "Unfortunately, you have no chance, the answer is 1234!";
        Assertions.assertEquals(expected, tempGame.getResult());
    }
}