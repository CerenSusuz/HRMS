package com.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="company_logos")
public class CompanyLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "path")
    private String path;

    @Column(name = "uploaded_at", nullable=true)
    private LocalDate uploadedAt;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private Employer employer;
}
