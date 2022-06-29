package com.mytests.spring.springDataRestTest0;


import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class PersonEventHandler {

  @HandleAfterSave
  public void handlePersonSave(Person p) {
    System.out.println("new Person has been created with id="+p.getId());
  }

  @HandleBeforeDelete
  public void handlePersonDeleteAttempt(Person p){
    System.out.println("i'm trying to delete the person with id="+ p.getId());
  }
}