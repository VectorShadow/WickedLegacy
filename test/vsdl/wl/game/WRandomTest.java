package vsdl.wl.game;

import org.junit.jupiter.api.Test;

public class WRandomTest {

    private static final int REPETITION_CONSTANT = 1024;

    @Test
    public void testWeightedRandom() {
        double lowWeight = 1 + WRandom.weightedRandom(0) * 10;
        double highWeight = Math.pow(lowWeight, Math.E);
        double lowWeightSum = 0;
        double highWeightSum = 0;
        for (int i = 0; i < REPETITION_CONSTANT; ++i) {
            double l = WRandom.weightedRandom(lowWeight);
            double h = WRandom.weightedRandom(highWeight);
            assert l < 1.0;
            assert h < 1.0;
            lowWeightSum += l;
            highWeightSum += h;
        }
        assert lowWeightSum < highWeightSum;
    }

    @Test
    public void testSingleArgumentD() {
        int[] sideValues = new int[] {4, 6, 8, 10, 12, 20, 100};
        int numberOfValues = sideValues.length;
        double[] expectedAverages = new double[numberOfValues];
        for (int i = 0;  i < numberOfValues; ++i) {
            int sum = 0;
            for (int j = 1; j <= sideValues[i]; ++j) {
                sum += j;
            }
            expectedAverages[i] = (double) sum / (double) sideValues[i];
        }
        int[] actualSums = new int[]{0,0,0,0,0,0,0};
        for (int i = 0; i < REPETITION_CONSTANT; ++i) {
            for (int j = 0; j < numberOfValues; ++j) {
                actualSums[j] += WRandom.d(sideValues[j]);
            }
        }
        for (int i = 0; i < numberOfValues; ++i) {
            double actualAverage = (double) actualSums[i] / (double) REPETITION_CONSTANT;
            double actualVariance = Math.abs(expectedAverages[i] - actualAverage);
            double expectedVariance = Math.log10(sideValues[i]);
            assert actualVariance < expectedVariance;
        }
    }

    @Test
    public void testExpectedAverage() {
        for (int i = -2; i < 91; i+=2) {
            double d = Math.pow(10, (i / 10.0));
            double trunc_d = (double)((long)(d * 10)) / 10;
            double avg = WRandom.getExpectedAverage(d);
            double sig = Math.pow(10, Math.max(4, (long)Math.log10(d) + 1));
            double trunc_avg = (double)((long)(avg * sig)) / sig;
            System.out.println("d(" + trunc_d + "): " + trunc_avg);
        }
    }
}
