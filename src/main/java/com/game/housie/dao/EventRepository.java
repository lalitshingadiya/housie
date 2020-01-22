package com.game.housie.dao;

import com.game.housie.entity.Event;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long>{
    long countByNameStartsWith(String str);

    Event getEventByEventId(Long l);


    //Optional<Event> findById(Long aLong);

}
