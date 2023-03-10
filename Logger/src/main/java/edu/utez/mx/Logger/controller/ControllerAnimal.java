package edu.utez.mx.Logger.controller;

import edu.utez.mx.Logger.model.modelAnimales;
import edu.utez.mx.Logger.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ControllerAnimal {
    @Autowired
    private AnimalServiceImpl service;

    @GetMapping("/")
    public String getAll(Model model){
        List<modelAnimales> list = service.getAllAnimales();
        model.addAttribute("animales", list);
        return "index";
    }

    @GetMapping("/form")
    public String moveForm(Model model){
        model.addAttribute("animal",new modelAnimales());
        return "formulario";
    }

    @PostMapping("/save")
    public String saveAnimal ( modelAnimales animales, Model model) {
        System.out.println(animales.toString());
        service.saveAnimal(animales);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editAnimal(@PathVariable int id, Model model) {
        Optional<modelAnimales> animales = service.getAnimalById(id);
       // System.out.println(person.toString());
        model.addAttribute("animal", animales.get());

        return "formulario";
    };

}
