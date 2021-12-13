package org.example.design_pattern_state.kidage;

public class SecondYearKid implements KidState{
    @Override
    public void play() {
        System.out.println("Play with simple toys");
    }

    @Override
    public void eat() {
        System.out.println("Eating porridge");
    }
}
