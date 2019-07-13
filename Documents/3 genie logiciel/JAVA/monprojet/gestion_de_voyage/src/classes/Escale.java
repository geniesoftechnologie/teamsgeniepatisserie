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
public class Escale {
    private int id;
    private int id_vol;
    private int id_aeroport;
    private String heurarrivee;
    private String heurdepart;

    public Escale() {
    }

    public Escale(int id_vol, int id_aeroport, String heurarrivee, String heurdepart) {
        this.id_vol = id_vol;
        this.id_aeroport = id_aeroport;
        this.heurarrivee = heurarrivee;
        this.heurdepart = heurdepart;
    }

    public Escale(int id, int id_vol, int id_aeroport, String heurarrivee, String heurdepart) {
        this.id = id;
        this.id_vol = id_vol;
        this.id_aeroport = id_aeroport;
        this.heurarrivee = heurarrivee;
        this.heurdepart = heurdepart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public int getId_aeroport() {
        return id_aeroport;
    }

    public void setId_aeroport(int id_aeroport) {
        this.id_aeroport = id_aeroport;
    }

    public String getHeurarrivee() {
        return heurarrivee;
    }

    public void setHeurarrivee(String heurarrivee) {
        this.heurarrivee = heurarrivee;
    }

    public String getHeurdepart() {
        return heurdepart;
    }

    public void setHeurdepart(String heurdepart) {
        this.heurdepart = heurdepart;
    }
    
}
