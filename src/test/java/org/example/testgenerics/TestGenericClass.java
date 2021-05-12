package org.example.testgenerics;

import org.example.generics.GenericClass;
import org.junit.Assert;
import org.junit.Test;

public class TestGenericClass {

    @Test
    public void TestInteger() {
        GenericClass<Integer> integerClass = new GenericClass<>(1);

        System.out.printf("Integer Value :%d\n\n", integerClass.get());
        Assert.assertEquals(1,integerClass.get(),0.1);

    }

    @Test
    public void TestString() {
        GenericClass<String> stringClass = new GenericClass<>("1");

        System.out.printf("String Value :%s\n", stringClass.get());
        Assert.assertTrue(stringClass.get().equals("1"));
    }



}
