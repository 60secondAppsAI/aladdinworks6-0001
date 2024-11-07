package com.aladdinworks6.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class MaintenanceDTO {

	private Integer maintenanceId;

	private Date dateScheduled;

	private String technicianName;

	private String notes;






}
