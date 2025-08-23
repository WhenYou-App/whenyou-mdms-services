package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MTextileWearBrandDto {
    private UUID id;
    private Long textileWearBrandId;
    private Long categoryId;
    private String brandName;
    private String nameInLocal;
    private boolean status;
}
