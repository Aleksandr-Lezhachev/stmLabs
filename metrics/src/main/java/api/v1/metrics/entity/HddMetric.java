package api.v1.metrics.entity;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@Table(name = "hdd_metrics")
public class HddMetric extends BaseMetric {
    @Column(name = "param")
    private String param;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", nullable = false)
    @JsonUnwrapped
    private Attributes attribute_id;

    public HddMetric() {
    }

    public HddMetric(String param, Attributes attribute_id) {
        this.param = param;
        this.attribute_id = attribute_id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Attributes getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(Attributes attribute_id) {
        this.attribute_id = attribute_id;
    }

    @Override
    public String toString() {
        return "HddMetric{" +
                "param='" + param + '\'' +
                ", attribute_id=" + attribute_id +
                '}';
    }
}
