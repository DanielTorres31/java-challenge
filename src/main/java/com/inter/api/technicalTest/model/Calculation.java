package com.inter.api.technicalTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Calculation extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long id;
	
	@Column(nullable = false)
	@Getter @Setter private Long userId;
	
	@Column(nullable = false)
	@Getter @Setter private String n;
	
	@Column(nullable = false)
	@Getter @Setter private Integer k;
	
	@Column(nullable = false)
	@Getter @Setter private Integer singleDigit;
}
