 package com.itwins.artisanatshop.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itwins.artisanatshop.models.Vente;
import com.itwins.artisanatshop.repository.VenteRepository; 
 

@Service
@Transactional
public class VenteService {
	
	    private final VenteRepository VenteRepository;
	    public  VenteService (VenteRepository venteRepository){ this.VenteRepository = venteRepository;}
	    public List<Vente> findAll() {
	        return VenteRepository.findAll();
	    }
	    
	    
	    //........................
	    public List<Vente> getVentes() {
			
			
			List<Vente> ventes=new ArrayList<>();
			
			List<Vente> ventesModel=VenteRepository.findAll();

	        for(Vente vente: ventesModel) {

				ventes.add(vente);
			}
			
			return ventes;
		}

}
