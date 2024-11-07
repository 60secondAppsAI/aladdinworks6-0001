package com.aladdinworks6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworks6.domain.Room;
import com.aladdinworks6.dto.RoomDTO;
import com.aladdinworks6.dto.RoomSearchDTO;
import com.aladdinworks6.dto.RoomPageDTO;
import com.aladdinworks6.dto.RoomConvertCriteriaDTO;
import com.aladdinworks6.service.GenericService;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface RoomService extends GenericService<Room, Integer> {

	List<Room> findAll();

	ResultDTO addRoom(RoomDTO roomDTO, RequestDTO requestDTO);

	ResultDTO updateRoom(RoomDTO roomDTO, RequestDTO requestDTO);

    Page<Room> getAllRooms(Pageable pageable);

    Page<Room> getAllRooms(Specification<Room> spec, Pageable pageable);

	ResponseEntity<RoomPageDTO> getRooms(RoomSearchDTO roomSearchDTO);
	
	List<RoomDTO> convertRoomsToRoomDTOs(List<Room> rooms, RoomConvertCriteriaDTO convertCriteria);

	RoomDTO getRoomDTOById(Integer roomId);







}





