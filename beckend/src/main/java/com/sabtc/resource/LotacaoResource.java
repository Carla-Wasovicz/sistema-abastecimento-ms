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

import com.sabtc.DTO.LotacaoDTO;
import com.sabtc.service.LotacaoService;


@RestController
@RequestMapping (value = "/lotacao")
public class LotacaoResource {
	
	@Autowired
	private LotacaoService service;
	
	@GetMapping
	public ResponseEntity<List< LotacaoDTO >> findAll(){
		List<LotacaoDTO> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
		
	}
	@GetMapping(value = "/{Id}")
	public ResponseEntity<LotacaoDTO> findById(@PathVariable Long Id){
	LotacaoDTO dto = service.findById(Id);
	return ResponseEntity.ok().body(dto);
	} 
	@PostMapping
	public ResponseEntity<LotacaoDTO> insert(@RequestBody LotacaoDTO dto){
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	} 
	
	@PutMapping(value = "/{Id}")
	public ResponseEntity<LotacaoDTO> update(@PathVariable Long Id,@RequestBody LotacaoDTO dto){
		dto = service.update(Id,dto);
		return ResponseEntity.ok().body(dto);
		
	}
	@DeleteMapping(value = "/{Id}")
	public ResponseEntity<LotacaoDTO> delete(@PathVariable Long Id){
		service.delete(Id);
		return ResponseEntity.noContent().build();
		
	}

}
