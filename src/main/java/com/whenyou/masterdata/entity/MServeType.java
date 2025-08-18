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
@Table(name = "m_serve_types")
public class MServeType extends Auditor {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long excelId;

    @Column
    private String serveType;

    @Column
    private boolean status;
}
