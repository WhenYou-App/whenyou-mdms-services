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
@Table(name = "m_food_categories")
public class MFoodCategory {
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
