package org.example.generics;

public class QlongSoB implements QLongStrategy{

    @Override
    public <T extends Memory> Double calculate(double SoB, T memory) {
        if (!(memory instanceof MemoryOnePar) ) {
            logger.warning("Wrong memory type into calculate");
            return 0d;
        }

        MemoryOnePar mem=(MemoryOnePar)memory;
        return (SoB<mem.getPar1())?-1d:0d;
    }
}
