/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Approvisionnement;
import classes.Approvisionnement;
import classes.Approvisionnement;
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
public class ApprovisionnementDao extends Dao <Approvisionnement>{

    @Override
    public Approvisionnement rechercher(long id) {
        ResultSet result = null;
        Approvisionnement c = new Approvisionnement();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM approvisionnement WHERE idap ="+id);
            if(result.next() ){
                c.setIds(result.getInt("idap"));
                c.setIdp(result.getInt("idp"));
                c.setCategorie(result.getString("categorie"));
                c.setDesignation(result.getString("designation"));
                c.setPu(result.getInt("pu"));
                c.setQuantite(result.getInt("quantite"));
                c.setDateap(result.getDate("dateap"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApprovisionnementDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(Approvisionnement c) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO approvisionnement(idp, categorie, designation, pu, quantite, dateap) VALUES (?,?,?,?,?,?)");
            prepare.setInt(1, c.getIdp());
            prepare.setString(2, c.getCategorie());
            prepare.setString(3, c.getDesignation());
            prepare.setInt(4, c.getPu());
            prepare.setInt(5, c.getQuantite());
            prepare.setString(6, amj.format(c.getDateap()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApprovisionnementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM approvisionnement WHERE idap ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApprovisionnementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Approvisionnement c, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE approvisionnement SET categorie = ? , designation = ?, pu = ?, quantite WHERE idap ="+id);
            prepare.setString(1, c.getCategorie());
            prepare.setString(2, c.getDesignation());
            prepare.setInt(3, c.getPu());
            prepare.setInt(4, c.getQuantite());
            prepare.setString(5, amj.format(c.getDateap()));
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApprovisionnementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Approvisionnement> liste() {
        List<Approvisionnement> cat = new ArrayList();
        Approvisionnement obj = new Approvisionnement();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM approvisionnement");
            while(result.next()){
            obj.setIds(result.getInt("idap"));
            obj.setIdp(result.getInt("idp"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQuantite(result.getInt("quantite"));
            obj.setDateap(result.getDate("dateap"));
            cat.add(obj);
            obj = new Approvisionnement();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ApprovisionnementDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    
}
