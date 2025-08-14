package com.whenyou.masterdata.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MPincodeDto {
    private UUID id;
    private Long excelId;
    private String name;
    private String nameInLocal;
    private String pincode;
    private boolean status;
}
