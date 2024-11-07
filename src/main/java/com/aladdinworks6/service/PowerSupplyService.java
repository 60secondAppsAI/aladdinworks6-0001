package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.PowerSupply;
import com.aladdinworks6.dto.PowerSupplyDTO;
import com.aladdinworks6.dto.PowerSupplySearchDTO;
import com.aladdinworks6.dto.PowerSupplyPageDTO;
import com.aladdinworks6.dto.PowerSupplyConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PowerSupplyService extends GenericService<PowerSupply, Integer> {

	List<PowerSupply> findAll();

	ResultDTO addPowerSupply(PowerSupplyDTO powerSupplyDTO, RequestDTO requestDTO);

	ResultDTO updatePowerSupply(PowerSupplyDTO powerSupplyDTO, RequestDTO requestDTO);

    Page<PowerSupply> getAllPowerSupplys(Pageable pageable);

    Page<PowerSupply> getAllPowerSupplys(Specification<PowerSupply> spec, Pageable pageable);

	ResponseEntity<PowerSupplyPageDTO> getPowerSupplys(PowerSupplySearchDTO powerSupplySearchDTO);
	
	List<PowerSupplyDTO> convertPowerSupplysToPowerSupplyDTOs(List<PowerSupply> powerSupplys, PowerSupplyConvertCriteriaDTO convertCriteria);

	PowerSupplyDTO getPowerSupplyDTOById(Integer powerSupplyId);







}





