package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Incident;





public interface IncidentDAO extends GenericDAO<Incident, Integer> {
  
	List<Incident> findAll();
	






}


