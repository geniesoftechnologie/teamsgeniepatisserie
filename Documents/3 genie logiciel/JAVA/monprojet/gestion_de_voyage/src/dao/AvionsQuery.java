/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Avion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bureau
 */
public class AvionsQuery {
    
//    public Avion rechercher(long id) {
//        Connection con = Connect.getInstance();
//            Statement st;
//            ResultSet rs = null;;
//        
//        Avion a = new Avion();
//        try {
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT * FROM avion WHERE id ="+id);
//            if(rs.next() ){
//                a.setId(rs.getInt("id"));
//                a.setId_typeavion(rs.getInt("id_compagnie"));
//                a.setReference(rs.getString("nom_compagnie"));
//                a.setNom(rs.getString("nom"));
//                a.setDateentree(rs.getDate("dateentree"));
//                a.setEtat(rs.getInt("etat"));
//                a.setNbplace(rs.getInt("nbplace"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        return a;
//    }
//    
    
    public void inertAvion(Avion a){
        
        try {
            Connection con = Connect.getInstance();
            SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO avion( id_compagnie, nom_compagnie, nom, dateentree, etat, nbplace, picture,uid) VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, a.getId_typeavion());
            ps.setString(2, a.getReference());
            ps.setString(3, a.getNom());
            ps.setString(4, amj.format(a.getDateentree()));
            ps.setInt(5, a.getEtat());
            ps.setInt(6, a.getNbplace());
            ps.setBytes(7, a.getPic());
            ps.setInt(8, a.getUid());
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Nouvel avion enregistré ...");
            }else{
                 JOptionPane.showMessageDialog(null, "Quelque chose n'est pas correcte !");
                 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    public void updateAvion(Avion a, boolean withImage){
        
        
        try {
            Connection con = Connect.getInstance();
            SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps;
            String updateQuery = "";
            
            if(withImage){
                // if user want to update the contact profil to
                updateQuery = "UPDATE avion SET id_compagnie = ?, nom_compagnie = ?, nom =?, dateentree = ?, etat =?, nbplace =?, picture =? WHERE id = ?";
                
                ps = con.prepareStatement(updateQuery);
                ps.setInt(1, a.getId_typeavion());
                ps.setString(2, a.getReference());
                ps.setString(3, a.getNom());
                ps.setString(4, amj.format(a.getDateentree()));
                ps.setInt(5, a.getEtat());
                ps.setInt(6, a.getNbplace());
                ps.setBytes(7, a.getPic());
                ps.setInt(8, a.getId());
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Avion données modifiées ...");
            }else{
                 JOptionPane.showMessageDialog(null, "Quelque chose n'est pas correcte !");
                 
            }
            
            
            }
            else{
                //if the user want to keep the same image[remove the image from the update
                updateQuery = "UPDATE avion SET id_compagnie = ?, nom_compagnie = ?, nom =?, dateentree =?, etat = ?, nbplace = ? WHERE id = ?";
                
                ps = con.prepareStatement(updateQuery);
                ps.setInt(1, a.getId_typeavion());
                ps.setString(2, a.getReference());
                ps.setString(3, a.getNom());
                ps.setString(4, amj.format(a.getDateentree()));
                ps.setInt(5, a.getEtat());
                ps.setInt(6, a.getNbplace());
                ps.setInt(7, a.getId());
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Avion données modifiées ...");
            }else{
                 JOptionPane.showMessageDialog(null, "Quelque chose n'est pas correcte !");
                 
            }
              
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(AvionsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
     public void deleteAvion(int aid){
        
        
        try {
            Connection con = Connect.getInstance();
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE FROM `avion` WHERE `id`= ?");
            ps.setInt(1, aid);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Avion supprimer ...");
            }else{
                 JOptionPane.showMessageDialog(null, " Quelque chose n'est pas correcte !");
                 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    public ArrayList<Avion> contactList(){
        ArrayList<Avion> clist = new ArrayList<Avion>();
        
        
        try {
            Connection con = Connect.getInstance();
            Statement st;
            ResultSet rs;
        
        
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `id_compagnie`, `nom_compagnie`, `nom`, `dateentree`, `etat`, `nbplace`, `picture`, `uid` FROM `avion`");
            
            Avion a;
            
            while(rs.next()){
                a = new Avion(rs.getInt("id"), rs.getInt("id_compagnie"), rs.getString("nom_compagnie"), rs.getString("nom"), rs.getDate("dateentree"), rs.getInt("etat"), rs.getInt("nbplace"), rs.getBytes("picture"));
                
                
                clist.add(a);  
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(AvionsQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return clist;
    }
    
}
