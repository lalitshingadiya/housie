package com.game.housie.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="eventmaster")
public class Event implements Serializable {

	 	@Id
	    @Column(name="eid",updatable=false,nullable=false)
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    int nEventId;

	 	@Column(name = "eventdate")
	 	Date dtEventDate;
	 	
	 	@Column(name="maxtickets")
		int nNoOfTickets;
	 
	 	@Column(name="priceperticket")
	 	int nPricePerTicket;
	 	
	 	@Column(name="status")
	 	String status;
}

