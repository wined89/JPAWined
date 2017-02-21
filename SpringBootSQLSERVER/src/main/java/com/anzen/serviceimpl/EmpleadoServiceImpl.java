package com.anzen.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anzen.entity.EmpleadoEntity;
import com.anzen.repository.EmpleadoRepository;
import com.anzen.service.EmpleadoService;
@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{
	@Autowired
	EntityManager entityManager;
	@Autowired
	EmpleadoRepository empleadorepository;
	
	public List<EmpleadoEntity> findAll(){
		return empleadorepository.findAll();
	}

	@Override
	public EmpleadoEntity save(EmpleadoEntity empleadoEntity) {		
		return empleadorepository.save(empleadoEntity);
	}

	@Override
	public EmpleadoEntity findById(long userId) {
		
		return empleadorepository.findOne((int) userId);
	}

	@Override
	public EmpleadoEntity update(EmpleadoEntity copyFrom) {
		
		return empleadorepository.save(copyFrom);
	}

	@Override
	public void delete(long userId) {
		empleadorepository.delete((int) userId);
		
	}
	@Override
	public void updateManaulmente(EmpleadoEntity empleadoEntity) {
		
		empleadorepository.updateManualmente(empleadoEntity.getApellido(),empleadoEntity.getNombre());
		
	}
	@Override
	public List<EmpleadoEntity> storeTestIn(Integer idEmpleado) {
		Query query= entityManager.createNamedQuery("testStore");
		query.setParameter("param1", idEmpleado);
		return query.getResultList();
		 
	}

	
	
	
	
}
