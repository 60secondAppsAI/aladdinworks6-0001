package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Maintenance;





public interface MaintenanceDAO extends GenericDAO<Maintenance, Integer> {
  
	List<Maintenance> findAll();
	






}


