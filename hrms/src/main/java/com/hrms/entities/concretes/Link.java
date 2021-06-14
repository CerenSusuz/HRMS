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
@Table(name = "links")
@AllArgsConstructor
@NoArgsConstructor
public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
    @Column(name = "title",nullable = false)
    @NotNull
    @NotBlank
    private String title;
    
    @NotNull
    @NotBlank
    @Column(name = "path")
    private String path;
    
    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id",nullable = false)
    private JobSeeker jobSeeker;
    
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae cv;

}
