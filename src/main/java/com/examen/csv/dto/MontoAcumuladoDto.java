package com.examen.csv.dto;

import lombok.Data;

@Data
public class MontoAcumuladoDto {
	private String estadoCivil;
	private Integer monto;
	
	public MontoAcumuladoDto(String estadoCivil, Integer monto) {
		super();
		this.estadoCivil = estadoCivil;
		this.monto = monto;
	}
	
	
}
