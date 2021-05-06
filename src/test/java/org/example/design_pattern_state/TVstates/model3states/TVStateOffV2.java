package org.example.design_pattern_state.TVstates.model3states;

public class TVStateOffV2 implements TVStateV2 {
    @Override
    public void setOn(TVv2 tv) {tv.setState(new TVStateOnV2());  }  //from off to on
    @Override
    public void setOff(TVv2 tv) { System.out.println("Warning: TV is already turned OFF");  }  //no change
    @Override
    public void kickHard(TVv2 tv) {tv.setState(new TVStateBroken());  }  //from off to broken
    @Override
    public void showState() {System.out.println("TV is turned OFF");   }
}
