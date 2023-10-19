package com.examen.csv.service.impl;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examen.csv.dto.CreditoViviendaDto;
import com.examen.csv.dto.MontoAcumuladoDto;
import com.examen.csv.dto.UsuarioDto;
import com.examen.csv.entity.CreditoVivienda;
import com.examen.csv.service.UsuarioService;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Override
	public ResponseEntity<UsuarioDto> getUsuario(String idPersona, Path path) throws Exception{
		
		UsuarioDto usr =  null;
		try(Reader reader = new FileReader(path.toString())){
			
			List<CreditoVivienda> lista = new CsvToBeanBuilder<CreditoVivienda>(reader)
					.withType(CreditoVivienda.class)
					.build()
					.parse();
			
			for (CreditoVivienda creditoVivienda : lista) {
				if(creditoVivienda.getIdPersona().equals(idPersona)) {
						usr =  new UsuarioDto(creditoVivienda.getIdPersona(),creditoVivienda.getGenero(),creditoVivienda.getEdadAcreditado(),creditoVivienda.getEstadoCivil());
						break;
				}
			}
			if(usr == null) {
				return  ResponseEntity.notFound().build();
			}
		}
		
		return ResponseEntity.ok(usr);
	}

	@Override
	public ResponseEntity<List<CreditoViviendaDto>> getCreditoVivienda(Path path) throws Exception {
		List<CreditoViviendaDto> listaCreditos = new ArrayList<CreditoViviendaDto>();
		try(Reader reader = new FileReader(path.toString())){
			
			List<CreditoVivienda> lista = new CsvToBeanBuilder<CreditoVivienda>(reader)
					.withType(CreditoVivienda.class)
					.build()
					.parse();
			
			for (CreditoVivienda creditoVivienda : lista) {
//				System.out.println(creditoVivienda.getValorViviendaOrig());
				Integer valorVivienda = new Integer(creditoVivienda.getValorViviendaOrig() == null || creditoVivienda.getValorViviendaOrig().isEmpty() ? "0" : creditoVivienda.getValorViviendaOrig());
				
				Integer montoCred = new Integer(creditoVivienda.getMontCredAut() == null || creditoVivienda.getMontCredAut().isEmpty() ? "0" :  creditoVivienda.getMontCredAut());
				
				if(valorVivienda > montoCred) {
					listaCreditos.add(new CreditoViviendaDto(creditoVivienda.getIdCredito(), creditoVivienda.getMontCredAut(), creditoVivienda.getValorViviendaOrig(), creditoVivienda.getValorAvaluo()));
				}
				
			}
		}
		return ResponseEntity.ok(listaCreditos);
	}

	@Override
	public ResponseEntity<List<MontoAcumuladoDto>> getMontoAcumulado(Path path) throws Exception {
		List<MontoAcumuladoDto> listaCreditos = new ArrayList<MontoAcumuladoDto>();
		
		try(Reader reader = new FileReader(path.toString())){

			List<CreditoVivienda> lista = new CsvToBeanBuilder<CreditoVivienda>(reader)
			    .withType(CreditoVivienda.class)
			    .build()
			    .parse();
			List<CreditoVivienda> edoCivil1 = lista.stream().filter(g -> g.getEstadoCivil().equals("1")).collect(Collectors.toList());

			Integer creditoG1 = 0;
			for (CreditoVivienda creditoVivienda : edoCivil1) {
				Integer monto = new Integer(creditoVivienda.getMontoSubcuenta() == null || creditoVivienda.getMontoSubcuenta().isEmpty() ? "0" : creditoVivienda.getMontoSubcuenta());
				creditoG1 += monto;
			}
			listaCreditos.add(new MontoAcumuladoDto("1", creditoG1));

			List<CreditoVivienda> edoCivil2 = lista.stream().filter(g -> g.getEstadoCivil().equals("2")).collect(Collectors.toList());

			Integer creditoG2 = 0;
			for (CreditoVivienda creditoVivienda : edoCivil2) {
				Integer monto = new Integer(creditoVivienda.getMontoSubcuenta() == null || creditoVivienda.getMontoSubcuenta().isEmpty() ? "0" : creditoVivienda.getMontoSubcuenta());
				creditoG2 += monto;
			}
			listaCreditos.add(new MontoAcumuladoDto("2", creditoG2));

		}
		
		return ResponseEntity.ok(listaCreditos);
	}
}
