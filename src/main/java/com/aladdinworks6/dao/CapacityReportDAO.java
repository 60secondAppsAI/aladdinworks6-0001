package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.CapacityReport;





public interface CapacityReportDAO extends GenericDAO<CapacityReport, Integer> {
  
	List<CapacityReport> findAll();
	






}


