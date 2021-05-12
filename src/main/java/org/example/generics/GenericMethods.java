package org.example.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericMethods {

    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;   // assume x is initially the largest

        if(y.compareTo(max) > 0) {
            max = y;   // y is the largest so far
        }

        if(z.compareTo(max) > 0) {
            max = z;   // z is the largest now
        }
        return max;   // returns the largest object
    }

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    //specify that a method accepts a type and all its subclasses (upper bound) or
    // a type all its superclasses (lower bound).
    public <T extends Number> List<T> fromArrayToListNumberBounded(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    //A wildcard parameterized type is not a concrete type that could appear in a new expression.
    // It just hints the rule enforced by java generics that which types are valid in any
    // particular scenario where wild cards have been used.
    //Upper-bound wildcards are used to provide a generic type that limits a variable to a class or
    // an interface and all its subtypes. The name, upper-bounded refers to the fact that you bound
    // the variable to an upper type - and all of it's subtypes.
    public static Number sumNumbersOnly (List<? extends Number> numbers){
        double s = 0.0;
        for (Number n : numbers)
            s += n.doubleValue();
        return s;
    }

    public <T extends Memory> void printMemory (T memory){

        if (memory instanceof MemoryEmpty )
            System.out.println("Empty memory");
        else {
            MemoryOnePar mem=(MemoryOnePar) memory;
            System.out.println("Memory with one parameter set as:" + mem.getPar1());
        }
    }

    public <T extends Memory> double calcQlong (double SoB,T memory){

        QLongStrategy qLongStrategy;
        if (memory instanceof MemoryEmpty )
             qLongStrategy=new QLongZero();
        else
             qLongStrategy=new QlongSoB();

        return qLongStrategy.calculate(SoB,memory);
    }


}
