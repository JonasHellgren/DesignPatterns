package org.example.design_pattern_strategy.balance;

import org.example.design_pattern_strategy.balance_measure_classes.BalanceCalculator;
import org.example.design_pattern_strategy.balance_measure_classes.LowerInterval1Std;
import org.example.design_pattern_strategy.balance_measure_classes.MinMeasure;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class TestBalance {
    BalanceCalculator balanceCalculatorMin = new BalanceCalculator(new MinMeasure());
    BalanceCalculator balanceCalculatorLow = new BalanceCalculator(new LowerInterval1Std());
    private final double BACKUP_VALUE=0d;

    @Test
    public void BalanceMinOf2_5_8_max9_Is_3() {
        List<Double> positions = Arrays.asList(2d, 5d, 8d);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 9d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(3, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceMinOf2_7_8_max9_Is_1() {
        List<Double> positions = Arrays.asList(2d, 7d, 8d);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 9d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(1, gapMin.orElse(BACKUP_VALUE), 0.1);
    }


    @Test
    public void SoBOMinf2_5_8_max9_Is_1() {
        List<Double> positions = Arrays.asList(2d, 5d, 8d);
        OptionalDouble SoBMin = balanceCalculatorMin.calcStateOfBalance(positions, 9d);
        System.out.println(SoBMin.getAsDouble());
        Assert.assertEquals(1, SoBMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void SoBOMinf2_7_8_max9_Is_0d33() {
        List<Double> positions = Arrays.asList(2d, 7d, 8d);
        OptionalDouble SoBMin = balanceCalculatorMin.calcStateOfBalance(positions, 9d);
        System.out.println(SoBMin.getAsDouble());
        Assert.assertEquals(0.33, SoBMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceLowOf2_5_8_max9_Is_3() {
        List<Double> positions = Arrays.asList(2d, 5d, 8d);
        OptionalDouble gapMin = balanceCalculatorLow.calcBalance(positions, 9d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(3, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceLowOf2_7_8_max9_Is_3() {
        List<Double> positions = Arrays.asList(2d, 7d, 8d);
        OptionalDouble gapMin = balanceCalculatorLow.calcBalance(positions, 9d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(1, gapMin.orElse(BACKUP_VALUE), 0.5);
    }

    @Test
    public void BalanceMinOf2_5_max6_Is_3() {
        List<Double> positions = Arrays.asList(2d, 5d);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 6d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(3, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceMinOf2_max6_Is_6() {
        List<Double> positions = Arrays.asList(5d);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 6d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(6, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceMinOf2_5_max4_Is_3() {
        List<Double> positions = Arrays.asList(2d, 5d);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 4d);
        System.out.println(gapMin.getAsDouble());
        Assert.assertEquals(2, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceEmpty() {
        List<Double> positions = new ArrayList<>();
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 4d);
        Assert.assertFalse(gapMin.isPresent());
        System.out.println(gapMin.orElse(BACKUP_VALUE));
        OptionalDouble sobMin = balanceCalculatorMin.calcStateOfBalance(positions, 4d);
        System.out.println(sobMin.orElse(0));
        Assert.assertEquals(BACKUP_VALUE, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void BalanceNull() {
        List<Double> positions = new ArrayList<>();
        positions.add(null);
        OptionalDouble gapMin = balanceCalculatorMin.calcBalance(positions, 4d);
        Assert.assertFalse(gapMin.isPresent());
        System.out.println(gapMin.orElse(BACKUP_VALUE));
        OptionalDouble sobMin = balanceCalculatorMin.calcStateOfBalance(positions, 4d);
        System.out.println(gapMin.orElse(BACKUP_VALUE));
        Assert.assertEquals(BACKUP_VALUE, gapMin.orElse(BACKUP_VALUE), 0.1);
    }

    @Test
    public void SpeedTester() {
        List<Double> positions = Arrays.asList(2d, 5d, 8d);
        double posMax = 10;
        int nofIter = 1000000;

        OptionalDouble gapMin;
        long startTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < nofIter; i++)
            gapMin = balanceCalculatorMin.calcBalance(positions, posMax);
        System.out.println("Time for min:" + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < nofIter; i++)
            gapMin = balanceCalculatorLow.calcBalance(positions, posMax);
        System.out.println("Time for low:" + (System.currentTimeMillis() - startTime));
    }

}
