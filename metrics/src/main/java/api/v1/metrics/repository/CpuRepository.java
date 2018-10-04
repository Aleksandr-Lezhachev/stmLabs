package api.v1.metrics.repository;

import api.v1.metrics.entity.CpuMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<CpuMetric, Long> {
}
