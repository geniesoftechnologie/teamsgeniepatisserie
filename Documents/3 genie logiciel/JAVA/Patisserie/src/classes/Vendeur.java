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
public class Vendeur {
    private int idu;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String profil;

    public Vendeur(int idu, String nom, String prenom, String login, String password, String profil) {
        this.idu = idu;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.profil = profil;
    }

    public Vendeur(String nom, String prenom, String login, String password, String profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.profil = profil;
    }

    public Vendeur() {
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
    
    
    
}
