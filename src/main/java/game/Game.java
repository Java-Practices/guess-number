package game;

import answer.Answer;
import answer.InvalidAnswerException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    
    private Answer answer;
    private Map<String, String> guessResult;
    private static final int CHANCE_LIMIT = 6;
    
    public Game() throws InvalidAnswerException {
        Path filePath = Paths.get("answer.txt");
        this.answer =  new Answer(filePath);
        this.guessResult = new HashMap<>();
    }
    
    public String guess(List<Integer> numbers) throws ChanceOverException {
        if (this.guessResult.size() >= CHANCE_LIMIT) {
            throw new ChanceOverException("Chance over！");
        }
        
        String result = "";
        if (numbers.equals(answer.getAnswer())) {
            result = "4A0B";
        } else {
            int countA = getASize(numbers);
            int countB = getBSize(numbers);
            result = countA + "A" + countB + "B";
        }
        String key = numbers.stream().map(String::valueOf).collect(Collectors.joining(""));
        this.guessResult.put(key, result);
        return result;
    }
    
    private int getBSize(List<Integer> numbers) {
        long size  =this.answer.getAnswer().stream().filter(numbers::contains).count();
        return (int) (size - getASize(numbers));
    }
    
    private int getASize(List<Integer> numbers) {
        int count = 0;
        for (int i = 0; i < this.answer.getAnswer().size(); i++) {
            if (answer.getAnswer().get(i) == numbers.get(i)) {
                count = count + 1;
            }
        }
        return count;
    }
}
