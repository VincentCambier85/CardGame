package com.cartes.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CarteController {

    @Autowired
    private CarteRepository carteRepository;

    @GetMapping("/cartes")
    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }
}