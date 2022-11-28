package com.parcial.web.segundoparcial.Entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@Table(name ="partido")
public class Partido {
    
    @Id
	@SequenceGenerator(name="categoria_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_id_seq")
    private Integer id;

    private Timestamp fecha;

    @JsonIgnore
    @OneToMany(mappedBy="partido")
	private List<Resultado> resultado;

    @ManyToOne
	@JoinColumn(name="estadio_id")
    private Estadio estadio;
}
