package com.fatesg.meutransporteapi.entities;


import lombok.*;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_route")
@SequenceGenerator(name = "route_seq", sequenceName = "route_seq", initialValue = 1, allocationSize = 1)
public class Route extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	@Column(name = "id")
	private Long idRoute;

	@ManyToOne
	private Truck idTruck;

	@OneToMany
	private List<Order> orders;

	@ManyToOne
	private Driver idDriver;

	@Column(name = "initial_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date initialDate;

	@Column(name = "final_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalDate;
}
 
