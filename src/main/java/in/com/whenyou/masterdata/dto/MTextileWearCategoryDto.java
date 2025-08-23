package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MTextileWearCategoryDto {
    private UUID id;
    private Long categoryId;
    private String categoryName;
    private String nameInLocal;
    private boolean status;
}
