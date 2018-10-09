package api.v1.metrics.rest;

import api.v1.metrics.entity.CpuMetric;
import api.v1.metrics.service.CpuMetricService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/metrics")
public class CpuRestController {
    private final CpuMetricService cpuMetricService;


    public CpuRestController(CpuMetricService cpuMetricService) {
        this.cpuMetricService = cpuMetricService;
    }

    @PostMapping("/post/cpu")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCpuMetric(@RequestBody CpuMetric cpuMetric) {
        cpuMetricService.save(cpuMetric);
    }


}
