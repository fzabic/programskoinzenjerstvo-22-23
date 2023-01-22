package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;
import org.example.domain.vehicle.builder.IVehicleBuilder;

public class Bus extends LargeVehicle{

    //Insert bus specifications

    public Bus(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    public Bus(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }

    public static final class Builder implements IVehicleBuilder<Builder, Bus> {
        private Integer id;
        private Fuel fuel;
        private final Double CHARGE = 70.00;

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
        public Bus build() {
            return new Bus(id, CHARGE, fuel);
        }
    }
}
