package com.sabtc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sabtc.entities.AutoPosto;

@Repository
public interface AutoPostoRepository extends JpaRepository<AutoPosto,Long> {

}
