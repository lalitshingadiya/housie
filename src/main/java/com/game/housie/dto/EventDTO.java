package com.game.housie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.housie.entity.Event;
import com.game.housie.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EventDTO implements Serializable {
    int eventId;
    String name;
    @JsonFormat(pattern="MM-dd-yyyy")
    Date eventDate;
    int noOfTickets;
   int pricePerTicket;
    int soldTicket;
    int noOfUsers;
    String status;
    Date createdDate;
    UserDTO user;
}
