package com.sabtc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sabtc.entities.Veiculo;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

}
