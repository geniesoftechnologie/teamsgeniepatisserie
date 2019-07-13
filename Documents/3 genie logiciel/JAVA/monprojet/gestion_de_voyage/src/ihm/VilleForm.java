/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import classes.Ville;
import dao.VilleDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bureau
 */
public class VilleForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form VilleForm
     */
    public VilleForm() {
        initComponents();
        
        list_v();
        
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
        jLabel2 = new javax.swing.JLabel();
        txt_ville = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_suppression = new javax.swing.JButton();
        btn_modification = new javax.swing.JButton();
        btn_enregistrement = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Nouelle Ville");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        txt_ville.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txt_ville.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ville"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_suppression.setBackground(new java.awt.Color(255, 0, 0));
        btn_suppression.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_suppression.setForeground(new java.awt.Color(255, 255, 255));
        btn_suppression.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/delete.png"))); // NOI18N
        btn_suppression.setText("Delete");
        btn_suppression.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_suppression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suppressionActionPerformed(evt);
            }
        });

        btn_modification.setBackground(new java.awt.Color(102, 102, 255));
        btn_modification.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_modification.setForeground(new java.awt.Color(255, 255, 255));
        btn_modification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/edit.png"))); // NOI18N
        btn_modification.setText("Eddit");
        btn_modification.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_modification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificationActionPerformed(evt);
            }
        });

        btn_enregistrement.setBackground(new java.awt.Color(51, 255, 51));
        btn_enregistrement.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_enregistrement.setForeground(new java.awt.Color(255, 255, 255));
        btn_enregistrement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/add.png"))); // NOI18N
        btn_enregistrement.setText("Add");
        btn_enregistrement.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_enregistrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enregistrementActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/travel-tourist-attraction-3d-icon-set-vector-20634478.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/business-plan-agence-de-voyage.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ville, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(btn_suppression)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_enregistrement, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_enregistrement, btn_modification, btn_suppression});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ville, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modification)
                    .addComponent(btn_enregistrement, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suppression, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_enregistrement, btn_modification, btn_suppression});

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
        int index = jTable1.getSelectedRow();
        int id = (int) jTable1.getValueAt(index, 0);
        VilleDao vdao = new VilleDao();
        Ville v = vdao.rechercher(id);
        if(v!=null){

            txt_ville.setText(v.getNom());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_suppressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suppressionActionPerformed
        int index = jTable1.getSelectedRow();
        if(index >= 0){
            int id = (int) jTable1.getValueAt(index, 0);
            VilleDao cdao = new VilleDao();
            cdao.supprimer(id);
            JOptionPane.showMessageDialog(null, "Ville supprimer...");
            vider();
            list_v();
        }
        else{
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une ligne svp...");
        }
    }//GEN-LAST:event_btn_suppressionActionPerformed

    private void btn_modificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificationActionPerformed
        int index = jTable1.getSelectedRow();
        int id = (int) jTable1.getValueAt(index, 0);
        VilleDao cdao = new VilleDao();
        String ville = txt_ville.getText();
        if(ville.equals("")){
            JOptionPane.showMessageDialog(this, "Veuillez cliquer sur la ligne ou modifier...");
        }
        else {
            Ville v = new Ville(ville);
            cdao.modifier(v, id);
            JOptionPane.showMessageDialog(null, "Ville modifié...");
            vider();
            list_v();
        }
    }//GEN-LAST:event_btn_modificationActionPerformed

    private void btn_enregistrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrementActionPerformed
        String ville = txt_ville.getText();
        if(ville.equals("")){
            JOptionPane.showMessageDialog(this, "Veuillez bien remplir les champs...");
        }
        else {
            Ville v = new Ville(ville);
            VilleDao cdao = new VilleDao();
            cdao.inserer(v);
            JOptionPane.showMessageDialog(null, "Ville ajouté...");
            vider();
            list_v();
        }
    }//GEN-LAST:event_btn_enregistrementActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enregistrement;
    private javax.swing.JButton btn_modification;
    private javax.swing.JButton btn_suppression;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_ville;
    // End of variables declaration//GEN-END:variables


    private void list_v(){
     VilleDao cdao = new VilleDao();
    List<Ville> lv = cdao.liste();
    for(int i =0; i<lv.size(); i ++){
        ((DefaultTableModel) jTable1.getModel()).addRow(new Object []{
            lv.get(i).getId(),
            lv.get(i).getNom()
        }
                
                );
    }
    }
  private void vider(){
      txt_ville.setText("");
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
      int n = model.getRowCount();
      for(int i = n-1; i>=0; --i){
          model.removeRow(i);
      }
      
  }  
}