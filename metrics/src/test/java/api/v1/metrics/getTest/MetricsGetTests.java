package api.v1.metrics.getTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class MetricsGetTests {
    /**
     * Класс для тестирования запроса http://localhost:8080/api/v1/metrics/get/{name}/{count}
     * При выполнении данных тестов мы должны получить последние N (N- число указанное в параметре  {count} запроса)
     * самых свежих метрик указанного типа (тип - имя метрики указанное в параметре {name} запроса)
     * Перед выполнением тестов необходимо проверить, что
     * в базе данных количество записей для каждого типа метрик больше количества запрашиваемых
     */
    int count = 2; // число запрашиваемых метрик
    @Test
    public void contextLoads() {
    }
    /**
     * Тесты для проверки возвращаемых кодов ошибок при невалидном запросе
     */
    @Test
    public void testValidateParamOneSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }

    @Test
    public void testValidateParamTwoSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }

    @Test
    public void testValidateParamThreeSuccess() throws URISyntaxException {
        String metric_name = "foo"; // имя несуществующей метрики
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/" + metric_name;
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }

    @Test
    public void testValidateParamFourSuccess() throws URISyntaxException {
        String metric_name = "foo"; // имя несуществующей метрики
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/" + metric_name + "/";
        URI uri = new URI(baseUrl);
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(400, ex.getRawStatusCode());
        }
    }
    /**
     * По умолчанию мы должны получить последние 3 самые свежие метрики указанного типа
     * Перед выполнением тестов необходимо проверить что в базе данных есть как минимум по 3 записи для каждого типа метрик
     */
    @Test
    public void testGetCpuDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/cpu/";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"cpu\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetHddDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/hdd";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"hdd\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetMemoryDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/memory";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"memory\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetSsdDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/ssd";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"ssd\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetTaskDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/taskCount";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int count = 0;
        for (String l : list) {
            if (!(l.contains("\"name\":\"taskCount\""))) {
                break;
            }
            count++;
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == 3);
    }

    @Test
    public void testGetAllDefaultListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/all";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int cpuCount = 0;
        int hddCount = 0;
        int memoryCount = 0;
        int ssdCount = 0;
        int taskCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"cpu\"")) {
                cpuCount++;
            }
            if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            }
            if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            }
            if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            }
            if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == 3);
        Assert.assertEquals(true, hddCount == 3);
        Assert.assertEquals(true, ssdCount == 3);
        Assert.assertEquals(true, memoryCount == 3);
        Assert.assertEquals(true, taskCount == 3);
    }

    @Test
    public void testGetCpuCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/cpu/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int cpuCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"cpu\"")) {
                cpuCount++;
            } else {
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == count);
    }

    @Test
    public void testGetHddCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/hdd/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int hddCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            } else {
                break;
            }
        }
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == hddCount);
    }

    @Test
    public void testGetMemoryCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/memory/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int memoryCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == memoryCount);
    }

    @Test
    public void testGetSsdCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/ssd/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int ssdCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == ssdCount);
    }

    @Test
    public void testGetTaskCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/taskCount/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int taskCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, count == taskCount);
    }

    @Test
    public void testGetAllCountListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/api/v1/metrics/get/all/" + count;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String[] list = result.getBody().split("},");
        int cpuCount = 0;
        int hddCount = 0;
        int memoryCount = 0;
        int ssdCount = 0;
        int taskCount = 0;
        for (String l : list) {
            if (l.contains("\"name\":\"cpu\"")) {
                cpuCount++;
            } else if (l.contains("\"name\":\"hdd\"")) {
                hddCount++;
            } else if (l.contains("\"name\":\"memory\"")) {
                memoryCount++;
            } else if (l.contains("\"name\":\"ssd\"")) {
                ssdCount++;
            } else if (l.contains("\"name\":\"taskCount\"")) {
                taskCount++;
            } else {
                break;
            }
        }
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, cpuCount == count);
        Assert.assertEquals(true, hddCount == count);
        Assert.assertEquals(true, ssdCount == count);
        Assert.assertEquals(true, memoryCount == count);
        Assert.assertEquals(true, taskCount == count);
    }
    /**
     * Тесты для проверки GET запроса для получения списка всех метрик соответсвующего типа и списка всех метрик.
     * Перед выполнением теста необходимо чтобы в базе данных содержалась хотя бы 1 запись для каждого типа метрик.
     */
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
