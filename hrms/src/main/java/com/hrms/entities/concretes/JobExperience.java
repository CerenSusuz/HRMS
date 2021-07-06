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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @Column(name = "workplace_name",nullable = false)
    @NotNull
    @NotBlank
    private String workplaceName;
    
    @Column(name = "position",nullable = false)
    @NotNull
    @NotBlank
    private String position;
	
    @Column(name = "date_of_start",nullable = false)
    @NotNull
    private int dateOfStart;

    @Column(name = "date_of_end")
    private int dateOfEnd;
    
    @ManyToOne()
    @JoinColumn(name = "job_seeker_id",nullable = false)
    private JobSeeker jobSeeker;
    
}
