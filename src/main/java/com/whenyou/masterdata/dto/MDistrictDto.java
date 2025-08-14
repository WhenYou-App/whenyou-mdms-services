package com.whenyou.masterdata.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MDistrictDto {
    private Long id;
    private String name;
    private String nameInLocal;
    private boolean status;
}
