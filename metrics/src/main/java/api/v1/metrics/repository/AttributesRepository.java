package api.v1.metrics.repository;

import api.v1.metrics.entity.Attributes;
import api.v1.metrics.entity.BaseMetric;
import api.v1.metrics.entity.CpuMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

import static javafx.scene.input.KeyCode.T;

public interface AttributesRepository extends JpaRepository<Attributes, Long> {
/*fetch('http://localhost:8080/api/v1/metrics/post/cpu/',{method: "POST", headers: {'Content-Type': 'application/json'}, body:  JSON.stringify({param:"SuperTest",name:"cpu", value:"27",Status:"UP",timestamp:"2018-09-21T14:32:34.354+0000",requestTimeStamp:"2018-09-21T14:32:34.354+0000"})}).then(console.log)*/
}
