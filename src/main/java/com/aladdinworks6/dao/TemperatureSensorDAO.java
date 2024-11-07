package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.TemperatureSensor;





public interface TemperatureSensorDAO extends GenericDAO<TemperatureSensor, Integer> {
  
	List<TemperatureSensor> findAll();
	






}


