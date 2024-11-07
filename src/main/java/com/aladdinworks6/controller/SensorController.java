package com.aladdinworks6.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.aladdinworks6.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.aladdinworks6.domain.Sensor;
import com.aladdinworks6.dto.SensorDTO;
import com.aladdinworks6.dto.SensorSearchDTO;
import com.aladdinworks6.dto.SensorPageDTO;
import com.aladdinworks6.service.SensorService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/sensor")
@RestController
public class SensorController {

	private final static Logger logger = LoggerFactory.getLogger(SensorController.class);

	@Autowired
	SensorService sensorService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Sensor> getAll() {

		List<Sensor> sensors = sensorService.findAll();
		
		return sensors;	
	}

	@GetMapping(value = "/{sensorId}")
	@ResponseBody
	public SensorDTO getSensor(@PathVariable Integer sensorId) {
		
		return (sensorService.getSensorDTOById(sensorId));
	}

 	@RequestMapping(value = "/addSensor", method = RequestMethod.POST)
	public ResponseEntity<?> addSensor(@RequestBody SensorDTO sensorDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = sensorService.addSensor(sensorDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/sensors")
	public ResponseEntity<SensorPageDTO> getSensors(SensorSearchDTO sensorSearchDTO) {
 
		return sensorService.getSensors(sensorSearchDTO);
	}	

	@RequestMapping(value = "/updateSensor", method = RequestMethod.POST)
	public ResponseEntity<?> updateSensor(@RequestBody SensorDTO sensorDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = sensorService.updateSensor(sensorDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
