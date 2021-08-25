package com.example.telephone.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TELEPHONENO")
public class TelephoneNo {

	@Id
	@Column(name="ID", updatable=false, unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PHONENUMBER", updatable=true, unique=true, nullable=false)
	private Long phoneNumber;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CUSTOMERID", nullable = false)
	private Customer customer;
}
