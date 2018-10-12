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
        Attributes cpuAttributes = new Attributes("cpu", 100.0, Status.OVERLOADED.getStatus(),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        CpuMetric cpuMetric = new CpuMetric("Intel core i9 Extreme", cpuAttributes);

        Attributes hddAttributes = new Attributes("hdd", 84.4, Status.UP.getStatus(),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        HddMetric hddMetric = new HddMetric("Toshiba LT678904", hddAttributes);

        Attributes memoryAttributes = new Attributes("memory", 66, Status.NOT_RESPONDING.getStatus(),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        MemoryMetric memoryMetric = new MemoryMetric("Corsair 2600", memoryAttributes);

        Attributes ssdAttributes = new Attributes("ssd", 0, Status.DOWN.getStatus(),
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        SsdMetric ssdMetric = new SsdMetric("Samsung 4500", ssdAttributes);

        Attributes taskAttributes = new Attributes("taskCount", 10,
                new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        TaskMetric taskMetric = new TaskMetric(taskAttributes);

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

