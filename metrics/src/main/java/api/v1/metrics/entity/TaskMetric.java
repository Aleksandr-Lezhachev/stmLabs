package api.v1.metrics.entity;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "taskMetrics")
public class TaskMetric extends BaseMetric {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attributeId", nullable = false)
    @JsonUnwrapped
    private Attributes attributeId;

    public TaskMetric() {

    }

    public TaskMetric(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public String toString() {
        return "TaskMetric{" +
                "attribute_id=" + attributeId +
                '}';
    }
}
