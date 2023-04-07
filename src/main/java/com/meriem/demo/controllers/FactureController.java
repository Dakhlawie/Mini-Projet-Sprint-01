package com.meriem.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meriem.demo.entities.Facture;

import com.meriem.demo.services.FactureService;

@Controller
public class FactureController {
	@Autowired
	FactureService factureService;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createFacture";
	}
	@RequestMapping("/saveFacture")
	public String saveFacture(@ModelAttribute("Facture")Facture facture,@RequestParam("date") String date,ModelMap modelMap)throws ParseException{
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateEmission = dateformat.parse(String.valueOf(date));
		 facture.setDateEmission(dateEmission);
		 Facture saveFacture=factureService.saveFacture(facture);
		 String msg ="Facture enregistré avec Id "+saveFacture.getIdFacture();
			modelMap.addAttribute("msg", msg);
			return "createFacture";
	}
@RequestMapping("/ListeFactures")
public String listeFactures(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "3") int size)
{
	Page<Facture> fact = factureService.getAllFacturesParPage(page, size);
	modelMap.addAttribute("factures", fact);
	 modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeFactures";

}
@RequestMapping("/supprimerFacture")
public String supprimerFacture(@RequestParam("id") Long id,
 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{ 
factureService.deleteFactureById(id);
Page<Facture> fact = factureService.getAllFacturesParPage(page, size);
		modelMap.addAttribute("factures", fact);
		modelMap.addAttribute("pages", new int[fact.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

return "listeFactures";
}
@RequestMapping("/modifierFacture")
public String editerFacture(@RequestParam("id") Long id,ModelMap modelMap)
{
Facture f= factureService.getFacture(id);
modelMap.addAttribute("facture", f);
return "editerFacture";
}
@RequestMapping("/updateFacture")
public String updateFacture(@ModelAttribute("facture") Facture facture,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
	 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateEmission = dateformat.parse(String.valueOf(date));
	 facture.setDateEmission(dateEmission);
	 
	factureService.updateFacture(facture);
	 List<Facture> fact = factureService.getAllFactures();
	 modelMap.addAttribute("factures", fact);
	return "listeFactures";
	}
}
