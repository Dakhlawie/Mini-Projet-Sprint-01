package com.meriem.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private Date dateEmission;
	private Double montant;
	public Facture() {
		super();
		
	}
	public Facture(Date dateEmission, Double montant) {
		super();
		this.dateEmission = dateEmission;
		this.montant = montant;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", dateEmission=" + dateEmission + ", montant=" + montant + "]";
	}
	
	

}
