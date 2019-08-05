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
public class Operation {
    private int ido;
    private int idv;
    private Date dateo;
    private int total;

    public Operation() {
    }

    public Operation(int idv, int total) {
        this.idv = idv;
        this.total = total;
    }
    
    public Operation( int total) {
        this.total = total;
    }

    public Operation(int idv, Date dateo, int total) {
        this.idv = idv;
        this.dateo = dateo;
        this.total = total;
    }

    public Operation(int ido, int idv, Date dateo, int total) {
        this.ido = ido;
        this.idv = idv;
        this.dateo = dateo;
        this.total = total;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public Date getDateo() {
        return dateo;
    }

    public void setDateo(Date dateo) {
        this.dateo = dateo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
