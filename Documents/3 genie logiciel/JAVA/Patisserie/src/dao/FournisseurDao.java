/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Fournisseur;
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
public class FournisseurDao extends Dao<Fournisseur>{

    @Override
    public Fournisseur rechercher(long id) {
         ResultSet result = null;
        Fournisseur f = new Fournisseur();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM fournisseur WHERE idf ="+id);
            if(result.next() ){
                f.setIdf(result.getInt("idf"));
                f.setNom(result.getString("nom"));
                f.setAdresse(result.getString("adresse"));
                f.setTelephone(result.getString("telephone"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return f;
    }

    @Override
    public void inserer(Fournisseur f) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO `fournisseur`( `nom`, `adresse`, `telephone`) VALUES (?,?,?)");
            prepare.setString(1, f.getNom());
            prepare.setString(2, f.getAdresse());
            prepare.setString(3, f.getTelephone());
            
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM fournisseur WHERE idf ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Fournisseur f, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE fournisseur SET nom=?, adresse=?, telephone=?  WHERE idf="+id);
            prepare.setString(1, f.getNom());
            prepare.setString(2, f.getAdresse());
            prepare.setString(3, f.getTelephone());
           
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Fournisseur> liste() {
        List<Fournisseur> user = new ArrayList();
        Fournisseur obj = new Fournisseur();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM fournisseur");
            while(result.next()){
            obj.setIdf(result.getInt("idf"));
            obj.setNom(result.getString("nom"));
            obj.setAdresse(result.getString("adresse"));
            obj.setTelephone(result.getString("telephone"));
            
            user.add(obj);
            obj = new Fournisseur();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    }
    

