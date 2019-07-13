/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Ville;
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
public class VilleDao extends Dao <Ville> {

    @Override
    public Ville rechercher(long id) {
        ResultSet result = null;
        Ville v = new Ville();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM ville WHERE id ="+id);
            if(result.next() ){
                v.setId(result.getInt("id"));
                v.setNom(result.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VilleDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return v;
    }

    @Override
    public void inserer(Ville v) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO ville(nom) VALUES (?)");
            prepare.setString(1, v.getNom());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM ville WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Ville v, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE ville SET nom = ? WHERE id ="+id);
            prepare.setString(1, v.getNom());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Ville> liste() {
        List<Ville> v = new ArrayList();
        Ville obj = new Ville();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM ville");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setNom(result.getString("nom"));
            v.add(obj);
            obj = new Ville();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VilleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    
    
}
