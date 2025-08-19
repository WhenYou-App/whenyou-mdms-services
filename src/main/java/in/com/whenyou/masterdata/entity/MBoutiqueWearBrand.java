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
@Table(name = "m_boutique_wear_brands")
public class MBoutiqueWearBrand extends Auditor {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long excelId;

    @Column
    private String brandName;

    @Column
    private String category;

    @Column
    private String attireType;

    @Column
    private boolean status;
}
