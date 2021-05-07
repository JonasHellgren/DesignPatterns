package org.example.design_pattern_strategy.balance_measure_classes;

import org.example.intervallestimate.IntervalEstimate;

import java.util.List;
import java.util.OptionalDouble;

public class LowerInterval1Std implements BalanceMeasureStrategy {

    IntervalEstimate intervalEstimate =new IntervalEstimate();

    @Override
    public OptionalDouble calculate(List<Double> gaps) {
        List<Double> confInt= intervalEstimate.calc(gaps,69);

        return OptionalDouble.of(confInt.get(0));
    }

}
