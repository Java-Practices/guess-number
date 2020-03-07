package answer;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerTest {
    
    @Test
    public void test_get_answer_is_1234_when_answer_file_is_exit() throws InvalidAnswerException {
        Path filePath = Paths.get("answer.txt");
        Answer answer = new Answer(filePath);
        List<Integer> answerList = answer.getAnswer();
        assertEquals(Arrays.asList(2, 3, 4, 5), answerList);
    }
    
    @Test
    public void test_set_answer_correct_when_answer_is_1234() throws InvalidAnswerException {
        Answer answer = new Answer(null);
        answer.setAnswer(Arrays.asList(1, 2, 3, 4));
        List<Integer> answerList = answer.getAnswer();
        assertEquals(Arrays.asList(1, 2, 3, 4), answerList);
    }
    
    @Test
    public void test_set_answer_incorrect_when_answer_is_123() {
        assertThrows(InvalidAnswerException.class, () -> {
            Answer answer = new Answer(null);
            answer.setAnswer(Arrays.asList(1, 2, 3));
        });
    }
    
    @Test
    public void test_set_answer_incorrect_when_answer_is_1233() {
        assertThrows(InvalidAnswerException.class, () -> {
            Answer answer = new Answer(null);
            answer.setAnswer(Arrays.asList(1, 2, 3, 3));
        });
    }
    
    @Test
    public void test_generate_round_answer() throws InvalidAnswerException {
        Answer answer = new Answer(null);
        List<Integer> answerList = answer.getAnswer();
        assertEquals(4, answerList.size());
    }
}