package mtgroup.restaurantmanagementsystem.mapper;

import mtgroup.restaurantmanagementsystem.dto.WorkerDto;
import mtgroup.restaurantmanagementsystem.model.Worker;

public class WorkerMap {

    public static WorkerDto mapToDto (Worker worker){
        return WorkerDto.builder()
                .id(worker.getId())
                .name(worker.getName())
                .lastName(worker.getLastName())
                .position(worker.getPosition())
                .dateOfBirth(worker.getDateOfBirth())
                .salary(worker.getSalary())
                .photoUrl(worker.getPhotoUrl()).build();
    }

}
