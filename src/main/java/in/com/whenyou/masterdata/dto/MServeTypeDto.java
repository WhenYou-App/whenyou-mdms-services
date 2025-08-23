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
    private Long serveTypeId;
    private String serveType;
    private String nameInLocal;
    private boolean status;
}
