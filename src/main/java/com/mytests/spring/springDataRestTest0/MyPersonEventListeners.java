package com.mytests.spring.springDataRestTest0;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class MyPersonEventListeners extends AbstractRepositoryEventListener<Person> {

  @Override
  public void onBeforeCreate(Person p) {
    System.out.println("-- i'm trying to add new entity "+p.getFirstName());
  }

  @Override
  public void onAfterDelete(Person p) {
    System.out.println("-- deleted entity with id="+p.getId());
  }
}