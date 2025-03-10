package com.aladdinworks6.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StaticTransferSwitchSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer staticTransferSwitchId;
	
	private String status;
	
	private double transferCapacity;
	
}
