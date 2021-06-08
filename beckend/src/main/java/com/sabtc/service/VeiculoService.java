package com.sabtc.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtc.DTO.VeiculoDTO;
import com.sabtc.entities.Veiculo;


@Service
public class VeiculoService {
	@Autowired
	private Veiculo repository;
	
	public List<VeiculoDTO> findAll() {
	  List<Veiculo> list = repository.findAll();
	   return list.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
	}

	public VeiculoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public VeiculoDTO insert(VeiculoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public VeiculoDTO update(Long id, VeiculoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
