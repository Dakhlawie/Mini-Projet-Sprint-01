package com.meriem.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.meriem.demo.entities.Facture;
import com.meriem.demo.repos.FactureRepository;

import com.meriem.demo.services.FactureService;


@SpringBootTest
class FactureApplicationTests {

	@Autowired
	private FactureRepository factureRepository;
	@Autowired
	private FactureService factureService;
	@Test
	public void testCreateFacture() {
	Facture fact = new Facture(new Date(),180.0);
	factureRepository.save(fact);
	}
	@Test
	public void testFindFacture()
	{
	Facture f = factureRepository.findById(1L).get(); 
	System.out.println(f);
	}
	@Test
	public void testUpdateFacture()
	{
	Facture f = factureRepository.findById(1L).get();
	f.setMontant(150.0);
	factureRepository.save(f);
	}
	@Test
	public void testDeleteFacture()
	{
	factureRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousFactures()
	{
	List<Facture> fact = factureRepository.findAll();
	for (Facture f : fact)
	{
	System.out.println(f);
	}
	}
	@Test
	public void testFindByNomFactureContains()
	{
	Page<Facture> fact = factureService.getAllFacturesParPage(0, 2);
	System.out.println(fact.getSize());
	System.out.println(fact.getTotalElements());
	System.out.println(fact.getTotalPages());
	fact.getContent().forEach(f -> {System.out.println(f.toString());
	 });
	/*ou bien
	for (Facture f : fact.getContent())
	{
	System.out.println(f);
	} */
	}

}
