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
@Table(name = "m_jewel_product_types")
public class MJewelProductType {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long jewelProductTypeId;

    @Column
    private String productTypeName;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
