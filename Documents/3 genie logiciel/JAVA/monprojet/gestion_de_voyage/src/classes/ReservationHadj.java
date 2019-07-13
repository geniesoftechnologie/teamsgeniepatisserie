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
public class ReservationHadj {
    private int id;
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private String passport;
    private int id_vol;
    private String nom_aero;
    private Date datedepart;
    private Date datearrivee;
    private String heurdepart;
    private String heurarrivee;
    private String nom_aero_ar;
    private int prix;
    private Date dater;
    private int idf;

    public ReservationHadj() {
    }

    public ReservationHadj(int id_utilisateur, String nom, String prenom, String passport, int id_vol, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, String nom_aero_ar, int prix, Date dater, int idf) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.passport = passport;
        this.id_vol = id_vol;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.nom_aero_ar = nom_aero_ar;
        this.prix = prix;
        this.dater = dater;
        this.idf = idf;
    }

    public ReservationHadj(int id_utilisateur, String nom, String prenom, String passport, int id_vol, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, String nom_aero_ar, int prix, Date dater) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.passport = passport;
        this.id_vol = id_vol;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.nom_aero_ar = nom_aero_ar;
        this.prix = prix;
        this.dater = dater;
    }

    public ReservationHadj(int id, int id_utilisateur, String nom, String prenom, String passport, int id_vol, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, String nom_aero_ar, int prix, Date dater) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.passport = passport;
        this.id_vol = id_vol;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.nom_aero_ar = nom_aero_ar;
        this.prix = prix;
        this.dater = dater;
    }

    
    public ReservationHadj(String nom, String prenom, String passport, int id_vol, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, String nom_aero_ar, int prix, Date dater) {
        this.nom = nom;
        this.prenom = prenom;
        this.passport = passport;
        this.id_vol = id_vol;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.nom_aero = nom_aero_ar;
        this.prix = prix;
        this.dater = dater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public String getNom_aero() {
        return nom_aero;
    }

    public void setNom_aero(String nom_aero) {
        this.nom_aero = nom_aero;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public Date getDatearrivee() {
        return datearrivee;
    }

    public void setDatearrivee(Date datearrivee) {
        this.datearrivee = datearrivee;
    }

    public String getHeurdepart() {
        return heurdepart;
    }

    public void setHeurdepart(String heurdepart) {
        this.heurdepart = heurdepart;
    }

    public String getHeurarrivee() {
        return heurarrivee;
    }

    public void setHeurarrivee(String heurarrivee) {
        this.heurarrivee = heurarrivee;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDater() {
        return dater;
    }

    public void setDater(Date dater) {
        this.dater = dater;
    }

    public String getNom_aero_ar() {
        return nom_aero_ar;
    }

    public void setNom_aero_ar(String nom_aero_ar) {
        this.nom_aero_ar = nom_aero_ar;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

        
}
