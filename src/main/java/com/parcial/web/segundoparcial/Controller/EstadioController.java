package com.parcial.web.segundoparcial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.segundoparcial.Entity.Estadio;
import com.parcial.web.segundoparcial.Repository.EstadioRepository;

@RestController
@RequestMapping("/estadio")
public class EstadioController {
    
    @Autowired
    EstadioRepository estadioRepository;

	@GetMapping
    public List<Estadio> getEstadiosAll() {
		
		return estadioRepository.findAll();

	}

    @DeleteMapping("/{id}")
	public Estadio deleteProductosbyId(@PathVariable Integer id) {
		
		Optional<Estadio> estadio = estadioRepository.findById(id);
		
		if (estadio.isPresent()) {
			
			Estadio productoReturn = estadio.get();
			
			estadioRepository.deleteById(id);
			
			return productoReturn;
		}
		
		return null;

	}
}
