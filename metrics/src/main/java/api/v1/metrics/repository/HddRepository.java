package api.v1.metrics.repository;

import api.v1.metrics.entity.HddMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HddRepository extends JpaRepository<HddMetric, Long> {
    @Query(value = "SELECT attributes.name, hdd_metrics.id, hdd_metrics.attribute_id ,attributes.value, hdd_metrics.param,attributes.timestamp, attributes.requesttimestamp " +
            "FROM hdd_metrics INNER JOIN attributes " +
            "ON hdd_metrics.attribute_id = attributes.id  " +
            "WHERE attributes.name = (:name) " +
            "ORDER BY attributes.timestamp " +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<HddMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
