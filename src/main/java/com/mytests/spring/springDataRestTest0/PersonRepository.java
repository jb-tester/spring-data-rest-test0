package com.mytests.spring.springDataRestTest0;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "relatives", path = "family")
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

  List<Person> findByLastName(@Param("name") String name);

}