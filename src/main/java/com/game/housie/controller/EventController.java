package com.game.housie.controller;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import com.game.housie.service.EventService;
import com.game.housie.test.Maruti;
import com.game.housie.test.PropertyReader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;



	@Autowired
	PropertyReader pr;

	@PostMapping("/save")
	public String saveEvent(@Valid @ModelAttribute("event") EventDTO e, BindingResult bindingResult) {
		JSONObject json = new JSONObject();
		if (bindingResult.hasErrors()) {
			json.put("status","fail");
			json.put("errorList",bindingResult.getAllErrors());
		}else{
			Long returnId=eventService.save(e);
			json.put("status","success");
		}
		return json.toString();
	}
	
	@GetMapping(value = "/getAll")
	public String getAll(@RequestParam Map<String,String> allParams) {
		JSONObject jsonObject= eventService.findAllEvents(allParams);
		return jsonObject.toString();
	}
	@GetMapping(value = "/get/{id}")
	public @ResponseBody Event getById(@PathVariable Long id) {

		pr.getAllProperty();
		return eventService.getEventById(id);
	}




}
