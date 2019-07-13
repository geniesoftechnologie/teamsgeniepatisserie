/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author bureau
 */
public class Aeroport {
    private int id;
    private int id_ville;
    private String nom_ville;
    private String nom;

    public Aeroport() {
    }

    public Aeroport(int id_ville, String nom_ville, String nom) {
        this.id_ville = id_ville;
        this.nom_ville = nom_ville;
        this.nom = nom;
    }

    public Aeroport(int id, int id_ville, String nom_ville, String nom) {
        this.id = id;
        this.id_ville = id_ville;
        this.nom_ville = nom_ville;
        this.nom = nom;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }
    
    
    
}
