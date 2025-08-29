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
    private Long jewelMaterialId;
    private String materialName;
    private String nameInLocal;
    private boolean status;
}
