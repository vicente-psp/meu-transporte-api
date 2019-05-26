package com.fatesg.meutransporteapi.entities;

import com.fatesg.meutransporteapi.utils.CnhCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "tb_driver")
@SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq", initialValue = 1, allocationSize = 1)
public class Driver extends People {

    @Column(length = 20, nullable = false)
    private String cnh;

    @Enumerated(EnumType.STRING)
    @Column(name = "cnh_category", nullable = false)
    private CnhCategory cnhCategry;

    @Column(name = "first_date_cnh", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstDateCnh;

    @Column(name = "validity_of_cnh", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date validityOfCnh;

    @Column(name = "initial_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;

    @Column(name = "final_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;

    @Column(name = "date_of_birth", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

}
