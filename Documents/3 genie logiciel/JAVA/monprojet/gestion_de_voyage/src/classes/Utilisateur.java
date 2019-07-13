/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author bureau
 */
public class Utilisateur {
    private int id;
    private int id_profil;
    private int id_typepieceident;
    private String nom;
    private String prenom;
    private String sexe;
    private Date datenaissance;
    private String telephone;
    private String email;
    private String codepieceident;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String sexe, Date datenaissance, String telephone, String email, String codepieceident) {
       this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datenaissance = datenaissance;
        this.telephone = telephone;
        this.email = email;
        this.codepieceident = codepieceident;
    }

    public Utilisateur(int id, int id_profil, int id_typepieceident, String nom, String prenom, String sexe, Date datenaissance, String telephone, String email, String codepieceident) {
        this.id = id;
        this.id_profil = id_profil;
        this.id_typepieceident = id_typepieceident;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.datenaissance = datenaissance;
        this.telephone = telephone;
        this.email = email;
        this.codepieceident = codepieceident;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_profil() {
        return id_profil;
    }

    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }

    public int getId_typepieceident() {
        return id_typepieceident;
    }

    public void setId_typepieceident(int id_typepieceident) {
        this.id_typepieceident = id_typepieceident;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodepieceident() {
        return codepieceident;
    }

    public void setCodepieceident(String codepieceident) {
        this.codepieceident = codepieceident;
    }
    
}
