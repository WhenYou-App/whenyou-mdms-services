package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MDistrictDto {
    private UUID id;
    private Long districtId;
    private String name;
    private String nameInLocal;
    private boolean status;
}
