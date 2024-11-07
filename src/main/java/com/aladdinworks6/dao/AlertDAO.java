package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Alert;





public interface AlertDAO extends GenericDAO<Alert, Integer> {
  
	List<Alert> findAll();
	






}


