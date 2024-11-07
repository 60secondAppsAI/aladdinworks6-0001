package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.CoolingUnit;





public interface CoolingUnitDAO extends GenericDAO<CoolingUnit, Integer> {
  
	List<CoolingUnit> findAll();
	






}


