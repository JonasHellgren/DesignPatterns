package org.example.design_pattern_state.TVstates.model3states;

public class TVv2 {
    private TVStateV2 state = new TVStateOffV2();  //the variable expressing the state of the TV
    public void setState(TVStateV2 state) {this.state=state; };  //setter
    public TVStateV2 getstate() {return this.state; };    //getter
    //following two lines are interesting, transferring TV variable to method of TV variable
    //potentially not just changing state variable value, but also behaviour/methods of TV variable state
    public void setOn() {state.setOn(this); };  //might give transition, i.e. changing class of TVstate state
    public void setOff() {state.setOff(this); };  //might give transition, i.e. changing class of TVstate state
    public void kickHard() {state.kickHard(this); };  //might give transition, i.e. changing class of TVstate state
    public void showstate() {state.showState(); };  //printing the state
}
