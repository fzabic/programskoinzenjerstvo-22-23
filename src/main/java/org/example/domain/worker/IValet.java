package org.example.domain.worker;

import org.example.domain.train.Train;
import org.example.domain.vehicle.Vehicle;

public interface IValet {
    Boolean parkVehicle(Vehicle vehicle, Train train);
}
