/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import classes.Reservation;
import dao.ReservationDao;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author bureau
 */
public class Zzzzz extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservationListeForm
     */
    public Zzzzz() {
        initComponents();
        
        list_res();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        text_rech = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "Passport", "Id Vol", "Aeroport", "Date Depart", "Date Arrivée", "Heure de depart", "Heure d'arrivée", "Prix", "Date reserv"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Recherche");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        text_rech.setBackground(new java.awt.Color(204, 204, 204));
        text_rech.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        text_rech.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        text_rech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_rechKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(text_rech, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_rech, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(519, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(64, 64, 64)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int index = jTable1.getSelectedRow();
//        int idu = (int) jTable1.getValueAt(index, 0);
//
//        txt_nom.setText(jTable1.getValueAt(index, 1).toString());
//        txt_prenom.setText(jTable1.getValueAt(index, 2).toString());
//        txt_passport.setText(jTable1.getValueAt(index, 3).toString());
//        txt_idv.setText(jTable1.getValueAt(index, 4).toString());
//        txt_aero.setText(jTable1.getValueAt(index, 5).toString());
//        txt_datedep.setDate((Date) jTable1.getValueAt(index, 6));
//        txt_datear.setDate((Date) jTable1.getValueAt(index, 7));
//        txt_heurdep.setText(jTable1.getValueAt(index, 8).toString());
//        txt_heurar.setText(jTable1.getValueAt(index, 9).toString());
//        txt_prix.setText(jTable1.getValueAt(index, 10).toString());
//        txt_dater.setDate((Date) jTable1.getValueAt(index, 11));
//
//        ReservationDao rdao = new ReservationDao();
//        Reservation r = rdao.search(idu);
//        if(r!=null){
//
//            txt_idv.setText(String.valueOf(r.getId_vol()));
//            txt_dater.setDate(r.getDater());
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void text_rechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_rechKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter sorter = new TableRowSorter(model);
        jTable1.setRowSorter(sorter);
        String rech = text_rech.getText();
        sorter.setRowFilter(RowFilter.regexFilter(rech));
    }//GEN-LAST:event_text_rechKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField text_rech;
    // End of variables declaration//GEN-END:variables


    private void list_res(){
    ReservationDao rdao = new ReservationDao();
    List<Reservation> lr = rdao.liste();
    for(int i =0; i<lr.size(); i ++){
        ((DefaultTableModel) jTable1.getModel()).addRow(new Object []{
            lr.get(i).getId(),
            lr.get(i).getNom(),
            lr.get(i).getPrenom(),
            lr.get(i).getPassport(),
            lr.get(i).getId_vol(),
            lr.get(i).getNom_aero(),
            lr.get(i).getDatedepart(),
            lr.get(i).getDatearrivee(),
            lr.get(i).getHeurdepart(),
            lr.get(i).getHeurarrivee(),
            lr.get(i).getPrix(),
            lr.get(i).getDater()
            
        }
                
                );
    }
    }
}
