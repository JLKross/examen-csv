package com.examen.csv.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CreditoVivienda {

	@CsvBindByName(column = "id_persona")
	private String idPersona;
	
	@CsvBindByName(column = "genero")
	private String genero;
	
	@CsvBindByName(column = "edad_acreditado")
	private String edadAcreditado;
	
	@CsvBindByName(column = "estado_civil")
	private String estadoCivil;
	
	@CsvBindByName(column = "id_credito_h")
	private String idCredito;
	
	@CsvBindByName(column = "monto_cred_aut")
	private String montCredAut;
	
	@CsvBindByName(column = "montosubcuenta")
	private String montoSubcuenta;

	@CsvBindByName(column = "valor_vivienda_orig")
	private String valorViviendaOrig;
	
	@CsvBindByName(column = "valor_avaluo")
	private String valorAvaluo;
	
}
