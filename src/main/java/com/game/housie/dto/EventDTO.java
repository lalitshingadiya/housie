package com.game.housie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.housie.entity.Event;
import com.game.housie.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EventDTO implements Serializable {
    Long eventId;
    @NotNull
    @Size(min=5,max = 30)
    String name;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Future()
    Date eventDate;

    Integer noOfTickets;
    Integer pricePerTicket;

    @ColumnDefault("0")
    Integer soldTicket;

    Integer noOfUsers;
    String status;
    Date createdDate;
    UserDTO user;

}
