package api.v1.metrics.repository;

import api.v1.metrics.entity.TaskMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskMetric, Long> {
    @Query(value = "SELECT base_metric.id, task_metric.id, base_metric.name, base_metric.param, base_metric.value, base_metric.status, base_metric.param,base_metric.time_stamp, " +
            "base_metric.operation_time_stamp, base_metric.request_time_stamp \n" +
            "FROM task_metric INNER JOIN base_metric \n" +
            "ON task_metric.id = base_metric.id \n" +
            "WHERE base_metric.name = (:name)\n" +
            "ORDER BY base_metric.time_stamp \n" +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<TaskMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
