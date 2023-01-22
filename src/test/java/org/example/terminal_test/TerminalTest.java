package org.example.terminal_test;

import org.example.domain.fuel.Battery;
import org.example.domain.fuel.Gas;
import org.example.domain.terminal.Revenue;
import org.example.domain.train.LargeTrain;
import org.example.domain.train.SmallTrain;
import org.example.domain.train.Train;
import org.example.domain.vehicle.*;
import org.example.domain.worker.Worker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class TerminalTest {

    private static Worker juniorWorker;
    private static Worker seniorWorker;

    private static Train smallTrain;
    private static Train largeTrain;

    private static Revenue terminal = new Revenue();

    @BeforeAll
    public static void init(){
        juniorWorker = new Worker(0.1);
        seniorWorker = new Worker(0.11);

        terminal.addWorker(juniorWorker);
        terminal.addWorker(seniorWorker);

        smallTrain = new SmallTrain();
        largeTrain = new LargeTrain();
    }

    @Test
    @DisplayName("Can workers park vehicles on to trains?")
    public void parkVehicles(){
        juniorWorker.parkVehicle(new Car.Builder().fuel(new Gas(0.9)).build(), smallTrain);
        juniorWorker.parkVehicle(new Van.Builder().fuel(new Gas(0.4)).build(), smallTrain);
        juniorWorker.parkVehicle(new Car.Builder().fuel(new Battery(0.09)).build(), smallTrain);

        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.5)).build(), largeTrain);
        seniorWorker.parkVehicle(new Bus.Builder().fuel(new Gas(0.02)).build(), largeTrain);

        int smallTrainCurrentCargoSize = smallTrain.getTransferables().size();
        int largeTrainCurrentCargoSize = largeTrain.getTransferables().size();

        assertEquals(3, smallTrainCurrentCargoSize);
        assertEquals(2, largeTrainCurrentCargoSize);
    }

    @Test
    @DisplayName("Will workers refill vehicles if needed?")
    public void refills(){
        seniorWorker.parkVehicle(new Car.Builder().fuel(new Gas(0.2)).build(), smallTrain);
        juniorWorker.parkVehicle(new Car.Builder().fuel(new Gas(0.01)).build(), smallTrain);

        smallTrain.getTransferables().forEach(v -> assertTrue(v.getFuel().getCurrent_percentage() > 0.1));
    }

    @Test
    @DisplayName("Will workers stop adding if train cargo is full?")
    public void addingOverLimit(){
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);
        seniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.7)).build(), largeTrain);

        assertEquals(largeTrain.getTransferables().size(), largeTrain.getLimit());
    }

    @Test
    @DisplayName("Will workers add wrong category to the wrong train?")
    public void addingWrong(){
        assertFalse(juniorWorker.parkVehicle(new Van.Builder().fuel(new Gas(0.5)).build(), largeTrain));
        assertFalse(juniorWorker.parkVehicle(new Truck.Builder().fuel(new Gas(0.5)).build(), smallTrain));
    }

    @Test
    @DisplayName("Can calculate revenue?")
    public void calculateRevenue(){
        assertEquals(terminal.getRevenue(), largeTrain.getProfit() + smallTrain.getProfit());
    }

    @Test
    @DisplayName("Can calculate salary")
    public void calculateSalary(){
        assertEquals(juniorWorker.getVehicles().stream().mapToDouble(Vehicle::calculateCharging).sum() * juniorWorker.getSalary(),
                juniorWorker.earned());
    }
}
