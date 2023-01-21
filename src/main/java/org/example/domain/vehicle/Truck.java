package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public class Truck extends LargeVehicle{

    //Insert truck specifications

    public Truck(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    public Truck(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }
}
