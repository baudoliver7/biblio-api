/**
MIT License

Copyright (c) 2021 Olivier Baudouin OURA

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.biblio.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.biblio.domain.Livre;
import com.biblio.exceptions.LivreIntrouvableException;
import com.biblio.repository.LivreRepository;

/**
 * API Rest des livres.
 * @since 0.1
 */
@RestController
public class LivreController {
	
	/**
	 * Repository des livres.
	 */
	@Autowired
    private LivreRepository livrerepo;
      
	/**
	 * Recupère tous les livres
	 * @return List de livres
	 */
    @GetMapping(value = "/Livres")
    public Iterable<Livre> listAll() {
        return this.livrerepo.findAll();
    }
    
    /**
     * Récupère le livre avec l'id.
     * @param id Identifiant
     * @return Livre
     */
    @GetMapping(value = "/Livres/{id}")
    public Livre afficherUnLivre(@PathVariable int id) {
        final Optional<Livre> livreOpt = this.livrerepo.findById(id);
        if(!livreOpt.isPresent()) {
        	throw new LivreIntrouvableException(String.format("Le livre avec l'ID %s n'a pas été trouvé !", id));
        }
        return livreOpt.get();
    }
    
    /**
     * Modifier un livre.
     * @param livre Livre
     * @return Response entity
     */
    @PostMapping(value = "/Livres")
    public ResponseEntity<Livre> ajouterUnLivre(@Valid @RequestBody Livre livre) {
        Livre added =  this.livrerepo.save(livre);
        return new ResponseEntity<Livre>(added, HttpStatus.CREATED);
    }

    /**
     * Modifier un livre.
     * @param id Identifiant
     * @param livre Livre
     * @return Response entity
     */
    @PutMapping(value = "/Livres{id}")
    public ResponseEntity<Livre> modifierUnLivre(@PathVariable int id, @Valid @RequestBody Livre livreDetails) {
    	final Optional<Livre> livreOpt = this.livrerepo.findById(id);
        if(!livreOpt.isPresent()) {
        	throw new LivreIntrouvableException(String.format("Le livre à modifier avec l'ID %s n'a pas été trouvé !", id));
        }
    	Livre livre =  livreOpt.get();
    	livre.setAuteur(livreDetails.getAuteur());
    	livre.setCodeBarre(livreDetails.getCodeBarre());
    	livre.setIntitule(livreDetails.getIntitule());
    	livre.setIsbn(livreDetails.getIsbn());
    	livre.setNbDePages(livreDetails.getNbDePages());
    	livre.setResume(livreDetails.getResume());
    	final Livre updateLivre = this.livrerepo.save(livre);
    	return ResponseEntity.ok(updateLivre);
    }
    
    /**
     * Supprime le livre avec l'id.
     * @param id Identifiant
     * @return Response entity
     */
    @DeleteMapping(value = "/Livres/{id}")
    public ResponseEntity<Void> supprimerUnLivre(@PathVariable int id) {
    	this.livrerepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
