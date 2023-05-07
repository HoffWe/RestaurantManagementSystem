package mtgroup.restaurantmanagementsystem.repository;

import mtgroup.restaurantmanagementsystem.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaWorkerRepository extends JpaRepository<Worker,Long> {
}
