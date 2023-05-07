package mtgroup.restaurantmanagementsystem.controller;


import mtgroup.restaurantmanagementsystem.dto.WorkerDto;

import mtgroup.restaurantmanagementsystem.mapper.WorkerMap;
import mtgroup.restaurantmanagementsystem.service.WorkerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("api/worker")
public class WorkerController {
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/")
    public List<WorkerDto> getAllWorkers(){
        return workerService.allWorkers().stream().map(WorkerMap::mapToDto).collect(Collectors.toList());
    }
}
