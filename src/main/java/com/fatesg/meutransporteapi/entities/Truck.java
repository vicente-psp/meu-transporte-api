package com.fatesg.meutransporteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_truck")
@SequenceGenerator(name = "truck_seq", sequenceName = "truck_seq", initialValue = 1, allocationSize = 1)
public class Truck extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "truck_seq")
    @Column(name = "id")
    private Long idTruck;

    @NotBlank(message = "Modelo é obrigatório")
    @Size(min = 3, message = "Modelo deve ter no mínimo 3 caracteres")
    @Column(length = 75, nullable = false)
    private String model;

    @NotBlank(message = "Fabricante é obrigatório")
    @Size(min = 3, message = "Fabricante deve ter no mínimo 3 caracteres")
    @Column(length = 75, nullable = false)
    private String manufacturer;

    @Column(name = "year_manufacturing", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date yearManufacturing;

    @NotBlank(message = "Placa é obrigatório")
    @Size(min = 6, message = "placa deve ter no mínimo 6 caracteres")
    @Column(length = 75, nullable = false)
    private String board;

    @OneToOne(mappedBy = "driver")
    private Driver driver;


}
