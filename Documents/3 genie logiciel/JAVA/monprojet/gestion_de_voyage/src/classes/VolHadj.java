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
public class VolHadj {
    private int id;
    private int id_avion;
    private int id_aeroport;
    private String nom_aero;
    private Date datedepart;
    private Date datearrivee;
    private String heurdepart;
    private String heurarrivee;
    private int prix;
    private int nbplacereserve;
    private int id_aeroport_ar;
    private String nom_aero_ar;
    private int duree;
    private int etat;

    public VolHadj() {
    }

    public VolHadj(int etat) {
        this.etat = etat;
    }

    public VolHadj(int id_avion, int id_aeroport, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, int prix, int nbplacereserve, int id_aeroport_ar, String nom_aero_ar, int duree, int etat) {
        this.id_avion = id_avion;
        this.id_aeroport = id_aeroport;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.prix = prix;
        this.nbplacereserve = nbplacereserve;
        this.id_aeroport_ar = id_aeroport_ar;
        this.nom_aero_ar = nom_aero_ar;
        this.duree = duree;
        this.etat = etat;
    }

    public VolHadj(int id, int id_avion, int id_aeroport, String nom_aero, Date datedepart, Date datearrivee, String heurdepart, String heurarrivee, int prix, int nbplacereserve, int id_aeroport_ar, String nom_aero_ar, int duree, int etat) {
        this.id = id;
        this.id_avion = id_avion;
        this.id_aeroport = id_aeroport;
        this.nom_aero = nom_aero;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.heurdepart = heurdepart;
        this.heurarrivee = heurarrivee;
        this.prix = prix;
        this.nbplacereserve = nbplacereserve;
        this.id_aeroport_ar = id_aeroport_ar;
        this.nom_aero_ar = nom_aero_ar;
        this.duree = duree;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public int getId_aeroport() {
        return id_aeroport;
    }

    public void setId_aeroport(int id_aeroport) {
        this.id_aeroport = id_aeroport;
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

    public int getNbplacereserve() {
        return nbplacereserve;
    }

    public void setNbplacereserve(int nbplacereserve) {
        this.nbplacereserve = nbplacereserve;
    }

    public int getId_aeroport_ar() {
        return id_aeroport_ar;
    }

    public void setId_aeroport_ar(int id_aeroport_ar) {
        this.id_aeroport_ar = id_aeroport_ar;
    }

    public String getNom_aero_ar() {
        return nom_aero_ar;
    }

    public void setNom_aero_ar(String nom_aero_ar) {
        this.nom_aero_ar = nom_aero_ar;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    
}
