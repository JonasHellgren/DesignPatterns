package org.example.interface_tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class PassingSubClassToMethod {

    interface CalcLow  {
         Double calc(List<Integer> numbers);
         default  Double calc() {
             return 0d;
         }
    }

    class CalcLowInterval implements CalcLow {
        @Override
        public Double calc(List<Integer> numbers) {
            DoubleSummaryStatistics stats = numbers.stream().mapToDouble(a -> a).summaryStatistics();
            Double squaredDifferenceSum  = numbers.stream().mapToDouble(n -> (n-stats.getAverage())*(n-stats.getAverage())).sum();
            Double variance=stats.getCount()==0?0:squaredDifferenceSum /stats.getCount();
            return stats.getAverage()-Math.sqrt(variance);
        }

    }

    class CalcMin implements CalcLow {
        @Override
        public Double calc(List<Integer> numbers) {
            DoubleSummaryStatistics stats = numbers.stream().mapToDouble(a -> a).summaryStatistics();
            return stats.getMin();
        }

    }

    class UseCalcLow {
        //polymorphism, calcLow can be either CalcLowInterval or CalcMin
        public double getLow (List<Integer> numbers, CalcLow calcLow ) {
            return calcLow.calc(numbers);
        }

        public double getLow (CalcLow calcLow) {
            return calcLow.calc();
        }
    }

    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

    @Test
    public void TestInterval() {
        //use interval method
        UseCalcLow useCalcLow=new UseCalcLow();
        CalcLowInterval calcLowInterval=new CalcLowInterval();
        System.out.println(useCalcLow.getLow(numbers,calcLowInterval));
    }

    @Test
    public void TestMin() {
        //use min method
        UseCalcLow useCalcLow=new UseCalcLow();
        CalcMin calcMin=new CalcMin();
        System.out.println(useCalcLow.getLow(numbers,calcMin));
    }

    @Test
    public void TestEmptyPar() {
        //wihhout numbers
        UseCalcLow useCalcLow=new UseCalcLow();
        CalcMin calcMin=new CalcMin();
        System.out.println(useCalcLow.getLow(calcMin));
    }

}
