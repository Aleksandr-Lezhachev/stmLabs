package api.v1.metrics.repository;


import api.v1.metrics.entity.SsdMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SsdRepository extends JpaRepository<SsdMetric, Long> {
    @Query(value = "SELECT attributes.name, ssd_metrics.id, ssd_metrics.attribute_id ,attributes.value, " +
            "ssd_metrics.param,attributes.timestamp, attributes.requesttimestamp " +
            "FROM ssd_metrics INNER JOIN attributes " +
            "ON ssd_metrics.attribute_id = attributes.id  " +
            "WHERE attributes.name = (:name) " +
            "ORDER BY attributes.timestamp " +
            "DESC LIMIT NULLIF(:size, -1)", nativeQuery = true)
    List<SsdMetric> getByNameSomeMetrics(@Param("name") String name, @Param("size") Integer size);
}
