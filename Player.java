import java.util.HashSet;
import java.util.Set;

public class Player {

    public class player {
        private Set<Character> guesses;

        public player() {
            guesses = new HashSet<>();
        }

        public boolean hasGuessed(char letter) {
            return guesses.contains(letter);
        }

        public void addGuess(char letter) {
            guesses.add(letter);
        }
    }
}
