package api.v1.metrics.repository;

import api.v1.metrics.entity.MemoryMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemoryRepository extends JpaRepository<MemoryMetric, Long> {
    @Query(value = "SELECT attributes.name, memory_metrics.id, memory_metrics.attribute_id ,attributes.value, memory_metrics.param,attributes.timestamp, attributes.requesttimestamp " +
            "FROM memory_metrics INNER JOIN attributes " +
            "ON memory_metrics.attribute_id = attributes.id  " +
            "WHERE attributes.name = (:name) " +
            "ORDER BY attributes.timestamp " +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<MemoryMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
