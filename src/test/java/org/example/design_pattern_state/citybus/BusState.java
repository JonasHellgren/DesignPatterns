package org.example.design_pattern_state.citybus;

public interface BusState {
    public void acc(Bus bus);  //abstract method
    public void drive(Bus bus);  //abstract method
    public void stop(Bus bus);  //abstract method
    public String getStateAsString();  ////abstract method for printing status, i.e. present state
}
