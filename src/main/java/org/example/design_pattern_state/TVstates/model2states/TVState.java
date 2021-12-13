package org.example.design_pattern_state.TVstates.model2states;

public interface TVState {
    public void setOn(TV tv);  //abstract method for turning TV on
    public void setOff(TV tv);  //abstract method for turning TV off
    public void showState();  ////abstract method for printing status, i.e. present state
}
