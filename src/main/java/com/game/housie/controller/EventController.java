package com.game.housie.controller;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.Event;
import com.game.housie.service.EventService;
import com.game.housie.utility.Helper;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping("/save")
	@ResponseBody
	public String saveEvent(@Valid @ModelAttribute("event") EventDTO e, BindingResult bindingResult) {
		JSONObject json = new JSONObject();
		if (bindingResult.hasErrors()) {
			json.put("status","fail");
			json.put("errorList",bindingResult.getAllErrors());
		}else{
			int returnId=eventService.save(e);
			json.put("status","success");
		}
		return json.toString();
	}
	
	@GetMapping(value = "/getAll")
	@ResponseBody
	//public List<EventDTO> getAll(HttpServletRequest request) {//,
	public String getAll(@RequestParam Map<String,String> allParams) {

		int start=0;
		int length=0;
		String searchName="";
		start= Helper.getInt(allParams.get("start"),1);
		length= Helper.getInt(allParams.get("length"),10);
		//searchName=allParams.get("draw");

		searchName=allParams.get("search[value]");

		long totalCount=0;
		long filteredCount=0;
		Object key;
		int draw=Integer.parseInt(allParams.get("draw"));
		draw=1;
		 List<EventDTO> lst= eventService.findAllEvents(start,length,"1");
		 totalCount=eventService.count();

		 if(searchName.length()>0){
		 	filteredCount=eventService.count(searchName);
		 }else{
		 	filteredCount=totalCount;
		 }

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data",lst);
		jsonObject.put("recordsTotal",totalCount);
		jsonObject.put("recordsFiltered",filteredCount);
		jsonObject.put("draw",allParams.get("draw"));

		return jsonObject.toString();
	}

}
