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
import com.aladdinworks6.dao.RoomDAO;
import com.aladdinworks6.domain.Room;
import com.aladdinworks6.dto.RoomDTO;
import com.aladdinworks6.dto.RoomSearchDTO;
import com.aladdinworks6.dto.RoomPageDTO;
import com.aladdinworks6.dto.RoomConvertCriteriaDTO;
import com.aladdinworks6.dto.common.RequestDTO;
import com.aladdinworks6.dto.common.ResultDTO;
import com.aladdinworks6.service.RoomService;
import com.aladdinworks6.util.ControllerUtils;





@Service
public class RoomServiceImpl extends GenericServiceImpl<Room, Integer> implements RoomService {

    private final static Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Autowired
	RoomDAO roomDao;

	


	@Override
	public GenericDAO<Room, Integer> getDAO() {
		return (GenericDAO<Room, Integer>) roomDao;
	}
	
	public List<Room> findAll () {
		List<Room> rooms = roomDao.findAll();
		
		return rooms;	
		
	}

	public ResultDTO addRoom(RoomDTO roomDTO, RequestDTO requestDTO) {

		Room room = new Room();

		room.setRoomId(roomDTO.getRoomId());


		room.setRoomNumber(roomDTO.getRoomNumber());


		room.setUsage(roomDTO.getUsage());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		room = roomDao.save(room);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Room> getAllRooms(Pageable pageable) {
		return roomDao.findAll(pageable);
	}

	public Page<Room> getAllRooms(Specification<Room> spec, Pageable pageable) {
		return roomDao.findAll(spec, pageable);
	}

	public ResponseEntity<RoomPageDTO> getRooms(RoomSearchDTO roomSearchDTO) {
	
			Integer roomId = roomSearchDTO.getRoomId(); 
 			String roomNumber = roomSearchDTO.getRoomNumber(); 
 			String usage = roomSearchDTO.getUsage(); 
 			String sortBy = roomSearchDTO.getSortBy();
			String sortOrder = roomSearchDTO.getSortOrder();
			String searchQuery = roomSearchDTO.getSearchQuery();
			Integer page = roomSearchDTO.getPage();
			Integer size = roomSearchDTO.getSize();

	        Specification<Room> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, roomId, "roomId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, roomNumber, "roomNumber"); 
			
			spec = ControllerUtils.andIfNecessary(spec, usage, "usage"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("roomNumber")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("usage")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Room> rooms = this.getAllRooms(spec, pageable);
		
		//System.out.println(String.valueOf(rooms.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(rooms.getTotalPages()));
		
		List<Room> roomsList = rooms.getContent();
		
		RoomConvertCriteriaDTO convertCriteria = new RoomConvertCriteriaDTO();
		List<RoomDTO> roomDTOs = this.convertRoomsToRoomDTOs(roomsList,convertCriteria);
		
		RoomPageDTO roomPageDTO = new RoomPageDTO();
		roomPageDTO.setRooms(roomDTOs);
		roomPageDTO.setTotalElements(rooms.getTotalElements());
		return ResponseEntity.ok(roomPageDTO);
	}

	public List<RoomDTO> convertRoomsToRoomDTOs(List<Room> rooms, RoomConvertCriteriaDTO convertCriteria) {
		
		List<RoomDTO> roomDTOs = new ArrayList<RoomDTO>();
		
		for (Room room : rooms) {
			roomDTOs.add(convertRoomToRoomDTO(room,convertCriteria));
		}
		
		return roomDTOs;

	}
	
	public RoomDTO convertRoomToRoomDTO(Room room, RoomConvertCriteriaDTO convertCriteria) {
		
		RoomDTO roomDTO = new RoomDTO();
		
		roomDTO.setRoomId(room.getRoomId());

	
		roomDTO.setRoomNumber(room.getRoomNumber());

	
		roomDTO.setUsage(room.getUsage());

	

		
		return roomDTO;
	}

	public ResultDTO updateRoom(RoomDTO roomDTO, RequestDTO requestDTO) {
		
		Room room = roomDao.getById(roomDTO.getRoomId());

		room.setRoomId(ControllerUtils.setValue(room.getRoomId(), roomDTO.getRoomId()));

		room.setRoomNumber(ControllerUtils.setValue(room.getRoomNumber(), roomDTO.getRoomNumber()));

		room.setUsage(ControllerUtils.setValue(room.getUsage(), roomDTO.getUsage()));



        room = roomDao.save(room);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public RoomDTO getRoomDTOById(Integer roomId) {
	
		Room room = roomDao.getById(roomId);
			
		
		RoomConvertCriteriaDTO convertCriteria = new RoomConvertCriteriaDTO();
		return(this.convertRoomToRoomDTO(room,convertCriteria));
	}







}
