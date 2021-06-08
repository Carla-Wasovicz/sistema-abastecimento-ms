package com.sabtc.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabtc.DTO.AutoPostoDTO;
import com.sabtc.entities.AutoPosto;

@Service
public class AutoPostoService {
	@Autowired
	private AutoPosto repository;

	public List<AutoPostoDTO> findAll() {
	  List<AutoPosto> list = repository.findAll();
	   return list.stream().map(autoposto -> new AutoPostoDTO(autoposto)).collect(Collectors.toList());
	}

	public AutoPostoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AutoPostoDTO insert(AutoPostoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public AutoPostoDTO update(Long id, AutoPostoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
