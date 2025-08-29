package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MVehicleModelNameDto {
    private UUID id;
    private Long modelNameId;
    private Long modelTypeId;
    private Long brandId;
    private String modelName;
    private String nameInLocal;
    private boolean status;
}
