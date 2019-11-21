package com.example.BasicAuthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BasicAuthentication.Service.IProfesorService;
import com.example.BasicAuthentication.entity.Profesor;

@RestController
@RequestMapping(value = "/api")
public class ProfesorController {

	@Autowired
	IProfesorService service;
	
	
	@RequestMapping(value = "/todos_profesores", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> getProfesores()
	{
		List<Profesor> profesores =service.findAllProfesor();
		if(profesores.isEmpty())
			return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Profesor>>(profesores,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/todos_profesores_admin", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> getProfesoresAdmin()
	{
		List<Profesor> profesores =service.findAllProfesor();
		if(profesores.isEmpty() )
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Profesor>>(profesores,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/todos_profesores_user", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> getProfesoresUser()
	{
		List<Profesor> profesores =service.findAllProfesor();
		if(profesores.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Profesor>>(profesores,HttpStatus.OK);
	}
	
	
}
