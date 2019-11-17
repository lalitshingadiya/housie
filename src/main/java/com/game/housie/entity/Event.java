package com.game.housie.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="eventmaster")
@Data
public class Event implements Serializable {

	 	
	private static final long serialVersionUID = 1L;

		@Id
	    @Column(name="eid",updatable=false,nullable=false)
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int nEventId;

		@NotNull
		@Column(name="name",unique = true)
		String name;
		
	 	@Column(name = "eventdate")
	 	Date dtEventDate;
	 	
	 	@Column(name="maxtickets")
		int nNoOfTickets;
	 
	 	@Column(name="priceperticket")
	 	int nPricePerTicket;
	 	
	 	@Column(name="status")
	 	String status;
	 
	 	@Column(name="createdby")
	 	int createdBy;
	 	
	 	@Column(name="createddate")
	 	Date createdDate;
	 	
	 	
	 	@OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "createdby", nullable = false)
	    private User user;

}

