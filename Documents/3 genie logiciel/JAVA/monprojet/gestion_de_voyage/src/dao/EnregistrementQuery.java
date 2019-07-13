/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bureau
 */
public class EnregistrementQuery {
    
        
    public void updateUser(User c, boolean withImage){
        
        try {
            Connection con = Connect.getInstance();
            PreparedStatement ps;
            String updateQuery = "";
            
            if(withImage){
                // if user want to update the contact profil to
                updateQuery = "UPDATE users SET fname=?, lname=?, user_name=?, pass=?, picture=?, statut=? WHERE id = ?";
                
                ps = con.prepareStatement(updateQuery);
                ps.setString(1, c.getFname());
                ps.setString(2, c.getLname());
                ps.setString(3, c.getUse_name());
                ps.setString(4, c.getPass());
                ps.setBytes(5, c.getPic());
                ps.setString(6, c.getStatut());
                ps.setInt(7, c.getId());
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, " User données modifiées ...");
            }else{
                 JOptionPane.showMessageDialog(null, " Quelque chose n'est pas correct !");
                 
            }
            
            
            }
            else{
                //if the user want to keep the same image[remove the image from the update
                updateQuery = "UPDATE `users` SET `fname`=?,`lname`=?,`user_name`=?,`pass`=?, `statut`=? WHERE `id` = ?";
                
                ps = con.prepareStatement(updateQuery);
                ps.setString(1, c.getFname());
                ps.setString(2, c.getLname());
                ps.setString(3, c.getUse_name());
                ps.setString(4, c.getPass());
                ps.setString(5, c.getStatut());
                ps.setInt(6, c.getId());
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "User données modifiées ...");
            }else{
                 JOptionPane.showMessageDialog(null, "Quelque chose n'est pas correcte !");
                 
            }
              
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(EnregistrementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
     public void deleteUser(int cid){
        
        
        try {
            Connection con = Connect.getInstance();
            PreparedStatement ps;
            ps = con.prepareStatement("DELETE FROM `users` WHERE `id`= ?");
            ps.setInt(1, cid);
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "User supprimé ...");
            }else{
                 JOptionPane.showMessageDialog(null, "Quelque chose n'est pas correcte !");
                 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EnregistrementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    public ArrayList<User> contactList(){
        ArrayList<User> clist = new ArrayList<User>();
        
        
        try {
            Connection con = Connect.getInstance();
            Statement st;
            ResultSet rs;
        
        
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `fname`, `lname`, `user_name`, `pass`, `picture`, `statut` FROM `users`");
            
            User u;
            
            while(rs.next()){
                u = new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("user_name"), rs.getString("pass"), rs.getBytes("picture"), rs.getString("statut"));
                
                clist.add(u);  
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(EnregistrementQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return clist;
    }
    
}
