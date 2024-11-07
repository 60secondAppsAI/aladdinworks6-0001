package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.UserRole;





public interface UserRoleDAO extends GenericDAO<UserRole, Integer> {
  
	List<UserRole> findAll();
	






}


