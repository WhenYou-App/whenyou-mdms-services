package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MJewelMaterialPurityDto {
    private UUID id;
    private Long jewelMaterialPurityId;
    private Long jewelMaterialId;
    private String materialPurity;
    private boolean status;
}
