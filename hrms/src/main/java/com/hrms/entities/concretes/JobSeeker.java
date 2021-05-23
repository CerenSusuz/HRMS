package com.hrms.entities.concretes;

import javax.persistence.*;

import com.hrms.core.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id")
@Table(name="job_seekers")
public class JobSeeker extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nalionality_id")
	private String nalionalityId;
	
	@Column(name="year_of_birth")
	private int yearOfBirth;

    public JobSeeker(int userId, 
    		boolean status, 
    		String email,
    		String password, 
    		String firstName,
    		String lastName, 
    		String nationalityId, 
    		int yearOfBirth) {
        super(userId, status, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nalionalityId = nalionalityId;
        this.yearOfBirth = yearOfBirth;
    }

}

