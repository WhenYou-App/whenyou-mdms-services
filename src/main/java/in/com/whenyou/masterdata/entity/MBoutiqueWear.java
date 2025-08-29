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
@Table(name = "m_boutique_wears")
public class MBoutiqueWear {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long boutiqueWearId;

    @Column
    private Long categoryId;

    @Column
    private String typeOfWear;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
