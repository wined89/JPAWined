package com.anzen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anzen.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
	
	public List<EmpleadoEntity> findByNombre(String nombre);

	@Query("update EmpleadoEntity emp set emp.apellido = ?1 where emp.nombre = ?2")
	int updateManualmente(String apellido, String nombre);
	


		
	 
	 
			

	
	
	

}
