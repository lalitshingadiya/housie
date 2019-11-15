package com.game.housie.service;

import org.springframework.stereotype.Service;

public interface TicketService {

    public boolean genTickets(int empcode,int createdby,int category,int nooftickets);
    public String renderingTickets(int empcode);
    public int generateRandomTokens();
    //public boolean assignTickets(int [][]arr,int empcode,int category);
    public boolean updatingResult(int ticketno);
}
