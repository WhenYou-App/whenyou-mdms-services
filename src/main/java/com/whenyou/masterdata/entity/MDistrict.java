package com.whenyou.masterdata.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_districts")
public class MDistrict extends Auditor {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String nameInLocal;

    @Column
    private boolean status;
}
