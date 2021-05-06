package org.example.design_pattern_state.TVstates.model3states;

public class TVStateBroken implements TVStateV2 {
    @Override
    public void setOn(TVv2 tv) {System.out.println("TV is broken");   }
    @Override
    public void setOff(TVv2 tv) { System.out.println("TV is broken");  }
    @Override
    public void kickHard(TVv2 tv) {System.out.println("Warning: TV more damaged");  }  //from off to broken
    @Override
    public void showState() {System.out.println("TV is broken");   }
}