package org.example.design_pattern_state.citybus;

public class BusStateAcc implements BusState {
    @Override
    public void acc(Bus bus) { }  //no change
    @Override
    public void drive(Bus bus) { bus.setState(new BusStateMoving());  }  //to driving
    @Override
    public void stop(Bus bus) {  }  //no change
    @Override
    public String getStateAsString() { return "Acc";   }
}
