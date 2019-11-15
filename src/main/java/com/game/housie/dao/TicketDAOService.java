package com.game.housie.dao;

import com.game.housie.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface TicketDAOService  extends CrudRepository<Ticket,Integer>  {
public interface TicketDAOService  extends JpaRepository<Ticket,Integer> {

}
