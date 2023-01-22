package org.example.domain.terminal;

import org.example.domain.vehicle.Vehicle;
import org.example.domain.worker.Worker;

import java.util.ArrayList;
import java.util.List;

public class Revenue {

    public Revenue() {
    }

    private final List<Worker> workers = new ArrayList<>();

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public Double getWorkerSalary() {
        return workers.stream().mapToDouble(Worker::earned).sum();
    }
    public Double getRevenue() {
        return workers.stream()
                .mapToDouble(w ->
                        w.getVehicles().stream().mapToDouble(Vehicle::calculateCharging)
                                .sum())
                .sum();
    }
}
