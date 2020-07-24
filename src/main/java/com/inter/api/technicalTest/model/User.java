package com.inter.api.technicalTest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long id;
	
	@Column(nullable = false)
	@Getter @Setter private String name;
	
	@Column(nullable = false)
	@Getter @Setter private String email;
	
	@Column(nullable = true)
	@OneToMany(mappedBy = "userId", targetEntity = Calculation.class)
	@Getter @Setter private List<Integer> calculations;
	
}
