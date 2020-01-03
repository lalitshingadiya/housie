package com.game.housie.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="eventmaster")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="eid",updatable=false,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int eventId;
	@NotNull
	@Column(name="name",unique = true)
	String name;
	@Column(name = "eventdate")
	Date eventDate;
	@Column(name="maxtickets")
	int noOfTickets;
	@Column(name="priceperticket")
	int pricePerTicket;
	@Column(name="soldtickets")
	int soldTickets;
	@Column(name="noofusers")
	int noOfUsers;
	@Column(name="status")
	String status;
	@Column(name="createddate")
	Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "createdby", nullable = false)
	private User user;


}

