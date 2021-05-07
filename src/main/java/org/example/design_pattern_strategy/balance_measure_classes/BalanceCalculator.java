package org.example.design_pattern_strategy.balance_measure_classes;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BalanceCalculator {

    Logger logger = Logger.getLogger(BalanceCalculator.class.getName());

    BalanceMeasureStrategy balanceMeasureStrategy;

    private final double BACKUP_VALUE=0d;


    public BalanceCalculator(BalanceMeasureStrategy balanceMeasureStrategy) {
        this.balanceMeasureStrategy = balanceMeasureStrategy;
    }

    public OptionalDouble calcStateOfBalance(final List<Double> positions, final Double positionMax) {
        OptionalDouble balance = calcBalance(positions, positionMax);
        Double balanceBest;
        if (positions.size() == 0)
            balanceBest = BACKUP_VALUE;
        else
            balanceBest = positionMax / positions.size();
        return OptionalDouble.of(balance.orElse(BACKUP_VALUE) / balanceBest);
    }

    public OptionalDouble calcBalance(List<Double> positions, final Double positionMax) {

        Boolean allNotNull = positions.stream().allMatch(Objects::nonNull);
        if (!allNotNull) {
            logger.warning("Null items in positions list");
            positions=positions.stream().filter(Objects::nonNull).collect(Collectors.toList());}

        if (positions.size() == 0) {
            logger.warning("Empty positions list");
            return  OptionalDouble.empty();   }

        List<Double> positionsSorted = positions.stream().sorted().collect(Collectors.toList());
        List<Double> gaps = getGaps(positions, positionMax, positionsSorted);
        return balanceMeasureStrategy.calculate(gaps);
    }

    private List<Double> getGaps(final List<Double> positions, Double positionMax, final List<Double> positionsSorted) {
        List<Double> gaps = new ArrayList<>();
        int nofPos=positionsSorted.size();

        if (nofPos==0) {
            logger.warning("Empty positions list");
            return  new ArrayList<>();   }

        Double posMin = positionsSorted.get(0);
        Double posMax = positionsSorted.get(nofPos - 1);

        if (posMax > positionMax) {
            logger.warning("Largest position is  greater than positionMax, changing positionMax.");
            positionMax = posMax;
        }

        for (int i = 0; i < nofPos; i++) {
            Double pos = positions.get(i);
            if (pos.equals(posMax))
                gaps.add(posMin + positionMax - pos);
            else
                gaps.add(positions.get(i + 1) - pos);
        }
        return gaps;
    }

}
