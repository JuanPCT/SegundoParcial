package com.parcial.web.segundoparcial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial.web.segundoparcial.Entity.Partido;

public interface PartidoRepository extends JpaRepository<Partido,Integer> {
    
}
