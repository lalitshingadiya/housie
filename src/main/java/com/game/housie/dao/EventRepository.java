package com.game.housie.dao;

import com.game.housie.entity.Event;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    long countByNameStartsWith(String str);
}
