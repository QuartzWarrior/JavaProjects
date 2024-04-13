import java.util.Scanner;

public class Hangman {
    private String[] words = {
            "apple", "banana", "cherry", "date", "elderberry", "computer", "fig", "grape",
            "honeydew", "kiwi", "lemon", "mango", "orange", "papaya", "quince", "raspberry",
            "strawberry", "tangerine", "watermelon", "blueberry", "coconut", "dragonfruit",
            "grapefruit", "jackfruit", "lime", "melon", "nectarine", "peach", "pear", "pineapple",
            "car", "dog", "house", "book", "sun", "moon", "star", "tree", "flower", "mountain",
            "java", "programming", "code", "class", "method", "variable", "object", "array",
            "loop", "conditional", "interface", "inheritance", "polymorphism", "encapsulation",
            "abstraction", "exception", "debugging", "testing", "algorithm", "data structure",
            "addition", "subtraction", "multiplication", "division", "equation", "variable",
            "function", "derivative", "integral", "matrix", "vector", "theorem", "proof",
            "geometry", "trigonometry", "calculus", "statistics", "probability", "algebra"
    };
    private String mysteryWord = words[(int) (Math.random() * words.length)];

    private String[] hangmanFigures = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    private int currentFigureIndex = 1;
    private String guessedLetters = "";
    private String currentGuess = "*".repeat(mysteryWord.length());

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman! You have to guess the mystery word in 5 guesses or less.");
        Hangman game = new Hangman();
        System.out.println("*".repeat(game.mysteryWord.length()));
        game.play();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int guesses = 5;
        while (guesses > 0) {
            System.out.println("Here's what you have so far: " + currentGuess);
            System.out.println("You have " + guesses + " guesses left.");
            System.out.println("Here are the letters you have guessed so far: " + guessedLetters);
            System.out.print("Guess a letter: ");
            char guess = Character.toLowerCase(scanner.nextLine().charAt(0));
            if (guessedLetters.indexOf(guess) != -1) {
                System.out.println("You already guessed that letter!");
                continue;
            }
            guessedLetters += guess;
            guessedLetters = orderGuessedLetters();
            if (mysteryWord.indexOf(guess) != -1) {
                System.out.println("Correct!");
                for (int i = 0; i < mysteryWord.length(); i++) {
                    if (mysteryWord.charAt(i) == guess) {
                        currentGuess = currentGuess.substring(0, i) + guess + currentGuess.substring(i + 1);
                    }
                }
                if (currentGuess.indexOf('*') == -1) {
                    System.out.println("You win!");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("Incorrect!");
                guesses--;
                printHangmanFigure();
            }
        }
        System.out.println("You lose!");
        scanner.close();
    }

    private void printHangmanFigure() {
        System.out.println(hangmanFigures[currentFigureIndex]);
        currentFigureIndex++;
    }

    private String orderGuessedLetters() {
        StringBuilder ordered = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (guessedLetters.indexOf(c) != -1) {
                ordered.append(c);
            }
        }
        return ordered.toString();
    }
}
