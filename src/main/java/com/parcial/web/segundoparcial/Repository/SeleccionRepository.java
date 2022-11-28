package com.parcial.web.segundoparcial.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial.web.segundoparcial.Entity.Seleccion;

public interface SeleccionRepository extends JpaRepository<Seleccion,Integer> {
    
    public List<Seleccion> findByGrupo(String grupo);
}
