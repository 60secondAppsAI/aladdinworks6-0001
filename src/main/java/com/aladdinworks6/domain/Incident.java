package com.aladdinworks6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="incidents")
@Getter @Setter @NoArgsConstructor
public class Incident {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="incident_id")
	private Integer incidentId;
    
  	@Column(name="description")
	private String description;
    
  	@Column(name="resolution_date")
	private Date resolutionDate;
    
	




}
