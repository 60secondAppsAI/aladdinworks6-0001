package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.Maintenance;
import com.aladdinworks6.dto.MaintenanceDTO;
import com.aladdinworks6.dto.MaintenanceSearchDTO;
import com.aladdinworks6.dto.MaintenancePageDTO;
import com.aladdinworks6.dto.MaintenanceConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MaintenanceService extends GenericService<Maintenance, Integer> {

	List<Maintenance> findAll();

	ResultDTO addMaintenance(MaintenanceDTO maintenanceDTO, RequestDTO requestDTO);

	ResultDTO updateMaintenance(MaintenanceDTO maintenanceDTO, RequestDTO requestDTO);

    Page<Maintenance> getAllMaintenances(Pageable pageable);

    Page<Maintenance> getAllMaintenances(Specification<Maintenance> spec, Pageable pageable);

	ResponseEntity<MaintenancePageDTO> getMaintenances(MaintenanceSearchDTO maintenanceSearchDTO);
	
	List<MaintenanceDTO> convertMaintenancesToMaintenanceDTOs(List<Maintenance> maintenances, MaintenanceConvertCriteriaDTO convertCriteria);

	MaintenanceDTO getMaintenanceDTOById(Integer maintenanceId);







}





