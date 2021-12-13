package org.example.design_pattern_state.citybus;

public class MainBus {

   public static void main(String[] args) {

    Bus bus=new Bus();
    System.out.println("Lets test bus status");
    System.out.println(bus.getStateAsString());  bus.acc();
    System.out.println(bus.getStateAsString());  bus.drive();
    System.out.println(bus.getStateAsString());  bus.stop();
    System.out.println(bus.getStateAsString());

    System.out.println("Lets test bus updating");
       for (int i = 0; i <20 ; i++) {
           bus.update();
           System.out.println(bus);
       }


   }
}
