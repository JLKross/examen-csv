package com.examen.csv.dto;

import lombok.Data;

@Data
public class UsuarioDto {

	private String idPersona;
	
	private String genero;
	
	private String edadAcreditado;
	
	private String estadoCivil;

	public UsuarioDto(String idPersona, String genero, String edadAcreditado, String estadoCivil) {
		super();
		this.idPersona = idPersona;
		this.genero = genero;
		this.edadAcreditado = edadAcreditado;
		this.estadoCivil = estadoCivil;
	}
	
	
	
}
