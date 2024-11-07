package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Rack;





public interface RackDAO extends GenericDAO<Rack, Integer> {
  
	List<Rack> findAll();
	






}


