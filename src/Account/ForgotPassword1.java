package Account;

import Resources.components.DatabaseConnection;
import java.awt.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class ForgotPassword1 extends javax.swing.JFrame {

    public ForgotPassword1() {
        initComponents();
        setupUsernameFieldListener();
        continue_btn.setEnabled(false);
        setBackground(new Color(0, 0, 0, 0));
        mover.initMoving(ForgotPassword1.this);
        Image icon = new ImageIcon(this.getClass().getResource("/Resources/elements/fts-icon.png")).getImage();
        this.setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Resources.components.PanelBorder();
        instruction = new javax.swing.JLabel();
        user_field = new javax.swing.JTextField();
        continue_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        mover = new Resources.components.PanelMover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instruction.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instruction.setText("Enter your email/username then click continue");
        panelBorder1.add(instruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, -1));

        user_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        panelBorder1.add(user_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 240, -1));

        continue_btn.setBackground(new java.awt.Color(102, 102, 255));
        continue_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        continue_btn.setForeground(new java.awt.Color(255, 255, 255));
        continue_btn.setText("CONTINUE");
        continue_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continue_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(continue_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 150, 110, -1));

        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png"))); // NOI18N
        exit_btn.setBorder(null);
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exit_btnMouseReleased(evt);
            }
        });
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 5, 30, 30));
        panelBorder1.add(mover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 20));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void continue_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continue_btnActionPerformed
        String user = user_field.getText().trim();
        
        String checkUserQuery = "SELECT * FROM `tb_users` WHERE `username` = ? OR `email` = ?";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(checkUserQuery)) {
            ps.setString(1, user);
            ps.setString(2, user);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "User found. Proceeding...");
                    new ForgotPassword2(user).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "User does not exist.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred while checking the username.");
        }
    }//GEN-LAST:event_continue_btnActionPerformed

    private void setupUsernameFieldListener() {
        user_field.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggleContinueButton(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggleContinueButton(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggleContinueButton(); }
        });
    }

    private void toggleContinueButton() {
        String username = user_field.getText().trim();
        continue_btn.setEnabled(!username.isEmpty());
    }    
    
    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-idle.png")));
    }//GEN-LAST:event_exit_btnMouseExited

    private void exit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMousePressed
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-click.png")));
    }//GEN-LAST:event_exit_btnMousePressed

    private void exit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseReleased
        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buttons/exit-hover.png")));
    }//GEN-LAST:event_exit_btnMouseReleased

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        int confirmExit = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmExit == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_exit_btnActionPerformed
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ForgotPassword1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ForgotPassword1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continue_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel instruction;
    private Resources.components.PanelMover mover;
    private Resources.components.PanelBorder panelBorder1;
    private javax.swing.JTextField user_field;
    // End of variables declaration//GEN-END:variables
}
