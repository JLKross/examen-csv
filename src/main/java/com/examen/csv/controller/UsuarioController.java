package com.examen.csv.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.csv.dto.CreditoViviendaDto;
import com.examen.csv.dto.MontoAcumuladoDto;
import com.examen.csv.dto.UsuarioDto;
import com.examen.csv.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/{idPersona}")
	public ResponseEntity<UsuarioDto> getUsuario(@PathVariable String idPersona) throws Exception{
		Path path =  Paths.get("src/main/resources/datos.csv");
		return usuarioService.getUsuario(idPersona, path);
	}
	
	@GetMapping("/viviendas")
	public ResponseEntity<List<CreditoViviendaDto>> getCreditoVivienda() throws Exception {
		Path path =  Paths.get("src/main/resources/datos.csv");
		return usuarioService.getCreditoVivienda(path);
	}
	
	@GetMapping("/montosubcuentas")
	public ResponseEntity<List<MontoAcumuladoDto>> getMontoAcumulado() throws Exception {
		Path path =  Paths.get("src/main/resources/datos.csv");
		return usuarioService.getMontoAcumulado(path);
	}
	
}
