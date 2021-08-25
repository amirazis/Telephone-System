package com.example.telephone.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CALLTRANSACTION")
public class CallTransaction {

	@Id
	@Column(name="ID", updatable=false, unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCNUM", nullable = false)
	private Customer CustomerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "A_NUM", nullable = false)
	private TelephoneNo telephoneNo;
	
	@Column(name="B_NUM", updatable=false, unique=true, nullable=false)
	private Long contactedNo;

	@JsonFormat(pattern = "dd MMM yyyy")
	@Column(name = "STT_TIME")
	private Date callStart;
	
	@JsonFormat(pattern = "dd MMM yyyy")
	@Column(name = "END_TIME")	
	private Date callStop;

	@Column(name = "CALL_TYPE")	
	private char callType;
	
	@Column(name = "CALL_COST")	
	private Long callCost;
}
