package answer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {
    
    private static final int ANSWER_LENGTH = 4;
    private static final int ANSWER_NUMBER_LIMIT = 10;
    private List<Integer> answer = null;
    
    public Answer(Path filePath) {
        try {
            List<Integer> numbers = getAnswerFromFile(filePath);
            validAnswer(numbers);
            this.setAnswer(numbers);
        } catch (Exception e) {
            this.setAnswer(generateRandomAnswer());
        }
    }
    
    public List<Integer> getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(List<Integer> answer){
        this.answer = answer;
    }
    
    @Override
    public String toString() {
        return answer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
    
    private List<Integer> getAnswerFromFile(Path filePath) throws IOException {
        // Need to be implemented
        return null;
    }
    
    private List<Integer> generateRandomAnswer() {
        // Need to be implemented
        return null;
    }
    
    static void validAnswer(List<Integer> answer) throws InvalidAnswerException {
        // Need to be implemented
    }
}
