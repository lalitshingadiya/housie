package com.game.housie.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

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

	Long eventId;
	@NotNull
	@Column(name="name",unique = true)
	String name;
	@Column(name = "eventdate")
	Date eventDate;
	@Column(name="maxtickets")
	Integer noOfTickets;
	@Column(name="priceperticket")
	Integer pricePerTicket;
	@ColumnDefault("0")
	@Column(name="soldtickets")

	Integer soldTickets;
	@Column(name="noofusers")
	@ColumnDefault("0")
	Integer noOfUsers;
	@Column(name="status")
	String status;
	@Column(name="createddate",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false,updatable = false)
	//@CreationTimestamp
	Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "createdby", nullable = false)
	private User user;

	public static Event getClone(String name){
		Event e=new Event();
		e.setName(name);
		return e;
	}

}

