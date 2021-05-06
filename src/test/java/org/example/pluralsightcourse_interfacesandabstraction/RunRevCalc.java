package org.example.pluralsightcourse_interfacesandabstraction;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RunRevCalc {

    final List<ClientEngagement> engagementList= Arrays.asList(
            new ClientEngagement("Jonas",100),
            new ClientEngagement("Katja",50),
            new ClientEngagement("Alex",1),
            new ClientEngagement("Christofer",50)
    );


    @Test
    public void CalcFixedFee() {
    RevenueCalculator calculator = new FixedFeeCalculator(100);
    Assert.assertEquals(400,getRevSum(engagementList,calculator),0.1);
    }

    @Test
    public void CalcHourlyRate() {
        RevenueCalculator calculator = new HourlyRateCalculator(1);
        Assert.assertEquals(201,getRevSum(engagementList,calculator),0.1);
    }

    public static double getRevSum(
            final List<ClientEngagement> engagementList, RevenueCalculator calculator
    )  {

        double sum= engagementList.stream().mapToDouble(e -> calculator.calculate(e)).sum();
        //same as double total= engagementList.stream().mapToDouble(calculator::calculate).sum();

        return sum;
    }

}
