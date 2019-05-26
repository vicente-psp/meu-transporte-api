package com.fatesg.meutransporteapi.interfaces;

import java.util.List;

public interface GenericOperations<E> {
	
	E save(E entity);
	E findById(Long id);
	void update(E entity);
	void delete(E entity);
	void patch(E entity);

	List<E> save(List<E> entities);
	List<E> findAll();
	void update(List<E> entities);
	void delete(List<E> entities);
	void patch(List<E> entities);

}
