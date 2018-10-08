package api.v1.metrics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@MappedSuperclass
public class BaseMetric {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @JsonIgnore

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
