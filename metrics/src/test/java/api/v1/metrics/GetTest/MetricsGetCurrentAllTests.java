package api.v1.metrics.GetTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
/**
 * Тесты для проверки GET запроса для получения списка всех метрик соответсвующего типа и списка всех метрик.
 * Перед выполнением теста необходимо чтобы в базе данных содержалась хотя бы 1 запись для каждого типа метрик.
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsGetCurrentAllTests {
    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetCpuAllListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/cpu/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        boolean flag = true;
        for (String l : list) {
            if (!(l.contains("\"name\":\"cpu\""))) {
                flag = false;
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testGetHddAllListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/hdd/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        boolean flag = true;
        for (String l : list) {
            if (!(l.contains("\"name\":\"hdd\""))) {
                flag = false;
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testGetMemoryAllListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/memory/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        boolean flag = true;
        for (String l : list) {
            if (!(l.contains("\"name\":\"memory\""))) {
                flag = false;
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testGetSsdAllListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/ssd/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        boolean flag = true;
        for (String l : list) {
            if (!(l.contains("\"name\":\"ssd\""))) {
                flag = false;
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, flag);
    }

    @Test
    public void testGetTaskAllListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/taskCount/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        boolean flag = true;
        for (String l : list) {
            if (!(l.contains("\"name\":\"taskCount\""))) {
                flag = false;
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, flag);
    }

}
