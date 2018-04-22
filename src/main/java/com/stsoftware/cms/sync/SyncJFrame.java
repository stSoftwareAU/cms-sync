/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stsoftware.cms.sync;

import com.aspc.remote.database.InvalidDataException;
import com.aspc.remote.rest.ReST;
import com.aspc.remote.rest.Response;
import com.aspc.remote.rest.Status;
import com.aspc.remote.util.misc.StringUtilities;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jdk.net.SocketFlow;
import org.json.JSONObject;

/**
 *
 * @author nigel
 */
public class SyncJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SyncJFrame
     */
    public SyncJFrame() {
        initComponents();
        
        JTextField list[]={
            password,
            serverURL,
            siteName,
            userName
        };
         
        for( JTextField tf: list)
        {
            tf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    checkOK();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    checkOK();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    checkOK();
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        directoryButton = new javax.swing.JButton();
        directoryPath = new javax.swing.JTextField();
        serverURL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        siteName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        directoryButton.setText("Directory");
        directoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directoryButtonActionPerformed(evt);
            }
        });

        directoryPath.setEditable(false);
        directoryPath.setToolTipText("The directory to sync");
        directoryPath.setEnabled(false);

        serverURL.setText("https://demo.jobtrack.com.au");
        serverURL.setToolTipText("server");

        jLabel1.setText("Server:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, serverURL, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Site:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, siteName, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel2, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        siteName.setToolTipText("The name of the site to sync");

        jLabel3.setText("User:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userName, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel3, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        userName.setText("admin");

        jLabel4.setLabelFor(password);
        jLabel4.setText("Password:");

        password.setText("admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directoryButton)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directoryPath)
                    .addComponent(serverURL, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(siteName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directoryButton)
                    .addComponent(directoryPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(siteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMessage(final String msg)
    {

        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void checkValid( )
    {
        try{
            Response response = ReST.builder(serverURL.getText() + "/ReST/v8/class/Site")
                    .setParameter("q", "site=" + siteName.getText())
                    .setAuthorization(userName.getText(), new String(password.getPassword()))
                    .getResponse();
            
            if( response.status == Status.C200_SUCCESS_OK)
            {
                JSONObject json = response.getContentAsJSON();
            }
            else 
            {
                showMessage(response.status.label);
            }
        }
        catch( InvalidDataException | IOException e)
        {
            showMessage( e.toString());
        }
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        checkValid();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void directoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directoryButtonActionPerformed

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            directoryPath.setText(chooser.getSelectedFile().toString());
            checkOK();
        }

    }//GEN-LAST:event_directoryButtonActionPerformed

    private void checkOK()
    {
        okButton.setEnabled(false);
        if( StringUtilities.notBlank(directoryPath.getText())){
            if( StringUtilities.notBlank(siteName.getText()))
            {
                if( StringUtilities.notBlank(userName.getText()))
                {
                    if( StringUtilities.notBlank(new String( password.getPassword())))
                    {
                        if( StringUtilities.notBlank(serverURL.getText()))
                        {
                            okButton.setEnabled(true);
                        }
                    }                
                }                
            }
        }
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SyncJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SyncJFrame().setVisible(true);
        });
    }

    private JFileChooser chooser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton directoryButton;
    private javax.swing.JTextField directoryPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField serverURL;
    private javax.swing.JTextField siteName;
    private javax.swing.JTextField userName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
