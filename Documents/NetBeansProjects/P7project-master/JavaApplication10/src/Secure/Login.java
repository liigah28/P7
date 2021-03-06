/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import p7.DBconnector;
import p7.Student;

/**
 *
 * @author Liigah
 */
public class Login extends javax.swing.JFrame {

    String username;
    String password;

    /**
     * Creates new form Login2
     */
    public Login() {
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

        jLabelLogo = new javax.swing.JLabel();
        jLabelSignIn = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonNewUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.WHITE);
        setPreferredSize(new java.awt.Dimension(253, 459));
        setSize(new java.awt.Dimension(70, 138));
        getContentPane().setLayout(null);

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Liigah\\Downloads\\rsz_1rsz_1rsz_1rsz_15403012_10209045691393100_72582050_n.png")); // NOI18N
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(50, 20, 150, 120);

        jLabelSignIn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelSignIn.setForeground(new java.awt.Color(51, 153, 0));
        jLabelSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSignIn.setText("Sign In");
        getContentPane().add(jLabelSignIn);
        jLabelSignIn.setBounds(90, 140, 66, 22);

        jLabelUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(51, 153, 0));
        jLabelUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsername.setText("User Name");
        getContentPane().add(jLabelUsername);
        jLabelUsername.setBounds(23, 173, 95, 26);

        jTextFieldUsername.setForeground(new java.awt.Color(102, 204, 0));
        getContentPane().add(jTextFieldUsername);
        jTextFieldUsername.setBounds(33, 200, 193, 35);

        jLabelPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(51, 153, 0));
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPassword.setText("Password");
        getContentPane().add(jLabelPassword);
        jLabelPassword.setBounds(20, 240, 90, 26);

        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldPassword);
        jPasswordFieldPassword.setBounds(33, 271, 193, 35);

        jButtonLogin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(51, 153, 0));
        jButtonLogin.setText("Log In");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(126, 324, 100, 30);

        jButtonNewUser.setBackground(new java.awt.Color(102, 153, 0));
        jButtonNewUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonNewUser.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNewUser.setText("New User");
        jButtonNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewUserActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewUser);
        jButtonNewUser.setBounds(30, 390, 200, 30);

        setBounds(0, 0, 271, 511);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        String password = jPasswordFieldPassword.getText(); //Get the password 
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void jButtonNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewUserActionPerformed
        new Registration().setVisible(true); //when you press the register button, the Registration JFrame pops up
        this.dispose(); //makes the current JFrame disapear

    }//GEN-LAST:event_jButtonNewUserActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        //String username = jTextFieldUsername.getText();

        try {
            jTextFieldUsername.setText("");
            jPasswordFieldPassword.setText("");
            ArrayList<Integer> interests = new ArrayList<Integer>();
            Student s = DBconnector.getDB().getLogin(username, password, interests);

            //username.contains("@student.aau.dk")
            if (s != null) {

                close();
                Account w = new Account(s);
                w.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username and/or password.", "Error", JOptionPane.ERROR_MESSAGE);
                jTextFieldUsername.setText("");
                jPasswordFieldPassword.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login af = new Login();
                af.setBounds(0, 0, 270, 510);
                af.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonNewUser;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelSignIn;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void close() { //method to close the login page and move on to another page
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
//To change body of generated methods, choose Tools | Templates.
    }

}
