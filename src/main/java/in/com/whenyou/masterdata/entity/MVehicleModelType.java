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
@Table(name = "m_vehicle_model_types")
public class MVehicleModelType {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long modelTypeId;

    @Column
    private String modelTypeName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
