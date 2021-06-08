package com.sabtc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sabtc.entities.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento,Long>{
	

}
