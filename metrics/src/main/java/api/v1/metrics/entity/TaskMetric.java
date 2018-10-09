package api.v1.metrics.entity;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "task_metrics")
public class TaskMetric extends BaseMetric {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", nullable = false)
    @JsonUnwrapped
    private Attributes attribute_id;

    public TaskMetric() {
    }

    public TaskMetric(Attributes attribute_id) {
        this.attribute_id = attribute_id;
    }

    public Attributes getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(Attributes attribute_id) {
        this.attribute_id = attribute_id;
    }

    @Override
    public String toString() {
        return "TaskMetric{" +
                "attribute_id=" + attribute_id +
                '}';
    }
}
