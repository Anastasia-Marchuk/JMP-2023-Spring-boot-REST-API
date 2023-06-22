package com.mentoring.amarchuk.springboot.controller;

import com.mentoring.amarchuk.springboot.model.Animal;
import com.mentoring.amarchuk.springboot.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(description="Animal REST API Controller")
public class AnimalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalController.class);

    AnimalService animalService;


    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

        @ApiOperation(value = "Get a all animals", notes = "Returns a list of animals")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - Something went wrong")
    })
    @GetMapping("/")
    public List <Animal>  allAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        LOGGER.debug("get all users => {}", animals);
        LOGGER.info("Method start. UserController (-- / --)");
        return animals;
    }

    //    @ApiOperation(value = "Get animal by name", nickname = "Get animal by name")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "Animal's name", required = true, dataType = "String", paramType = "path", defaultValue="1")
//    })
    @GetMapping("/{name}")
    public List <Animal> getAnimalByName(@PathVariable("name") String name) {
        List<Animal> animals = animalService.findByName(name);
        return animals;

    }

    //    @ApiOperation(value = "Get animal by id", nickname = "Get animal by id")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "Animal's id", required = true, dataType = "long", paramType = "path", defaultValue="1")
//    })
    @GetMapping("/id/{id}")
    public Animal getAnimalByName(@PathVariable("id") long id) {
        Animal animal = animalService.findById(id);
        return animal;

    }

    @PutMapping("/update/{id}")
    public Animal update(@RequestBody Animal animal, @PathVariable("id") long id) {
//        Animal animal=animalService.updateAnimal(name, color, id);
        Animal an=animalService.updateAnimal(animal.getName(), animal.getColor(),id);
        LOGGER.debug("Update animal with id ({}) ", id);
        LOGGER.info("Method start. animalController.");
        return an;

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

    @DeleteMapping ("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        LOGGER.debug("Delete animal with id ({}) ", id);
        animalService.deleteAnimal(id);

    }

    @PostMapping("/new")
    public Animal create(@RequestBody Animal animal) {
        LOGGER.debug("Create animal");
        Animal an=animalService.createAnimal(animal);
        return an;
    }


}
