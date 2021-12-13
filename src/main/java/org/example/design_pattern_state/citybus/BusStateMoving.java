package org.example.design_pattern_state.citybus;

public class BusStateMoving implements BusState {
    @Override
    public void acc(Bus bus) {   }   //no change
    @Override
    public void drive(Bus bus) {     }    //no change
    public void stop(Bus bus) {    bus.setState(new BusStateWaiting());  }  //from move to stop
    @Override
    public String getStateAsString() { return "Moving";   }
}
