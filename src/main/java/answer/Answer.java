package answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;
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
    
    static void validAnswer(List<Integer> answer) throws InvalidAnswerException {
        if (answer == null || answer.size() != ANSWER_LENGTH) {
            throw new InvalidAnswerException("The answer is not four number!");
        }
        
        long size = answer.stream().distinct().count();
        if (size != ANSWER_LENGTH) {
            throw new InvalidAnswerException("There are duplicate Numbers in the answer");
        }
    }
    
    public List<Integer> getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
    
    @Override
    public String toString() {
        return answer.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
    
    private List<Integer> getAnswerFromFile(Path filePath) throws IOException {
        Objects.requireNonNull(filePath);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filePath.toString());
        Objects.requireNonNull(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String number = reader.readLine();
        return number.chars().mapToObj(o -> Character.getNumericValue(o)).collect(Collectors.toList());
    }
    
    private List<Integer> generateRandomAnswer() {
        return new Random().ints(1, ANSWER_NUMBER_LIMIT)
                .boxed().distinct().limit(ANSWER_LENGTH).collect(Collectors.toList());
    }
}
