package com.ManEcole;

import java.util.*;

public class Etudiant {
	private String nom;
	private List<Note> notes;

	public Etudiant(String nom) {
		this.nom = nom;
		this.notes = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void ajouterNote(Matiere matiere, double valeur) {
		notes.add(new Note(matiere, valeur));
	}

	public double calculerMoyenneMatiere(Matiere matiere) {
		double total = 0;
		int count = 0;
		for (Note note : notes) {
			if (note.getMatiere().equals(matiere)) {
				total += note.getValeur();
				count++;
			}
		}
		return count > 0 ? total / count : 0;
	}

	public double calculerMoyenneGenerale() {
		double total = 0;
		for (Note note : notes) {
			total += note.getValeur();
		}
		return notes.size() > 0 ? total / notes.size() : 0;
	}

	public Map<String, Double> getNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNoteMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String calculerMoyenne() {
		// TODO Auto-generated method stub
		return null;
	}
}
