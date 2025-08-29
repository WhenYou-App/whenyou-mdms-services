package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MVehicleBrandDto {
    private UUID id;
    private Long brandId;
    private String brandName;
    private String nameInLocal;
    private boolean status;
}
