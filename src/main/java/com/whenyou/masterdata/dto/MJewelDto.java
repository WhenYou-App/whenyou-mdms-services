package com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MJewelDto {
    private UUID id;
    private Long excelId;
    private String productType;
    private boolean status;
}
