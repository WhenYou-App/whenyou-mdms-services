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
@Table(name = "m_textile_wears")
public class MTextileWear {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long textileWearId;

    @Column
    private Long categoryId;

    @Column
    private String typeOfWear;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
