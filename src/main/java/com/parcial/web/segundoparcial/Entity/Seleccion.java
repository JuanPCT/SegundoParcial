package com.parcial.web.segundoparcial.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="seleccion")
public class Seleccion {
    
    @Id
	@SequenceGenerator(name="seleccion_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seleccion_id_seq")
	private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name="continente_id")
    private Continente continente;

    private String grupo;
}
