package game;

import java.util.Map;

public class GuessResult {
    private Map<String, String> guessRecord;
    private static final int CHANCE_LIMIT = 6;
    
    public GuessResult(Map<String, String> guessRecord) {
        this.guessRecord = guessRecord;
    }
    
    
    public String getResult() {
        return guessRecord.entrySet().stream().map(record -> record.getKey() + " " + record.getValue()).reduce("", (partialString, element) -> partialString + element + "\n").trim();
    }
    
    public GameResult getGameResult() {
        if (guessRecord.values().contains("4A0B")) {
            return GameResult.WIN;
        }
    
        if (guessRecord.size() >= CHANCE_LIMIT) {
            return GameResult.LOST;
        }
    
        return GameResult.NORMAL;
    }
}
