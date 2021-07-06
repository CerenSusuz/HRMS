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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @Column(name = "name",nullable = false)
    @NotNull
    @NotBlank
    private String name;
    
    @Column(name = "level")
    @Min(1)
    @Max(5)
    @NotNull
    private short level;
	
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = JobSeeker.class)
    @JoinColumn(name = "jobSeeker_id",nullable = false)
    private JobSeeker jobSeeker;
   

}
