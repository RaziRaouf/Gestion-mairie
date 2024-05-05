package Gui;

import javax.swing.*;

import mairie.GestionMairie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class GestionMairieGUI extends JFrame {
    private GestionMairie gestionMairie;

    public GestionMairieGUI() {
        gestionMairie = new GestionMairie();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestion de la Mairie");
        setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton mariageButton = new JButton("Mariage");
        mariageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id1 = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'ID de la première personne :"));
                int id2 = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'ID de la deuxième personne :"));
                gestionMairie.mariage(id1, id2);
            }
        });
        panel.add(mariageButton);

        JButton divorceButton = new JButton("Divorce");
        divorceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'ID de la personne à divorcer :"));
                gestionMairie.divorce(id);
            }
        });
        panel.add(divorceButton);

        JButton nouveauNeButton = new JButton("Nouveau-né");
        nouveauNeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nouveauNeDialog();
            }
        });
        panel.add(nouveauNeButton);

        JButton afficherPersonnesButton = new JButton("Afficher les personnes");
        afficherPersonnesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMairie.affichePersonnes();
            }
        });
        panel.add(afficherPersonnesButton);

        JButton ajouterPersonneButton = new JButton("Ajouter une personne");
        ajouterPersonneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saisiePersonne();
            }
        });
        panel.add(ajouterPersonneButton);

        JButton quitterButton = new JButton("Quitter");
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(quitterButton);

        add(panel);
        setVisible(true);
    }

    private void saisiePersonne() {
        String nom = JOptionPane.showInputDialog("Entrez le nom de la personne :");
        String prenom = JOptionPane.showInputDialog("Entrez le prénom de la personne :");
        char sexe = JOptionPane.showInputDialog("Entrez le sexe de la personne (M/F) :").charAt(0);
        String dateStr = JOptionPane.showInputDialog("Entrez la date de naissance de la personne (YYYY-MM-DD) :");
        LocalDate dateNaissance = LocalDate.parse(dateStr);
        gestionMairie.saisiePersonne(nom, prenom, sexe, dateNaissance, "célibataire");
    }

    private void nouveauNeDialog() {
        JTextField parent1Field = new JTextField(5);
        JTextField parent2Field = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("ID Parent 1:"));
        myPanel.add(parent1Field);
        myPanel.add(new JLabel("ID Parent 2:"));
        myPanel.add(parent2Field);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Entrez les identifiants des parents", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int parent1ID = Integer.parseInt(parent1Field.getText());
            int parent2ID = Integer.parseInt(parent2Field.getText());

            // Passer les identifiants des parents à la méthode pour afficher la boîte de dialogue des informations du nouveau-né
            nouveauNeInfoDialog(parent1ID, parent2ID);
        }
    }

    private void nouveauNeInfoDialog(int parent1ID, int parent2ID) {
        JTextField nomField = new JTextField(10);
        JTextField prenomField = new JTextField(10);
        JTextField sexeField = new JTextField(1);
        JTextField dateNaissanceField = new JTextField(10);

        JPanel nouveauNePanel = new JPanel(new GridLayout(5, 2));
        nouveauNePanel.add(new JLabel("Nom:"));
        nouveauNePanel.add(nomField);
        nouveauNePanel.add(new JLabel("Prénom:"));
        nouveauNePanel.add(prenomField);
        nouveauNePanel.add(new JLabel("Sexe (M/F):"));
        nouveauNePanel.add(sexeField);
        nouveauNePanel.add(new JLabel("Date de naissance (YYYY-MM-DD):"));
        nouveauNePanel.add(dateNaissanceField);

        int result = JOptionPane.showConfirmDialog(null, nouveauNePanel, "Saisir les informations du nouveau-né", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Récupérer les informations saisies et les passer à la méthode nouveauNe de GestionMairie
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            char sexe = sexeField.getText().charAt(0);
            String dateStr = dateNaissanceField.getText();
            LocalDate dateNaissance = LocalDate.parse(dateStr);
            
            // Appeler la méthode nouveauNe de GestionMairie avec les informations du nouveau-né
            gestionMairie.nouveauNe(parent1ID, parent2ID, nom, prenom, sexe, dateNaissance);
        }
    }

    public static void main(String[] args) {
        new GestionMairieGUI();
    }
}
