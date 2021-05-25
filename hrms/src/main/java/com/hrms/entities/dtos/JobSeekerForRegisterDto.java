package com.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto {
    private String firstName;
    private String lastName;
    private long nalionalityId;
    private int yearOfBirth;
    private String email;
    private String password;
    private String repassword;
}
