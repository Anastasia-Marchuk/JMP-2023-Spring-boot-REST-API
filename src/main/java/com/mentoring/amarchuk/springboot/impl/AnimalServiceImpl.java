package com.mentoring.amarchuk.springboot.impl;

import com.mentoring.amarchuk.springboot.api.AnimalService;
import com.mentoring.amarchuk.springboot.dao.AnimalRepository;
import com.mentoring.amarchuk.springboot.dto.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;

    public AnimalServiceImpl(AnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Animal createAnimal(Animal animal) {
        return repository.save(animal);
    }

    @Override
    public Animal readAnimalById(long id) {
        return repository.findById(id);
    }

    @Override
    public  List<Animal> findByName(String name) {
        return  repository.findByName(name);
    }



    @Override
    public List<Animal> getAllAnimals() {
        return (List<Animal>) repository.findAll();
    }

    @Override
    public Animal updateAnimal(String name, String color, long id) {
        Animal a = repository.findById(id);
        a.setName(name);
        a.setColor(color);
        return repository.save(a);
    }



    @Override
    public void deleteAnimal(long id) {
        repository.deleteById(id);

    }

    @Override
    public Animal findById(long id) {
        return repository.findById(id);
    }
}
