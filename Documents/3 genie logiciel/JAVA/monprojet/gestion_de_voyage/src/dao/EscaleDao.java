/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Escale;
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
public class EscaleDao extends Dao <Escale> {

    @Override
    public Escale rechercher(long id) {
        ResultSet result = null;
        Escale e = new Escale();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM escale WHERE id ="+id);
            if(result.next() ){
                e.setId(result.getInt("id"));
                e.setId_vol(result.getInt("id_vol"));
                e.setId_aeroport(result.getInt("id_aeroport"));
                e.setHeurarrivee(result.getString("heurarrivee"));
                e.setHeurdepart(result.getString("heurdepart"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EscaleDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return e;
    }

    @Override
    public void inserer(Escale e) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO escale( id_vol, id_aeroport, heurarrivee, heurdepart) VALUES (?,?,?,?)");
            prepare.setInt(1, e.getId_vol());
            prepare.setInt(2, e.getId_aeroport());
            prepare.setString(3, e.getHeurarrivee());
            prepare.setString(4, e.getHeurdepart());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EscaleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM escale WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EscaleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Escale e, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE escale SET id_vol = ? , id_aeroport = ?, heurarrivee = ?, heurdepart = ? WHERE id ="+id);
            prepare.setInt(1, e.getId_vol());
            prepare.setInt(2, e.getId_aeroport());
            prepare.setString(3, e.getHeurarrivee());
            prepare.setString(4, e.getHeurdepart());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EscaleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Escale> liste() {
        List<Escale> es = new ArrayList();
        Escale obj = new Escale();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM escale");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setId_vol(result.getInt("id_vol"));
            obj.setId_aeroport(result.getInt("id_aeroport"));
            obj.setHeurarrivee(result.getString("heurarrivee"));
            obj.setHeurdepart(result.getString("heurdepart"));
            es.add(obj);
            obj = new Escale();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EscaleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return es;
    }
    
}
