package com.fatesg.meutransporteapi.entities;

import com.fatesg.meutransporteapi.utils.enums.Estados;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "tb_city")
//@SequenceGenerator(name = "city_seq", sequenceName = "city_seq", initialValue = 1, allocationSize = 1)
public class City {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
//    @Column(name = "id")
    private Long idCity;
    
    private String description;
    
    private Estados estado;
    
}
