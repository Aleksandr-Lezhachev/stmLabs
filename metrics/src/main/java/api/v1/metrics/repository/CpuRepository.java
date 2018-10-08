package api.v1.metrics.repository;

import api.v1.metrics.entity.CpuMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CpuRepository extends JpaRepository<CpuMetric, Long> {
    @Query(value = "SELECT attributes.name, cpu_metrics.id, cpu_metrics.attribute_id ,attributes.value, cpu_metrics.param,attributes.timestamp, attributes.requesttimestamp " +
            "FROM cpu_metrics INNER JOIN attributes " +
            "ON cpu_metrics.attribute_id = attributes.id  " +
            "WHERE attributes.name = (:name) " +
            "ORDER BY attributes.timestamp " +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<CpuMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);


}
