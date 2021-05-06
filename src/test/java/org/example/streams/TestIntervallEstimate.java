package org.example.streams;


import org.example.streams_needed_classes.IntervalEstimate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestIntervallEstimate {

    IntervalEstimate intervalEstimate =new IntervalEstimate();

    List<Double> numbersDouble1 = Arrays.asList(3d, 2d, 2d, 3d, 7d, 3d, 5d);
    List<Double> numbersDouble2 = Arrays.asList(3d, 4d, 2d, 3d, 5d, 3d, 5d);
    List<Double> normDistrNumbers=new ArrayList<>();
    Random random = new Random();

    @Before
    public void arrange() {
        Double  desiredMean=50d;
        Double desiredStandardDeviation = 10d;
        for (int i = 0; i <100 ; i++)
            normDistrNumbers.add(desiredMean + desiredStandardDeviation * random.nextGaussian());
    }

    @Test
    public void singleDouble() {
        List<Double> singleDouble = Arrays.asList(3d);
        List<Double> confInt= intervalEstimate.calc(singleDouble,99);
        confInt.forEach(System.out::println);
    }

    @Test
    public void numbersDouble1() {
        List<Double> confInt= intervalEstimate.calc(numbersDouble1,95);
        confInt.forEach(System.out::println);
    }

    @Test
    public void numbersDouble2() {
        List<Double> confInt= intervalEstimate.calc(numbersDouble2,95);
        confInt.forEach(System.out::println);
    }

    @Test
    public void manyRandoms() {
        List<Double> confInt= intervalEstimate.calc(normDistrNumbers,95);
        confInt.forEach(System.out::println);
    }

}
