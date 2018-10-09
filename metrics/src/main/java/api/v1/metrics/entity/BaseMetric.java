package api.v1.metrics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseMetric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", nullable = false)
    @JsonUnwrapped
    private Attributes attribute_id;

    public Attributes getAttribute_id() {
        return attribute_id;
    }

    public void setAttribute_id(Attributes attribute_id) {
        this.attribute_id = attribute_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
