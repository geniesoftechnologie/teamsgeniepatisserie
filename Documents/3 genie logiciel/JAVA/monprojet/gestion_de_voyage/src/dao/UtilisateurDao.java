/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Utilisateur;
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
public class UtilisateurDao extends Dao <Utilisateur> {

    @Override
    public Utilisateur rechercher(long id) {
        ResultSet result = null;
        Utilisateur a = new Utilisateur();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM utilisateur WHERE id ="+id);
            if(result.next() ){
                a.setId(result.getInt("id"));
                a.setNom(result.getString("nom"));
                a.setPrenom(result.getString("prenom"));
                a.setSexe(result.getString("sexe"));
                a.setDatenaissance(result.getDate("datenaissance"));
                a.setTelephone(result.getString("telephone"));
                a.setEmail(result.getString("email"));
                a.setCodepieceident(result.getString("codepieceident"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return a;
    }

    @Override
    public void inserer(Utilisateur u) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO utilisateur(nom, prenom, sexe, dateNaissance, telephone, email, codePieceIdent) VALUES (?,?,?,?,?,?,?)");
            prepare.setString(1, u.getNom());
            prepare.setString(2, u.getPrenom());
            prepare.setString(3, u.getSexe());
            prepare.setString(4, amj.format(u.getDatenaissance()));
            prepare.setString(5, u.getTelephone());
            prepare.setString(6, u.getEmail());
            prepare.setString(7, u.getCodepieceident());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM utilisateur WHERE id ="+id);
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Utilisateur u, long id) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ?, sexe = ?, dateNaissance = ?, telephone = ?, email = ?, codePieceIdent = ? WHERE id ="+id);
            prepare.setString(1, u.getNom());
            prepare.setString(2, u.getPrenom());
            prepare.setString(3, u.getSexe());
            prepare.setString(4, amj.format(u.getDatenaissance()));
            prepare.setString(5, u.getTelephone());
            prepare.setString(6, u.getEmail());
            prepare.setString(7, u.getCodepieceident());
            prepare.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> liste() {
        List<Utilisateur> u = new ArrayList();
        Utilisateur obj = new Utilisateur();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM utilisateur");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setNom(result.getString("nom"));
            obj.setPrenom(result.getString("prenom"));
            obj.setSexe(result.getString("sexe"));
            obj.setDatenaissance(result.getDate("dateNaissance"));
            obj.setTelephone(result.getString("telephone"));
            obj.setEmail(result.getString("email"));
            obj.setCodepieceident(result.getString("codePieceIdent"));
            u.add(obj);
            obj = new Utilisateur(); 
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public int lastid(){
        int max = 0;
     ResultSet result = null;
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT MAX(id) as maximum FROM utilisateur");
            if(result.next() ){
              max = result.getInt("maximum");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return max;
    }
}
