package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.Alert;
import com.aladdinworks6.dto.AlertDTO;
import com.aladdinworks6.dto.AlertSearchDTO;
import com.aladdinworks6.dto.AlertPageDTO;
import com.aladdinworks6.dto.AlertConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AlertService extends GenericService<Alert, Integer> {

	List<Alert> findAll();

	ResultDTO addAlert(AlertDTO alertDTO, RequestDTO requestDTO);

	ResultDTO updateAlert(AlertDTO alertDTO, RequestDTO requestDTO);

    Page<Alert> getAllAlerts(Pageable pageable);

    Page<Alert> getAllAlerts(Specification<Alert> spec, Pageable pageable);

	ResponseEntity<AlertPageDTO> getAlerts(AlertSearchDTO alertSearchDTO);
	
	List<AlertDTO> convertAlertsToAlertDTOs(List<Alert> alerts, AlertConvertCriteriaDTO convertCriteria);

	AlertDTO getAlertDTOById(Integer alertId);







}





