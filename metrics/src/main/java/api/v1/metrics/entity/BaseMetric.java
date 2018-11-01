package api.v1.metrics.entity;

import api.v1.metrics.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "base_metric")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseMetric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column
    private String name;
    @Column
    private String param;
    @Column
    private double value;
    @Column
    private String status = Status.UP.getStatus();
    @Column
    private Timestamp timeStamp;
    @Column
    private Timestamp requestTimeStamp;
    @Column
    private Timestamp operationTimeStamp;

    public BaseMetric() {
    }

    public BaseMetric(String name, String param, double value, String status, Timestamp timeStamp, Timestamp requestTimeStamp) {
        this.name = name;
        this.param = param;
        this.value = value;
        this.status = status;
        this.timeStamp = timeStamp;
        this.requestTimeStamp = requestTimeStamp;
        this.operationTimeStamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getOperationTimeStamp() {
        return operationTimeStamp;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public Timestamp getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
