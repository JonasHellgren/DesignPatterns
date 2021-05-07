package org.example.design_pattern_strategy.traveltorailway_classes;

public class Travel
{
    private TravelStrategy travelStrategy;

    public void setTravelStrategy(TravelStrategy railwayStation)
    {
        this.travelStrategy = railwayStation;
    }

    public TravelStrategy getTravelStrategy()
    {
        return travelStrategy;
    }



}