package api.v1.metrics.repository;

import api.v1.metrics.entity.SsdMetric;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SsdRepository extends JpaRepository<SsdMetric, Long> {
}
