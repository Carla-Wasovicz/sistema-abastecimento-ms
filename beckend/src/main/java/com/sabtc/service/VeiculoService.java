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

import com.sabtc.DTO.VeiculoDTO;
import com.sabtc.entities.Veiculo;
import com.sabtc.exceptions.DataBaseException;
import com.sabtc.exceptions.ResourceNotFoundException;
import com.sabtc.repository.VeiculoRepository;


@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;
	
	@Transactional(readOnly = true)
	public List<VeiculoDTO> findAll() {
	  List<Veiculo> list = repository.findAll();
	   return list.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	public VeiculoDTO findById(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		Veiculo veiculo = obj.orElseThrow(() 
				-> new ResourceNotFoundException(" Lotacao não localizado"));
		return new VeiculoDTO(veiculo);
		
	}
	@Transactional
	public VeiculoDTO insert(VeiculoDTO dto) {
		Veiculo entity = new Veiculo();
		entity.setAno(dto.getAno());
		entity.setPlaca(dto.getPlaca());
		entity.setRenavan(dto.getRenavan());
		entity.setPatrimonio(dto.getPatrimonio());
		entity.setChassi(dto.getChassi());
		entity.setVersao(dto.getVersao());
		entity.setCapacidadeTanque(dto.getCapacidadeTanque());
		entity.setTipoCombustivel(dto.getTipoCombustivel());
	
		entity = repository.save(entity);
		return new VeiculoDTO(entity);
	}
	@Transactional
	public VeiculoDTO update(Long id, VeiculoDTO dto) {
		try {
			Veiculo entity = repository.getOne(id);
			entity.setAno(dto.getAno());
			entity.setPlaca(dto.getPlaca());
			entity.setRenavan(dto.getRenavan());
			entity.setPatrimonio(dto.getPatrimonio());
			entity.setChassi(dto.getChassi());
			entity.setVersao(dto.getVersao());
			entity.setCapacidadeTanque(dto.getCapacidadeTanque());
			entity.setTipoCombustivel(dto.getTipoCombustivel());
			
			entity = repository.save(entity);
			return new VeiculoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do Veiculo não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O id do Veiculo não foi localizado");

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possivel deletar,pois o mesmo está em uso");
		}		
	}	
	
	

}
