package DiceSimulator;
/**
 * Dice.java
 *
 * @author - Isaiah Martinez
 * @author - Period H
 *
 */
public class Dice {
    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public int[] rollMultiple(int rolls) {
        int[] response = new int[rolls];
        for (int i = rolls; i > 0; i--) {
            response[i - 1] = (int) (Math.random() * 6) + 1;
        }
        return response;
    }
}