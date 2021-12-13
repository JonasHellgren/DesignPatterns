package org.example.design_pattern_state.citybus;

public class BusStateWaiting implements BusState {
    @Override
    public void acc(Bus bus) { bus.setState((new BusStateAcc()));  }
    @Override
    public void drive(Bus bus) {  }  //no change
    @Override
    public void stop(Bus bus) {  }  //no change
    @Override
    public String getStateAsString() { return "Waiting";   }
}