package api.v1.metrics.entity;

import api.v1.metrics.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.w3c.dom.Attr;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private double value;
    @Column(name = "status")
    private String status = Status.UP.getStatus();
    @Column(name = "timeStamp")
    private Timestamp timestamp;
    @Column(name = "requestTimeStamp")
    private Timestamp requestTimeStamp;
    @Column(name = "operationTimeStamp")
    @JsonIgnore
    private Timestamp operationTimeStamp = new Timestamp(System.currentTimeMillis());

    public Attributes() {
    }

    public Attributes(String name, double value, String status, Timestamp timestamp, Timestamp requestTimeStamp) {
        this.name = name;
        this.value = value;
        this.status = status;
        this.timestamp = timestamp;
        this.requestTimeStamp = requestTimeStamp;
    }

    public Attributes(String name, double value, Timestamp timestamp, Timestamp requestTimeStamp) {
        this.name = name;
        this.value = value;
        this.timestamp = timestamp;
        this.requestTimeStamp = requestTimeStamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                ", requestTimeStamp=" + requestTimeStamp +
                ", operationTimeStamp=" + operationTimeStamp +
                '}';
    }
}
