package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.NetworkSwitch;





public interface NetworkSwitchDAO extends GenericDAO<NetworkSwitch, Integer> {
  
	List<NetworkSwitch> findAll();
	






}


