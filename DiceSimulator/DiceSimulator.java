package DiceSimulator;
import java.text.DecimalFormat;

/**
 * DiceSimulator.java
 *
 * @author - Isaiah Martinez
 * @author - Period H
 *
 */

public class DiceSimulator {
    public static void main(String[] args) {
        System.out.println("2 Die Simulator");
        printTheoreticalProbabilities();
        simulateAndPrint(36);
        simulateAndPrint(500);
        simulateAndPrint(10000);
    }

    private static void simulateAndPrint(int n) {
        System.out.println("\nSimulating " + n + " rolls of two dice...");
        int[] sums = simulateRolls(n);
        calculateProbabilities(sums, n);
    }

    private static void printTheoreticalProbabilities() {
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("Theoretical Probability of rolling two die\t");

        System.out.print("X\t");
        for (int i = 2; i <= 12; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.print("P(X)\t");
        for (int i = 2; i <= 12; i++) {
            double theoreticalProb = i <= 7 ? (i - 1) / 36.0 : (13 - i) / 36.0;
            System.out.print(df.format(theoreticalProb) + "\t");
        }
        System.out.println();
    }

    private static int[] simulateRolls(int n) {
        Dice dice = new Dice();
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            int die1 = dice.roll();
            int die2 = dice.roll();
            sums[i] = die1 + die2;
        }
        return sums;
    }

    private static void calculateProbabilities(int[] sums, int n) {
        int[] counts = new int[13];
        for (int sum : sums) {
            counts[sum]++;
        }

        DecimalFormat df = new DecimalFormat("#.####");

        System.out.print("X\t");
        for (int i = 2; i <= 12; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        System.out.print("Count\t");
        for (int i = 2; i <= 12; i++) {
            System.out.print(counts[i] + "\t");
        }
        System.out.println();

        System.out.print("Em Prob\t");
        for (int i = 2; i <= 12; i++) {
            double empiricalProb = (double) counts[i] / n;
            System.out.print(df.format(empiricalProb) + "\t");
        }
        System.out.println();

        System.out.print("P(X)\t");
        for (int i = 2; i <= 12; i++) {
            double theoreticalProb = i <= 7 ? (i - 1) / 36.0 : (13 - i) / 36.0;
            System.out.print(df.format(theoreticalProb) + "\t");
        }
        System.out.println();
    }
}