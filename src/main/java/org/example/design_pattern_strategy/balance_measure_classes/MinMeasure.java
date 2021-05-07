package org.example.design_pattern_strategy.balance_measure_classes;

import java.util.List;
import java.util.OptionalDouble;

public class MinMeasure implements BalanceMeasureStrategy {

    @Override
    public OptionalDouble calculate(List<Double> gaps) {
        return gaps.stream().mapToDouble(v -> v).min();
    }
}
