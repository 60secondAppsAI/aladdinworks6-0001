package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Sensor;





public interface SensorDAO extends GenericDAO<Sensor, Integer> {
  
	List<Sensor> findAll();
	






}


