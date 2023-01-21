package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public class Van extends SmallVehicle{

    //Insert van specifications

    public Van(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }
    protected Van(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }
}
