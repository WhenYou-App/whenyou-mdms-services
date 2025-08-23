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
@Table(name = "m_make_over_packages")
public class MMakeOverPackage {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long packageId;

    @Column
    private Long categoryId;

    @Column
    private String packageName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
