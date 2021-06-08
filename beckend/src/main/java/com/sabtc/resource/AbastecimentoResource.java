package com.sabtc.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sabtc.DTO.AbastecimentoDTO;
import com.sabtc.service.AbastecimentoService;

@RestController
@RequestMapping (value = "/abastecimento")
public class AbastecimentoResource {
	
	@Autowired
	private AbastecimentoService service;
	
	@GetMapping
	public ResponseEntity<List<AbastecimentoDTO>> findAll(){
		List<AbastecimentoDTO> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
		
	}
	@GetMapping(value = "/{Id}")
	public ResponseEntity<AbastecimentoDTO> findById(@PathVariable Long Id){
	AbastecimentoDTO dto = service.findById(Id);
	return ResponseEntity.ok().body(dto);
	} 
	@PostMapping
	public ResponseEntity<AbastecimentoDTO> insert(@RequestBody AbastecimentoDTO dto){
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	} 
	
	@PutMapping(value = "/{Id}")
	public ResponseEntity<AbastecimentoDTO> update(@PathVariable Long Id,@RequestBody AbastecimentoDTO dto){
		dto = service.update(Id,dto);
		return ResponseEntity.ok().body(dto);
		
	}
	@DeleteMapping(value = "/{Id}")
	public ResponseEntity<AbastecimentoDTO> delete(@PathVariable Long Id){
		service.delete(Id);
		return ResponseEntity.noContent().build();
		
	}
}
