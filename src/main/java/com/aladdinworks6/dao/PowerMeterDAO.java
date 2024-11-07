package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.PowerMeter;





public interface PowerMeterDAO extends GenericDAO<PowerMeter, Integer> {
  
	List<PowerMeter> findAll();
	






}


