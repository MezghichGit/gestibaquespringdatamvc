package com.sip.gestibanque.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.gestibanque.entities.Message;
import com.sip.gestibanque.entities.User;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
	List<Message> findByDateCreation(LocalDate dateCreation);
}
