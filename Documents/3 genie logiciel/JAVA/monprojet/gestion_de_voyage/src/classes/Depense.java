/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Depense {
    private int id;
    private String motif;
    private int montant;
    private Date date_d;

    public Depense() {
    }

    public Depense(String motif, int montant, Date date_d) {
        this.motif = motif;
        this.montant = montant;
        this.date_d = date_d;
    }

    public Depense(int id, String motif, int montant, Date date_d) {
        this.id = id;
        this.motif = motif;
        this.montant = montant;
        this.date_d = date_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDate_d() {
        return date_d;
    }

    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }
    
    
}
