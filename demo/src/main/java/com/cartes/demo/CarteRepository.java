package com.cartes.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    
}
