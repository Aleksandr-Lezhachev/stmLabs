package api.v1.metrics.entity;


import javax.persistence.Entity;

@Entity
public class TaskMetric extends BaseMetric {
    public TaskMetric() {

    }

    public TaskMetric(BaseMetric m) {
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
