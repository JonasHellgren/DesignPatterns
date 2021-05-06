package org.example.design_pattern_state.TVstates.model2states;

public class TV {
    private TVState state = new TVStateOff();  //the variable expressing the state of the TV
    public void setState(TVState state) {this.state=state; };  //setter
    public TVState getstate() {return this.state; };    //getter
    //following two lines are interesting, transferring TV variable to method of TV variable
    //potentially not just changing state variable value, but also behaviour/methods of TV variable state
    public void setOn() {state.setOn(this); };  //might give transition, i.e. changing class of TVstate state
    public void setOff() {state.setOff(this); };  //might give transition, i.e. changing class of TVstate state
    public void showState() {state.showState(); };  //printing the state
}
