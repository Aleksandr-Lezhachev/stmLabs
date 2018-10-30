package api.v1.metrics.repository;

import api.v1.metrics.entity.TaskMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskMetric, Long> {
    @Query(value = "SELECT attributes.name, task_metrics.id, task_metrics.attribute_id ,attributes.value, attributes.timestamp, attributes.requesttimestamp " +
            "FROM task_metrics INNER JOIN attributes " +
            "ON task_metrics.attribute_id = attributes.id  " +
            "WHERE attributes.name = (:name) " +
            "ORDER BY attributes.timestamp " +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<TaskMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
