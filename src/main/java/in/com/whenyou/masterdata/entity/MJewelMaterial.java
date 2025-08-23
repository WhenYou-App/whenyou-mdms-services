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
@Table(name = "m_jewel_materials")
public class MJewelMaterial {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long jewelMaterialId;

    @Column
    private String materialName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
