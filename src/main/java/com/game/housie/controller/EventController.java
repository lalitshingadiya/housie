package com.game.housie.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.housie.entity.Event;

@RestController
@RequestMapping("/Event")
public class EventController {

	@PostMapping("/save")
	
	public String saveEvent(Event e) {
		return "";
	}
}
