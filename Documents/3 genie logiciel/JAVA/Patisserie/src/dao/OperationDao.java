/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Operation;
import java.sql.Date;
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
public class OperationDao extends Dao <Operation> {

    @Override
    public Operation rechercher(long id) {
        ResultSet result = null;
        Operation c = new Operation();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM operation WHERE ido ="+id);
            if(result.next() ){
                c.setIdo(result.getInt("ido"));
                c.setIdv(result.getInt("id_vendeur"));
                c.setDateo(result.getDate("dateo"));
                c.setTotal(result.getInt("total_paie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }

    @Override
    public void inserer(Operation c) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO operation(id_vendeur, total_paie) VALUES (?,?)");
            prepare.setInt(1, c.getIdv());
            prepare.setInt(2, c.getTotal());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM operation WHERE ido ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Operation c, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE operation SET total_paie = ? WHERE ido ="+id);
            prepare.setInt(1, c.getTotal());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Operation> liste() {
        List<Operation> cat = new ArrayList();
        Operation obj = new Operation();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM operation");
            while(result.next()){
            obj.setIdo(result.getInt("ido"));
            obj.setIdv(result.getInt("id_vendeur"));
            obj.setDateo(result.getDate("dateo"));
            obj.setTotal(result.getInt("total_paie"));
            cat.add(obj);
            obj = new Operation();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
    
    public int lastid(){
        int max = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT MAX(ido) as maximum FROM operation");
            if(result.next() ){
              max = result.getInt("maximum");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return max;
    }
    
    public Date lastdate(){
        Date d = null;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT ido, dateo FROM operation  ORDER BY ido Desc limit 0,1");
            if(result.next() ){
              d = result.getDate("dateo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperationDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return d;
    }
    
    }