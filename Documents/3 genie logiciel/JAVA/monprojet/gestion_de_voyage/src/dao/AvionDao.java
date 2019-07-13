/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Avion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bureau
 */
public class AvionDao extends Dao <Avion> {

    @Override
    public Avion rechercher(long id) {
        ResultSet result = null;
        Avion a = new Avion();
        try {
            
            result = this.connect.createStatement().executeQuery("SELECT * FROM avion WHERE id ="+id);
            if(result.next() ){
                a.setId(result.getInt("id"));
                a.setId_typeavion(result.getInt("id_compagnie"));
                a.setReference(result.getString("nom_compagnie"));
                a.setNom(result.getString("nom"));
                a.setDateentree(result.getDate("dateentree"));
                a.setEtat(result.getInt("etat"));
                a.setNbplace(result.getInt("nbplace"));
                a.setPic(result.getBytes("picture"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return a;
    }

    @Override
    public void inserer(Avion a) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO avion( id_compagnie, nom_compagnien, nom, dateentree, etat, nbplace) VALUES (?,?,?,?,?,?)");
            prepare.setInt(1, a.getId_typeavion());
            prepare.setString(2, a.getReference());
            prepare.setString(3, a.getNom());
            prepare.setString(4, amj.format(a.getDateentree()));
            prepare.setInt(5, a.getEtat());
            prepare.setInt(6, a.getNbplace());
            prepare.setBytes(7, a.getPic());
            prepare.executeUpdate();
            
            if(prepare.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New Avion Add");
            }else{
                 JOptionPane.showMessageDialog(null, "Something wos wrong");
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM avion WHERE id ="+id);
            prepare.executeUpdate();
            if(prepare.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Avion Deleted");
            }else{
                 JOptionPane.showMessageDialog(null, "Something wos wrong");
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public void modifie(Avion a, boolean withImage) {
        SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            if(withImage){
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE avion SET id_compagnie = ? , nom_compagnie = ?, nom = ?, dateentree = ?, etat = ?, nbplace = ? WHERE id = ?");
            prepare.setInt(1, a.getId_typeavion());
            prepare.setString(2, a.getReference());
            prepare.setString(3, a.getNom());
            prepare.setString(4, amj.format(a.getDateentree()));
            prepare.setInt(5, a.getEtat());
            prepare.setInt(6, a.getNbplace());
            prepare.setInt(6, a.getId());
            prepare.executeUpdate();
            if(prepare.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Contact data eddited");
            }else{
                 JOptionPane.showMessageDialog(null, "Something wos wrong");
                 
            }
            }
            else{
                PreparedStatement prepare = this.connect.prepareStatement("UPDATE avion SET id_compagnie = ? , nom_compagnie = ?, nom = ?, dateentree = ?, etat = ?, nbplace = ? WHERE id = ?");
            prepare.setInt(1, a.getId_typeavion());
            prepare.setString(2, a.getReference());
            prepare.setString(3, a.getNom());
            prepare.setString(4, amj.format(a.getDateentree()));
            prepare.setInt(5, a.getEtat());
            prepare.setInt(6, a.getNbplace());
            prepare.setInt(6, a.getId());
            prepare.executeUpdate();
            if(prepare.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Contact data eddited");
            }else{
                 JOptionPane.showMessageDialog(null, "Something wos wrong");
                 
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Avion> liste() {
        List<Avion> av = new ArrayList();
        Avion obj = new Avion();
        ResultSet result;
        try {
            result = this.connect.createStatement().executeQuery("SELECT * FROM avion");
            while(result.next()){
            obj.setId(result.getInt("id"));
            obj.setId_typeavion(result.getInt("id_compagnie"));
            obj.setReference(result.getString("nom_compagnie"));
            obj.setNom(result.getString("nom"));
            obj.setEtat(result.getInt("etat"));
            obj.setNbplace(result.getInt("nbplace"));
            av.add(obj);
            obj = new Avion();   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AvionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return av;
    }

    @Override
    public void modifier(Avion paramT, long paramlong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
