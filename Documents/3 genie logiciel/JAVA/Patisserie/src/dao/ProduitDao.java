/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bureau
 */
public class ProduitDao extends Dao <Produit> {

    @Override
    public Produit rechercher(long id) {
        ResultSet result = null;
        Produit c = new Produit();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM produit WHERE idp ="+id);
            if(result.next() ){
                c.setIdp(result.getInt("idp"));
                c.setCategorie(result.getString("categorie"));
                c.setDesignation(result.getString("designation"));
                c.setPu(result.getInt("pu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(Produit c) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO produit(categorie, designation, pu) VALUES (?,?,?)");
            prepare.setString(1, c.getCategorie());
            prepare.setString(2, c.getDesignation());
            prepare.setInt(3, c.getPu());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
         try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM produit WHERE idp ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Produit c, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE produit SET categorie = ? , designation = ?, pu = ? WHERE idp ="+id);
            prepare.setString(1, c.getCategorie());
            prepare.setString(2, c.getDesignation());
            prepare.setInt(3, c.getPu());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produit> liste() {
        List<Produit> cat = new ArrayList();
        Produit obj = new Produit();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM produit");
            while(result.next()){
            obj.setIdp(result.getInt("idp"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            cat.add(obj);
            obj = new Produit();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public Produit search(String nom) {
        ResultSet result = null;
        Produit p = new Produit();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT categorie, pu FROM produit WHERE designation = 'nom'");
            if(result.next() ){
                p.setCategorie(result.getString("categorie"));
                p.setPu(result.getInt("pu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return p;
    }
    
    public int lastidp(){
        int max = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT MAX(idp) as maximum FROM produit");
            if(result.next() ){
              max = result.getInt("maximum");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return max;
    }
    
}
