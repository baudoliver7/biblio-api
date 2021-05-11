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
package com.biblio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Livre.
 * 
 * @since 0.1
 */
@Entity
@Table(name = "livres")
public final class Livre {
	
	/**
	 * Identifiant.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Intitule.
	 */
	@NotBlank(message = "Vous devez saisir l'intitulé de l'ouvrage")
	private String intitule;
	
	/**
	 * Nombre de pages.
	 */
	@Min(value=1, message = "Le nombre de page du livre doit être au moins égale à 1")
	private int nbDePages;
	
	/**
	 * Auteur.
	 */
	@NotBlank(message = "Vous devez saisir le nom de l'auteur du livre")
	private String auteur;
	
	/**
	 * Numéro ISBN.
	 */
	@NotBlank(message = "Veuillez saisir l'ISBN du livre")
	private String isbn;
	
	/**
	 * Le code barre.
	 */
	private String codeBarre;
	
	/**
	 * Resume de l'ouvrage.
	 */
	private String resume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getNbDePages() {
		return nbDePages;
	}

	public void setNbDePages(int nbDePages) {
		this.nbDePages = nbDePages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCodeBarre() {
		return codeBarre;
	}

	public void setCodeBarre(String codeBarre) {
		this.codeBarre = codeBarre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
