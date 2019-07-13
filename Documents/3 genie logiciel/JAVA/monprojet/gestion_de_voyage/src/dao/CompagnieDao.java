/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Compagnie;
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
public class CompagnieDao extends Dao <Compagnie> {

    @Override
    public Compagnie rechercher(long id) {
        ResultSet result = null;
        Compagnie t = new Compagnie();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM compagnie WHERE id ="+id);
            if(result.next() ){
                t.setId(result.getInt("id"));
                t.setLibelle(result.getString("libelle"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return t;
    }

    @Override
    public void inserer(Compagnie t) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO compagnie(libelle) VALUES (?)");
            prepare.setString(1, t.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM compagnie WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Compagnie t, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE compagnie SET libelle = ? WHERE id ="+id);
            prepare.setString(1, t.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Compagnie> liste() {
        List<Compagnie> t = new ArrayList();
        Compagnie obj = new Compagnie();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM compagnie");
            while(result.next()){
            obj.setId(result.getInt("id"));    
            obj.setLibelle(result.getString("libelle"));
            t.add(obj);
            obj = new Compagnie();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
}
