package com.ManEcole;

import java.util.*;

public class Ecole {
	private List<Classe> classes;
	private List<Matiere> matieres;

	public Ecole() {
		this.classes = new ArrayList<>();
		this.matieres = new ArrayList<>();
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void ajouterClasse(Classe classe) {
		classes.add(classe);
	}

	public void ajouterMatiere(Matiere matiere) {
		matieres.add(matiere);
	}
}
