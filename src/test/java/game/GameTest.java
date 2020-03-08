package game;

import answer.InvalidAnswerException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameTest {
    static Game game;
    
    @BeforeAll
    public static void setUp() throws InvalidAnswerException {
        
        game = new Game();
    }
    
    @Test
    void test_guess_return_1A0B_when_input_1567() throws ChanceOverException {
        String result = game.guess(Arrays.asList(1, 5, 6, 7));
        Assertions.assertEquals("1A0B", result);
    }
    
    @Test
    void test_guess_return_0A2B_when_input_2478() throws ChanceOverException {
        String result = game.guess(Arrays.asList(2, 4, 7, 8));
        Assertions.assertEquals("0A2B", result);
    }
    
    @Test
    void test_guess_return_1A2B_when_input_0324() throws ChanceOverException {
        String result = game.guess(Arrays.asList(0, 3, 2, 4));
        Assertions.assertEquals("1A2B", result);
    }
    
    @Test
    void test_guess_return_0A0B_when_input_5678() throws ChanceOverException {
        String result = game.guess(Arrays.asList(5, 6, 7, 8));
        Assertions.assertEquals("0A0B", result);
    }
    
    @Test
    void test_guess_return_0A4B_when_input_4321() throws ChanceOverException {
        String result = game.guess(Arrays.asList(4, 3, 2, 1));
        Assertions.assertEquals("0A4B", result);
    }
    
    @Test
    void test_guess_return_4A0B_when_input_1234() throws ChanceOverException {
        String result = game.guess(Arrays.asList(1, 2, 3, 4));
        Assertions.assertEquals("4A0B", result);
    }
    
    @AfterAll
    public static void test_guess_return_except_when_input_6789() {
        Assertions.assertThrows(ChanceOverException.class, ()-> {
            String result = game.guess(Arrays.asList(6, 7, 8, 9));
        });
    }
}