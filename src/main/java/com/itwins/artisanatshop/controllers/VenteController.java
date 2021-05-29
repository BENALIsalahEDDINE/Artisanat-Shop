 package com.itwins.artisanatshop.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwins.artisanatshop.models.Vente;
 
import com.itwins.artisanatshop.services.VenteService;
@RestController
public class VenteController {
	@Autowired
    private VenteService venteService;
	
	    @CrossOrigin()
	    @GetMapping("/Ventes")
	    public List<Vente> Ventes() {
	    
	        
	        List<Vente> ventesResponse= new ArrayList<>();
			
			List<Vente> ventes=venteService.getVentes();
			
			for(Vente vente: ventes) {
				
				ventesResponse.add(vente);
			}
			
			return ventesResponse;
	    }

}
