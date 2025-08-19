package in.com.whenyou.masterdata.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MBoutiqueWearBrandDto {
    private UUID id;
    private Long excelId;
    private String brandName;
    private String category;
    private String attireType;
    private boolean status;
}
