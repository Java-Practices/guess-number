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
        Objects.requireNonNull(filePath);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filePath.toString());
        Objects.requireNonNull(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String number = reader.readLine();
        return number.chars().mapToObj(o -> Character.getNumericValue(o)).collect(Collectors.toList());
    }
    
    private List<Integer> generateRandomAnswer() {
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();
        while (digits.size() < ANSWER_LENGTH) {
            int digit = random.nextInt(ANSWER_NUMBER_LIMIT);
            digits.add(digit);
        }
        return digits.stream().collect(Collectors.toList());
    }
    
    private static void validAnswer(List<Integer> answer) throws InvalidAnswerException {
        if (answer == null || answer.size() != ANSWER_LENGTH) {
            throw new InvalidAnswerException("The answer is not four number!");
        }
        
        long size = answer.stream().distinct().count();
        if (size != ANSWER_LENGTH) {
            throw new InvalidAnswerException("There are duplicate Numbers in the answer");
        }
    }
}
