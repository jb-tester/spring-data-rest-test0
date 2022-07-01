package com.mytests.spring.springDataRestTest0.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "relatives", path = "family")
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

  @RestResource(description = @Description("search person by family name"), path = "filtered/by_surname")
  List<Person> findByLastName(@Param("surname") String name);

  @RestResource(description = @Description("search person by name"))
  List<Person> findByFirstName(String firstName);
}