package org.example.design_pattern_state.TVstates.model2states;

public class TVStateOn implements TVState {
    @Override
    public void setOn(TV tv) {System.out.println("TV is already turned ON");   }  //no change
    @Override
    public void setOff(TV tv) {tv.setState(new TVStateOff());    }  //from on to off
    @Override
    public void showState() {System.out.println("TV is turned ON");   }
}
