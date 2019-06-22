package com.fatesg.meutransporteapi.interfaces;

import java.util.List;

public interface GenericOperations<E> {

	E save(E entity) throws Exception;
	E findById(Long id) throws Exception;
	void update(E entity) throws Exception;
	void delete(Long id) throws Exception;
	void patch(E entity) throws Exception;

	List<E> save(List<E> entities) throws Exception;
	List<E> findAll() throws Exception;
	void update(List<E> entities) throws Exception;
	void delete(List<Long> id) throws Exception;
	void patch(List<E> entities) throws Exception;

}
