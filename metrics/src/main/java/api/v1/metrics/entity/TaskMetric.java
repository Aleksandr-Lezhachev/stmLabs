package api.v1.metrics.entity;


import javax.persistence.*;

@Entity
@Table(name = "task_metrics")
public class TaskMetric extends BaseMetric {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id")
    private Attributes attribute_id;

    public Attributes getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(Attributes attribute_id) {
        this.attribute_id = attribute_id;
    }
}
