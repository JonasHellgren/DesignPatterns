package org.example.design_pattern_state.TVstates.model3states;

public class TVStateOnV2 implements TVStateV2 {
    @Override
    public void setOn(TVv2 tv) { System.out.println("Warning: TV is already turned ON");  }   //no change
    @Override
    public void setOff(TVv2 tv) {  tv.setState(new TVStateOffV2());    }    //from on to off
    public void kickHard(TVv2 tv) {tv.setState(new TVStateBroken());  }  //from on to broken
    @Override
    public void showState() {System.out.println("TV is turned ON");   }
}
