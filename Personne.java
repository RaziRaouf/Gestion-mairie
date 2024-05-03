import java.io.Serializable;
import java.time.LocalDate;

public class Personne implements Serializable{
    private int id;
    private String nom;
    private String prenom;
    private String etatCivil;
    private char sexe;
    private int idConjoint;// 0 si elle est célibataire
    private LocalDate birthDate;
    public Personne(String nom,String prenom,String etatCivil,char sexe,LocalDate birthDate){
      this.nom = nom;
      this.prenom = prenom;
      this.etatCivil = etatCivil;
      this.sexe = sexe;
      this.birthDate = birthDate;
    }
    
    
    
    /**
     * @return long return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return String return the etatCivil
     */
    public String getEtatCivil() {
        return etatCivil;
    }

    /**
     * @param etatCivil the etatCivil to set
     */
    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    /**
     * @return char return the sexe
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }
    public void setDate (LocalDate date){
        this.birthDate=date;
    }
    public LocalDate getDate(){
        return getDate();
    }
    public void setIdConjoint(int id){
        this.idConjoint=id;
    }
    public int getIdConjoint(){
        return this.idConjoint;
    }
    public void afficherInfos() {
        System.out.println("Identifiant: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Date de naissance: " + birthDate);
        System.out.println("Sexe: " + sexe);
        System.out.println("État civil: " + etatCivil);
        if (etatCivil.equals("mariée")) {
            System.out.println("Conjoint ID: " + idConjoint);
        }
    }


}