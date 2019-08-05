/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.OperationDetail;
import form.AcceuilForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bureau
 */
public class OperationDetailDao extends Dao <OperationDetail> {

    @Override
    public OperationDetail rechercher(long id) {
        ResultSet result = null;
        OperationDetail c = new OperationDetail();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM operationdetail WHERE idod ="+id);
            if(result.next() ){
                c.setIdp(result.getInt("idod"));
                c.setIdo(result.getInt("id_operation"));
                c.setCategorie(result.getString("categorie"));
                c.setDesignation(result.getString("designation"));
                c.setPu(result.getInt("pu"));
                c.setQte(result.getInt("quantite"));
                c.setDated(result.getDate("dated"));
                c.setNum(result.getInt("numf"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(OperationDetail c) {
        try {
            SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO operationdetail(id_operation, categorie, designation, pu, quantite, dated, numf) VALUES (?,?,?,?,?,?,?)");
            prepare.setInt(1, c.getIdo());
            prepare.setString(2, c.getCategorie());
            prepare.setString(3, c.getDesignation());
            prepare.setInt(4, c.getPu());
            prepare.setInt(5, c.getQte());
            prepare.setString(6, amj.format(c.getDated()));
            prepare.setInt(7, c.getNum());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
         try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM operationdetail WHERE idod ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(OperationDetail c, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE operationdetail SET categorie = ? , designation = ?, pu = ?, quantite = ? WHERE idod ="+id);
            prepare.setString(1, c.getCategorie());
            prepare.setString(2, c.getDesignation());
            prepare.setInt(3, c.getPu());
            prepare.setInt(4, c.getQte());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OperationDetail> liste() {
        List<OperationDetail> cat = new ArrayList();
        OperationDetail obj = new OperationDetail();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM operationdetail");
            while(result.next()){
            obj.setIdp(result.getInt("idod"));
            obj.setIdo(result.getInt("id_operation"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQte(result.getInt("quantite"));
            cat.add(obj);
            obj = new OperationDetail();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public List<OperationDetail> listeb() {
        List<OperationDetail> cat = new ArrayList();
        OperationDetail obj = new OperationDetail();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM operationdetail LEFT JOIN operation on operationdetail.id_operation = operation.ido WHERE operation.id_vendeur ="+AcceuilForm.currentUserId);
            while(result.next()){
            obj.setIdp(result.getInt("idod"));
            obj.setIdo(result.getInt("id_operation"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQte(result.getInt("quantite"));
            cat.add(obj);
            obj = new OperationDetail();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public List<OperationDetail> listec( Date ventefdate) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        List<OperationDetail> cat = new ArrayList();
        OperationDetail obj = new OperationDetail();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT `idod`, `id_operation`, `categorie`, `designation`, `pu`, `quantite`, `dated` FROM `operationdetail` WHERE dated = '"+amj.format(ventefdate)+"' ");
            while(result.next()){
            obj.setIdp(result.getInt("idod"));
            obj.setIdo(result.getInt("id_operation"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQte(result.getInt("quantite"));
            cat.add(obj);
            obj = new OperationDetail();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public List<OperationDetail> listed( Date ventefdate, Date ventetdate) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        List<OperationDetail> cat = new ArrayList();
        OperationDetail obj = new OperationDetail();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT `idod`, `id_operation`, `categorie`, `designation`, `pu`, `quantite`, `dated` FROM `operationdetail` WHERE dated between '"+amj.format(ventefdate)+"' and '"+amj.format(ventetdate)+"' ");
            while(result.next()){
            obj.setIdp(result.getInt("idod"));
            obj.setIdo(result.getInt("id_operation"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQte(result.getInt("quantite"));
            cat.add(obj);
            obj = new OperationDetail();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    
    public List<OperationDetail> listee(String categorie) {
        List<OperationDetail> cat = new ArrayList();
        OperationDetail obj = new OperationDetail();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM operationdetail where categorie like'%"+categorie+"%'");
            while(result.next()){
            obj.setIdp(result.getInt("idod"));
            obj.setIdo(result.getInt("id_operation"));
            obj.setCategorie(result.getString("categorie"));
            obj.setDesignation(result.getString("designation"));
            obj.setPu(result.getInt("pu"));
            obj.setQte(result.getInt("quantite"));
            cat.add(obj);
            obj = new OperationDetail();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    
     public int montantu(){
        int montantu = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT SUM(quantite*pu) as montantu FROM operationdetail LEFT JOIN operation on operationdetail.id_operation = operation.ido WHERE operation.id_vendeur ="+AcceuilForm.currentUserId);
            if(result.next() ){
              montantu = result.getInt("montantu");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return montantu;
    }
     
     public int nombreu(){
        int nombreu = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT count(idod) as nombreu FROM operationdetail LEFT JOIN operation on operationdetail.id_operation = operation.ido WHERE operation.id_vendeur ="+AcceuilForm.currentUserId);
            if(result.next() ){
              nombreu = result.getInt("nombreu");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nombreu;
    }
     
     public int montant(){
        int montant = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT SUM(quantite*pu) as montant FROM operationdetail");
            if(result.next() ){
              montant = result.getInt("montant");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return montant;
    }
     
     public int nombre(){
        int nombre = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT count(idod) as nombre FROM operationdetail");
            if(result.next() ){
              nombre = result.getInt("nombre");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return nombre;
    }
     
      public int montantf(int numc){
        int montant = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT SUM(quantite*pu) as montant FROM operationdetail WHERE numf ="+numc);
            if(result.next() ){
              montant = result.getInt("montant");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return montant;
    }
    
}
