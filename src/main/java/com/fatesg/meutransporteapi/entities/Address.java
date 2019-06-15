package com.fatesg.meutransporteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "tb_address")
//@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
//    @Column(name = "id")
    private Long idAddress;

    private String logradouro;

    private City city;

}
