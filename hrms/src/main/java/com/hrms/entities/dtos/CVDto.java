package com.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.entities.concretes.City;
import com.hrms.entities.concretes.JobExperience;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.concretes.JobSeekerImage;
import com.hrms.entities.concretes.Language;
import com.hrms.entities.concretes.Link;
import com.hrms.entities.concretes.PreWriting;
import com.hrms.entities.concretes.SchoolInfo;
import com.hrms.entities.concretes.Skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CVDto {
	@JsonIgnore()
	private JobSeeker jobSeeker;
	private List<City> cities;
	private List<SchoolInfo> schoolInfos;
	private List<JobExperience> experiences;
	private List<Language> languages;
	private List<PreWriting> preWritings;
	private List<Skill> skills;
	private List<JobSeekerImage> images;
	private List<Link> links;
}
