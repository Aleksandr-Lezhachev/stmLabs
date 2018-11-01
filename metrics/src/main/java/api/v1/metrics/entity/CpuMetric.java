package api.v1.metrics.entity;

import javax.persistence.Entity;

@Entity
public class CpuMetric extends BaseMetric {

    public CpuMetric() {

    }

    public CpuMetric(BaseMetric m) {
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
