package com.example.client.api;

import com.example.client.dto.MeasureDTO;
import com.example.client.util.ThousandRandomRequest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        ClientAPI api = new ClientAPI();
        String sensorName = "TestSensor2";
        try {
            api.register(sensorName);
            ThousandRandomRequest requests = new ThousandRandomRequest(sensorName);
            requests.getMeasures().forEach(api::addMeasure);
        }
        catch (HttpClientErrorException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }

        List<MeasureDTO> measures = api.get().getMeasurements();
        measures.forEach(measureDTO -> {
            System.out.println("Value: " + measureDTO.getValue());
            System.out.println("Raining: " + measureDTO.isRaining());
            System.out.println("Sensor: " + measureDTO.getSensor().getName());
            System.out.println();
        });

        HashMap<String, Long> rainyDaysCount = api.getRainyDaysCount();
        System.out.println(rainyDaysCount);
    }
}
