package vsdl.wl.game;

import java.util.Random;

public class WRandom {
    private static Random random() {
        return new Random();
    }

    public static double weightedRandom(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Weight must be non-negative.");
        double rand = random().nextDouble();
        if (weight == 0) return rand;
        double limit = 1.0 / rand;
        double adjustedWeight = rand * weight;
        double weightedRatio = (adjustedWeight / (1.0 + adjustedWeight));
        double weightedResult = rand * limit * weightedRatio;
        return Math.max(weightedResult, rand);
    }

    public static int d(int sides) {
        return d(1, sides);
    }

    public static int wd(int sides, int weight) {
        return wd(1, sides, weight);
    }

    public static int d(int number, int sides) {
        return d(number, sides, 0);
    }

    public static int wd(int number, int sides, int weight) {
        return wd(number, sides, 0, weight);
    }

    public static int d(int number, int sides, int modifier) {
        return wd(number, sides, modifier, 0);
    }

    public static int wd(int number, int sides, int modifier, int weight) {
        double averageRoll = 1 + (weightedRandom(weight) * sides);
        int sumOfRolls = (int)((double)number * averageRoll);
        return sumOfRolls + modifier;
    }
}
