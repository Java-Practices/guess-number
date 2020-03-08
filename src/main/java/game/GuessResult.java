package game;

import java.util.Map;

public class GuessResult {
    private Map<String, String> guessRecord;
    private static final int CHANCE_LIMIT = 6;
    
    public GuessResult(Map<String, String> guessRecord) {
        this.guessRecord = guessRecord;
    }
    
    
    public String getResult() {
        // Need to be implemented
        return "";
    }
    
    public GameResult getGameResult() {
        // Need to be implemented
        return null;
    }
}
