package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MVehicleModelTypeDto {
    private UUID id;
    private Long modelTypeId;
    private String modelTypeName;
    private String nameInLocal;
    private boolean status;
}
