package api.v1.metrics.entity.resultClasses;

import java.sql.Timestamp;
/** Class for @SqlResultSetMapping and @NamedNativeQuery */
public class ResultClass {

    private String param;
    private String name;
    private double value;
    private Timestamp timestamp;
    private Timestamp requestTimeStamp;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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
}
