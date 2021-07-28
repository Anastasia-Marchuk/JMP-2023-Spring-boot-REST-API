package com.mentoring.amarchuk.springboot.service;

import com.mentoring.amarchuk.springboot.model.Animal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AnimalService {

    Animal createAnimal(Animal animal);

    Animal readAnimalById(long id);
    List<Animal> findByName(String name);


    List<Animal> getAllAnimals();

    @Modifying
    @Query("update Animal a set a.name = ?1, a.color = ?2 where a.id = ?3")
    Animal updateAnimal(String name, String color, long id);

    void deleteAnimal(long id);
}
