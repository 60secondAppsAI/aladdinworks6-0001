package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.DataCenter;
import com.aladdinworks6.dto.DataCenterDTO;
import com.aladdinworks6.dto.DataCenterSearchDTO;
import com.aladdinworks6.dto.DataCenterPageDTO;
import com.aladdinworks6.dto.DataCenterConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface DataCenterService extends GenericService<DataCenter, Integer> {

	List<DataCenter> findAll();

	ResultDTO addDataCenter(DataCenterDTO dataCenterDTO, RequestDTO requestDTO);

	ResultDTO updateDataCenter(DataCenterDTO dataCenterDTO, RequestDTO requestDTO);

    Page<DataCenter> getAllDataCenters(Pageable pageable);

    Page<DataCenter> getAllDataCenters(Specification<DataCenter> spec, Pageable pageable);

	ResponseEntity<DataCenterPageDTO> getDataCenters(DataCenterSearchDTO dataCenterSearchDTO);
	
	List<DataCenterDTO> convertDataCentersToDataCenterDTOs(List<DataCenter> dataCenters, DataCenterConvertCriteriaDTO convertCriteria);

	DataCenterDTO getDataCenterDTOById(Integer dataCenterId);







}





