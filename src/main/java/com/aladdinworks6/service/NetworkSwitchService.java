package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.NetworkSwitch;
import com.aladdinworks6.dto.NetworkSwitchDTO;
import com.aladdinworks6.dto.NetworkSwitchSearchDTO;
import com.aladdinworks6.dto.NetworkSwitchPageDTO;
import com.aladdinworks6.dto.NetworkSwitchConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface NetworkSwitchService extends GenericService<NetworkSwitch, Integer> {

	List<NetworkSwitch> findAll();

	ResultDTO addNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO);

	ResultDTO updateNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO);

    Page<NetworkSwitch> getAllNetworkSwitchs(Pageable pageable);

    Page<NetworkSwitch> getAllNetworkSwitchs(Specification<NetworkSwitch> spec, Pageable pageable);

	ResponseEntity<NetworkSwitchPageDTO> getNetworkSwitchs(NetworkSwitchSearchDTO networkSwitchSearchDTO);
	
	List<NetworkSwitchDTO> convertNetworkSwitchsToNetworkSwitchDTOs(List<NetworkSwitch> networkSwitchs, NetworkSwitchConvertCriteriaDTO convertCriteria);

	NetworkSwitchDTO getNetworkSwitchDTOById(Integer networkSwitchId);







}





