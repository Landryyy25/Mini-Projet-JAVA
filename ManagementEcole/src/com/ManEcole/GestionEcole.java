package com.ManEcole;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class GestionEcole {

	private Ecole ecole;
	private Scanner scanner;
	private String adminUsername = "admin";
	private String adminPassword = "password";
	private boolean isAuthenticated;

	public GestionEcole() {
		this.ecole = new Ecole();
		this.scanner = new Scanner(System.in);
		this.isAuthenticated = false;
	}

	public void demarrer() {
		while (true) {
			if (authentifier()) {
				menuPrincipal();
			} else {
				System.out.println("Authentification échouée. Voulez-vous réessayer ? (O/N)");
				String reponse = scanner.nextLine();
				if (!reponse.equalsIgnoreCase("O")) {
					System.out.println("Au revoir !");
					return;
				}
			}
		}
	}

	private boolean authentifier() {
		System.out.println("\n=========================================================");
		System.out.println("\n                  *   CONNEXION   *              ");
		System.out.println("\n=========================================================");
		System.out.println("");
		System.out.print("         Nom d'utilisateur : ");
		String nom = scanner.nextLine();
		System.out.print("         Mot de passe : ");
		String motDePasse = scanner.nextLine();
		System.out.println("\n=========================================================");

		if (adminUsername.equals(nom) && adminPassword.equals(motDePasse)) {
			isAuthenticated = true;
			System.out.println("Connexion réussie. Bienvenue, " + nom + " !");
			return true;
		} else {
			System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
			return false;
		}
	}

	public void menuPrincipal() {
		while (true) {
			System.out.println("\n=========================================================");
			System.out.println("\n              *   MENU PRINCIPAL   *              ");
			System.out.println("\n=========================================================");
			System.out.println("");
			System.out.println("           1. Gérer les classes");
			System.out.println("           2. Gérer les étudiants");
			System.out.println("           3. Gérer les matières");
			System.out.println("           4. Enregistrer les notes");
			System.out.println("           5. Afficher les moyennes");
			System.out.println("           6. Afficher le classement");
			System.out.println("           7. Gérer les bulletins de notes");
			System.out.println("           0. Déconnexion");
			System.out.println("");
			System.out.print("             Choisissez une option : ");
			System.out.println("");
			System.out.println("");
			System.out.println("\n=========================================================");

			int choix = scanner.nextInt();
			scanner.nextLine(); // Consommer la nouvelle ligne

			switch (choix) {
			case 1:
				menuClasses();
				break;
			case 2:
				menuEtudiants();
				break;
			case 3:
				menuMatieres();
				break;
			case 4:
				menuNotes();
				break;
			case 5:
				afficherMoyennes();
				break;
			case 6:
				menuClassement();
				break;
			case 7:
				genererBulletins();
				break;
			case 0:
				System.out.println("Déconnexion...");
				isAuthenticated = false;
				return;
			default:
				System.out.println("Option invalide. Veuillez réessayer.");
			}
		}
	}

	private void menuClasses() {
		while (true) {
			System.out.println("\n=========================================================");
			System.out.println("\n              *   Gestion des Classes   *              ");
			System.out.println("\n=========================================================");
			System.out.println("");
			System.out.println("           1. Ajouter une classe");
			System.out.println("           2. Afficher les classes");
			System.out.println("           0. Retour au menu principal");
			System.out.println("");
			System.out.print("             Choisissez une option : ");
			System.out.println("");
			System.out.println("");
			System.out.println("\n=========================================================");

			int choix = scanner.nextInt();
			scanner.nextLine(); // Consommer la nouvelle ligne

			switch (choix) {
			case 1:
				System.out.print("Nom de la nouvelle classe : ");
				String nomClasse = scanner.nextLine();
				ajouterClasse(nomClasse);
				System.out.println("Classe ajoutée avec succès.");
				break;
			case 2:
				afficherClasses();
				break;
			case 0:
				return;
			default:
				System.out.println("Option invalide. Veuillez réessayer.");
			}
		}
	}

	private void menuEtudiants() {
		while (true) {
			System.out.println("\n=========================================================");
			System.out.println("\n              *   Gestion des Étudiants   *              ");
			System.out.println("\n=========================================================");
			System.out.println("");
			System.out.println("           1. Ajouter un étudiant");
			System.out.println("           2. Afficher les étudiants par classe");
			System.out.println("           0. Retour au menu principal");
			System.out.println("");
			System.out.print("             Choisissez une option : ");
			System.out.println("");
			System.out.println("");
			System.out.println("\n=========================================================");

			int choix = scanner.nextInt();
			scanner.nextLine(); // Consommer la nouvelle ligne

			switch (choix) {
			case 1:
				System.out.print("Nom de la classe : ");
				String nomClasse = scanner.nextLine();
				System.out.print("Nom de l'étudiant : ");
				String nomEtudiant = scanner.nextLine();
				ajouterEtudiant(nomClasse, nomEtudiant);
				System.out.println("Étudiant ajouté avec succès.");
				break;
			case 2:
				afficherEtudiantsParClasse();
				break;
			case 0:
				return;
			default:
				System.out.println("Option invalide. Veuillez réessayer.");
			}
		}
	}

	private void menuMatieres() {
		while (true) {
			System.out.println("\n=========================================================");
			System.out.println("\n              *   Gestion des Matières   *              ");
			System.out.println("\n=========================================================");
			System.out.println("");
			System.out.println("           1. Ajouter une matière");
			System.out.println("           2. Afficher les matières");
			System.out.println("           0. Retour au menu principal");
			System.out.println("");
			System.out.print("             Choisissez une option : ");
			System.out.println("");
			System.out.println("");
			System.out.println("\n=========================================================");

			int choix = scanner.nextInt();
			scanner.nextLine(); // Consommer la nouvelle ligne

			switch (choix) {
			case 1:
				System.out.print("Nom de la nouvelle matière : ");
				String nomMatiere = scanner.nextLine();
				ajouterMatiere(nomMatiere);
				System.out.println("Matière ajoutée avec succès.");
				break;
			case 2:
				afficherMatieres();
				break;
			case 0:
				return;
			default:
				System.out.println("Option invalide. Veuillez réessayer.");
			}
		}
	}

	private void menuNotes() {
		System.out.print("Nom de la classe : ");
		String nomClasse = scanner.nextLine();
		System.out.print("Nom de la matière : ");
		String nomMatiere = scanner.nextLine();

		Classe classe = trouverClasse(nomClasse);
		Matiere matiere = trouverMatiere(nomMatiere);

		if (classe == null || matiere == null) {
			System.out.println("Classe ou matière introuvable.");
			return;
		}

		Map<String, Double> notes = new HashMap<>();
		for (Etudiant etudiant : classe.getEtudiants()) {
			System.out.print("Note pour " + etudiant.getNom() + " : ");
			double note = scanner.nextDouble();
			notes.put(etudiant.getNom(), note);
		}
		scanner.nextLine(); // Consommer la nouvelle ligne

		enregistrerNotes(nomClasse, nomMatiere, notes);
		System.out.println("Notes enregistrées avec succès.");
	}

	private void menuClassement() {
		System.out.print("Nom de la matière pour le classement : ");
		String nomMatiere = scanner.nextLine();
		afficherClassement(nomMatiere);
	}

	public void ajouterClasse(String nom) {
		ecole.ajouterClasse(new Classe(nom));
	}

	public void ajouterEtudiant(String nomClasse, String nomEtudiant) {
		Classe classe = trouverClasse(nomClasse);
		if (classe != null) {
			classe.ajouterEtudiant(new Etudiant(nomEtudiant));
		} else {
			System.out.println("Classe non trouvée.");
		}
	}

	public void ajouterMatiere(String nom) {
		ecole.ajouterMatiere(new Matiere(nom));
	}

	public void enregistrerNotes(String nomClasse, String nomMatiere, Map<String, Double> notes) {
		Classe classe = trouverClasse(nomClasse);
		Matiere matiere = trouverMatiere(nomMatiere);
		if (classe != null && matiere != null) {
			for (Etudiant etudiant : classe.getEtudiants()) {
				Double note = notes.get(etudiant.getNom());
				if (note != null) {
					etudiant.ajouterNote(matiere, note);
				}
			}
		} else {
			System.out.println("Classe ou matière introuvable.");
		}
	}

	public void afficherMoyennes() {
		for (Classe classe : ecole.getClasses()) {
			System.out.println("Classe : " + classe.getNom());
			for (Etudiant etudiant : classe.getEtudiants()) {
				System.out.println("  Étudiant : " + etudiant.getNom());
				System.out.println("    Moyenne : " + etudiant.calculerMoyenneGenerale());
			}
		}
	}

	public void afficherClassement(String nomMatiere) {
		Matiere matiere = trouverMatiere(nomMatiere);
		if (matiere == null) {
			System.out.println("Matière non trouvée.");
			return;
		}

		List<Etudiant> tousLesEtudiants = new ArrayList<>();
		for (Classe classe : ecole.getClasses()) {
			tousLesEtudiants.addAll(classe.getEtudiants());
		}

		tousLesEtudiants.sort((e1, e2) -> Double.compare(e2.getNoteMatiere(matiere), e1.getNoteMatiere(matiere)));

		System.out.println("Classement pour la matière " + nomMatiere + " :");
		for (int i = 0; i < tousLesEtudiants.size(); i++) {
			Etudiant etudiant = tousLesEtudiants.get(i);
			System.out.println((i + 1) + ". " + etudiant.getNom() + " - Note : " + etudiant.getNoteMatiere(matiere));
		}
	}

	public void afficherClasses() {
		for (Classe classe : ecole.getClasses()) {
			System.out.println("Classe : " + classe.getNom());
		}
	}

	public void afficherEtudiantsParClasse() {
		for (Classe classe : ecole.getClasses()) {
			System.out.println("Classe : " + classe.getNom());
			for (Etudiant etudiant : classe.getEtudiants()) {
				System.out.println("  Étudiant : " + etudiant.getNom());
			}
		}
	}

	public void afficherMatieres() {
		for (Matiere matiere : ecole.getMatieres()) {
			System.out.println("Matière : " + matiere.getNom());
		}
	}

	public void genererBulletins() {
		for (Classe classe : ecole.getClasses()) {
			for (Etudiant etudiant : classe.getEtudiants()) {
				try (PrintWriter writer = new PrintWriter(new FileWriter(etudiant.getNom() + "_bulletin.txt"))) {
					writer.println("Bulletin de notes de " + etudiant.getNom());
					writer.println("Classe : " + classe.getNom());
					for (Entry<String, Double> note : etudiant.getNotes().entrySet()) {
						writer.println(note.getKey().getClass() + " : " + note.getValue());
					}
					writer.println("Moyenne générale : " + etudiant.calculerMoyenne());
				} catch (IOException e) {
					System.out.println("Erreur lors de la génération du bulletin de " + etudiant.getNom());
				}
			}
		}
		System.out.println("Bulletins générés avec succès.");
	}

	private Classe trouverClasse(String nomClasse) {
		for (Classe classe : ecole.getClasses()) {
			if (classe.getNom().equals(nomClasse)) {
				return classe;
			}
		}
		return null;
	}

	private Matiere trouverMatiere(String nomMatiere) {
		for (Matiere matiere : ecole.getMatieres()) {
			if (matiere.getNom().equals(nomMatiere)) {
				return matiere;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		GestionEcole gestionEcole = new GestionEcole();
		gestionEcole.demarrer();
	}
}
