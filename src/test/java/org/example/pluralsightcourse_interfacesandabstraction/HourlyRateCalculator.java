package org.example.pluralsightcourse_interfacesandabstraction;

public class HourlyRateCalculator implements RevenueCalculator {

    private final double hourlyRate;

    public HourlyRateCalculator(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculate(ClientEngagement clientEngagement) {
        return hourlyRate*clientEngagement.getHoursWorked();
    }
}
