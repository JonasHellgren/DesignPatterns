package org.example.design_pattern_state.TVstates.model2states;

public class TVStateOff implements TVState {
    @Override
    public void setOn(TV tv) {tv.setState(new TVStateOn());  }  //from off to on
    @Override
    public void setOff(TV tv) { System.out.println("TV is already turned OFF");  }  //no change
    @Override
    public void showState() {System.out.println("TV is turned OFF");   }
}
