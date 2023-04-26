package com.example.client.util;

import com.example.client.dto.MeasureDTO;
import com.example.client.dto.SensorDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class ThousandRandomRequest {
    private List<MeasureDTO> measures;
    private static final int max = 100;
    private static final int min = -100;
    public ThousandRandomRequest(String sensorName) {
        this.measures = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<500;i++) {
            MeasureDTO measure = new MeasureDTO();
            measure.setValue(random.nextDouble(max));
            measure.setRaining(random.nextBoolean());
            measure.setSensor(new SensorDTO(sensorName));
            measures.add(measure);
        }
    }

}
