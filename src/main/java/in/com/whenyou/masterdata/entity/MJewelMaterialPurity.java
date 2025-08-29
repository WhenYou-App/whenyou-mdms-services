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
@Table(name = "m_jewel_material_purities")
public class MJewelMaterialPurity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long jewelMaterialPurityId;

    @Column
    private Long jewelMaterialId;

    @Column
    private String materialPurity;

    @Column
    private boolean status;
}
