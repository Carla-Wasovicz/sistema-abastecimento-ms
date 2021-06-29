package com.sabtc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sabtc.DTO.AbastecimentoDTO;
import com.sabtc.entities.Abastecimento;
import com.sabtc.exceptions.DataBaseException;
import com.sabtc.exceptions.ResourceNotFoundException;
import com.sabtc.repository.AbastecimentoRepository;


@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository repository;
	
	@Transactional(readOnly = true)
	public List<AbastecimentoDTO> findAll() {
	  List<Abastecimento> list = repository.findAll();
	   return list.stream().map(abastecimento -> new AbastecimentoDTO(abastecimento)).collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	public AbastecimentoDTO findById(Long id) {
		Optional<Abastecimento> obj = repository.findById(id);
		Abastecimento abastecimento = obj.orElseThrow(() 
				-> new ResourceNotFoundException(" Abastecimento não localizado"));
		return new AbastecimentoDTO(abastecimento);
		
	}
	@Transactional
	public AbastecimentoDTO insert(AbastecimentoDTO dto) {
		Abastecimento entity = new Abastecimento();
		entity.setCpfMotorista(dto.getCpfMotorista());
		entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
		entity.setQuilometragem(dto.getQuilometragem());
		entity.setCombustivel(dto.getCombustivel());
		entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
		entity.setValorPorLitro(dto.getValorPorLitro());	
	
		entity = repository.save(entity);
		return new AbastecimentoDTO(entity);
	}
	@Transactional
	public AbastecimentoDTO update(Long id, AbastecimentoDTO dto) {
		try {
			Abastecimento entity = repository.getOne(id);
			entity.setCpfMotorista(dto.getCpfMotorista());
			entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
			entity.setQuilometragem(dto.getQuilometragem());
			entity.setCombustivel(dto.getCombustivel());
			entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
			entity.setValorPorLitro(dto.getValorPorLitro());
		
			entity = repository.save(entity);
			return new AbastecimentoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do abastecimento não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O id do abastecimento não foi localizado");

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possivel deletar,pois o mesmo está em uso");
		}		
	}	
}





















