package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schoolInfos")
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "department")
    private String department;
    
    @Column(name = "start_date")
    @NotNull
    private int startDate;
    
    @Column(name = "graduation_date")
    private int graduationDate;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = JobSeeker.class)
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
 
	
}
