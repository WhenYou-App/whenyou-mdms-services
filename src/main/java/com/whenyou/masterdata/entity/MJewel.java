package com.whenyou.masterdata.entity;

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
@Table(name = "m_districts")
public class MJewel extends Auditor {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long excelId;

    @Column
    private String productType;

    @Column
    private String material;

    @Column
    private String purity;

    @Column
    private boolean status;
}
