package StatesQuizGame;

import java.util.ArrayList;

public class State {
    public String name;
    public String abbreviation;
    public int population;
    public int rank;

    public State(String name, String abbreviation, int population, int rank) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.population = population;
        this.rank = rank;
    }

    public String toString() {
        return name + " (" + abbreviation + ") has a population of " + population + " and is ranked " + rank
                + " in the US.";
    }

    public static void printStates(ArrayList<State> states) {
        for (State state : states) {
            System.out.println(state);
        }
    }

}
