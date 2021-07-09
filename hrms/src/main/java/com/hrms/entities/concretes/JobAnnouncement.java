package com.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
	@Column(name = "description",nullable = false)
	private String description;
	
    @NotNull
    @PositiveOrZero
	@Column(name = "min_salary",nullable = false)
	private int minSalary;
	
    @NotNull
    @PositiveOrZero
	@Column(name = "max_salary",nullable = false)
	private int maxSalary;
	
    @NotNull
    @Positive
	@Column(name = "open_positions",nullable = false)
	private int openPositions;
	
    @NotNull
    @Future
	@Column(name = "application_deadline",nullable = false)
	private LocalDate applicationDeadline;
	
    @NotNull
	@Column(name = "is_active",nullable = false)
	private boolean isActive;
	
	@Column(name = "release_date",nullable = false)
	private LocalDate releaseDate;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employer.class)
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class)
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
	@JoinColumn(name="department_id")
	private Department department;
	
	
}
