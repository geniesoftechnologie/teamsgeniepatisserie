/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Aeroport;
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
public class AeroportDao extends Dao <Aeroport> {

    @Override
    public Aeroport rechercher(long id) {
        ResultSet result = null;
        Aeroport a = new Aeroport();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM aeroport WHERE id ="+id);
            if(result.next() ){
                a.setId(result.getInt("id"));
                a.setId_ville(result.getInt("id_ville"));
                a.setNom_ville(result.getString("nom_ville"));
                a.setNom(result.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AeroportDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return a;
    }

    @Override
    public void inserer(Aeroport a) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO aeroport( id_ville, nom_ville, nom) VALUES (?,?,?)");
            prepare.setInt(1, a.getId_ville());
            prepare.setString(2, a.getNom_ville());
            prepare.setString(3, a.getNom());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AeroportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM aeroport WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AeroportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Aeroport a, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE aeroport SET id_ville = ? , nom = ? WHERE id ="+id);
            prepare.setInt(1, a.getId_ville());
            prepare.setString(2, a.getNom());;
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AeroportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Aeroport> liste() {
        List<Aeroport> aer = new ArrayList();
        Aeroport obj = new Aeroport();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM aeroport");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setId_ville(result.getInt("id_ville"));
            obj.setNom_ville(result.getString("nom_ville"));
            obj.setNom(result.getString("nom"));
            aer.add(obj);
            obj = new Aeroport();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AeroportDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aer;
    }
    
}
