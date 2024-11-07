package com.aladdinworks6.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.service.impl.GenericServiceImpl;
import com.aladdinworks6.dao.PowerMeterDAO;
import com.aladdinworks6.domain.PowerMeter;
import com.aladdinworks6.dto.PowerMeterDTO;
import com.aladdinworks6.dto.PowerMeterSearchDTO;
import com.aladdinworks6.dto.PowerMeterPageDTO;
import com.aladdinworks6.dto.PowerMeterConvertCriteriaDTO;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import com.aladdinworks6.service.PowerMeterService;
import com.aladdinworks6.util.ControllerUtils;





@Service
public class PowerMeterServiceImpl extends GenericServiceImpl<PowerMeter, Integer> implements PowerMeterService {

    private final static Logger logger = LoggerFactory.getLogger(PowerMeterServiceImpl.class);

	@Autowired
	PowerMeterDAO powerMeterDao;

	


	@Override
	public GenericDAO<PowerMeter, Integer> getDAO() {
		return (GenericDAO<PowerMeter, Integer>) powerMeterDao;
	}
	
	public List<PowerMeter> findAll () {
		List<PowerMeter> powerMeters = powerMeterDao.findAll();
		
		return powerMeters;	
		
	}

	public ResultDTO addPowerMeter(PowerMeterDTO powerMeterDTO, RequestDTO requestDTO) {

		PowerMeter powerMeter = new PowerMeter();

		powerMeter.setPowerMeterId(powerMeterDTO.getPowerMeterId());


		powerMeter.setCurrentReading(powerMeterDTO.getCurrentReading());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		powerMeter = powerMeterDao.save(powerMeter);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<PowerMeter> getAllPowerMeters(Pageable pageable) {
		return powerMeterDao.findAll(pageable);
	}

	public Page<PowerMeter> getAllPowerMeters(Specification<PowerMeter> spec, Pageable pageable) {
		return powerMeterDao.findAll(spec, pageable);
	}

	public ResponseEntity<PowerMeterPageDTO> getPowerMeters(PowerMeterSearchDTO powerMeterSearchDTO) {
	
			Integer powerMeterId = powerMeterSearchDTO.getPowerMeterId(); 
  			String sortBy = powerMeterSearchDTO.getSortBy();
			String sortOrder = powerMeterSearchDTO.getSortOrder();
			String searchQuery = powerMeterSearchDTO.getSearchQuery();
			Integer page = powerMeterSearchDTO.getPage();
			Integer size = powerMeterSearchDTO.getSize();

	        Specification<PowerMeter> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, powerMeterId, "powerMeterId"); 
			
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<PowerMeter> powerMeters = this.getAllPowerMeters(spec, pageable);
		
		//System.out.println(String.valueOf(powerMeters.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(powerMeters.getTotalPages()));
		
		List<PowerMeter> powerMetersList = powerMeters.getContent();
		
		PowerMeterConvertCriteriaDTO convertCriteria = new PowerMeterConvertCriteriaDTO();
		List<PowerMeterDTO> powerMeterDTOs = this.convertPowerMetersToPowerMeterDTOs(powerMetersList,convertCriteria);
		
		PowerMeterPageDTO powerMeterPageDTO = new PowerMeterPageDTO();
		powerMeterPageDTO.setPowerMeters(powerMeterDTOs);
		powerMeterPageDTO.setTotalElements(powerMeters.getTotalElements());
		return ResponseEntity.ok(powerMeterPageDTO);
	}

	public List<PowerMeterDTO> convertPowerMetersToPowerMeterDTOs(List<PowerMeter> powerMeters, PowerMeterConvertCriteriaDTO convertCriteria) {
		
		List<PowerMeterDTO> powerMeterDTOs = new ArrayList<PowerMeterDTO>();
		
		for (PowerMeter powerMeter : powerMeters) {
			powerMeterDTOs.add(convertPowerMeterToPowerMeterDTO(powerMeter,convertCriteria));
		}
		
		return powerMeterDTOs;

	}
	
	public PowerMeterDTO convertPowerMeterToPowerMeterDTO(PowerMeter powerMeter, PowerMeterConvertCriteriaDTO convertCriteria) {
		
		PowerMeterDTO powerMeterDTO = new PowerMeterDTO();
		
		powerMeterDTO.setPowerMeterId(powerMeter.getPowerMeterId());

	
		powerMeterDTO.setCurrentReading(powerMeter.getCurrentReading());

	

		
		return powerMeterDTO;
	}

	public ResultDTO updatePowerMeter(PowerMeterDTO powerMeterDTO, RequestDTO requestDTO) {
		
		PowerMeter powerMeter = powerMeterDao.getById(powerMeterDTO.getPowerMeterId());

		powerMeter.setPowerMeterId(ControllerUtils.setValue(powerMeter.getPowerMeterId(), powerMeterDTO.getPowerMeterId()));

		powerMeter.setCurrentReading(ControllerUtils.setValue(powerMeter.getCurrentReading(), powerMeterDTO.getCurrentReading()));



        powerMeter = powerMeterDao.save(powerMeter);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PowerMeterDTO getPowerMeterDTOById(Integer powerMeterId) {
	
		PowerMeter powerMeter = powerMeterDao.getById(powerMeterId);
			
		
		PowerMeterConvertCriteriaDTO convertCriteria = new PowerMeterConvertCriteriaDTO();
		return(this.convertPowerMeterToPowerMeterDTO(powerMeter,convertCriteria));
	}







}
