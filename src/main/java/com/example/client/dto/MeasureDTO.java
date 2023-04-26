package com.example.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasureDTO {
    private double value;
    private boolean raining;
    private SensorDTO sensor;
}
