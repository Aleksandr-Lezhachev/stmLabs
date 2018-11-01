package api.v1.metrics.postTest;

import api.v1.metrics.entity.*;
import api.v1.metrics.entity.enums.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 * Тест для тестирования Post запроса сохранения набора метрик
 * Успешное выполнение теста вернет код 201 и добавит в каждую из таблиц по одной новой записи соответсвующей метрики
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsPostTest {

   @Test
    public void testAddPackageMetrics() throws URISyntaxException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/post";
        URI uri = new URI(baseUrl);
        BaseMetric cpuBaseMetric = new BaseMetric("cpu", "Intel core i9 Extreme", 100.0, Status.OVERLOADED.getStatus(),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        CpuMetric cpuMetric = new CpuMetric(cpuBaseMetric);

        BaseMetric hddBaseMetric = new BaseMetric("hdd", "TOSHIBA MQ 01ABF050", 100.0, Status.OVERLOADED.getStatus(),
               new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        HddMetric hddMetric = new HddMetric(hddBaseMetric);

       BaseMetric memoryBaseMetric = new BaseMetric("memory", "Slot1: SO-DIMM DDR3L 1600 MHz 4GiB", 100.0, Status.OVERLOADED.getStatus(),
               new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
       MemoryMetric memoryMetric = new MemoryMetric(memoryBaseMetric);

       BaseMetric ssdBaseMetric = new BaseMetric("ssd", "KINGSTON MLG1267", 100.0, Status.OVERLOADED.getStatus(),
               new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
       SsdMetric ssdMetric = new SsdMetric(ssdBaseMetric);

       BaseMetric taskBaseMetric = new BaseMetric("taskCount", "", 100.0, Status.OVERLOADED.getStatus(),
               new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
       TaskMetric taskMetric = new TaskMetric(taskBaseMetric);

        List<BaseMetric> metrics = new ArrayList<>();
        metrics.add(cpuMetric);
       metrics.add(hddMetric);
        metrics.add(memoryMetric);
        metrics.add(ssdMetric);
        metrics.add(taskMetric);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        json = ow.writeValueAsString(metrics);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, request, String.class);

        Assert.assertEquals(201, response.getStatusCodeValue());
    }

}

