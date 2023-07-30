package com.atorres.notificationmsf.service;

import com.atorres.notificationmsf.model.events.CustomerCreatedEvent;
import com.atorres.notificationmsf.model.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class
CustomerEventsService {

	@KafkaListener(
			topics = "${topic.customer.name:message}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(CustomerCreatedEvent.class)) {
			CustomerCreatedEvent customerCreatedEvent = (CustomerCreatedEvent) event;
			log.info("Evento creado , mensaje recibo : Id={}, data={}",
					customerCreatedEvent.getId(),
					customerCreatedEvent.getData().toString());
		}

	}
	
	

}
