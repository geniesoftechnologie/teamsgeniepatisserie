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
public class Avion {
    private int id;
    private int id_compagnie;
    private String nom_compagnie;
    private String nom;
    private Date dateentree;
    private int etat;
    private int nbplace;
    private byte[] pic;
    private int uid;

    public Avion() {
    }

    public Avion(int id_compagnie, String nom_compagnie, String nom, Date dateentree, int etat, int nbplace, byte[] pic) {
        this.id_compagnie = id_compagnie;
        this.nom_compagnie = nom_compagnie;
        this.nom = nom;
        this.dateentree = dateentree;
        this.etat = etat;
        this.nbplace = nbplace;
        this.pic = pic;
    }

    public Avion(int id, int id_compagnie, String nom_compagnie, String nom, Date dateentree, int etat, int nbplace, byte[] pic) {
        this.id = id;
        this.id_compagnie = id_compagnie;
        this.nom_compagnie = nom_compagnie;
        this.nom = nom;
        this.dateentree = dateentree;
        this.etat = etat;
        this.nbplace = nbplace;
        this.pic = pic;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_typeavion() {
        return id_compagnie;
    }

    public void setId_typeavion(int id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    public String getReference() {
        return nom_compagnie;
    }

    public void setReference(String nom_compagnie) {
        this.nom_compagnie = nom_compagnie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateentree() {
        return dateentree;
    }

    public void setDateentree(Date dateentree) {
        this.dateentree = dateentree;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
}
