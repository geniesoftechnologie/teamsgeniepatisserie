/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etat;

import classes.OperationDetail;
import dao.Connect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author bureau
 */
public class VenteReport {
   public void affichercatReport() throws FileNotFoundException{
       HashMap hm = new HashMap();
       
       try {
           
           
           InputStream in = new FileInputStream(new File("report/OperationDetailReport.jrxml"));
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n"+
     "operationdetail.`idod` AS operationdetail_idod,\n"+
     "operationdetail.`id_operation` AS operationdetail_id_operation,\n"+
     "operationdetail.`categorie` AS operationdetail_categorie,\n"+
     "operationdetail.`designation` AS operationdetail_designation,\n"+
     "operationdetail.`pu` AS operationdetail_pu,\n"+
     "operationdetail.`quantite` AS operationdetail_quantite,\n"+
     "operationdetail.`numf` AS operationdetail_numf\n"+
"FROM\n"+
     "`operationdetail` operationdetail where operationdetail.numf =3 \n";
                   
                   
                   
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;;
           
             
           JasperPrint jp = JasperFillManager.fillReport(jr, hm, Connect.getInstance());
           JRViewer jv = new JRViewer(jp);
           JFrame jf = new JFrame();
           jf.getContentPane().add(jv);
           jf.validate();
           jf.setVisible(true);
           jf.setLocationRelativeTo(null);
           jf.setExtendedState(jf.MAXIMIZED_BOTH);
       } catch (JRException ex) {
           ex.printStackTrace();
       }
   }
}
