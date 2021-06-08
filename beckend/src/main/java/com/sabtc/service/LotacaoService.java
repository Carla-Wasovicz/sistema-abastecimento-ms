package com.sabtc.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtc.DTO.LotacaoDTO;
import com.sabtc.entities.Lotacao;


@Service
public class LotacaoService {
	
	@Autowired
	private Lotacao repository;
	
	public List<LotacaoDTO> findAll() {
	  List<Lotacao> list = repository.findAll();
	   return list.stream().map(lotacao -> new LotacaoDTO(lotacao)).collect(Collectors.toList());
	}

	public LotacaoDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public LotacaoDTO insert(LotacaoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public LotacaoDTO update(Long id, LotacaoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
