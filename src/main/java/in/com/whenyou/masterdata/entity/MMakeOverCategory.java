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
@Table(name = "m_make_over_categories")
public class MMakeOverCategory {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long categoryId;

    @Column
    private String categoryName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
