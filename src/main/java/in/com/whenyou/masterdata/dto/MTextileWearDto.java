package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MTextileWearDto {
    private UUID id;
    private Long textileWearId;
    private Long categoryId;
    private String typeOfWear;
    private String nameInLocal;
    private boolean status;
}
