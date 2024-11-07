package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.Sensor;
import com.aladdinworks6.dto.SensorDTO;
import com.aladdinworks6.dto.SensorSearchDTO;
import com.aladdinworks6.dto.SensorPageDTO;
import com.aladdinworks6.dto.SensorConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface SensorService extends GenericService<Sensor, Integer> {

	List<Sensor> findAll();

	ResultDTO addSensor(SensorDTO sensorDTO, RequestDTO requestDTO);

	ResultDTO updateSensor(SensorDTO sensorDTO, RequestDTO requestDTO);

    Page<Sensor> getAllSensors(Pageable pageable);

    Page<Sensor> getAllSensors(Specification<Sensor> spec, Pageable pageable);

	ResponseEntity<SensorPageDTO> getSensors(SensorSearchDTO sensorSearchDTO);
	
	List<SensorDTO> convertSensorsToSensorDTOs(List<Sensor> sensors, SensorConvertCriteriaDTO convertCriteria);

	SensorDTO getSensorDTOById(Integer sensorId);







}





