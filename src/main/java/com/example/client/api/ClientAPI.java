package com.example.client.api;

import com.example.client.dto.MeasureDTO;
import com.example.client.dto.MeasurementsResponse;
import com.example.client.dto.SensorDTO;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class ClientAPI extends RestTemplate {
    private static final String REGISTRATION_URL = "http://localhost:8080/sensors/registration";
    private static final String MEASUREMENTS_URL = "http://localhost:8080/measurements";
    private static final String ADD_MEASURE_URL = "http://localhost:8080/measurements/add";
    private static final String RAINY_DAYS_MEASUREMENTS_URL = "http://localhost:8080/measurements/rainyDaysCount";

    public void register(String name) {
        HttpEntity<SensorDTO> request = new HttpEntity<>(new SensorDTO(name));
        postForObject(REGISTRATION_URL, request, String.class);
    }
    public void addMeasure(MeasureDTO measureDTO) {
        HttpEntity<MeasureDTO> request = new HttpEntity<>(measureDTO);
        postForObject(ADD_MEASURE_URL, request, String.class);
    }
    public MeasurementsResponse get() {
        return getForObject(MEASUREMENTS_URL, MeasurementsResponse.class);
    }
    public HashMap<String,Long> getRainyDaysCount() {
        return getForObject(RAINY_DAYS_MEASUREMENTS_URL, HashMap.class);
    }
}
