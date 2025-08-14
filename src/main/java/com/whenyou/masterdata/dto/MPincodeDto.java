package com.whenyou.masterdata.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MPincodeDto {
    private Long id;
    private String name;
    private String nameInLocal;
    private String pincode;
    private boolean status;
}
