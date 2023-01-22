package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;
import org.example.domain.vehicle.builder.IVehicleBuilder;

public class Van extends SmallVehicle{

    //Insert van specifications

    public Van(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }
    protected Van(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }

    public static final class Builder implements IVehicleBuilder<Builder, Van> {
        private Integer id;
        private Fuel fuel;
        private final Double CHARGE = 80.00;

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
        public Van build() {
            return new Van(id, CHARGE, fuel);
        }
    }
}
