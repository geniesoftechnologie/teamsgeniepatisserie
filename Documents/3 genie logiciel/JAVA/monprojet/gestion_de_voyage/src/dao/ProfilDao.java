package dao;

import classes.Profil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bureau
 */
public class ProfilDao extends Dao <Profil> {

    @Override
    public Profil rechercher(long id) {
        ResultSet result = null;
        Profil r = new Profil();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM profil WHERE id ="+id);
            if(result.next() ){
                r.setId(result.getInt("id"));
                r.setLibelle(result.getString("libelle"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return r;
    }

    @Override
    public void inserer(Profil p) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO profil(libelle) VALUES (?)");
            prepare.setString(1, p.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM profil WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Profil p, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE profil SET libelle = ? WHERE id ="+id);
            prepare.setString(1, p.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Profil> liste() {
        List<Profil> p = new ArrayList();
        Profil obj = new Profil();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM profil");
            while(result.next()){
            obj.setLibelle(result.getString("libelle"));
            p.add(obj);
            obj = new Profil();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EtatReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
