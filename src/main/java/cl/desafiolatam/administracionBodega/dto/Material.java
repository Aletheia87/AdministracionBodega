package cl.desafiolatam.administracionBodega.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Material {

	private int precio;
	private String nombre;
	private LocalDate fechaIngreso;
	private Bodega bodega;
	

}