package in.com.whenyou.masterdata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_vehicle_model_names")
public class MVehicleModelName {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long modelNameId;

    @Column
    private Long modelTypeId;

    @Column
    private Long brandId;

    @Column
    private String modelName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
