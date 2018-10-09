package api.v1.metrics.wrapper;

import api.v1.metrics.entity.BaseMetric;

/**
 * Класс-обертка для POST запроса
 */
public class WrapperMetrics extends BaseMetric {
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}

