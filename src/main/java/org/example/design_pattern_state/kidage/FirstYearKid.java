package org.example.design_pattern_state.kidage;

public class FirstYearKid implements KidState {

    @Override
    public void play() {
        System.out.println("Play in crade");
    }

    @Override
    public void eat() {
        System.out.println("Drink milk");
    }
}
