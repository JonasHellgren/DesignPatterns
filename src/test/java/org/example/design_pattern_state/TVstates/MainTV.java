package org.example.design_pattern_state.TVstates;


import org.example.design_pattern_state.TVstates.model2states.TV;
import org.example.design_pattern_state.TVstates.model3states.TVv2;

public class MainTV {

   public static void main(String[] args) {

   System.out.println("Lets test traditional hard coding of TV state setting");
   TVIfElse tvifelse = new TVIfElse();
   tvifelse.setState("OFF"); tvifelse.showstate();
   tvifelse.setState("ON"); tvifelse.showstate();

    System.out.println("Lets test state design pattern of TV state setting");
    TV tv = new TV();
    tv.showState();  tv.setOff();
    tv.setOn(); tv.showState();
    tv.setOn(); tv.showState();

    System.out.println("Lets test state design pattern of TV state setting with additional broken state");
    TVv2 tv2= new TVv2();
    tv2.showstate();  tv2.setOff();
    tv2.setOn(); tv2.showstate();
    tv2.setOn(); tv2.showstate();
    tv2.kickHard(); tv2.showstate();
    tv2.setOn(); tv2.showstate();
    tv2.kickHard(); tv2.showstate();

   }
}
