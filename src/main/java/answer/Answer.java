package answer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Answer {
    
    private static final int ANSWER_LENGTH = 4;
    private static final int ANSWER_NUMBER_LIMIT = 10;
    private List<Integer> answer = null;
    
    public Answer(Path filePath) throws InvalidAnswerException {
        try {
            this.setAnswer(getAnswerFromFile(filePath));
        } catch (Exception e) {
            this.setAnswer(generateRandomAnswer());
        }
    }
    
    public List<Integer> getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(List<Integer> answer) throws InvalidAnswerException {
        validAnswer(answer);
        this.answer = answer;
    }
    
    private List<Integer> getAnswerFromFile(Path filePath) throws IOException {
        // Need to be implemented
        return null;
    }
    
    private List<Integer> generateRandomAnswer() {
        // Need to be implemented
        return null;
    }
    
    private static void validAnswer(List<Integer> answer) throws InvalidAnswerException {
        // Need to be implemented
    }
}
