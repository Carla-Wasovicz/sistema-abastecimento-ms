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
import com.sabtc.DTO.AutoPostoDTO;
import com.sabtc.entities.AutoPosto;
import com.sabtc.exceptions.DataBaseException;
import com.sabtc.exceptions.ResourceNotFoundException;
import com.sabtc.repository.AutoPostoRepository;

@Service
public class AutoPostoService {
	@Autowired
	private AutoPostoRepository repository;
	
	@Transactional(readOnly = true)
	public List<AutoPostoDTO> findAll() {
		  List<AutoPosto> list = repository.findAll();
		   return list.stream().map(autoPosto -> new AutoPostoDTO(autoPosto)).collect(Collectors.toList());
		}
	@Transactional(readOnly = true)
	public AutoPostoDTO findById(Long id) {
		Optional<AutoPosto> obj = repository.findById(id);
		AutoPosto autoPosto = obj.orElseThrow(() 
				-> new ResourceNotFoundException(" Auto Posto não localizado"));
		return new AutoPostoDTO(autoPosto);
		
	}
	@Transactional
	public AutoPostoDTO insert(AutoPostoDTO dto) {
		AutoPosto entity = new AutoPosto();
		entity.setNomeFantasia(dto.getNomeFantasia());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setCNPJ(dto.getCNPJ());
		entity.setEndereco(dto.getEndereco());
	
		entity = repository.save(entity);
		return new AutoPostoDTO(entity);
	}
	@Transactional
	public AutoPostoDTO update(Long id, AutoPostoDTO dto) {
		try {
			AutoPosto entity = repository.getOne(id);
			entity.setNomeFantasia(dto.getNomeFantasia());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setCNPJ(dto.getCNPJ());
			entity.setEndereco(dto.getEndereco());
		
			entity = repository.save(entity);
			return new AutoPostoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do Auto Posto não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O id do Auto Posto não foi localizado");

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possivel deletar,pois o mesmo está em uso");
		}		
	}	
}
		

