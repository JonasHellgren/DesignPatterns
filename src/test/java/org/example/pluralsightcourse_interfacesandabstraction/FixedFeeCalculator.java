package org.example.pluralsightcourse_interfacesandabstraction;

public class FixedFeeCalculator implements RevenueCalculator {

    private final double fee;

    public FixedFeeCalculator(double fee) {
        this.fee = fee;
    }

    @Override
    public double calculate(ClientEngagement clientEngagement) {
        return fee;
    }
}
