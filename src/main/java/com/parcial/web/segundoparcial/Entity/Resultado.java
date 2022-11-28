package com.parcial.web.segundoparcial.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@Table(name ="resultado")
public class Resultado {
    
    @Id
	@SequenceGenerator(name="categoria_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_id_seq")
    private Integer serial;

    @ManyToOne
	@JoinColumn(name="partido_id")
    private Partido partido;

    @ManyToOne
	@JoinColumn(name="seleccion_id")
    private Seleccion seleccion;

    private Integer goles;
    private Integer amarillas;
    private Integer rojas;
}
