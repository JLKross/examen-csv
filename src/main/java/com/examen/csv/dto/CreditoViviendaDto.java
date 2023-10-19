package com.examen.csv.dto;

import lombok.Data;

@Data
public class CreditoViviendaDto {

	private String idCredito;
	private String montCredAut;
	private String valorViviendaOrig;
	private String valorAvaluo;
	
	public CreditoViviendaDto(String idCredito, String montCredAut, String valorViviendaOrig, String valorAvaluo) {
		super();
		this.idCredito = idCredito;
		this.montCredAut = montCredAut;
		this.valorViviendaOrig = valorViviendaOrig;
		this.valorAvaluo = valorAvaluo;
	}
	
	
}
