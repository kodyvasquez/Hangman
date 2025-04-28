import java.util.Arrays;

public class Secret {
    private String word;
    private char[] revealedWord;

    public Secret() {
        String[] wordList = { "java", "hangman", "developing", "coding", "game" };
        word = wordList[(int) (Math.random() * wordList.length)];
        revealedWord = new char[word.length()];
        Arrays.fill(revealedWord, '_');
    }

    public String getWord() {
        return word;
    }

    public String getRevealedWord() {
        return new String(revealedWord);
    }

    public boolean checkGuess(char guess) {
        boolean correct = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                revealedWord[i] = guess;
                correct = true;
            }
        }
        return correct;
    }

    public boolean isSolved() {
        return word.equals(getRevealedWord());
    }
}