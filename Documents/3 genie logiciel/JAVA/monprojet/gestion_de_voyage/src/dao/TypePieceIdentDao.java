/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.TypePieceIdent;
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
public class TypePieceIdentDao extends Dao <TypePieceIdent> {

    @Override
    public TypePieceIdent rechercher(long id) {
        ResultSet result = null;
        TypePieceIdent t = new TypePieceIdent();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM typepieceident WHERE id ="+id);
            if(result.next() ){
                t.setId(result.getInt("id"));
                t.setLibelle(result.getString("libelle"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypePieceIdentDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return t;
    }

    @Override
    public void inserer(TypePieceIdent t) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO typepieceident(libelle) VALUES (?)");
            prepare.setString(1, t.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypePieceIdentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM typepieceident WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypePieceIdentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(TypePieceIdent t, long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE typepieceident SET libelle = ? WHERE id ="+id);
            prepare.setString(1, t.getLibelle());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypePieceIdentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TypePieceIdent> liste() {
        List<TypePieceIdent> t = new ArrayList();
        TypePieceIdent obj = new TypePieceIdent();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM typepieceident");
            while(result.next()){
            obj.setLibelle(result.getString("libelle"));
            t.add(obj);
            obj = new TypePieceIdent();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TypePieceIdentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
}
