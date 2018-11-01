package api.v1.metrics.entity;


import javax.persistence.Entity;

@Entity
public class HddMetric extends BaseMetric {
    public HddMetric() {

    }

    public HddMetric(BaseMetric m) {
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
