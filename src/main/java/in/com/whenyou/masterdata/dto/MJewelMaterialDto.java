package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MJewelMaterialDto {
    private UUID id;
    private Long excelId;
    private String material;
    private String purity;
    private boolean status;
}
