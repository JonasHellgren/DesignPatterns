package org.example.interface_tests;

import org.junit.Test;

public class BasicExtension {

    class Bank{
        float getRateOfInterest(){return 0;}
    }
    class SBI extends Bank{
        float getRateOfInterest(){return 8.4f;}
    }
    class ICICI extends Bank{
        float getRateOfInterest(){return 7.3f;}
    }
    class AXIS extends Bank{
        float getRateOfInterest(){return 9.7f;}
    }

    @Test
    public void showInterest () {
        Bank b;  //be will later change shape...
        b=new Bank();
        System.out.println("Bank Rate of Interest: "+b.getRateOfInterest());
        b=new SBI();
        System.out.println("SBI Rate of Interest: "+b.getRateOfInterest());
        b=new ICICI();
        System.out.println("ICICI Rate of Interest: "+b.getRateOfInterest());
        b=new AXIS();
        System.out.println("AXIS Rate of Interest: "+b.getRateOfInterest());
    }

}
