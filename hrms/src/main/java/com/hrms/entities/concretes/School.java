package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
@AllArgsConstructor
@NoArgsConstructor
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "department")
    private String department;
    
    @Column(name = "start_date")
    @NotNull
    @NotBlank
    private int startDate;
    
    @Column(name = "graduation_date")
    private int graduationDate;
    
    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
	
}
