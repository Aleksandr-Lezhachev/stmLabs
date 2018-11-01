package api.v1.metrics.entity;


import javax.persistence.Entity;

@Entity
public class MemoryMetric extends BaseMetric {
    public MemoryMetric() {

    }

    public MemoryMetric(BaseMetric m) {
        super(
                m.getName(),
                m.getParam(),
                m.getValue(),
                m.getStatus(),
                m.getTimeStamp(),
                m.getRequestTimeStamp()
        );
    }
}
