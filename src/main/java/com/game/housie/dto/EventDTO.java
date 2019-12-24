package com.game.housie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.housie.entity.Event;
import com.game.housie.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class EventDTO implements Serializable {
    int nEventId;
    String name;
    Date dtEventDate;
    int nNoOfTickets;
    int nPricePerTicket;
    String status;
    Date createdDate;
    UserDTO user;

//    public int getnEventId() {
//        return nEventId;
//    }
//
//    public void setnEventId(int nEventId) {
//        this.nEventId = nEventId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
