package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MJewelProductTypeDto {
    private UUID id;
    private Long jewelProductTypeId;
    private String productTypeName;
    private String nameInLocal;
    private boolean status;
}
