package api.v1.metrics.entity;


import javax.persistence.*;

@Entity
@Table(name = "ssd_metrics")
public class SsdMetric extends BaseMetric {
    @Column(name = "params")
    private String param;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attributes attribute_id;

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
}
