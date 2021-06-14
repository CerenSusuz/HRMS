package com.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
@Table(name="curriculum_vitaes")
@Entity
public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobSeeker_id", referencedColumnName = "user_id")
	private JobSeeker jobSeeker;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobSeekerImage_id", referencedColumnName = "id")
	private JobSeekerImage jobSeekerImage;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Link> links;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<PreWriting> preWritings;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<SchoolInfo> schoolInfos;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobExperience> jobExperiences;
	
	
}
