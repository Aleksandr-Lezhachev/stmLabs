package api.v1.metrics.dto;

import java.sql.Timestamp;

public class BaseMetricDTO {
    private String name;
    private String param;
    private double value;
    private String status;
    private Timestamp timeStamp;
    private Timestamp requestTimeStamp;

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

}
