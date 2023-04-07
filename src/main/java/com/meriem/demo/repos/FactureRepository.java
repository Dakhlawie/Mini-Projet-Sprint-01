package com.meriem.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriem.demo.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long>{

}
