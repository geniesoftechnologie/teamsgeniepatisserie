/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.ReservationHadj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bureau
 */
public class ReservationHadjDao extends Dao <ReservationHadj> {

    @Override
    public ReservationHadj rechercher(long id) {
        ResultSet result = null;
        ReservationHadj e = new ReservationHadj();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM reservationhadj WHERE id ="+id);
            if(result.next() ){
                e.setId(result.getInt("id"));
                e.setId_utilisateur(result.getInt("id_utilisateur"));
                e.setNom(result.getString("nom"));
                e.setPrenom(result.getString("prenom"));
                e.setPassport(result.getString("passport"));
                e.setId_vol(result.getInt("id_vol"));
                e.setNom_aero(result.getString("nom_aeroport"));
                e.setDatedepart(result.getDate("datedepart"));
                e.setDatearrivee(result.getDate("datearrivee"));
                e.setHeurdepart(result.getString("heurdepart"));
                e.setHeurarrivee(result.getString("heurarrivee"));
                e.setNom_aero_ar(result.getString("nom_aeroport_ar"));
                e.setPrix(result.getInt("prix"));
                e.setDater(result.getDate("dater"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return e;
    }

    @Override
    public void inserer(ReservationHadj r) {
       SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO reservationhadj( id_utilisateur, nom, prenom, passport, id_vol, nom_aeroport, datedepart, datearrivee, heurdepart, heurarrivee, nom_aeroport_ar, prix, dater, idf) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            prepare.setInt(1, r.getId_utilisateur());
            prepare.setString(2, r.getNom());
            prepare.setString(3, r.getPrenom());
            prepare.setString(4, r.getPassport());
            prepare.setInt(5, r.getId_vol());
            prepare.setString(6, r.getNom_aero());
            prepare.setString(7, amj.format(r.getDatedepart()));
            prepare.setString(8, amj.format(r.getDatearrivee()));
            prepare.setString(9, r.getHeurdepart());
            prepare.setString(10, r.getHeurarrivee());
            prepare.setString(11, r.getNom_aero_ar());
            prepare.setDouble(12, r.getPrix());
            prepare.setString(13, amj.format(r.getDater()));
            prepare.setInt(14, r.getIdf());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM reservationhadj WHERE id="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(ReservationHadj r, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE reservationhadj SET id_utilisateur = ?, nom = ?, prenom = ? , passport = ? ,id_vol = ?, nom_aeroport = ?, datedepart = ?, datearrivee = ?, heurdepart = ?, heurarrivee = ?, nom_aeroport_ar = ?, prix = ?, dater = ? WHERE id ="+id);
            prepare.setInt(1, r.getId_utilisateur());
            prepare.setString(2, r.getNom());
            prepare.setString(3, r.getPrenom());
            prepare.setString(4, r.getPassport());
            prepare.setInt(5, r.getId_vol());
            prepare.setString(6, r.getNom_aero());
            prepare.setString(7, amj.format(r.getDatedepart()));
            prepare.setString(8, amj.format(r.getDatearrivee()));
            prepare.setString(9, r.getHeurdepart());
            prepare.setString(10, r.getHeurarrivee());
            prepare.setString(11, r.getNom_aero_ar());
            prepare.setDouble(12, r.getPrix());
            prepare.setString(13, amj.format(r.getDater()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ReservationHadj> liste() {
        List<ReservationHadj> r = new ArrayList();
        ReservationHadj obj = new ReservationHadj();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM reservationhadj");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setId_utilisateur(result.getInt("id_utilisateur"));
            obj.setNom(result.getString("nom"));
            obj.setPrenom(result.getString("prenom"));
            obj.setPassport(result.getString("passport"));
            obj.setId_vol(result.getInt("id_vol"));
            obj.setNom_aero(result.getString("nom_aeroport"));
            obj.setDatedepart(result.getDate("datedepart"));
            obj.setDatearrivee(result.getDate("datearrivee"));
            obj.setHeurdepart(result.getString("heurdepart"));
            obj.setHeurarrivee(result.getString("heurarrivee"));
            obj.setNom_aero_ar(result.getString("nom_aeroport_ar"));
            obj.setPrix(result.getInt("prix"));
            obj.setDater(result.getDate("dater"));
            r.add(obj);
            obj = new ReservationHadj();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public ReservationHadj search(long id) {
        ResultSet result = null;
        ReservationHadj e = new ReservationHadj();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM reservationhadj WHERE id_utilisateur ="+id);
            if(result.next() ){
                e.setId_vol(result.getInt("id_vol"));
                e.setDater(result.getDate("dater"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return e;
    }
    
    public void update(ReservationHadj r, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE reservationhadj SET id_vol = ?, dater = ? WHERE id_utilisateur ="+id);
            prepare.setInt(1, r.getId_vol());
            prepare.setString(2, amj.format(r.getDater()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public int montanth(int numc){
        int montant = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT SUM(prix) as montant FROM reservationhadj WHERE idf ="+numc);
            if(result.next() ){
              montant = result.getInt("montant");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return montant;
    }
    
   
    
    
}
