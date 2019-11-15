package com.game.housie.entity;



import org.hibernate.annotations.ColumnDefault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

  //  private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Id
    @Column(name="uid",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ticketId;

    @Column(name = "orgticket",nullable = false)
    String orgTicket=null;


    @Column(name = "currentticket",nullable = false)
    String currentTicket=null;

    @Column(name = "category",nullable = false)
    int category=0;

    @Column(name = "generateDate",nullable = false)
    java.util.Date generateDate=new Date();

    @Column(name = "result",nullable = false)
    String result="";

    @Column(name = "empcode",nullable = false)
    int empCode;




    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getOrgTicket() {
        return orgTicket;
    }


    public void setOrgTicket(String orgTicket) {
        this.orgTicket = orgTicket;
    }


    public String getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(String currentTicket) {
        this.currentTicket = currentTicket;
    }


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }



    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate() {
        this.generateDate = new Date();
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



}
