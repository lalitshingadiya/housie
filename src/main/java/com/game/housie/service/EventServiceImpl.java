package com.game.housie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.game.housie.dto.EventDTO;
import com.game.housie.entity.User;
import com.game.housie.mapper.EventMapper;
import com.game.housie.utility.Helper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.game.housie.dao.EventRepository;
import com.game.housie.entity.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	public Event getEventById(Long l){
		Optional<Event> e= eventRepository.findById(l);
		return e.get();
	}

	@Override
	public List<EventDTO> findAllEvents() {
		List<Event> lstevents=eventRepository.findAll();
		List<EventDTO> dtoList = new ArrayList<>();
		for(Event e:lstevents){
			dtoList.add(EventMapper.INSTANCE.eventToEventDTO(e));
		}
		return dtoList;
	}

	@Override
	public Long save(EventDTO event) {
		Event e = EventMapper.INSTANCE.eventDTOtoEvent(event);

		Long userId=Helper.getUserId(SecurityContextHolder.getContext());

		User user1 = new User();
		user1.setId(userId);
		e.setUser(user1);
		e = eventRepository.save(e);
		return e.getEventId();
	}


	@Override
	public JSONObject findAllEvents(Map map) {

	int	start= Helper.getInt(map.get("start").toString(),1);
	int length= Helper.getInt(map.get("length").toString(),10);
	String searchName=map.get("search[value]").toString();

	start=(start/length);
	Pageable p= PageRequest.of(start, length);
	Page<Event> lstevents;

	ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",m -> m.startsWith());
	Event e1 =Event.getClone(searchName);
	lstevents=eventRepository.findAll(Example.of(e1,matcher),p);
	List<EventDTO> dtoList = new ArrayList<>();
	for(Event e:lstevents){
		dtoList.add(EventMapper.INSTANCE.eventToEventDTO(e));
	}

	Long totalCount=this.count();
	Long filteredCount=0L;
	if(searchName.length()>0){
		filteredCount=this.count(searchName);
	}else{
		filteredCount=totalCount;
	}
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("data",dtoList);
	jsonObject.put("recordsTotal",totalCount);
	jsonObject.put("recordsFiltered",filteredCount);
	jsonObject.put("draw",map.get("draw").toString());
	return jsonObject;
	}

	@Override
	public Long count() {
		return eventRepository.count();
	}

	@Override
	public Long count(String eventname) {
		return eventRepository.countByNameStartsWith(eventname);
	}

}
