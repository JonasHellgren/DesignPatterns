package org.example.design_pattern_strategy.balance_measure_classes;

import java.util.List;
import java.util.OptionalDouble;

public interface BalanceMeasureStrategy {

    OptionalDouble calculate(List<Double> gaps);
}
