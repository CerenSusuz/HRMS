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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="preWritings")
public class PreWriting {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "writing")
    @NotNull
    @NotBlank
    private String writing;

    @ManyToOne()
    @NotNull
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
    
	@JsonIgnoreProperties({"id"})
	@ManyToOne()
	@JoinColumn(name="curriculum_vitae_id")
	private CurriculumVitae cv;
}
