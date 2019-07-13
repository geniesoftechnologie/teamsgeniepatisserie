/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import classes.Vol;
import dao.VolDao;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author bureau
 */
public class FrameListeVol extends javax.swing.JFrame {

    /**
     * Creates new form FrameListeVol
     */
    public FrameListeVol() {
        initComponents();
        
        list_vol();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        text_rech = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Fermer = new javax.swing.JLabel();
        Reduire = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        profil_pic = new javax.swing.JLabel();
        LabelUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id vol", "Date dep", "Date ar", "heure dep", "Heure ar", "Prix", "Nbre de pl", "Duree"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Recherche");

        text_rech.setBackground(new java.awt.Color(204, 204, 204));
        text_rech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_rechKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_rech, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));

        Fermer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Fermer.setForeground(new java.awt.Color(255, 255, 255));
        Fermer.setText("X");
        Fermer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Fermer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FermerMouseClicked(evt);
            }
        });

        Reduire.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Reduire.setForeground(new java.awt.Color(255, 255, 255));
        Reduire.setText("-");
        Reduire.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reduire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReduireMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Les Vols");

        profil_pic.setBackground(new java.awt.Color(0, 0, 0));
        profil_pic.setOpaque(true);

        LabelUsername.setBackground(new java.awt.Color(255, 255, 255));
        LabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsername.setText("Username");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(profil_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(240, 240, 240)
                .addComponent(Reduire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Fermer)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profil_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fermer)
                            .addComponent(Reduire)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LabelUsername))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int index = jTable1.getSelectedRow();
//        int idu = (int) jTable1.getValueAt(index, 0);
//        VolDao cdao = new VolDao();
//        Vol v = cdao.rechercher(idu);
//        if(v!=null){
//            txt_ida.setText(String.valueOf(v.getId_avion()));
//            combo_aeroportd.setSelectedItem(v.getId_aeroport());
//            txt_dated.setDate(v.getDatedepart());
//            txt_datea.setDate(v.getDatearrivee());
//            txt_heured.setText(v.getHeurdepart());
//            txt_heurea.setText(v.getHeurarrivee());
//            txt_prix.setText(String.valueOf(v.getPrix()));
//            txt_nbrp.setText(String.valueOf(v.getNbplacereserve()));
//            txt_dure.setText(String.valueOf(v.getDuree()));
//        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void FermerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FermerMouseClicked
        this.dispose();
    }//GEN-LAST:event_FermerMouseClicked

    private void ReduireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReduireMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_ReduireMouseClicked

    private void text_rechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_rechKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter sorter = new TableRowSorter(model);
        jTable1.setRowSorter(sorter);
        String rech = text_rech.getText();
        sorter.setRowFilter(RowFilter.regexFilter(rech));
    }//GEN-LAST:event_text_rechKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameListeVol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameListeVol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameListeVol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameListeVol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameListeVol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fermer;
    public javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel Reduire;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel profil_pic;
    private javax.swing.JTextField text_rech;
    // End of variables declaration//GEN-END:variables

private void list_vol(){
     VolDao cdao = new VolDao();
    List<Vol> la = cdao.liste();
    for(int i =0; i<la.size(); i ++){
        ((DefaultTableModel) jTable1.getModel()).addRow(new Object []{
            la.get(i).getId(),
            la.get(i).getDatedepart(),
            la.get(i).getDatearrivee(),
            la.get(i).getHeurdepart(),
            la.get(i).getHeurarrivee(),
            la.get(i).getPrix(),
            la.get(i).getNbplacereserve(),
            la.get(i).getDuree()
            
        }
                
                );
    }
    }

}
