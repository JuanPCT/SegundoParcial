package com.parcial.web.segundoparcial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.segundoparcial.Entity.Seleccion;
import com.parcial.web.segundoparcial.Repository.SeleccionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
    
    @Autowired
    SeleccionRepository seleccionRepository;

    @GetMapping
    public List<Seleccion> getSeleccionAll() {
        return seleccionRepository.findAll();
    }

    @PostMapping
	public Seleccion postProductos(@RequestBody Seleccion seleccion) {
		
		seleccionRepository.save(seleccion);
		
		return seleccion;
		
	}

    @GetMapping("/grupo/{grupo}")
	public List<Seleccion> getProductosbyId(@PathVariable String grupo) {
		
        List<Seleccion> seleccion = seleccionRepository.findByGrupo(grupo);
		
		if (!seleccion.isEmpty()) {
			return seleccion;
		}
		
		return null;
	}
    
}
