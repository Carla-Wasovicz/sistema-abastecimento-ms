package com.sabtc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabtc.DTO.AbastecimentoDTO;
import com.sabtc.entities.Abastecimento;


@Service
public class AbastecimentoService {
	
	@Autowired
	private Abastecimento repository;
	
	public List<AbastecimentoDTO> findAll() {
	  List<Abastecimento> list = repository.findAll();
	   return list.stream().map(abastecimento -> new AbastecimentoDTO(abastecimento)).collect(Collectors.toList());
	}

	public AbastecimentoDTO insert(AbastecimentoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbastecimentoDTO update(Long id, AbastecimentoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public AbastecimentoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
