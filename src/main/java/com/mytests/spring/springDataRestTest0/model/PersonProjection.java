package com.mytests.spring.springDataRestTest0.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameOnly", types = { Person.class })
interface PersonProjection {

  @Value("#{target.firstName+' '+target.lastName}")
  String getName();


}