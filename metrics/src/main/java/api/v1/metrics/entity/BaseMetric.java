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
    @JoinColumn(name = "attributeId", nullable = false)
    @JsonUnwrapped
    private Attributes attributeId;

    public Attributes getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Attributes attributeId) {
        this.attributeId = attributeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
