/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Blob;

/**
 *
 * @author bureau
 */
public class User {
    private Integer id;
    private String fname;
    private String lname;
    private String use_name;
    private String pass;
    private byte[] pic;
    private String statut;

    public User() {
    }

    public User(String fname, String lname, String use_name, String pass, byte[] pic, String statut) {
        this.fname = fname;
        this.lname = lname;
        this.use_name = use_name;
        this.pass = pass;
        this.pic = pic;
        this.statut = statut;
    }

    public User(Integer id, String fname, String lname, String use_name, String pass, byte[] pic, String statut) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.use_name = use_name;
        this.pass = pass;
        this.pic = pic;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
