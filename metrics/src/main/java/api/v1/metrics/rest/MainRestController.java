package api.v1.metrics.rest;


import api.v1.metrics.entity.*;
import api.v1.metrics.service.*;
import api.v1.metrics.wrapper.WrapperMetrics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1/metrics")
public class MainRestController {
    private final CpuMetricService cpuMetricService;
    private final HddMetricService hddMetricService;
    private final MemoryMetricService memoryMetricService;
    private final SsdMetricService ssdMetricService;
    private final TaskMetricService taskMetricService;

    public MainRestController(CpuMetricService cpuMetricService, HddMetricService hddMetricService, MemoryMetricService memoryMetricService, SsdMetricService ssdMetricService, TaskMetricService taskMetricService) {
        this.cpuMetricService = cpuMetricService;
        this.hddMetricService = hddMetricService;
        this.memoryMetricService = memoryMetricService;
        this.ssdMetricService = ssdMetricService;
        this.taskMetricService = taskMetricService;
    }

    @GetMapping("/get/all")
    public ResponseEntity getListMetrics() {
        List<BaseMetric> metricList = new ArrayList<>();
        List<CpuMetric> cpuMetricList = this.cpuMetricService.getByNameSomeMetrics("cpu");
        List<HddMetric> hddMetricList = this.hddMetricService.getByNameSomeMetrics("hdd");
        List<MemoryMetric> memoryMetricList = this.memoryMetricService.getByNameSomeMetrics("memory");
        List<SsdMetric> ssdMetricList = this.ssdMetricService.getByNameSomeMetrics("ssd");
        List<TaskMetric> taskMetricList = this.taskMetricService.getByNameSomeMetrics("taskCount");
        metricList.addAll(cpuMetricList);
        metricList.addAll(hddMetricList);
        metricList.addAll(memoryMetricList);
        metricList.addAll(ssdMetricList);
        metricList.addAll(taskMetricList);
        if (metricList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(metricList, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity badRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity getDefaultCurrentMetric(@PathVariable("name") String name) {
        switch (name) {
            case "cpu":
                List<CpuMetric> cpuMetricList = this.cpuMetricService.getByNameSomeMetrics(name);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetric> hddMetricList = this.hddMetricService.getByNameSomeMetrics(name);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetric> memoryMetricList = this.memoryMetricService.getByNameSomeMetrics(name);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetric> ssdMetricList = this.ssdMetricService.getByNameSomeMetrics(name);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetric> taskMetricList = this.taskMetricService.getByNameSomeMetrics(name);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}/{count}")
    public ResponseEntity getCurrentMetric(@PathVariable("name") String name, @PathVariable("count") int size) {
        switch (name) {
            case "cpu":
                List<CpuMetric> cpuMetricList = this.cpuMetricService.getByNameSomeMetrics(name, size);
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetric> hddMetricList = this.hddMetricService.getByNameSomeMetrics(name, size);
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetric> memoryMetricList = this.memoryMetricService.getByNameSomeMetrics(name, size);
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetric> ssdMetricList = this.ssdMetricService.getByNameSomeMetrics(name, size);
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetric> taskMetricList = this.taskMetricService.getByNameSomeMetrics(name, size);
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
            case "all":
                List<BaseMetric> metricList = new ArrayList<>();
                List<CpuMetric> cpuList = this.cpuMetricService.getByNameSomeMetrics("cpu", size);
                List<HddMetric> hddList = this.hddMetricService.getByNameSomeMetrics("hdd", size);
                List<MemoryMetric> memoryList = this.memoryMetricService.getByNameSomeMetrics("memory", size);
                List<SsdMetric> ssdList = this.ssdMetricService.getByNameSomeMetrics("ssd", size);
                List<TaskMetric> taskList = this.taskMetricService.getByNameSomeMetrics("taskCount", size);
                metricList.addAll(cpuList);
                metricList.addAll(hddList);
                metricList.addAll(memoryList);
                metricList.addAll(ssdList);
                metricList.addAll(taskList);
                if (metricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(metricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/{name}/all")
    public ResponseEntity getAllCurrentMetric(@PathVariable("name") String name) {
        switch (name) {
            case "cpu":
                List<CpuMetric> cpuMetricList = this.cpuMetricService.getAll();
                if (cpuMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(cpuMetricList, HttpStatus.OK);
            case "hdd":
                List<HddMetric> hddMetricList = this.hddMetricService.getAll();
                if (hddMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(hddMetricList, HttpStatus.OK);
            case "memory":
                List<MemoryMetric> memoryMetricList = this.memoryMetricService.getAll();
                if (memoryMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(memoryMetricList, HttpStatus.OK);
            case "ssd":
                List<SsdMetric> ssdMetricList = this.ssdMetricService.getAll();
                if (ssdMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(ssdMetricList, HttpStatus.OK);
            case "taskCount":
                List<TaskMetric> taskMetricList = this.taskMetricService.getAll();
                if (taskMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(taskMetricList, HttpStatus.OK);
            case "all":
                List<BaseMetric> allMetricList = new ArrayList<>();
                List<CpuMetric> cpuAllMetricList = this.cpuMetricService.getAll();
                List<HddMetric> hddAllMetricList = this.hddMetricService.getAll();
                List<MemoryMetric> memoryAllMetricList = this.memoryMetricService.getAll();
                List<SsdMetric> ssdAllMetricList = this.ssdMetricService.getAll();
                List<TaskMetric> taskAllMetricList = this.taskMetricService.getAll();
                allMetricList.addAll(cpuAllMetricList);
                allMetricList.addAll(hddAllMetricList);
                allMetricList.addAll(memoryAllMetricList);
                allMetricList.addAll(ssdAllMetricList);
                allMetricList.addAll(taskAllMetricList);
                if (allMetricList.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(allMetricList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMetrics(@RequestBody List<WrapperMetrics> metrics) {
        for (WrapperMetrics m : metrics) {
            if (m.getAttributeId().getName().equals("cpu")) {
                CpuMetric cpu = new CpuMetric(m.getParam(), m.getAttributeId());
                cpuMetricService.save(cpu);
            }
            if (m.getAttributeId().getName().equals("hdd")) {
                HddMetric hdd = new HddMetric(m.getParam(), m.getAttributeId());
                hddMetricService.save(hdd);
            }
            if (m.getAttributeId().getName().equals("memory")) {
                MemoryMetric memory = new MemoryMetric(m.getParam(), m.getAttributeId());
                memoryMetricService.save(memory);
            }
            if (m.getAttributeId().getName().equals("ssd")) {
                SsdMetric ssd = new SsdMetric(m.getParam(), m.getAttributeId());
                ssdMetricService.save(ssd);
            }
            if (m.getAttributeId().getName().equals("taskCount")) {
                TaskMetric task = new TaskMetric(m.getAttributeId());
                taskMetricService.save(task);
            }
        }

    }
}






