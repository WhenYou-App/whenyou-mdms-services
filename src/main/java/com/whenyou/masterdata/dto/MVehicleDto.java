package com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MVehicleDto {
    private UUID id;
    private Long excelId;
    private String brandName;
    private String modelType;
    private String modelName;
    private boolean status;
}
