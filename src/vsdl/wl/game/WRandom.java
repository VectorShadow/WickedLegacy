package vsdl.wl.game;

import java.util.Random;

public class WRandom {

    private static final double WEIGHT_FLOOR = 1.0;

    private static Random random() {
        return new Random();
    }

    static double getExpectedAverage(double weight) {
        double runningSum = 0;
        for (int i = 0; i < 0x000fffff; ++i) {
            runningSum += weightedRandom(weight);
        }
        return runningSum / (double) 0x000fffff;
    }

    public static double weightedRandom(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Weight must be non-negative.");
        double rand = random().nextDouble();
        double limit = 1.0 / rand;
        double adjustedWeight = rand * (WEIGHT_FLOOR + weight);
        double weightedRatio = (adjustedWeight / (WEIGHT_FLOOR + adjustedWeight));
        double weightedResult = rand * limit * weightedRatio;
        return Math.max(weightedResult, rand);
    }

    public static int d(int sides) {
        return d(1, sides);
    }

    public static int d(int sides, double weight) {
        return d(1, sides, weight);
    }

    public static int d(int number, int sides) {
        return d(number, sides, 0);
    }

    public static int d(int number, int sides, double weight) {
        return d(number, sides, 0, weight);
    }

    public static int d(int number, int sides, int modifier) {
        return d(number, sides, modifier, 0);
    }

    public static int d(int number, int sides, int modifier, double weight) {
        double averageRoll = 1 + (weightedRandom(weight) * sides);
        int sumOfRolls = (int)((double)number * averageRoll);
        return sumOfRolls + modifier;
    }
}
