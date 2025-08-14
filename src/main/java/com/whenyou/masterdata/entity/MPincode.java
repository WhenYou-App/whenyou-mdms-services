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
@Table(name = "m_pincode")
public class MPincode extends Auditor {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private Long excelId;

    @Column
    private String name;

    @Column
    private String nameInLocal;

    @Column
    private String pincode;

    @Column
    private boolean status;
}
