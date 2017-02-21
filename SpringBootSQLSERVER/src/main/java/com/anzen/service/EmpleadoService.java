package com.anzen.service;

import java.util.List;

import com.anzen.entity.EmpleadoEntity;

public interface EmpleadoService {
	public List<EmpleadoEntity> findAll();
	public 	EmpleadoEntity save(EmpleadoEntity empleadoEntity);
	public EmpleadoEntity findById(long userId);
	public EmpleadoEntity update(EmpleadoEntity copyFrom);
	public void delete(long userId);
	public void updateManaulmente(EmpleadoEntity empleadoEntity);
	public List<EmpleadoEntity> storeTestIn(Integer idEmpleado);
	

}
