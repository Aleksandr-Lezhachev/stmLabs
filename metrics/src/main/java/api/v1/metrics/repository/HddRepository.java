package api.v1.metrics.repository;

import api.v1.metrics.entity.HddMetric;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HddRepository extends JpaRepository<HddMetric, Long> {
}
