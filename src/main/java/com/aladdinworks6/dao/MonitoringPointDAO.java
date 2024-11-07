package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.MonitoringPoint;





public interface MonitoringPointDAO extends GenericDAO<MonitoringPoint, Integer> {
  
	List<MonitoringPoint> findAll();
	






}


