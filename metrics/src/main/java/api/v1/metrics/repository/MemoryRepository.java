package api.v1.metrics.repository;

import api.v1.metrics.entity.MemoryMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoryRepository extends JpaRepository<MemoryMetric, Long> {
    @Query(value = "SELECT base_metric.id, memory_metric.id, base_metric.name, base_metric.param, base_metric.value, base_metric.status, base_metric.param,base_metric.time_stamp, " +
            "base_metric.operation_time_stamp, base_metric.request_time_stamp \n" +
            "FROM memory_metric INNER JOIN base_metric \n" +
            "ON memory_metric.id = base_metric.id \n" +
            "WHERE base_metric.name = (:name)\n" +
            "ORDER BY base_metric.time_stamp \n" +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<MemoryMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
