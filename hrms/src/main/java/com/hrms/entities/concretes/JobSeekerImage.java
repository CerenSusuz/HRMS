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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobSeeker_images")
public class JobSeekerImage {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "path")
    private String path;

    @Column(name = "uploaded_at", nullable=true)
    private LocalDate uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = JobSeeker.class)
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;
  


    
}
