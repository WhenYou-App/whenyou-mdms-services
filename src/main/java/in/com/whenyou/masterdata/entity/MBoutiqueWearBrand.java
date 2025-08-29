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
public class MBoutiqueWearBrand {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long boutiqueWearBrandId;

    @Column
    private Long categoryId;

    @Column
    private String brandName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
