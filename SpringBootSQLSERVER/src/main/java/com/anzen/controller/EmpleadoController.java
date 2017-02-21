package com.anzen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.anzen.entity.EmpleadoEntity;
import com.anzen.service.EmpleadoService;

@RestController
@RequestMapping("/Empleado")
public class EmpleadoController {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	@Autowired
	EmpleadoService empleadoService;

	@RequestMapping(value = "/Consulta")
	List<EmpleadoEntity> index() {
		// List<EmpleadoEntity> list= new ArrayList<EmpleadoEntity>();
		/* list= */
		return /* list */empleadoService.findAll();
	}

	@RequestMapping(value = "/Guradar")
	List<EmpleadoEntity> ingresaDatosEmpleado() {
		// List<EmpleadoEntity> list= new ArrayList<EmpleadoEntity>();
		/* list= */

		return /* list */empleadoService.findAll();
	}

	@RequestMapping(value = "/usuario/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView pathVariables(@PathVariable EmpleadoEntity empleadoEntity) {

		empleadoService.save(empleadoEntity);
		return new ModelAndView("contenido", "metodo", "pathVariables");
	}

	@RequestMapping(value="/GetAll",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmpleadoEntity> getAllUsers() {
		return empleadoService.findAll();
	}
	
	
	
	
	@RequestMapping(value="/GetAll/{idEmpleado}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmpleadoEntity> storeInProcedure(@PathVariable("idEmpleado") Integer idEmpleado) {
		System.out.println(idEmpleado);
		return empleadoService.storeTestIn(idEmpleado);
	}
	
	
	

	@RequestMapping(value = "BuscarPoId/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpleadoEntity> getUser(@PathVariable long userId) {
		EmpleadoEntity user = empleadoService.findById(userId);
		ResponseEntity<EmpleadoEntity> response;
		if (user == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(user, HttpStatus.OK);
		}
		return response;
	}
	
	 @RequestMapping(value="/SavePost",method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public void insertUser(@RequestBody EmpleadoEntity user) {
		 empleadoService.save(user);
	    }
	 
	 
	 @RequestMapping(value = "UpDate/{userId}", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void updateUser(@PathVariable long userId, @RequestBody EmpleadoEntity user) {
	        EmpleadoEntity userOld = empleadoService.findById(userId);
	        if (userOld != null) {
	            empleadoService.update(userOld.copyFrom(user));
	        }
	    }
	 @RequestMapping(value = "Delete/{userId}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteUser(@PathVariable long userId) {
	        empleadoService.delete(userId);
	    }
	 @RequestMapping(value = "updateManual/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<EmpleadoEntity> updateManualmente(@PathVariable long id,@RequestBody EmpleadoEntity empleadoEntity) {
			EmpleadoEntity user = empleadoService.findById(id);
			ResponseEntity<EmpleadoEntity> response;
			if (user == null) {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				empleadoService.updateManaulmente(empleadoEntity);
				response = new ResponseEntity<>(user, HttpStatus.OK);
			}
			return response;
		}
	 

	@RequestMapping("/libre")
	String indexx() {
		return "Edwin";

	}

}