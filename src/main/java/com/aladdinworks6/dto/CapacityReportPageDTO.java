package com.aladdinworks6.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CapacityReportPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<CapacityReportDTO> capacityReports;
}





