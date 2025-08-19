package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MServeTypeDto {
    private UUID id;
    private Long excelId;
    private String serveType;
    private boolean status;
}
