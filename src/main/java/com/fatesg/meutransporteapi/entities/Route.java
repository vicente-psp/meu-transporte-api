package com.fatesg.meutransporteapi.entities;


import javax.persistence.OneToMany;
import java.util.List;

public class Route {
 
	private long id;
	 
	private Truck idTruck;

	@OneToMany
	private List<Order> orders;
	 
	private Driver idDriver;
}
 
