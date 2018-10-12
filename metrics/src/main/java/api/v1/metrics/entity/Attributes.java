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
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "requesttimestamp")
    private Timestamp requestTimeStamp;
    @Column(name = "operationtimestamp")
    @JsonIgnore
    private Timestamp operationTimeStamp = new Timestamp(System.currentTimeMillis());

    public Attributes(){}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(Timestamp requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    public Timestamp getOperationTimeStamp() {
        return operationTimeStamp;
    }

    public void setOperationTimeStamp(Timestamp operationTimeStamp) {
        this.operationTimeStamp = operationTimeStamp;
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
