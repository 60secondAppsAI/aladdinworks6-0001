package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Generator;





public interface GeneratorDAO extends GenericDAO<Generator, Integer> {
  
	List<Generator> findAll();
	






}


