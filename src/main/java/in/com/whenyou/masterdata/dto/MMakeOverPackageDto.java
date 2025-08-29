package in.com.whenyou.masterdata.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MMakeOverPackageDto {
    private UUID id;
    private Long packageId;
    private Long categoryId;
    private String packageName;
    private String nameInLocal;
    private boolean status;
}
