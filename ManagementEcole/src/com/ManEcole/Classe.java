package com.ManEcole;

import java.util.*;

public class Classe {
	private String nom;
	private List<Etudiant> etudiants;

	public Classe(String nom) {
		this.nom = nom;
		this.etudiants = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void ajouterEtudiant(Etudiant etudiant) {
		etudiants.add(etudiant);
	}

	public Etudiant trouverEtudiant(String nomEtudiant) {
		for (Etudiant etudiant : etudiants) {
			if (etudiant.getNom().equals(nomEtudiant)) {
				return etudiant;
			}
		}
		return null;
	}
}
