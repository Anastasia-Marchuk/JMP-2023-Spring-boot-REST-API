package com.mentoring.amarchuk.springboot.dao;

import com.mentoring.amarchuk.springboot.dto.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AnimalRepository extends CrudRepository<Animal, Long> {

    List<Animal> findByName(String name);
    List<Animal> findByColor(String name);
    Animal findById(long id);

}