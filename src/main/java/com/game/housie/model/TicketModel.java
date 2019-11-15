package com.game.housie.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

public class TicketModel {

    //private int res[][]=new int[3][9];
    private int ticketId;
    private String orgTicket;
    private String currentTicket;
    private int category;
    private java.util.Date generateDate;
    String result;
    int empCode;


    public TicketModel(){

    }
    TicketModel(int [][] res,int empCode,int category)
    {
        orgTicket=Arrays.deepToString(res);
        currentTicket=orgTicket;
        this.empCode=empCode;
        this.category=category;

    }


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

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
