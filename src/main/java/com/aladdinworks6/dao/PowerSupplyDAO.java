package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.PowerSupply;





public interface PowerSupplyDAO extends GenericDAO<PowerSupply, Integer> {
  
	List<PowerSupply> findAll();
	






}


