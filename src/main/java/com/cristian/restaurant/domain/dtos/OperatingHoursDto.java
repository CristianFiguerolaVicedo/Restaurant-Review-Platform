package com.cristian.restaurant.domain.dtos;

import com.cristian.restaurant.domain.entities.TimeRange;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatingHoursDto {

    private TimeRangeDto monday;

    private TimeRangeDto tuesday;

    private TimeRangeDto wednesday;

    private TimeRangeDto thursday;

    private TimeRangeDto friday;

    private TimeRangeDto saturday;

    private TimeRangeDto sunday;
}
