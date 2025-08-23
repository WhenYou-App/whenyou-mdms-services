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
@Table(name = "m_vehicle_brands")
public class MVehicleBrand {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long brandId;

    @Column
    private String brandName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
