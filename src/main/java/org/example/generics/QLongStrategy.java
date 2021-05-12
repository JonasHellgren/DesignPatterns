package org.example.generics;

import org.example.math.IntervalEstimate;

import java.util.logging.Logger;

public interface QLongStrategy {

      Logger logger = Logger.getLogger(QLongStrategy.class.getName());

     <T extends Memory> Double  calculate(double SoB, T memory);
}
