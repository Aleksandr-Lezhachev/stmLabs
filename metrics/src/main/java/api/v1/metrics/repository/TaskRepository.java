package api.v1.metrics.repository;

import api.v1.metrics.entity.TaskMetric;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<TaskMetric,Long> {
}
