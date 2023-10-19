package com.examen.csv.service;

import java.nio.file.Path;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examen.csv.dto.CreditoViviendaDto;
import com.examen.csv.dto.MontoAcumuladoDto;
import com.examen.csv.dto.UsuarioDto;

public interface UsuarioService {

	ResponseEntity<UsuarioDto> getUsuario(String idPersona, Path path) throws Exception;
	ResponseEntity<List<CreditoViviendaDto>> getCreditoVivienda(Path path) throws Exception;
	ResponseEntity<List<MontoAcumuladoDto>> getMontoAcumulado(Path path) throws Exception;
	
}
