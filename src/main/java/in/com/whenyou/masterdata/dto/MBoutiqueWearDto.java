package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MBoutiqueWearDto {
    private UUID id;
    private Long boutiqueWearId;
    private Long categoryId;
    private String typeOfWear;
    private String nameInLocal;
    private boolean status;
}
