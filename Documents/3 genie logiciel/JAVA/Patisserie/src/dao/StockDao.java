/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Stock;
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
public class StockDao extends Dao <Stock>{

    @Override
    public Stock rechercher(long id) {
        ResultSet result = null;
        Stock c = new Stock();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM stock WHERE idp ="+id);
            if(result.next() ){
                c.setIds(result.getInt("ids"));
                c.setIdp(result.getInt("idp"));
                c.setCategorie(result.getString("categorie"));
                c.setDesignation(result.getString("designation"));
                c.setPu(result.getInt("pu"));
                c.setQuantite(result.getInt("quantite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(Stock c) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO stock(idp, categorie, designation, pu, quantite) VALUES (?,?,?,?,?)");
            prepare.setInt(1, c.getIdp());
            prepare.setString(2, c.getCategorie());
            prepare.setString(3, c.getDesignation());
            prepare.setInt(4, c.getPu());
            prepare.setInt(5, c.getQuantite());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM stock WHERE ids ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Stock c, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE stock SET categorie = ? , designation = ?, pu = ?, quantite = ? WHERE idp ="+id);
            prepare.setString(1, c.getCategorie());
            prepare.setString(2, c.getDesignation());
            prepare.setInt(3, c.getPu());
            prepare.setInt(4, c.getQuantite());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Stock> liste() {
        List<Stock> cat = new ArrayList();
        Stock obj = new Stock();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM produit left join stock on produit.idp=stock.idp");
            while(result.next()){
            obj.setIds(result.getInt("ids"));
            obj.setIdp(result.getInt("idp"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQuantite(result.getInt("quantite"));
            cat.add(obj);
            obj = new Stock();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public int donneeStock(int idp){
        int qte = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT quantite FROM stock where idp ="+idp);
            if(result.next() ){
              qte = result.getInt("quantite");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return qte;
    }
    
    public List<Stock> listeStockInsufisant() {
        List<Stock> cat = new ArrayList();
        Stock obj = new Stock();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM stock where quantite < 20");
            while(result.next()){
            obj.setIds(result.getInt("ids"));
            obj.setIdp(result.getInt("idp"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQuantite(result.getInt("quantite"));
            cat.add(obj);
            obj = new Stock();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
}
