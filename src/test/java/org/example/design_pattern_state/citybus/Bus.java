package org.example.design_pattern_state.citybus;

public class Bus {
    private BusState state = new BusStateWaiting();  //the variable expressing the state of the TV
    private int tStop=0;
    private int dist =0;
    public void setState(BusState state) {this.state=state; };  //setter
    public BusState getState() {return this.state; };    //getter
    //following two lines are interesting, transferring TV variable to method of TV variable
    //potentially not just changing state variable value, but also behaviour/methods of TV variable state
    public void acc() {state.acc(this); };  //might give transition, i.e. changing class of TVstate state
    public void drive() {state.drive(this); };  //might give transition, i.e. changing class of TVstate state
    public void stop() {state.stop(this); };  //might give transition, i.e. changing class of TVstate state
    public String getStateAsString() { return state.getStateAsString(); };  //printing the state

    public void update() {
        //check guards, i.e. shall state be changed
        if (state instanceof BusStateWaiting) {
            if (tStop>Params.T_STOP_MAX)
                acc();
        } else if (state instanceof BusStateAcc) {
            drive();
        } else if (state instanceof BusStateMoving) {
            if (dist >Params.D_MAX)
                stop();
        }

        //update tStop and/or d
        if (state instanceof BusStateWaiting) {
            tStop = tStop + Params.D_TIME;
            dist = 0;
        } else if (state instanceof BusStateAcc) {
            tStop = 0;
        } else if (state instanceof BusStateMoving) {
            dist = dist + Params.D_DIST;
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                "state=" + state.getStateAsString() +
                ", tStop=" + tStop +
                ", d=" + dist +
                '}';
    }
}
