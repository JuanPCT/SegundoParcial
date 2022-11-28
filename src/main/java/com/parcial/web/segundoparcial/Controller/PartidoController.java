package com.parcial.web.segundoparcial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.segundoparcial.Entity.Partido;
import com.parcial.web.segundoparcial.Entity.Resultado;
import com.parcial.web.segundoparcial.Repository.PartidoRepository;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
    
    @Autowired
    PartidoRepository partidoRepository;

    @GetMapping
    public List<Partido> getPartidosAll() {
		
		return partidoRepository.findAll();

	}

    @GetMapping("/{id}/resultados")
    public List<Resultado> getPartidosAndResultados(@PathVariable Integer id) {
		
		Optional<Partido> partido = partidoRepository.findById(id);
		
		if (partido.isPresent()) {
			return partido.get().getResultado();
		}
		
		return null;

	}

}
