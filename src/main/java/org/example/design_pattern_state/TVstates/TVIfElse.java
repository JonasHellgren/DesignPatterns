package org.example.design_pattern_state.TVstates;

public class TVIfElse {
    private String state = "";
    public void setState(String state) { this.state = state;    }
    public void showstate() {
        if (state.equalsIgnoreCase("ON")) {
            System.out.println("TV is turned ON");
        } else if (state.equalsIgnoreCase("OFF")) {
            System.out.println("TV is turned OFF");
        }
    }
}
