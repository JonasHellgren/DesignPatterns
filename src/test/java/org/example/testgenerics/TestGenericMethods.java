package org.example.testgenerics;

import org.example.generics.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Some code stolen from: https://www.tutorialspoint.com/java/java_generics.htm
 *
 */

public class TestGenericMethods {

    GenericMethods genericMethods =new GenericMethods();

    @Test
    public void printIntegers() {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        System.out.println("Array integerArray contains:");
        genericMethods.printArray(intArray);   // pass an Integer array
    }

    @Test
    public void printDoubles() {
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        System.out.println("\nArray doubleArray contains:");
        genericMethods.printArray(doubleArray);   // pass a Double array
    }

    @Test
    public void printMaxOfIntegers() {
        System.out.printf("Max of %d,  %d and %d is %d\n\n",
                3, 4, 5, genericMethods.maximum(3, 4, 5));
    }

    @Test
    public void printMaxOfDoubles() {
        System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n",
                6.6, 8.8, 7.7, genericMethods.maximum(6.6, 8.8, 7.7));
    }

    @Test
    public void TestFromArrayToList() {

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        List<Integer> intList;
        intList=genericMethods.fromArrayToList(intArray);

        System.out.println(intList);
        Assert.assertEquals(intArray[0],intList.get(0),0.1);
    }

    @Test
    public void TestFromArrayToListNumberBounded() {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        List<Integer> intList;
        intList=genericMethods.fromArrayToList(intArray);
        System.out.println(intList);
        Assert.assertEquals(intArray[0],intList.get(0),0.1);
    }

    @Test
    public void TestFromArrayToListNumberBoundedNOtWorkingOnStrings() {
        String[] stringArray = { "1", "2", "3", "4", "5" };
        List<Integer> stringList;
        //The following does not work, string is not sub type of number
        //stringList=genericMethods.fromArrayToListNumberBounded(stringArray);
    }

    @Test
    public void TestSumNumbersOnly() {
        List<Integer> intList = Arrays.asList( 1, 2, 3, 4, 5 );
        Number sum= genericMethods.sumNumbersOnly(intList);
        System.out.println(sum);
        Assert.assertEquals(15, (Double) sum,0.1);
    }

    @Test
    public void PrintMemoryEmpty() {
        MemoryEmpty memoryEmpty=new MemoryEmpty();
        genericMethods.printMemory(memoryEmpty);
    }

    @Test
    public void PrintMemoryOnePar() {
        MemoryOnePar memoryOnePar=new MemoryOnePar(1.1);
        genericMethods.printMemory(memoryOnePar);
    }

    @Test
    public void TestMemoryEmpty() {
        MemoryEmpty memoryEmpty=new MemoryEmpty();
        genericMethods.calcQlong(0.1,memoryEmpty);
        Assert.assertEquals(0d,genericMethods.calcQlong(0.5,memoryEmpty),0.1);
    }

    @Test
    public void TestMemoryOnePar() {
        MemoryOnePar memoryOnePar=new MemoryOnePar(0.4);
        System.out.println(genericMethods.calcQlong(0.1,memoryOnePar));
        System.out.println(genericMethods.calcQlong(0.5,memoryOnePar));
        Assert.assertEquals(1d,genericMethods.calcQlong(0.1,memoryOnePar),0.1);
        Assert.assertEquals(0d,genericMethods.calcQlong(0.5,memoryOnePar),0.1);
    }

    @Test
    public void TestMemoryWrongMemoryStrategyMatching() {
        MemoryEmpty memoryEmpty=new MemoryEmpty();
        QLongStrategy qLongSoB=new QlongSoB();
        Assert.assertEquals(0d,qLongSoB.calculate(0.5,memoryEmpty),0.1);
    }

}
