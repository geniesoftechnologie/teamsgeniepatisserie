/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.EtatReservation;
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
public class EtatReservationDao extends Dao <EtatReservation> {

    @Override
    public EtatReservation rechercher(long id) {
        ResultSet result = null;
        EtatReservation r = new EtatReservation();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM etatreservation WHERE id ="+id);
            if(result.next() ){
                r.setId(result.getInt("id"));
                r.setLibelle(result.getString("libelle"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return r;
    }

    @Override
    public void inserer(EtatReservation r) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO etatreservation(libelle) VALUES (?)");
            prepare.setString(1, r.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
       try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM etateeservation WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(EtatReservation r, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE etatreservation SET libelle = ? WHERE id ="+id);
            prepare.setString(1, r.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<EtatReservation> liste() {
        List<EtatReservation> r = new ArrayList();
        EtatReservation obj = new EtatReservation();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM etatreservation");
            while(result.next()){
            obj.setLibelle(result.getString("libelle"));
            r.add(obj);
            obj = new EtatReservation();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
