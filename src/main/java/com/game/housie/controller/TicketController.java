package com.game.housie.controller;

import com.game.housie.service.TicketGenService;
import com.game.housie.service.TicketService;
import com.game.housie.service.TicketServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Ticket")
public class TicketController {

    //call service - 5 generate Ticket
    public static final Logger logger = LoggerFactory.getLogger(TicketController.class);


	@GetMapping("/sample")
	public String saveEvent() {
		return "sample";
	}
	
    @Autowired
    @Qualifier("ticketServiceImpl")
    private TicketService ticketService;

    @GetMapping("/generateticket/{empcode}/{createdby}/{category}/{noofticket}")
    public String generateTickets(@PathVariable(value = "empcode",required = true) int empcode , @PathVariable("createdby") int createdby, @PathVariable (value="category") int category,@PathVariable(value = "noofticket") int noofTickets){
        logger.info("Creating Ticket : {}");
        System.out.println("empcode "+empcode);
        System.out.println("createdby "+createdby);
        System.out.println("category "+category);
        System.out.println("noofTickets "+noofTickets);
        boolean bool= ticketService.genTickets(empcode,createdby,category,noofTickets);

        return "success";//need to test modelandview
    }
    @GetMapping("/")
    public String doLogin(){
        logger.info("login process");
        return "success";//need to test modelandview
    }



    @GetMapping("/updateTicket/{ticketno}")
    public String generateTickets(@PathVariable(value = "ticketno",required = true) int ticketno ){
        logger.info("updating Ticket : {}");
        boolean bool= ticketService.updatingResult(ticketno);

        return "success";//need to test modelandview
    }
    /*
     =====
     */
    @GetMapping("/ticketLayout")
    public String viewTicket(){
        return "ticketLayout";//need to test modelandview
    }

}
