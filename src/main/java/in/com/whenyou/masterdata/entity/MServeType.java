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
@Table(name = "m_serve_types")
public class MServeType {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long serveTypeId;

    @Column
    private String serveType;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
