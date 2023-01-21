package org.example.domain.terminal;

import org.example.domain.worker.Worker;

import java.util.ArrayList;
import java.util.List;

public class Revenue {

    private final List<Worker> workers = new ArrayList<>();

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public Double getRevenue() {
        return workers.stream().mapToDouble(Worker::earned).sum();
    }
}
