package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.Incident;
import com.aladdinworks6.dto.IncidentDTO;
import com.aladdinworks6.dto.IncidentSearchDTO;
import com.aladdinworks6.dto.IncidentPageDTO;
import com.aladdinworks6.dto.IncidentConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface IncidentService extends GenericService<Incident, Integer> {

	List<Incident> findAll();

	ResultDTO addIncident(IncidentDTO incidentDTO, RequestDTO requestDTO);

	ResultDTO updateIncident(IncidentDTO incidentDTO, RequestDTO requestDTO);

    Page<Incident> getAllIncidents(Pageable pageable);

    Page<Incident> getAllIncidents(Specification<Incident> spec, Pageable pageable);

	ResponseEntity<IncidentPageDTO> getIncidents(IncidentSearchDTO incidentSearchDTO);
	
	List<IncidentDTO> convertIncidentsToIncidentDTOs(List<Incident> incidents, IncidentConvertCriteriaDTO convertCriteria);

	IncidentDTO getIncidentDTOById(Integer incidentId);







}





