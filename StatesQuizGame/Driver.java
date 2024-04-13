package StatesQuizGame;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. Which of the following states has an abbreviation of <randomly selected abbreviation>?
 * 2. Of the following 4 states, which has the largest population?
 * 3. Of the following 4 states, which has the smallest population?
 * 4. Of the following 4 states, which state is the largest in land size?
 * 5. Of the following 4 states, which state is the smallest in land size?
 */
public class Driver {
    public static void main(String[] args) {
        String[] alphabet = { "A", "B", "C", "D" };
        StatesQuizGame game = new StatesQuizGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the States Quiz Game!");

        ArrayList<State> states = game.getStates(4);
        State chosenState = states.get((int) (Math.random() * states.size()));
        System.out.println("1. Which of the following states has an abbreviation of " + chosenState.abbreviation + "?");
        for (int i = 0; i < states.size(); i++) {
            System.out.println(alphabet[i] + ". " + states.get(i).name);
        }
        String answer = scanner.nextLine();
        while (!isValidAnswer(answer, alphabet)) {
            System.out.println("Invalid input! Please enter a valid answer (A, B, C, or D):");
            answer = scanner.nextLine();
        }

        answer = getValidAnswer(answer, alphabet) + "";

        System.out.println("You chose " + states.get(Integer.parseInt(answer)).name + ".");

        if (game.checkAnswer(chosenState.name, answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println(chosenState.name + " is the correct answer.");
            System.out.println("Incorrect!");
        }

        System.out.println("2. Of the following 4 states, which has the largest population?");
        states = game.getStates(4);
        for (int i = 0; i < states.size(); i++) {
            System.out.println(alphabet[i] + ". " + states.get(i).name);
        }
        answer = scanner.nextLine();
        while (!isValidAnswer(answer, alphabet)) {
            System.out.println("Invalid input! Please enter a valid answer (A, B, C, or D):");
            answer = scanner.nextLine();
        }

        answer = getValidAnswer(answer, alphabet) + "";

        if (game.checkAnswer(game.getLargestPopulationState(), answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }

        System.out.println("3. Of the following 4 states, which has the smallest population?");
        states = game.getStates(4);
        for (int i = 0; i < states.size(); i++) {
            System.out.println(alphabet[i] + ". " + states.get(i).name);
        }
        answer = scanner.nextLine();
        while (!isValidAnswer(answer, alphabet)) {
            System.out.println("Invalid input! Please enter a valid answer (A, B, C, or D):");
            answer = scanner.nextLine();
        }

        answer = getValidAnswer(answer, alphabet) + "";

        if (game.checkAnswer(game.getSmallestPopulationState(), answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }

        System.out.println("4. Of the following 4 states, which state is the largest in land size?");
        states = game.getStates(4);
        for (int i = 0; i < states.size(); i++) {
            System.out.println(alphabet[i] + ". " + states.get(i).name);
        }
        answer = scanner.nextLine();
        while (!isValidAnswer(answer, alphabet)) {
            System.out.println("Invalid input! Please enter a valid answer (A, B, C, or D):");
            answer = scanner.nextLine();
        }

        answer = getValidAnswer(answer, alphabet) + "";

        if (game.checkAnswer(game.getLargestLandSizeState(), answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }

        System.out.println("5. Of the following 4 states, which state is the smallest in land size?");
        states = game.getStates(4);
        for (int i = 0; i < states.size(); i++) {
            System.out.println(alphabet[i] + ". " + states.get(i).name);
        }
        answer = scanner.nextLine();
        while (!isValidAnswer(answer, alphabet)) {
            System.out.println("Invalid input! Please enter a valid answer (A, B, C, or D):");
            answer = scanner.nextLine();
        }

        answer = getValidAnswer(answer, alphabet) + "";

        if (game.checkAnswer(game.getSmallestLandSizeState(), answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }

        scanner.close();
    }

    private static boolean isValidAnswer(String answer, String[] alphabet) {
        for (String letter : alphabet) {
            if (answer.equalsIgnoreCase(letter)) {
                return true;
            }
        }
        return false;
    }

    private static int getValidAnswer(String answer, String[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (answer.equalsIgnoreCase(alphabet[i])) {
                return i;
            }
        }
        return -1;
    }
}
