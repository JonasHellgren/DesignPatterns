package org.example.streams;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTests {
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    List<Double> numbersDouble = Arrays.asList(3d, 2d, 2d, 3d, 7d, 3d, 5d);
    Random random = new Random();

    @Test
    public void forEach() {
        // ‘limit’ method is used to reduce the size of the stream
        //‘forEach’ iterates each element of the stream
        random.ints().limit(5).forEach(System.out::println);
    }

    @Test
    public void forEachNumbers() {
        //‘forEach’ iterates each element of the stream
        numbers.forEach(System.out::println);
    }

    @Test
    public void distinct() {
        //The distinct method is used to remove duplicates
        List<Integer> squaresList = numbers.stream().distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    @Test
    public void map() {
        //The ‘map’ method is used to map each element to its corresponding result
        //The following code segment prints unique squares of numbers using map

        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
    }

    @Test
    public void filter() {
        //The ‘filter’ method is used to eliminate elements based on a criteria
        //The following code segment prints nof empty strings using filter.

        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println("count:" + count);

        Assert.assertEquals(count,2,0.1);
    }

    @Test
    public void sorted() {
        //print 10 random numbers in a sorted order
        random.ints().limit(5).sorted().forEach(System.out::println);
    }

    @Test
    public void parallelStream() {
        //prints the count of empty strings using parallelStream
        // by using parallel streams, we can divide the code into multiple streams that are executed in parallel
        // on separate cores and the final result is the combination of the individual outcomes. The order of
        // execution, however, is not under our control.
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println("count:" + count);
    }

    @Test
    public void CollectorsJoining() {
        //Collectors are used to combine the result of processing on the elements of a
        //stream. Collectors can be used to return a list or a string logger.info("");
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining());
        System.out.println("Merged String: " + mergedString);
    }

    @Test
    public void CollectorsToList() {
        List<String> stringsAsList = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        stringsAsList.forEach(System.out::println);
    }

    @Test
    public void CollectorsJoiningCommaSep() {
        String mergedStringCommaSep = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String comma sep.: " + mergedStringCommaSep);
    }

    @Test
    public void CollectorsCounting() {
        Long nofStrings = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.counting());
        System.out.println("nofStrings: " + nofStrings);

        Assert.assertEquals(nofStrings,5,0.1);
    }

    @Test
    public void summaryStatisticsInt() {
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("average: " + stats.getAverage());
        System.out.println("sum: " + stats.getSum());

        Assert.assertEquals(stats.getSum(),25,0.1);
    }

    @Test
    public void summaryStatisticsDouble() {

        DoubleSummaryStatistics stats = numbersDouble.stream().mapToDouble(a -> a).summaryStatistics();
        System.out.println("max:" + stats.getMax());
        System.out.println("min:" + stats.getMin());
        System.out.println("average:" + stats.getAverage());
        System.out.println("count:" + stats.getCount());
        System.out.println("sum:" + stats.getSum());
    }

    @Test
    public void maxInt() {
        // Using stream.max() to get maximum element according to provided Comparator
        // and storing in variable max
        Integer max = numbers.stream().max(Integer::compare).get();
        System.out.print("max:" +max);

        Assert.assertEquals(max,7,0.1);
    }

    @Test
    public void maxDouble() {
        OptionalDouble max = numbersDouble.stream().mapToDouble(v -> v).max();
        System.out.print("max:" +max);
        Assert.assertEquals(max.getAsDouble(),7d,0.1);
    }

}
