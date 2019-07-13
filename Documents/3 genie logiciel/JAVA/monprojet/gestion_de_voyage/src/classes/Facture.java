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
public class Facture {
    private int numc;
    private int montant;
    private Date datef;

    public Facture() {
    }

    public Facture(int montant, Date datef) {
        this.montant = montant;
        this.datef = datef;
    }

    public Facture(int numc, int montant, Date datef) {
        this.numc = numc;
        this.montant = montant;
        this.datef = datef;
    }

    public int getNumc() {
        return numc;
    }

    public void setNumc(int numc) {
        this.numc = numc;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }
    
}
