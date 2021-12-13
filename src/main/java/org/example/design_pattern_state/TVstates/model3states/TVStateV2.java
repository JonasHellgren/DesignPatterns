package org.example.design_pattern_state.TVstates.model3states;

public interface TVStateV2 {
    public void setOn(TVv2 tv);  //abstract method for turning TV on
    public void setOff(TVv2 tv);  //abstract method for turning TV off
    public void kickHard(TVv2 tv);  //abstract method for hard kick on annoying TV
    public void showState();  ////abstract method for printing status, i.e. present state
}
