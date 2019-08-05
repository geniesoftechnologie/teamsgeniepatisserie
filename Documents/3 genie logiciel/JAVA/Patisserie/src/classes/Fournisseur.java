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
public class Fournisseur {
    
    private int idf;
    private String nom;
    private String adresse;
    private String telephone;

    public Fournisseur() {
    }

    public Fournisseur(String nom,String adresse, String telephone) {
        this.nom = nom;
         this.adresse=adresse;
        this.telephone = telephone;
    }

    public Fournisseur(int idf, String nom,String adresse, String telephone) {
        this.idf = idf;
        this.nom = nom;
        this.adresse=adresse;
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    
}
