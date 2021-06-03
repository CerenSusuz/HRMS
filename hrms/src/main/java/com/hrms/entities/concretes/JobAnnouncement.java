package com.hrms.entities.concretes;

import java.time.LocalDate;

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
@Table(name = "job_announcements")
@AllArgsConstructor
@NoArgsConstructor

public class JobAnnouncement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @NotNull
    @NotBlank
	@Column(name = "description",nullable = false)
	private String description;
	
    @NotNull
    @NotBlank
	@Column(name = "min_salary",nullable = false)
	private int minSalary;
	
    @NotNull
    @NotBlank
	@Column(name = "max_salary",nullable = false)
	private int maxSalary;
	
    @NotNull
    @NotBlank
	@Column(name = "open_positions",nullable = false)
	private int openPositions;
	
    @NotNull
    @NotBlank
	@Column(name = "application_deadline",nullable = false)
	private LocalDate applicationDeadline;
	
    @NotNull
    @NotBlank
	@Column(name = "is_active",nullable = false)
	private boolean isActive;
	
    @NotNull
    @NotBlank
	@Column(name = "release_date",nullable = false)
	private LocalDate releaseDate;
	
	@JsonIgnoreProperties({"user_id","web_address","phone_number","email","password","status"})
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;
	
	
}
