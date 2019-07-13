/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Facture;
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
public class FactureDao  extends Dao <Facture> {

    @Override
    public Facture rechercher(long id) {
        ResultSet result = null;
        Facture c = new Facture();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM facture WHERE numc ="+id);
            if(result.next() ){
                c.setNumc(result.getInt("numc"));
                c.setMontant(result.getInt("montant"));
                c.setDatef(result.getDate("datef"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(Facture f) {
         SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO facture(numc, montant, datef) VALUES (?,?,?)");
            prepare.setInt(1, f.getNumc());
            prepare.setInt(2, f.getMontant());
            prepare.setString(3, amj.format(f.getDatef()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM facture WHERE num ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Facture f, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE facture SET numc=?,montant=?,datef=? WHERE numc ="+id);
            prepare.setInt(1, f.getNumc());
            prepare.setInt(2, f.getMontant());
            prepare.setString(3, amj.format(f.getDatef()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Facture> liste() {
        SimpleDateFormat amj = new SimpleDateFormat("dd-MM-yyyy");
        List<Facture> cmd = new ArrayList();
        Facture obj = new Facture();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM facture");
            while(result.next()){
            obj.setNumc(result.getInt("numc"));
            obj.setMontant(result.getInt("montant"));
            obj.setDatef(result.getDate("datef"));
            cmd.add(obj);
            obj = new Facture();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cmd;
    }
    
 public int numcmd(){
     int max = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT MAX(numc) as maximum FROM facture");
            if(result.next() ){
              max = result.getInt("maximum");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(FactureDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return max+1;
 }   
    
    
    
}
