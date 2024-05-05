package mairie;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class GestionMairie implements Serializable{
	 private List<Personne> liste = new ArrayList<>();
	 private int dernierId = 0; // Nouvelle variable pour stocker le dernier ID utilisé
	   public void addPersonne(Personne personne) {
	        if (personne != null) {
	            liste.add(personne);
	        } else {
	            System.out.println("La personne est null !");
	        }
	    }
	   private Personne getPersonById(int id) {
	        for (Personne personne : liste) {
	            if (personne.getId() == id) {
	                return personne;
	            }
	        }
	        return null;
	    }

	    public void mariage(int id1, int id2) {
	        Personne personne1 = getPersonById(id1);
	        Personne personne2 = getPersonById(id2);

	        if (personne1 != null && personne2 != null) {
	            if (!personne1.getEtatCivil().equals("mariée") && !personne2.getEtatCivil().equals("mariée")) {
	                System.out.println("Félicitations pour le mariage !");
	                personne1.setIdConjoint(personne2.getId());
	                personne2.setIdConjoint(personne1.getId());
	                personne1.setEtatCivil("mariée");
	                personne2.setEtatCivil("mariée");
	            } else {
	                System.out.println("Les personnes sont déjà mariées !");
	            }
	        } else {
	            System.out.println("Les identifiants saisis sont incorrects !");
	        }
	    }

	    public void divorce(int id) {
	        Personne personne = getPersonById(id);

	        if (personne != null) {
	            if (personne.getEtatCivil().equals("mariée")) {
	                personne.setEtatCivil("divorcée");
	                Personne conjoint = getPersonById(personne.getIdConjoint());
	                conjoint.setEtatCivil("divorcé");
	                personne.setIdConjoint(conjoint.getId());
	                conjoint.setIdConjoint(personne.getId());
	                System.out.println("Divorce effectué avec succès !");
	            } else {
	                System.out.println("La personne n'est pas mariée !");
	            }
	        } else {
	            System.out.println("La personne est introuvable !");
	        }
	    }

	    public void nouveauNe(int id1, int id2, String nom, String prenom, char sexe, LocalDate dateNaissance) {
	        Personne personne1 = getPersonById(id1);
	        Personne personne2 = getPersonById(id2);

	        if (personne1 != null && personne2 != null) {
	            // Générer un identifiant unique pour le nouveau-né
	            int idNouveauNe = ++dernierId;
	            
	            // Créer la personne nouveau-né
	            Personne nouveauNe = new Personne(nom, prenom, "célibataire", sexe, dateNaissance);
	            nouveauNe.setId(idNouveauNe);
	            nouveauNe.setIdConjoint(0);
	            
	            // Ajouter le nouveau-né à la liste des personnes
	            addPersonne(nouveauNe);
	            System.out.println("Nouveau-né ajouté avec succès !");
	        } else {
	            System.out.println("Les deux parents sont introuvables !");
	        }
	    }


	    public void affichePersonne(int id) {
	        Personne person = getPersonById(id);
	        if (person != null) {
	            person.afficherInfos();
	        } else {
	            System.out.println("Personne introuvable !");
	        }
	    }

	    public void affichePersonnes() {
	        for (Personne person : liste) {
	            person.afficherInfos();
	        }
	    }

	    public void saisiePersonne(String nom, String prenom, char sexe, LocalDate dateNaissance, String etatCivil) {
	        
	        int idNouvellePersonne = liste.size() + 1; 
	        Personne nouvellePersonne = new Personne(nom, prenom, etatCivil, sexe, dateNaissance);
	        nouvellePersonne.setId(idNouvellePersonne);
	        liste.add(nouvellePersonne);
	        System.out.println("Personne ajoutée avec succès !");
	    }
    public void sauvegarderDonnees(String nomFichier) {
        try {
            FileOutputStream fos = new FileOutputStream(nomFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(liste);
            oos.close();
            fos.close();
            System.out.println("Données sauvegardées avec succès dans le fichier " + nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chargerDonnees(String nomFichier) {
        try {
            FileInputStream fis = new FileInputStream(nomFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            liste = (List<Personne>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Données chargées avec succès depuis le fichier " + nomFichier);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}