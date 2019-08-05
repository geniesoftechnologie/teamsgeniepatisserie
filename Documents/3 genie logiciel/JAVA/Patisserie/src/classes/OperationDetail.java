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
public class OperationDetail {
    private int idp;
    private int ido;
    private String categorie;
    private String designation;
    private int pu;
    private int qte;
    private Date dated;
    private int num;

    public OperationDetail() {
    }
    
    public OperationDetail( String categorie, String designation, int pu, int qte) {
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.qte = qte;
    }

    public OperationDetail(int ido, String categorie, String designation, int pu, int qte, Date dated, int num) {
        this.ido = ido;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.qte = qte;
        this.dated = dated;
        this.num = num;
    }

    public OperationDetail(int idp, int ido, String categorie, String designation, int pu, int qte, Date dated, int num) {
        this.idp = idp;
        this.ido = ido;
        this.categorie = categorie;
        this.designation = designation;
        this.pu = pu;
        this.qte = qte;
        this.dated = dated;
        this.num = num;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
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

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    
}
