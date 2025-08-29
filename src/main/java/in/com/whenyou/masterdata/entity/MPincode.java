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
@Table(name = "m_pincodes")
public class MPincode {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long pincodeId;

    @Column
    private Long districtId;

    @Column
    private String name;

    @Column
    private String nameInLocal;

    @Column
    private String pincode;

    @Column
    private boolean status;
}
