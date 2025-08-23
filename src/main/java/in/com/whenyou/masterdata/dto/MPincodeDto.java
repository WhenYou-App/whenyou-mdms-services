package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MPincodeDto {
    private UUID id;
    private Long pincodeId;
    private Long districtId;
    private String name;
    private String nameInLocal;
    private String pincode;
    private boolean status;
}
