package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;
import org.example.domain.vehicle.builder.IVehicleBuilder;

public class Car extends SmallVehicle{

    //Insert car specifications

    public Car(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    public Car(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }


    public static final class Builder implements IVehicleBuilder<Builder, Car> {
        private Integer id;
        private Fuel fuel;
        private final Double CHARGE = 50.00;

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public Builder fuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        @Override
        public Car build() {
            return new Car(id, CHARGE, fuel);
        }
    }

}
