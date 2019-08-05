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
public class Stock {
    private int ids;
    private int idp;
    private String categorie;
    private String designation;
    private int pu;
    private int quantite;

    public Stock() {
    }

    public Stock(int idp, String categorie, String designation, int pu) {
        this.idp = idp;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
    }

    public Stock(int idp, String categorie, String designation, int pu, int quantite) {
        this.idp = idp;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.quantite = quantite;
    }

    public Stock(int ids, int idp, String categorie, String designation, int pu, int quantite) {
        this.ids = ids;
        this.idp = idp;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.quantite = quantite;
    }
    
     public Stock( int quantite) {
        this.quantite = quantite;
    }

    public Stock(String categorie, String designation, int pu) {
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.quantite = quantite;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
}
