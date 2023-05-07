package mtgroup.restaurantmanagementsystem.service;

import mtgroup.restaurantmanagementsystem.dto.WorkerDto;
import mtgroup.restaurantmanagementsystem.model.Worker;
import mtgroup.restaurantmanagementsystem.repository.JpaWorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaWorkerService implements WorkerService{

    private final JpaWorkerRepository workerRepository;

    public JpaWorkerService(JpaWorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> allWorkers() {
        return workerRepository.findAll();
    }
}
