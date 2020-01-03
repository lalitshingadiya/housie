package com.game.housie.controller;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import com.game.housie.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	
	@PostMapping("/save")
	public int saveEvent(EventDTO e) {
		 return eventService.save(e);
	}
	
	@GetMapping(value = "/getAll")
	public List<EventDTO> getAll(@RequestParam("start") int start, @RequestParam("length")  int length,@RequestParam("search") String []search ) {//,
	//public List<EventDTO> getAll(@RequestParam Map<String,String> allParams) {//,

		//System.out.println(start);
		//System.out.println(search[0]);
		 List<EventDTO> lst= eventService.findAllEvents();
		return lst;
	}


}
