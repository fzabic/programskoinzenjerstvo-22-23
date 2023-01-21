package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public class Bus extends LargeVehicle{

    //Insert bus specifications

    public Bus(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    public Bus(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }
}
