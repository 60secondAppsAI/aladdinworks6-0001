package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.StaticTransferSwitch;
import com.aladdinworks6.dto.StaticTransferSwitchDTO;
import com.aladdinworks6.dto.StaticTransferSwitchSearchDTO;
import com.aladdinworks6.dto.StaticTransferSwitchPageDTO;
import com.aladdinworks6.dto.StaticTransferSwitchConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface StaticTransferSwitchService extends GenericService<StaticTransferSwitch, Integer> {

	List<StaticTransferSwitch> findAll();

	ResultDTO addStaticTransferSwitch(StaticTransferSwitchDTO staticTransferSwitchDTO, RequestDTO requestDTO);

	ResultDTO updateStaticTransferSwitch(StaticTransferSwitchDTO staticTransferSwitchDTO, RequestDTO requestDTO);

    Page<StaticTransferSwitch> getAllStaticTransferSwitchs(Pageable pageable);

    Page<StaticTransferSwitch> getAllStaticTransferSwitchs(Specification<StaticTransferSwitch> spec, Pageable pageable);

	ResponseEntity<StaticTransferSwitchPageDTO> getStaticTransferSwitchs(StaticTransferSwitchSearchDTO staticTransferSwitchSearchDTO);
	
	List<StaticTransferSwitchDTO> convertStaticTransferSwitchsToStaticTransferSwitchDTOs(List<StaticTransferSwitch> staticTransferSwitchs, StaticTransferSwitchConvertCriteriaDTO convertCriteria);

	StaticTransferSwitchDTO getStaticTransferSwitchDTOById(Integer staticTransferSwitchId);







}





