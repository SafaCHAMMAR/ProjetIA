/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

import javax.swing.JOptionPane;

/**
 *
 * @author safa
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public char pSinge;
    public char pBoite;
    public boolean eSinge;
    public boolean eBanane;
    public String methode;
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        posSinge = new javax.swing.JComboBox();
        posBoite = new javax.swing.JComboBox();
        etatBanane = new javax.swing.JComboBox();
        etatSinge = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        methodeS = new javax.swing.JComboBox();
        buttonCommencer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(226, 107, 115));

        jLabel1.setText("Singe");

        jLabel2.setText("Singe");

        jLabel3.setText("Boite");

        jLabel4.setText("Banane");

        posSinge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "b", "c" }));
        posSinge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posSingeActionPerformed(evt);
            }
        });

        posBoite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a", "b", "c" }));

        etatBanane.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Attrapé", "non attrapé", " " }));

        etatSinge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sur le sol", "Sur la boite" }));

        jLabel5.setText("POSITION:");

        jLabel6.setText("ETAT:");

        jLabel7.setText("METHODE DE RESOLUTION");

        methodeS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Largeur", "HillClimbing", "A*" }));
        methodeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                methodeSActionPerformed(evt);
            }
        });

        buttonCommencer.setText("Commencer");
        buttonCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCommencerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(posSinge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etatSinge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(methodeS, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCommencer)
                    .addComponent(etatBanane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posBoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posSinge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(posBoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etatSinge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(etatBanane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(methodeS)
                    .addComponent(buttonCommencer))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void posSingeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posSingeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posSingeActionPerformed

    private void buttonCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCommencerActionPerformed
        
        JOptionPane d = new JOptionPane();
        
        
        pSinge=posSinge.getSelectedItem().toString().charAt(0);
        pBoite=posBoite.getSelectedItem().toString().charAt(0);
        if(etatBanane.getSelectedItem().toString().equals("Attrapé"))
            eBanane=true;
        else eBanane=false;
        
        if(etatSinge.getSelectedItem().toString().equals("Sur le sol"))
            eSinge=false;
        else eSinge=true;
        methode=methodeS.getSelectedItem().toString();
        //verifier les données
            if(eBanane && (!eSinge || pSinge!='c' || pBoite!='c')){
                  d.showMessageDialog( this,"Combinaison n'est pas valide ","Attention",JOptionPane.WARNING_MESSAGE);}
            else{
        
        Node nd= new Node(pSinge,eSinge,pBoite,eBanane);
        String message;
        switch(methode){
            case "Largeur":
               largeur lg=new largeur(nd);
               message=lg.demarrer();
               d.showMessageDialog( this,message);
            break;
            case "HillClimbing":
                HillClimbing hl=new HillClimbing();
                hl.demarrer();
                hl.afficherNoeudsGeneres();
            break;
            case "HillClimbingMinorant":
                HillClimbingMinorant hlm=new HillClimbingMinorant();
                hlm.demarrer();
                hlm.afficherNoeudsGeneres();
            break;
            case "A*":
                A a=new A();
                a.demarrer();
                a.afficherNoeudsGeneres();
            break;
        }
            }
    }//GEN-LAST:event_buttonCommencerActionPerformed

    private void methodeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_methodeSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_methodeSActionPerformed

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCommencer;
    private javax.swing.JComboBox etatBanane;
    private javax.swing.JComboBox etatSinge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox methodeS;
    private javax.swing.JComboBox posBoite;
    private javax.swing.JComboBox posSinge;
    // End of variables declaration//GEN-END:variables
}
