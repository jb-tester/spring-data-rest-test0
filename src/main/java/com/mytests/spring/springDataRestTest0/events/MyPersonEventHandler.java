package com.mytests.spring.springDataRestTest0.events;


import com.mytests.spring.springDataRestTest0.model.Person;
import org.springframework.data.rest.core.annotation.*;
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
  @HandleAfterSave
  public void handlePersonSave(Person p) {

    System.out.println("new Person has been saved with id="+p.getId());
  }
  @HandleAfterDelete
  public void handlePersonDeleting(Person p) {

    System.out.println("Person has been deleted");
  }
  @HandleAfterLinkSave
  public void handleLinkSaving(Person p) {

    System.out.println("link has been saved");
  }
  @HandleAfterLinkDelete
  public void handleLinkDeleting(Person p) {

    System.out.println("link has been deleted");
  }

  @HandleBeforeCreate
  public void handleBeforePersonCreation(Person p) {

    System.out.println("new Person will be created with id="+p.getId());
  }
  @HandleBeforeSave
  public void handleBeforePersonSave(Person p) {

    System.out.println("new Person will be saved with id="+p.getId());
  }
  // should navigate to org.springframework.data.rest.core.event.BeforeDeleteEvent publisher
  @HandleBeforeDelete
  public void handlePersonDeleteAttempt(Person p){

    System.out.println("i'm trying to delete the person with id="+ p.getId());
  }
  @HandleBeforeLinkSave
  public void handleBeforeLinkSaving(Person p) {

    System.out.println("link will be saved");
  }
  @HandleBeforeLinkDelete
  public void handleBeforeLinkDeleting(Person p) {

    System.out.println("link will be deleted");
  }
}