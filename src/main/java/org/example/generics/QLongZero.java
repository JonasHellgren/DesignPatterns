package org.example.generics;

public class QLongZero implements QLongStrategy {

    @Override
    public <T extends Memory> Double calculate(double SoB, T memory) {
        return 0d;
    }
}
