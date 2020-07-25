package com.inter.api.technicalTest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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
	
	public Calculation(String n, Integer k, Long userId) {
		this.n = n;
		this.k = k;
		this.userId = userId;
	}
}
