package com.fatesg.meutransporteapi.entities;

import java.util.List;

public class Client extends People {
 
	private long id ;
	 
	private String cnpj;
	 
	private String socialName;
	 
	private List<Order> orders;
	 
	private Order idOrder;
	 
}
 
