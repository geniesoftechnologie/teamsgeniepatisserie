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
public class Produit {
    private int idp;
    private String categorie;
    private String designation;
    private int pu;

    public Produit(int idp, String categorie, String designation, int pu) {
        this.idp = idp;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
    }

    public Produit(String categorie, String designation, int pu) {
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
    }

    public Produit() {
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

    public int getPu() {
        return pu;
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

    public void setPu(int pu) {
        this.pu = pu;
    }
    
    
    
}
