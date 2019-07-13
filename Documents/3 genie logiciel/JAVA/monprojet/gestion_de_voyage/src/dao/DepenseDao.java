/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Depense;
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
public class DepenseDao extends Dao <Depense> {

    @Override
    public Depense rechercher(long id) {
        ResultSet result = null;
        Depense t = new Depense();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM depense WHERE id ="+id);
            if(result.next() ){
                t.setId(result.getInt("id"));
                t.setMotif(result.getString("motif"));
                t.setMontant(result.getInt("montant"));
                t.setDate_d(result.getDate("dated"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepenseDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return t;
    }

    @Override
    public void inserer(Depense t) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO depense(motif, montant, dated) VALUES (?,?,?)");
            prepare.setString(1, t.getMotif());
            prepare.setInt(2, t.getMontant());
            prepare.setString(3, amj.format(t.getDate_d()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM depense WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Depense t, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE depense SET motif = ?, montant = ?, dated = ? WHERE id ="+id);
            prepare.setString(1, t.getMotif());
            prepare.setInt(2, t.getMontant());
            prepare.setString(3, amj.format(t.getDate_d()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Depense> liste() {
        List<Depense> t = new ArrayList();
        Depense obj = new Depense();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM depense");
            while(result.next()){
            obj.setId(result.getInt("id"));    
            obj.setMotif(result.getString("motif"));
            obj.setMontant(result.getInt("montant"));
            obj.setDate_d(result.getDate("dated"));
            t.add(obj);
            obj = new Depense();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepenseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
}
