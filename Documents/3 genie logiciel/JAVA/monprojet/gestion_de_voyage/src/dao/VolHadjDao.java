/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Ville;
import classes.VolHadj;
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
public class VolHadjDao extends Dao <VolHadj> {

    @Override
    public VolHadj rechercher(long id) {
        ResultSet result = null;
        VolHadj v = new VolHadj();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM volhadj WHERE id ="+id);
            if(result.next() ){
                v.setId(result.getInt("id"));
                v.setId_avion(result.getInt("id_avion"));
                v.setId_aeroport(result.getInt("id_aeroport"));
                v.setNom_aero(result.getString("nom_aeroport"));
                v.setDatedepart(result.getDate("datedepart"));
                v.setDatearrivee(result.getDate("datearrivee"));
                v.setHeurdepart(result.getString("heurdepart"));
                v.setHeurarrivee(result.getString("heurarrivee"));
                v.setPrix(result.getInt("prix"));
                v.setNbplacereserve(result.getInt("nbplacereserve"));
                v.setId_aeroport_ar(result.getInt("id_aeroport_ar"));
                v.setNom_aero_ar(result.getString("nom_aeroport_ar"));
                v.setDuree(result.getInt("duree"));
                v.setEtat(result.getInt("etat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return v;
    }

    @Override
    public void inserer(VolHadj v) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO volhadj(id_avion, id_aeroport, nom_aeroport, datedepart, datearrivee, heurdepart, heurarrivee, prix, nbplacereserve, id_aeroport_ar, nom_aeroport_ar, duree, etat) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            prepare.setInt(1, v.getId_avion());
            prepare.setInt(2, v.getId_aeroport());
            prepare.setString(3, v.getNom_aero());
            prepare.setString(4, amj.format(v.getDatedepart()));
            prepare.setString(5, amj.format(v.getDatearrivee()));
            prepare.setString(6, v.getHeurdepart());
            prepare.setString(7, v.getHeurarrivee());
            prepare.setDouble(8, v.getPrix());
            prepare.setInt(9, v.getNbplacereserve());
            prepare.setInt(10, v.getId_aeroport_ar());
            prepare.setString(11, v.getNom_aero_ar());
            prepare.setInt(12, v.getDuree());
            prepare.setInt(13, v.getEtat());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM volhadj WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(VolHadj v, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE volhadj SET id_avion = ? , id_aeroport = ?, nom_aeroport = ?, datedepart = ?, datearrivee = ?, heurdepart = ?, heurarrivee = ?, prix = ?, nbplacereserve = ?, id_aeroport_ar = ?, nom_aeroport_ar = ?, duree = ?, etat = ? WHERE id ="+id);
            prepare.setInt(1, v.getId_avion());
            prepare.setInt(2, v.getId_aeroport());
            prepare.setString(3, v.getNom_aero());
            prepare.setString(4, amj.format(v.getDatedepart()));
            prepare.setString(5, amj.format(v.getDatearrivee()));
            prepare.setString(6, v.getHeurdepart());
            prepare.setString(7, v.getHeurarrivee());
            prepare.setDouble(8, v.getPrix());
            prepare.setInt(9, v.getNbplacereserve());
            prepare.setInt(10, v.getId_aeroport_ar());
            prepare.setString(11, v.getNom_aero_ar());
            prepare.setInt(12, v.getDuree());
            prepare.setInt(13, v.getEtat());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<VolHadj> liste() {
        List<VolHadj> r = new ArrayList();
        VolHadj obj = new VolHadj();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM volhadj");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setId_avion(result.getInt("id_avion"));
            obj.setId_aeroport(result.getInt("id_aeroport"));
            obj.setNom_aero(result.getString("nom_aeroport"));
            obj.setDatedepart(result.getDate("datedepart"));
            obj.setDatearrivee(result.getDate("datearrivee"));
            obj.setHeurdepart(result.getString("heurdepart"));
            obj.setHeurarrivee(result.getString("heurarrivee"));
            obj.setPrix(result.getInt("prix"));
            obj.setNbplacereserve(result.getInt("Nbplacereserve"));
            obj.setId_aeroport_ar(result.getInt("id_aeroport_ar"));
            obj.setNom_aero_ar(result.getString("nom_aeroport_ar"));
            obj.setDuree(result.getInt("duree"));
            r.add(obj);
            obj = new VolHadj(); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public int donnee(int id){
        int qte = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT etat FROM volhadj where id ="+id);
            if(result.next() ){
              qte = result.getInt("etat");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return qte;
    }
    
    
    public void Update(VolHadj v, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE volhadj SET etat = ? WHERE id ="+id);
            prepare.setInt(1, v.getEtat());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolHadjDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
