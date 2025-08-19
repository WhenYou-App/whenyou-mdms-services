package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MMakeOverDto {
    private UUID id;
    private Long excelId;
    private String packageName;
    private String category;
    private boolean status;
}
