package com.parcial.web.segundoparcial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.segundoparcial.Entity.Resultado;
import com.parcial.web.segundoparcial.Repository.ResultadoRepository;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {
    
    @Autowired
    ResultadoRepository resultadoRepository;

	@GetMapping
    public List<Resultado> getPartidosAll() {
		
		return resultadoRepository.findAll();

	}

    @PostMapping
    public Resultado postResultado(@RequestBody Resultado resultado) {
		
		resultadoRepository.save(resultado);
		
		return resultado;	

	}

    @PutMapping("/{id}")
	public Resultado putResultadobyId(@PathVariable Integer id, @RequestBody Resultado resultado) {
		
		Optional<Resultado> resultadoCurrent = resultadoRepository.findById(id);
		
		if (resultadoCurrent.isPresent()) {
			
			Resultado resultadoReturn = resultadoCurrent.get();
			            		
			resultadoReturn.setGoles(resultado.getGoles());
			resultadoReturn.setAmarillas(resultado.getAmarillas());
            resultadoReturn.setRojas(resultado.getRojas());			
			
			resultadoRepository.save(resultadoReturn);
			
			return resultadoReturn;
		}
		
		return null;

	}
}