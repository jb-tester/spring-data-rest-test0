package com.mytests.spring.springDataRestTest0.events;


import com.mytests.spring.springDataRestTest0.model.Person;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
// should not be shown as not used
@Component
@RepositoryEventHandler
public class MyPersonEventHandler {

  // should navigate to org.springframework.data.rest.core.event.AfterCreateEvent publisher
  @HandleAfterCreate
  public void handlePersonCreation(Person p) {
    System.out.println("new Person has been created with id="+p.getId());
  }

  // should navigate to org.springframework.data.rest.core.event.BeforeDeleteEvent publisher
  @HandleBeforeDelete
  public void handlePersonDeleteAttempt(Person p){
    System.out.println("i'm trying to delete the person with id="+ p.getId());
  }
}