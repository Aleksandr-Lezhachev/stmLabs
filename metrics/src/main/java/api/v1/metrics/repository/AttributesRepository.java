package api.v1.metrics.repository;

import api.v1.metrics.entity.Attributes;
import api.v1.metrics.entity.BaseMetric;
import api.v1.metrics.entity.CpuMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

import static javafx.scene.input.KeyCode.T;

public interface AttributesRepository extends JpaRepository<Attributes, Long> {

}
