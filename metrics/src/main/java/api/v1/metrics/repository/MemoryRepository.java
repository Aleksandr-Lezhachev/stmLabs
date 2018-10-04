package api.v1.metrics.repository;

import api.v1.metrics.entity.MemoryMetric;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemoryRepository extends JpaRepository<MemoryMetric, Long> {
}
