package api.v1.metrics.entity;


import javax.persistence.Entity;

@Entity
public class SsdMetric extends BaseMetric {
    public SsdMetric() {

    }

    public SsdMetric(BaseMetric m) {
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
