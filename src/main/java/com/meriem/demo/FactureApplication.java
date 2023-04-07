package com.meriem.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.meriem.demo.entities.Facture;
import org.springframework.boot.CommandLineRunner;

import com.meriem.demo.services.FactureService;

@SpringBootApplication
public class FactureApplication implements CommandLineRunner{
	@Autowired
	FactureService factureService;
	

	public static void main(String[] args) {
		SpringApplication.run(FactureApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		factureService.saveFacture(new Facture(new Date(),150.0));
		factureService.saveFacture(new Facture( new Date(),980.0));
		factureService.saveFacture(new Facture( new Date(),780.0));
		
	}

}
