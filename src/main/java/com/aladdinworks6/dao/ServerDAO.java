package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Server;





public interface ServerDAO extends GenericDAO<Server, Integer> {
  
	List<Server> findAll();
	






}


