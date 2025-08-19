package com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MBoutiqueWearDto {
    private UUID id;
    private Long excelId;
    private String typeOfWear;
    private String category;
    private String attireType;
    private boolean status;
}
