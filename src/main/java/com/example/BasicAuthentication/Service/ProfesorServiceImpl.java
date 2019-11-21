package com.example.BasicAuthentication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BasicAuthentication.Dao.IProfesorDao;
import com.example.BasicAuthentication.entity.Profesor;

@Service("profesorService")
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	IProfesorDao profesorDao;
	
	@Override
	public List<Profesor> findAllProfesor() {
		return (List<Profesor>) profesorDao.findAll();
	}

}
