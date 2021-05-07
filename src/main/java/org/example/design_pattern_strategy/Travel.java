package org.example.design_pattern_strategy;

import org.example.design_pattern_strategy.traveltorailway_classes.TravelByAuto;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelStrategy;

public class Travel
{
    private TravelStrategy travelStrategy;

    public Travel() {
        this.travelStrategy=new TravelByAuto();
    }

    public Travel(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy railwayStation)
    {
        this.travelStrategy = railwayStation;
    }

    public TravelStrategy getTravelStrategy()
    {
        return travelStrategy;
    }

    public Double timeToTravel(Double distance) {
        return distance/travelStrategy.speedOfTravelMeterPerSec();
    }

}