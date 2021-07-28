package com.mentoring.amarchuk.springboot.controller;

import com.mentoring.amarchuk.springboot.model.Animal;
import com.mentoring.amarchuk.springboot.service.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//@SpringBootApplication
@Controller
public class AnimalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalController.class);

    AnimalService animalService;



    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/")
    public String allAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        LOGGER.debug("get all users => {}", animals);
        model.addAttribute("animals", animals);
        LOGGER.info("Method start. UserController (-- / --)");
        return "list_animals";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {

        LOGGER.debug("Update user with id ({}) ", id);
        model.addAttribute("animal", id);
        LOGGER.info("Method start. UserController.");
        return "update";

    }

    @GetMapping("/updateAnimal")
    public String updateUserById(@RequestParam("name") String name, @RequestParam("id") long id, @RequestParam("color") String color) {
        LOGGER.debug("Create user with name ({}) and color ({})", name, color);
        Animal animal = new Animal();
        animal.setName(name);
        animal.setColor(color);
        animalService.updateAnimal(name,color,id);
        animalService.getAllAnimals();
        LOGGER.info("Method start. UserController.");
        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model) {
     //   LOGGER.debug("Delete user with id ({}) ", id);
        animalService.deleteAnimal(id);
     //   LOGGER.info("Method start. UserController.");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String create() {

        LOGGER.debug("Create new user ");
        return "new_animal";
    }
    @GetMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("color") String color) {
       // LOGGER.debug("Create user with name ({}) and email ({})", name, color);
        Animal animal = new Animal();
        animal.setName(name);
        animal.setColor(color);
        animalService.createAnimal(animal);
       // LOGGER.info("Method start. UserController (-- /create --)");
        return "redirect:/";
    }



}
