package api.v1.metrics.repository;

import api.v1.metrics.entity.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributesRepository extends JpaRepository<Attributes, Long> {

}
