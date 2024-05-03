import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        
        // Création d'une instance de GestionMairie
        GestionMairie gestionMairie = new GestionMairie();

        // Création de quelques personnes
        Personne personne1 = new Personne("Dupont", "Jean", "célibataire", 'M', LocalDate.of(1980, 5, 15));
        Personne personne2 = new Personne("Durand", "Marie", "célibataire", 'F', LocalDate.of(1985, 8, 20));
        Personne personne3 = new Personne("Martin", "Pierre", "célibataire", 'M', LocalDate.of(1990, 12, 10));
        Personne personne4 = new Personne("Dubois", "Sophie", "célibataire", 'F', LocalDate.of(1988, 3, 25));

        // Ajout des personnes à la liste de la mairie
        gestionMairie.addPersonne(personne1);
        gestionMairie.addPersonne(personne2);
        gestionMairie.addPersonne(personne3);
        gestionMairie.addPersonne(personne4);

        // Affichage de la liste des personnes avant mariage
        System.out.println("Liste des personnes avant mariage :");
        gestionMairie.affichePersonnes();
        System.out.println();

        // Test du mariage
        gestionMairie.mariage(personne1.getId(), personne2.getId());

        // Affichage de la liste des personnes après mariage
        System.out.println("Liste des personnes après mariage :");
        gestionMairie.affichePersonnes();
        System.out.println();

        // Test du divorce
        gestionMairie.divorce(personne1.getId());

        // Affichage de la liste des personnes après divorce
        System.out.println("Liste des personnes après divorce :");
        gestionMairie.affichePersonnes();
        System.out.println();

        // Test de l'ajout d'un nouveau-né
        System.out.println("Ajout d'un nouveau-né :");
        gestionMairie.nouveauNe(personne3.getId(), personne4.getId());

        // Affichage de la liste des personnes après l'ajout du nouveau-né
        System.out.println("Liste des personnes après ajout du nouveau-né :");
        gestionMairie.affichePersonnes();
        System.out.println();

        // Test de l'affichage d'une personne
        System.out.println("Affichage d'une personne :");
        gestionMairie.affichePersonne(personne3.getId());

    }
}
