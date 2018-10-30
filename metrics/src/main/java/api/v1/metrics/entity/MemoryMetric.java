package api.v1.metrics.entity;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "memoryMetrics")
public class MemoryMetric extends BaseMetric {
    @Column(name = "param")
    private String param;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attributeId", nullable = false)
    @JsonUnwrapped
    private Attributes attributeId;

    public MemoryMetric() {
    }

    public MemoryMetric(String param, Attributes attributeId) {
        this.param = param;
        this.attributeId = attributeId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public String toString() {
        return "MemoryMetric{" +
                "param='" + param + '\'' +
                ", attribute_id=" + attributeId +
                '}';
    }
}
