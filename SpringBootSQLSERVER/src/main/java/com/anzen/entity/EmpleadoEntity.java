package com.anzen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;



@Entity
@Table(name = "empleado")
	@NamedNativeQuery(name="testStore",
	query="Exec TableEmpleado :param1",resultClass=EmpleadoEntity.class) 



public class EmpleadoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;

	public EmpleadoEntity(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	protected EmpleadoEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public EmpleadoEntity copyFrom(EmpleadoEntity user) {
		EmpleadoEntity empleadoEntity = new EmpleadoEntity();

		empleadoEntity.id = user.id;
		empleadoEntity.nombre = user.nombre;
		empleadoEntity.apellido = user.apellido;
		return empleadoEntity;
	}

}
