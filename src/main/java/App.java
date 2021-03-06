import game.Game;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        Game game = new Game();
        out.println("Guess numbers game starting, please enter four digits：");
        do {
            String guess = scanner.nextLine();
            if (isCorrectInput(guess)) {
                List<Integer> numbers = guess.chars().mapToObj(o -> Character.getNumericValue(o)).collect(Collectors.toList());
                game.guess(numbers);
                String result = game.getResult();
                out.println(result);
            }
        } while (!game.isOver());
    }
    
    private static boolean isCorrectInput(String input) {
        long size = input.chars().distinct().count();
        if (size != 4) {
            out.println(input + " Wrong input");
            return false;
        }
        
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            out.println(input + " Wrong input");
            return false;
        }
        
        return true;
    }
}
