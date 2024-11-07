package com.aladdinworks6.dao;

import java.util.List;

import com.aladdinworks6.dao.GenericDAO;
import com.aladdinworks6.domain.Room;





public interface RoomDAO extends GenericDAO<Room, Integer> {
  
	List<Room> findAll();
	






}


