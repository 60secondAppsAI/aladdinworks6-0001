package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.PowerStrip;





public interface PowerStripDAO extends GenericDAO<PowerStrip, Integer> {
  
	List<PowerStrip> findAll();
	






}


