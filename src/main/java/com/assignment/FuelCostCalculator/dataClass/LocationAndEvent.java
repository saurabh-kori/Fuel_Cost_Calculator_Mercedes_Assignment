package com.assignment.FuelCostCalculator.dataClass;

// import javax.annotation.sql.DataSourceDefinition;


public class LocationAndEvent {
    private String location ;
    public boolean event;

    public LocationAndEvent() {
    }

    public LocationAndEvent(String location, boolean event) {
        this.location = location;
        this.event = event;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "LocationAndEvent [event=" + event + ", location=" + location + "]";
    }

    

}
